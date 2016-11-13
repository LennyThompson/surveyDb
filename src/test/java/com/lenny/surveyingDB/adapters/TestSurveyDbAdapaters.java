package com.lenny.surveyingDB.adapters;

import com.google.gson.*;
import com.lenny.Utils.ISerialiseState;
import com.lenny.Utils.UndoTarget;
import com.lenny.surveyingDB.interfaces.*;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class TestSurveyDbAdapaters
{
    static void buildSurveyDb(Connection connDb) throws SQLException
    {
        SurveyPointTypeAdapter.createInDatabase(connDb);
        SurveyReferenceAdapter.createInDatabase(connDb);
        InstrumentManufacturerAdapter.createInDatabase(connDb);
        InstrumentAdapter.createInDatabase(connDb);
        ProjectionAdapter.createInDatabase(connDb);
        SurveyAdapter.createInDatabase(connDb);
        TraverseAdapter.createInDatabase(connDb);
        SurveyPointAdapter.createInDatabase(connDb);
        SurveyImageAdapter.createInDatabase(connDb);
        SurveyMeasurementAdapter.createInDatabase(connDb);

    }
    @Test
    public void testLoadStatics() throws SQLException
    {
        File fileDb = new File("testLoadStatics.db");
        if (fileDb.exists())
        {
            fileDb.delete();
        }

        Connection connDb = DriverManager.getConnection("jdbc:sqlite:testLoadStatics.db");
        GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss");
        gsonBuild.registerTypeAdapter(ISurveyPointType.class, new SurveyPointTypeAdapter());
        gsonBuild.registerTypeAdapter(ISurveyReference.class, new SurveyReferenceAdapter());

        SurveyPointTypeAdapter.createInDatabase(connDb);
        SurveyReferenceAdapter.createInDatabase(connDb);

        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(connDb);

        assertEquals(15, listPointTypes.size());
        assertEquals("SM", listPointTypes.get(0).getAbbreviation());
        assertEquals("Survey Mark", listPointTypes.get(0).getName());
        assertFalse(listPointTypes.get(0).getUserDefined());
        String strJson = ((ISerialiseState) listPointTypes.get(0)).toJson();
        Gson gsonInstance = gsonBuild.create();
        ISurveyPointType ptTypeSerialised = gsonInstance.fromJson(strJson, ISurveyPointType.class);

        assertEquals("SM", ptTypeSerialised.getAbbreviation());
        assertEquals("Survey Mark", ptTypeSerialised.getName());
        assertFalse(ptTypeSerialised.getUserDefined());
        assertEquals(listPointTypes.get(0).getCreated(), ptTypeSerialised.getCreated());

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

        SurveyPointTypeAdapter.add(connDb, survPtType);

        listPointTypes = SurveyPointTypeAdapter.getAll(connDb);
        assertEquals(16, listPointTypes.size());
        assertEquals("CP", listPointTypes.get(15).getAbbreviation());
        assertEquals("Custom Point", listPointTypes.get(15).getName());
        assertTrue(listPointTypes.get(15).getUserDefined());

        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(connDb);

        assertEquals(2, listRefs.size());
        assertEquals("Current Survey", listRefs.get(0).getName());
        assertEquals("No Ref", listRefs.get(0).getReference());
        assertEquals("Current Survey", listRefs.get(0).getDescription());
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(listRefs.get(0).getDate());
        assertEquals(2000, calDate.get(Calendar.YEAR));

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
        File fileDb = new File("testCreatePoint.db");
        if (fileDb.exists())
        {
            fileDb.delete();
        }

        Connection connDb = DriverManager.getConnection("jdbc:sqlite:testCreatePoint.db");

        buildSurveyDb(connDb);

        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(connDb);

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

        ptSurvey = SurveyPointAdapter.add(connDb, ptSurvey);

        assertEquals("First Point", ptSurvey.getName());
        assertEquals("The first point in the survey", ptSurvey.getDescription());
        assertEquals(1000.0, ptSurvey.getX(), 0.001);
        assertEquals(2000.0, ptSurvey.getY(), 0.001);
        assertEquals(500.0, ptSurvey.getZ(), 0.001);
        assertEquals("Trig", ptSurvey.getPointType().getAbbreviation());
        assertEquals("Current Survey", ptSurvey.getReference().getName());
        assertTrue(((UndoTarget) ptSurvey).isSaved());

        // Test serialisation using adapter implemenation of JsonSerializer

        String strJson = ((ISerialiseState) ptSurvey).toJson();
        GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss");
        gsonBuild.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
        Gson gsonInstance = gsonBuild.create();
        ISurveyPoint ptSerialised = gsonInstance.fromJson(strJson, ISurveyPoint.class);
        assertEquals("First Point", ptSerialised.getName());
        assertEquals("The first point in the survey", ptSerialised.getDescription());
        assertEquals(1000.0, ptSerialised.getX(), 0.001);
        assertEquals(2000.0, ptSerialised.getY(), 0.001);
        assertEquals(500.0, ptSerialised.getZ(), 0.001);
        assertEquals("Trig", ptSerialised.getPointType().getAbbreviation());
        assertEquals("Current Survey", ptSerialised.getReference().getName());
    }

    @Test
    public void testUpdatePoint() throws SQLException
    {
        File fileDb = new File("testUpdatePoint.db");
        if (fileDb.exists())
        {
            fileDb.delete();
        }

        Connection connDb = DriverManager.getConnection("jdbc:sqlite:testUpdatePoint.db");

        buildSurveyDb(connDb);

        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(connDb);

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

        ptSurvey = SurveyPointAdapter.add(connDb, ptSurvey);

        ptSurvey.setX(1010.0);
        ptSurvey.setY(2020.0);
        ptSurvey.setZ(505.0);
        ptSurvey.setPointType(listPointTypes.get(2));
        assertTrue(((UndoTarget) ptSurvey).isUpdated());

        ptSurvey = SurveyPointAdapter.update(connDb, ptSurvey);

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
        File fileDb = new File("testSurveyMeasurement.db");
        if (fileDb.exists())
        {
            fileDb.delete();
        }

        Connection connDb = DriverManager.getConnection("jdbc:sqlite:testSurveyMeasurement.db");

        buildSurveyDb(connDb);

        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(connDb);

        ISurveyPoint ptSurveyFrom = SurveyPointAdapter.createNewSurveyPoint();

        ptSurveyFrom.setName("First Point");
        ptSurveyFrom.setDescription("The first point in the survey");
        ptSurveyFrom.setX(1000.0);
        ptSurveyFrom.setY(2000.0);
        ptSurveyFrom.setZ(500.0);
        ptSurveyFrom.setPointType(listPointTypes.get(3));
        ptSurveyFrom.setReference(listRefs.get(0));
        ptSurveyFrom = SurveyPointAdapter.add(connDb, ptSurveyFrom);

        ISurveyPoint ptSurveyTo = SurveyPointAdapter.createNewSurveyPoint();
        ptSurveyTo.setName("Second Point");
        ptSurveyTo.setDescription("The first point in the survey");
        ptSurveyTo.setX(1100.0);
        ptSurveyTo.setY(2000.0);
        ptSurveyTo.setZ(550.0);
        ptSurveyTo.setPointType(listPointTypes.get(7));
        ptSurveyTo.setReference(listRefs.get(0));
        ptSurveyTo = SurveyPointAdapter.add(connDb, ptSurveyTo);

        ISurveyMeasurement survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement();
        survMeas.setBearing(90.0);
        survMeas.setHorizDistance(100.0);
        survMeas.setVertDistance(50.0);
        survMeas.setPointFrom(ptSurveyFrom);
        survMeas.setPointTo(ptSurveyTo);

        survMeas = SurveyMeasurementAdapter.add(connDb, survMeas);

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
        File fileDb = new File("testTraverse.db");
        if (fileDb.exists())
        {
            fileDb.delete();
        }

        Connection connDb = DriverManager.getConnection("jdbc:sqlite:testTraverse.db");

        buildSurveyDb(connDb);

        List<ISurveyPointType> listPointTypes = SurveyPointTypeAdapter.getAll(connDb);
        List<ISurveyReference> listRefs = SurveyReferenceAdapter.getAll(connDb);

        ISurvey survey = SurveyAdapter.createNewSurvey();
        survey.setName("Test Survey");
        survey.setDescription("Testing...");
        survey.setProjection(ProjectionAdapter.getAll(connDb).get(0));
        survey = SurveyAdapter.add(connDb, survey);

        ITraverse travTest = TraverseAdapter.createNewTraverse();
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

        ISurveyPoint ptSurveyTo = SurveyPointAdapter.createNewSurveyPoint();
        ptSurveyTo.setName("Second Point");
        ptSurveyTo.setDescription("The second point in the survey");
        ptSurveyTo.setX(1100.0);
        ptSurveyTo.setY(2000.0);
        ptSurveyTo.setZ(550.0);
        ptSurveyTo.setPointType(listPointTypes.get(7));
        ptSurveyTo.setReference(listRefs.get(0));

        travTest.setEndPoint(ptSurveyTo);

        // Add some traverese measurements

        ISurveyMeasurement survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement();
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

        travTest.addSurveyMeasurement(survMeas);

        survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement();
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

        travTest.addSurveyMeasurement(survMeas);

        // Close the traverse back to the end point

        survMeas = SurveyMeasurementAdapter.createNewSurveyMeasurement();
        survMeas.setBearing(180.0);
        survMeas.setHorizDistance(100.0);
        survMeas.setVertDistance(20.0);
        survMeas.setPointFrom(ptSurveyNext);

        survMeas.setPointTo(ptSurveyTo);

        travTest.addSurveyMeasurement(survMeas);

        travTest = TraverseAdapter.add(connDb, travTest);

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

        List<ISurveyPoint> listPoints = SurveyPointAdapter.getAll(connDb);
        assertEquals(4, listPoints.size());

        List<ISurvey> listSurveys = SurveyAdapter.getAll(connDb);
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
    }
}
