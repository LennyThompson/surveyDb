package com.lenny.surveyingDB.adapters;

import com.google.gson.*;
import com.lenny.Utils.ISerialiseState;
import com.lenny.Utils.UndoTarget;
import com.lenny.surveyingDB.SurveyDb;
import com.lenny.surveyingDB.interfaces.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSurveyDbAdaptersSqlite
{
    private static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:test.db";
    private static final String SQLITE_USER = "lenny";
    private static final String SQLITE_PASSWORD = "pqxy(!%k";
    private static final String SQLITE_SCHEMA = "test";

    Connection m_connDb;

    @BeforeEach
    public void setUp() throws SQLException, IOException
    {
        SurveyDb.resetSqlProvider();
        File fileDb = new File("test.db");
        if (Files.exists(Path.of("test.db")))
        {
            Files.delete(Path.of("test.db"));
        }
        SurveyDb.buildNewDatabase("test.db");
        m_connDb = DriverManager.getConnection(SQLITE_CONNECTION_STRING);
    }

    @AfterEach
    public void tearDown() throws SQLException, IOException
    {
        try
        {
            m_connDb.close();
        }
        catch(SQLException exc)
        {
            // At this point we are not that interested... maybe later.
        }

        if (Files.exists(Path.of("test.db")))
        {
            Files.delete(Path.of("test.db"));
        }
    }

    static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.ss");
    String offsetTimeToString(OffsetDateTime dateTime)
    {
        return dateTime.format(FORMATTER);
    }

    @Test
    public void testLoadStatics() throws SQLException
    {
        GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss");
        gsonBuild.registerTypeAdapter(ISurveyPointType.class, new SurveyPointTypeAdapter());
        gsonBuild.registerTypeAdapter(ISurveyReference.class, new SurveyReferenceAdapter());

        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(m_connDb);
        assertTrue (15 <= listPointTypes.size());
        int nCurrSize = listPointTypes.size();
        assertEquals("SM", listPointTypes.get(0).getAbbreviation());
        assertEquals("Survey Mark", listPointTypes.get(0).getName());
        assertFalse(listPointTypes.get(0).getUserDefined());
        String strJson = ((ISerialiseState) listPointTypes.get(0)).toJson();
        Gson gsonInstance = gsonBuild.create();
        ISurveyPointType ptTypeSerialised = gsonInstance.fromJson(strJson, ISurveyPointType.class);

        assertEquals("SM", ptTypeSerialised.getAbbreviation());
        assertEquals("Survey Mark", ptTypeSerialised.getName());
        assertFalse(ptTypeSerialised.getUserDefined());
        //assertEquals(listPointTypes.get(0).getCreated(), ptTypeSerialised.getCreated());

        assertEquals("Trig", listPointTypes.get(3).getAbbreviation());
        assertEquals("Trig Point", listPointTypes.get(3).getName());
        assertFalse(listPointTypes.get(3).getUserDefined());
        assertEquals("Tree", listPointTypes.get(6).getAbbreviation());
        assertEquals("Tree", listPointTypes.get(6).getName());
        assertFalse(listPointTypes.get(6).getUserDefined());
        assertEquals("ToK", listPointTypes.get(13).getAbbreviation());
        assertEquals("Top of Kerb", listPointTypes.get(13).getName());
        assertFalse(listPointTypes.get(13).getUserDefined());
        assertEquals("Dr", listPointTypes.get(14).getAbbreviation());
        assertEquals("Drain", listPointTypes.get(14).getName());
        assertFalse(listPointTypes.get(14).getUserDefined());

        ISurveyPointType survPtType = SurveyPointTypeAdapter.createNewSurveyPointType();
        survPtType.setName("Custom Point");
        survPtType.setAbbreviation("CP");
        survPtType.setUserDefined(true);

        SurveyPointTypeAdapter.add(m_connDb, survPtType);

        listPointTypes = SurveyPointTypeAdapter.getAll(m_connDb);
        assertEquals(nCurrSize + 1, listPointTypes.size());
        assertEquals("CP", listPointTypes.get(15).getAbbreviation());
        assertEquals("Custom Point", listPointTypes.get(15).getName());
        assertTrue(listPointTypes.get(nCurrSize).getUserDefined());

        // TODO add test for delete when added.

        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(m_connDb);

        assertTrue(2 <= listRefs.size());
        assertEquals("Current Survey", listRefs.get(0).getName());
        assertEquals("No Ref", listRefs.get(0).getReference());
        assertEquals("Current Survey", listRefs.get(0).getDescription());
        assertEquals(2000, listRefs.get(0).getDate().getYear());

        strJson = ((ISerialiseState) listRefs.get(0)).toJson();
        gsonInstance = gsonBuild.create();
        ISurveyReference ptRefSerialised = gsonInstance.fromJson(strJson, ISurveyReference.class);
        assertEquals("Current Survey", ptRefSerialised.getName());
        assertEquals("No Ref", ptRefSerialised.getReference());
        assertEquals("Current Survey", ptRefSerialised.getDescription());
        assertEquals(listRefs.get(0).getDate(), ptRefSerialised.getDate());
    }

    @Test
    public void testCreatePoint() throws SQLException
    {
        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(m_connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(m_connDb);

        ISurveyPoint ptSurvey = SurveyPointAdapter.createNewSurveyPoint();

        ptSurvey.setName("First Point");
        ptSurvey.setDescription("The first point in the survey");
        ptSurvey.setX(1000.0);
        ptSurvey.setY(2000.0);
        ptSurvey.setZ(500.0);
        ptSurvey.setPointType(listPointTypes.get(3));
        ptSurvey.setReference(listRefs.get(0));

        assertEquals("First Point", ptSurvey.getName());
        assertEquals("The first point in the survey", ptSurvey.getDescription());
        assertEquals(1000.0, ptSurvey.getX(), 0.001);
        assertEquals(2000.0, ptSurvey.getY(), 0.001);
        assertEquals(500.0, ptSurvey.getZ(), 0.001);
        assertEquals("Trig", ptSurvey.getPointType().getAbbreviation());
        assertEquals("Current Survey", ptSurvey.getReference().getName());
        assertTrue(((UndoTarget) ptSurvey).isNew());

        ptSurvey = SurveyPointAdapter.add(m_connDb, ptSurvey);

        assertEquals("First Point", ptSurvey.getName());
        assertEquals("The first point in the survey", ptSurvey.getDescription());
        assertEquals(1000.0, ptSurvey.getX(), 0.001);
        assertEquals(2000.0, ptSurvey.getY(), 0.001);
        assertEquals(500.0, ptSurvey.getZ(), 0.001);
        assertEquals("Trig", ptSurvey.getPointType().getAbbreviation());
        assertEquals("Current Survey", ptSurvey.getReference().getName());
        assertTrue(((UndoTarget) ptSurvey).isSaved());

        // Test serialisation using adapter implementation of JsonSerializer

        String strJson = ((ISerialiseState) ptSurvey).toJson();
        GsonBuilder gsonBuild = new GsonBuilder()
            .registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
        Gson gsonInstance = gsonBuild.create();
        ISurveyPoint ptSerialised = gsonInstance.fromJson(strJson, ISurveyPoint.class);
        assertEquals("First Point", ptSerialised.getName());
        assertEquals("The first point in the survey", ptSerialised.getDescription());
        assertEquals(1000.0, ptSerialised.getX(), 0.001);
        assertEquals(2000.0, ptSerialised.getY(), 0.001);
        assertEquals(500.0, ptSerialised.getZ(), 0.001);
        assertEquals("Trig", ptSerialised.getPointType().getAbbreviation());
        assertEquals("Current Survey", ptSerialised.getReference().getName());

        assertEquals(offsetTimeToString(ptSurvey.getCreated()), offsetTimeToString(ptSerialised.getCreated()));
    }

    @Test
    public void testUpdatePoint() throws SQLException
    {
        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(m_connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(m_connDb);

        ISurveyPoint ptSurvey = SurveyPointAdapter.createNewSurveyPoint();

        ptSurvey.setName("First Point");
        ptSurvey.setDescription("The first point in the survey");
        ptSurvey.setX(1000.0);
        ptSurvey.setY(2000.0);
        ptSurvey.setZ(500.0);
        ptSurvey.setPointType(listPointTypes.get(3));
        ptSurvey.setReference(listRefs.get(0));

        assertEquals("First Point", ptSurvey.getName());
        assertEquals("The first point in the survey", ptSurvey.getDescription());
        assertEquals(1000.0, ptSurvey.getX(), 0.001);
        assertEquals(2000.0, ptSurvey.getY(), 0.001);
        assertEquals(500.0, ptSurvey.getZ(), 0.001);
        assertEquals("Trig", ptSurvey.getPointType().getAbbreviation());
        assertEquals("Current Survey", ptSurvey.getReference().getName());
        assertTrue(((UndoTarget) ptSurvey).isNew());

        ptSurvey = SurveyPointAdapter.add(m_connDb, ptSurvey);

        ptSurvey.setX(1010.0);
        ptSurvey.setY(2020.0);
        ptSurvey.setZ(505.0);
        ptSurvey.setPointType(listPointTypes.get(2));
        assertTrue(((UndoTarget) ptSurvey).isUpdated());

        ptSurvey = SurveyPointAdapter.update(m_connDb, ptSurvey);

        assertEquals("First Point", ptSurvey.getName());
        assertEquals("The first point in the survey", ptSurvey.getDescription());
        assertEquals(1010.0, ptSurvey.getX(), 0.001);
        assertEquals(2020.0, ptSurvey.getY(), 0.001);
        assertEquals(505.0, ptSurvey.getZ(), 0.001);
        assertEquals("PSM", ptSurvey.getPointType().getAbbreviation());
        assertEquals("Current Survey", ptSurvey.getReference().getName());
        assertTrue(((UndoTarget) ptSurvey).isSaved());
    }

    @Test
    public void testSurveyMeasurement() throws SQLException
    {
        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(m_connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(m_connDb);
        ISurvey survey = SurveyAdapter.createNewSurvey();
        survey.setName("Test Survey");
        survey.setDescription("Testing...");
        survey.setProjection(ProjectionAdapter.getAll(m_connDb).get(0));
        survey = SurveyAdapter.add(m_connDb, survey);

        ISurveyPoint ptSurveyFrom = SurveyPointAdapter.createNewSurveyPoint();

        ptSurveyFrom.setName("First Point");
        ptSurveyFrom.setDescription("The first point in the survey");
        ptSurveyFrom.setX(1000.0);
        ptSurveyFrom.setY(2000.0);
        ptSurveyFrom.setZ(500.0);
        ptSurveyFrom.setPointType(listPointTypes.get(3));
        ptSurveyFrom.setReference(listRefs.get(0));
        ptSurveyFrom = SurveyPointAdapter.add(m_connDb, ptSurveyFrom);

        ISurveyPoint ptSurveyTo = SurveyPointAdapter.createNewSurveyPoint();
        ptSurveyTo.setName("Second Point");
        ptSurveyTo.setDescription("The first point in the survey");
        ptSurveyTo.setX(1100.0);
        ptSurveyTo.setY(2000.0);
        ptSurveyTo.setZ(550.0);
        ptSurveyTo.setPointType(listPointTypes.get(7));
        ptSurveyTo.setReference(listRefs.get(0));
        ptSurveyTo = SurveyPointAdapter.add(m_connDb, ptSurveyTo);

        ISurveyMeasurement survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement(survey.getID());
        survMeas.setBearing(90.0);
        survMeas.setHorizDistance(100.0);
        survMeas.setVertDistance(50.0);
        survMeas.setPointFrom(ptSurveyFrom);
        survMeas.setPointTo(ptSurveyTo);

        survMeas = SurveyMeasurementAdapter.add(m_connDb, survMeas);

        assertEquals(90.0, survMeas.getBearing(), 0.01);
        assertEquals(100.0, survMeas.getHorizDistance(), 0.01);
        assertEquals(50.0, survMeas.getVertDistance(), 0.01);
        assertEquals("First Point", survMeas.getPointFrom().getName());
        assertEquals("Second Point", survMeas.getPointTo().getName());
        assertTrue(((UndoTarget) survMeas).isSaved());
    }

    @Test
    public void testTraverse() throws SQLException
    {
        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(m_connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(m_connDb);

        ISurvey survey = SurveyAdapter.createNewSurvey();
        survey.setName("Test Survey");
        survey.setDescription("Testing...");
        survey.setProjection(ProjectionAdapter.getAll(m_connDb).get(0));
        survey = SurveyAdapter.add(m_connDb, survey);

        ITraverse travTest = TraverseAdapter.createNewTraverse(survey.getID());
        travTest.setName("New Traverse");
        travTest.setDescription("A new traverse");
        survey.addTraverse(travTest);

        // Set a start and end point for the traverse

        ISurveyPoint ptSurveyFrom = SurveyPointAdapter.createNewSurveyPoint();

        ptSurveyFrom.setName("First Point");
        ptSurveyFrom.setDescription("The first point in the survey");
        ptSurveyFrom.setX(1000.0);
        ptSurveyFrom.setY(2000.0);
        ptSurveyFrom.setZ(500.0);
        ptSurveyFrom.setPointType(listPointTypes.get(3));
        ptSurveyFrom.setReference(listRefs.get(0));

        travTest.setStartPoint(ptSurveyFrom);
        survey.addSurveyPoint(ptSurveyFrom);

        ISurveyPoint ptSurveyTo = SurveyPointAdapter.createNewSurveyPoint();
        ptSurveyTo.setName("Second Point");
        ptSurveyTo.setDescription("The second point in the survey");
        ptSurveyTo.setX(1100.0);
        ptSurveyTo.setY(2000.0);
        ptSurveyTo.setZ(550.0);
        ptSurveyTo.setPointType(listPointTypes.get(7));
        ptSurveyTo.setReference(listRefs.get(0));

        travTest.setEndPoint(ptSurveyTo);
        survey.addSurveyPoint(ptSurveyTo);

        // Add some traverese measurements

        ISurveyMeasurement survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement(survey.getID());
        survMeas.setBearing(0.0);
        survMeas.setHorizDistance(100.0);
        survMeas.setVertDistance(10.0);
        survMeas.setPointFrom(ptSurveyFrom);

        ISurveyPoint ptSurveyNext = SurveyPointAdapter.createNewSurveyPoint();
        ptSurveyNext.setName("Trav 1");
        ptSurveyNext.setDescription("First traverse point");
        ptSurveyNext.setX(1000.0);
        ptSurveyNext.setY(2100.0);
        ptSurveyNext.setZ(510.0);
        ptSurveyNext.setPointType(listPointTypes.get(7));
        ptSurveyNext.setReference(listRefs.get(0));
        survMeas.setPointTo(ptSurveyNext);
        survey.addSurveyPoint(ptSurveyNext);

        travTest.addSurveyMeasurement(survMeas);
        survey.addSurveyMeasurement(survMeas);
        SurveyMeasurementAdapter.add(m_connDb, survMeas);


        survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement(survey.getID());
        survMeas.setBearing(90.0);
        survMeas.setHorizDistance(100.0);
        survMeas.setVertDistance(20.0);
        survMeas.setPointFrom(ptSurveyNext);

        ptSurveyNext = SurveyPointAdapter.createNewSurveyPoint();
        ptSurveyNext.setName("Trav 2");
        ptSurveyNext.setDescription("Second traverse point");
        ptSurveyNext.setX(1100.0);
        ptSurveyNext.setY(2100.0);
        ptSurveyNext.setZ(530.0);
        ptSurveyNext.setPointType(listPointTypes.get(7));
        ptSurveyNext.setReference(listRefs.get(0));
        survMeas.setPointTo(ptSurveyNext);
        survey.addSurveyPoint(ptSurveyNext);

        travTest.addSurveyMeasurement(survMeas);
        survey.addSurveyMeasurement(survMeas);
        SurveyMeasurementAdapter.add(m_connDb, survMeas);

        // Close the traverse back to the end point

        survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement(survey.getID());
        survMeas.setBearing(180.0);
        survMeas.setHorizDistance(100.0);
        survMeas.setVertDistance(20.0);
        survMeas.setPointFrom(ptSurveyNext);

        survMeas.setPointTo(ptSurveyTo);

        travTest.addSurveyMeasurement(survMeas);
        survey.addSurveyMeasurement(survMeas);
        SurveyMeasurementAdapter.add(m_connDb, survMeas);

        travTest = TraverseAdapter.add(m_connDb, travTest);
        survey = SurveyAdapter.update(m_connDb, survey);

        assertEquals("New Traverse", travTest.getName());
        assertEquals("First Point", travTest.getStartPoint().getName());
        assertEquals("Second Point", travTest.getEndPoint().getName());

        assertEquals(3, travTest.getSurveyMeasurements().size());
        assertEquals("First Point", travTest.getSurveyMeasurements().get(0).getPointFrom().getName());
        assertEquals("Trav 1", travTest.getSurveyMeasurements().get(0).getPointTo().getName());
        assertEquals("Trav 1", travTest.getSurveyMeasurements().get(1).getPointFrom().getName());
        assertEquals("Trav 2", travTest.getSurveyMeasurements().get(1).getPointTo().getName());
        assertEquals("Trav 2", travTest.getSurveyMeasurements().get(2).getPointFrom().getName());
        assertEquals("Second Point", travTest.getSurveyMeasurements().get(2).getPointTo().getName());

        List<ISurveyPoint> listPoints = SurveyPointAdapter.getAll(m_connDb);
        assertEquals(4, listPoints.size());

        List<ISurvey> listSurveys = SurveyAdapter.getAll(m_connDb);
        assertEquals(1, listSurveys.size());
        assertEquals(1, listSurveys.get(0).getTraverses().size());

        String strJson = ((ISerialiseState) listSurveys.get(0)).toJson();
        GsonBuilder gsonBuild = new GsonBuilder()
            .registerTypeAdapter(ISurvey.class, new SurveyAdapter())
            .setDateFormat("yyyy-MM-dd hh:mm:ss");
        Gson gsonInstance = gsonBuild.create();
        ISurvey surveySerial = gsonInstance.fromJson(strJson, ISurvey.class);

        assertEquals("Test Survey", surveySerial.getName());
        assertEquals("Testing...", surveySerial.getDescription());
        assertEquals(1, surveySerial.getTraverses().size());
        assertEquals(3, surveySerial.getTraverses().get(0).getSurveyMeasurements().size());

        // Test that the survey points can be accessed through the SurveyPointSummary view

        List<ISurveyPointSummary> listSurveyPts = SurveyPointSummaryAdapter.getAll(m_connDb);
        assertEquals(1, listSurveyPts.size());
        ISurveyPointSummary ptSummary = listSurveyPts.get(0);
        assertEquals(4, ptSummary.getPts().size());
        assertEquals(1000, ptSummary.getPts().get(0).getX(), 0.01);
        assertEquals(2000, ptSummary.getPts().get(0).getY(), 0.01);
        assertEquals(500, ptSummary.getPts().get(0).getZ(), 0.01);
        assertEquals("Trig Point", ptSummary.getPts().get(0).getPtType().getPtTypeName());
        assertEquals("Current Survey", ptSummary.getPts().get(0).getRef().getRefName());

        // And for a specific survey

        ptSummary = SurveyPointSummaryAdapter.get(m_connDb, survey.getID());
        assertEquals(4, ptSummary.getPts().size());
        assertEquals(1000, ptSummary.getPts().get(0).getX(), 0.01);
        assertEquals(2000, ptSummary.getPts().get(0).getY(), 0.01);
        assertEquals(500, ptSummary.getPts().get(0).getZ(), 0.01);
        assertEquals("Trig Point", ptSummary.getPts().get(0).getPtType().getPtTypeName());
        assertEquals("Current Survey", ptSummary.getPts().get(0).getRef().getRefName());

        // Now the traverse measurements for a specific traverse

        ITraverseMeasurementSummary travMeasSummary = TraverseMeasurementSummaryAdapter.get(m_connDb, travTest.getID());
        assertEquals(3, travMeasSummary.getSurvMeass().size());
        ITraverseMeasurementSummary.ITraverseMeasurementSummary_SurvMeas measSummary = travMeasSummary.getSurvMeass().get(1);
        assertEquals(90, measSummary.getBearing(), 0.01);
        assertEquals(100.0, measSummary.getHorizontal(), 0.01);
        assertEquals(20, measSummary.getVertical(), 0.01);
        assertEquals("Trav 1", measSummary.getPtFrom().getPtFromName());
        assertEquals("Trav 2", measSummary.getPtTo().getPtToName());

        List<ITraverseMeasurementSummary> listTrav = TraverseMeasurementSummaryAdapter.getForPathQuery(m_connDb, 1, 1);

        assertEquals(1, listTrav.size());

    }
}

