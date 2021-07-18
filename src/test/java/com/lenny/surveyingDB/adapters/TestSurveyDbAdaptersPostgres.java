package com.lenny.surveyingDB.adapters;

import com.google.gson.*;
import com.lenny.Utils.ISerialiseState;
import com.lenny.Utils.UndoTarget;
import com.lenny.surveyingDB.*;
import com.lenny.surveyingDB.interfaces.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static com.lenny.surveyingDB.adapters.PostgreSQLTestImages.POSTGRES_TEST_IMAGE;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class TestSurveyDbAdaptersPostgres
{
    private static final String POSTGRE_SCHEMA = "test";
    private static final String POSTGRE_CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS " + POSTGRE_SCHEMA;

    Connection m_connDb;

    @Container
    public PostgreSQLContainer<?> m_postgresContainer = new PostgreSQLContainer<>(POSTGRES_TEST_IMAGE)
                    .withExposedPorts(8080, 8081);

    @BeforeEach
    public void setUp() throws SQLException
    {
        Properties propsConn = new Properties();
        propsConn.put("user", m_postgresContainer.getUsername());
        propsConn.put("password", m_postgresContainer.getPassword());
        propsConn.put("currentSchema", POSTGRE_SCHEMA);
        m_connDb = DriverManager.getConnection(m_postgresContainer.getJdbcUrl(), propsConn);
        Statement stmtExecute = m_connDb.createStatement();
        stmtExecute.execute(POSTGRE_CREATE_SCHEMA);
        PLPGSQlScriptProvider.initProvider();
        SqlProvider sqlProvider = new PLPGSQlScriptProvider();
        SqlProviderManager.setCompatibleProvider(sqlProvider);

        assertTrue(sqlProvider.createDatabase(m_connDb));
    }

    @AfterEach
    public void tearDown() throws SQLException
    {
        m_connDb.close();

        m_postgresContainer.stop();
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
        String strPtTypeJson = "[" + listPointTypes.stream()
                            .map(ptType -> ((ISerialiseState) ptType).toJson())
                            .collect(Collectors.joining(",")) + "]";

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
        assertEquals(1999, listRefs.get(0).getDate().getYear());

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
    public void testRemoveSurveyPoint() throws SQLException
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

        ptSurvey = SurveyPointAdapter.add(m_connDb, ptSurvey);


        // Now delete the survey point and show that it no longer exists...

        assertTrue(SurveyPointAdapter.remove(m_connDb, ptSurvey));
        assertNull(SurveyPointAdapter.get(m_connDb, ptSurvey.getID()));

        // Now add a survey point type and show this cannot be deleted until all foreign key references are gone.

        ISurveyPointType ptType = SurveyPointTypeAdapter.createNewSurveyPointType();
        ptType.setName("Bobby");
        ptType.setAbbreviation("BOB");
        ptType.setUserDefined(true);
        ptType = SurveyPointTypeAdapter.add(m_connDb, ptType);

        ptSurvey = SurveyPointAdapter.createNewSurveyPoint();

        ptSurvey.setName("First Point");
        ptSurvey.setDescription("The first point in the survey");
        ptSurvey.setX(1000.0);
        ptSurvey.setY(2000.0);
        ptSurvey.setZ(500.0);
        ptSurvey.setPointType(ptType);
        ptSurvey.setReference(listRefs.get(0));

        SurveyPointAdapter.add(m_connDb, ptSurvey);

        assertFalse(SurveyPointTypeAdapter.remove(m_connDb, ptType));

        ptSurvey.setPointType(listPointTypes.get(3));
        SurveyPointAdapter.update(m_connDb, ptSurvey);

        assertTrue(SurveyPointTypeAdapter.remove(m_connDb, ptType));
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

        String strJson = ((UndoTarget) survMeas).toJson();
        assertEquals(90.0, survMeas.getBearing(), 0.01);
        assertEquals(100.0, survMeas.getHorizDistance(), 0.01);
        assertEquals(50.0, survMeas.getVertDistance(), 0.01);
        assertEquals("First Point", survMeas.getPointFrom().getName());
        assertEquals("Second Point", survMeas.getPointTo().getName());
        assertTrue(((UndoTarget) survMeas).isSaved());


    }

    String TRAVERSE_JSON = "{\"ID\":1,\"created\":\"2021-07-01T04:00:43.244Z\",\"updated\":\"2021-07-01T04:00:43.244Z\",\"Name\":\"New Traverse\",\"Description\":\"A new traverse\",\"StartPointID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.171Z\",\"updated\":\"2021-07-01T04:00:43.171Z\",\"X\":1000.0,\"Y\":2000.0,\"Z\":500.0,\"Name\":\"First Point\",\"Description\":\"The first point in the survey\",\"PointTypeID\":{\"ID\":4,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Trig Point\",\"Abbreviation\":\"Trig\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"EndPointID\":{\"ID\":4,\"created\":\"2021-07-01T04:00:43.222Z\",\"updated\":\"2021-07-01T04:00:43.222Z\",\"X\":1100.0,\"Y\":2000.0,\"Z\":550.0,\"Name\":\"Second Point\",\"Description\":\"The second point in the survey\",\"PointTypeID\":{\"ID\":8,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Boundary\",\"Abbreviation\":\"Bdy\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"TraverseClosure\":[],\"Traverse_SurveyMeasurement\":[{\"ID\":1,\"created\":\"2021-07-01T04:00:43.188Z\",\"updated\":\"2021-07-01T04:00:43.188Z\",\"HorizDistance\":100.0,\"VertDistance\":10.0,\"Bearing\":0.0,\"FromPtID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.171Z\",\"updated\":\"2021-07-01T04:00:43.171Z\",\"X\":1000.0,\"Y\":2000.0,\"Z\":500.0,\"Name\":\"First Point\",\"Description\":\"The first point in the survey\",\"PointTypeID\":{\"ID\":4,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Trig Point\",\"Abbreviation\":\"Trig\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"ToPtID\":{\"ID\":2,\"created\":\"2021-07-01T04:00:43.178Z\",\"updated\":\"2021-07-01T04:00:43.178Z\",\"X\":1000.0,\"Y\":2100.0,\"Z\":510.0,\"Name\":\"Trav 1\",\"Description\":\"First traverse point\",\"PointTypeID\":{\"ID\":8,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Boundary\",\"Abbreviation\":\"Bdy\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"SurveyAdjustmentID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.184Z\",\"updated\":\"2021-07-01T04:00:43.184Z\",\"DeltaX\":0.0,\"DeltaY\":0.0,\"DeltaZ\":0.0,\"BearingAdj\":0.0},\"SurveyID\":1},{\"ID\":2,\"created\":\"2021-07-01T04:00:43.211Z\",\"updated\":\"2021-07-01T04:00:43.211Z\",\"HorizDistance\":100.0,\"VertDistance\":20.0,\"Bearing\":90.0,\"FromPtID\":{\"ID\":2,\"created\":\"2021-07-01T04:00:43.178Z\",\"updated\":\"2021-07-01T04:00:43.178Z\",\"X\":1000.0,\"Y\":2100.0,\"Z\":510.0,\"Name\":\"Trav 1\",\"Description\":\"First traverse point\",\"PointTypeID\":{\"ID\":8,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Boundary\",\"Abbreviation\":\"Bdy\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"ToPtID\":{\"ID\":3,\"created\":\"2021-07-01T04:00:43.203Z\",\"updated\":\"2021-07-01T04:00:43.203Z\",\"X\":1100.0,\"Y\":2100.0,\"Z\":530.0,\"Name\":\"Trav 2\",\"Description\":\"Second traverse point\",\"PointTypeID\":{\"ID\":8,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Boundary\",\"Abbreviation\":\"Bdy\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"SurveyAdjustmentID\":{\"ID\":2,\"created\":\"2021-07-01T04:00:43.209Z\",\"updated\":\"2021-07-01T04:00:43.209Z\",\"DeltaX\":0.0,\"DeltaY\":0.0,\"DeltaZ\":0.0,\"BearingAdj\":0.0},\"SurveyID\":1},{\"ID\":3,\"created\":\"2021-07-01T04:00:43.228Z\",\"updated\":\"2021-07-01T04:00:43.228Z\",\"HorizDistance\":100.0,\"VertDistance\":20.0,\"Bearing\":180.0,\"FromPtID\":{\"ID\":3,\"created\":\"2021-07-01T04:00:43.203Z\",\"updated\":\"2021-07-01T04:00:43.203Z\",\"X\":1100.0,\"Y\":2100.0,\"Z\":530.0,\"Name\":\"Trav 2\",\"Description\":\"Second traverse point\",\"PointTypeID\":{\"ID\":8,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Boundary\",\"Abbreviation\":\"Bdy\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"ToPtID\":{\"ID\":4,\"created\":\"2021-07-01T04:00:43.222Z\",\"updated\":\"2021-07-01T04:00:43.222Z\",\"X\":1100.0,\"Y\":2000.0,\"Z\":550.0,\"Name\":\"Second Point\",\"Description\":\"The second point in the survey\",\"PointTypeID\":{\"ID\":8,\"created\":\"2021-07-01T04:00:43.023Z\",\"updated\":\"2021-07-01T04:00:43.023Z\",\"Name\":\"Boundary\",\"Abbreviation\":\"Bdy\",\"UserDefined\":false},\"RefID\":{\"ID\":1,\"created\":\"2021-07-01T04:00:43.030Z\",\"updated\":\"2021-07-01T04:00:43.030Z\",\"Name\":\"Current Survey\",\"Description\":\"Current Survey\",\"Date\":\"1999-12-31T14:00:00.000Z\",\"Reference\":\"No Ref\"},\"Images\":[]},\"SurveyAdjustmentID\":{\"ID\":3,\"created\":\"2021-07-01T04:00:43.227Z\",\"updated\":\"2021-07-01T04:00:43.227Z\",\"DeltaX\":0.0,\"DeltaY\":0.0,\"DeltaZ\":0.0,\"BearingAdj\":0.0},\"SurveyID\":1}],\"SurveyID\":1}";
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

        String strJson = ((ISerialiseState) survey).toJson();

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
        strJson = ((ISerialiseState)travTest).toJson();
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

        strJson = ((ISerialiseState) listSurveys.get(0)).toJson();
        GsonBuilder gsonBuild = new GsonBuilder()
                                    .registerTypeAdapter(ISurvey.class, new SurveyAdapter())
                                    .setDateFormat("yyyy-MM-dd hh:mm:ss");
        Gson gsonInstance = gsonBuild.create();
        ISurvey surveySerial = gsonInstance.fromJson(strJson, ISurvey.class);

        assertEquals("Test Survey", surveySerial.getName());
        assertEquals("Testing...", surveySerial.getDescription());
        assertEquals(1, surveySerial.getTraverses().size());
        assertEquals(3, surveySerial.getTraverses().get(0).getSurveyMeasurements().size());

        ITraverseSummary travSummary = TraverseSummaryAdapter.get(m_connDb, travTest.getID());
        assertEquals(travTest.getStartPoint().getID(), travSummary.getPtStart().getPtStartID());
        assertEquals(travTest.getEndPoint().getID(), travSummary.getPtEnd().getPtEndID());

        strJson = ((ISerialiseState) travSummary).toJson();

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

        strJson = ((ISerialiseState) ptSummary).toJson();

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

        strJson = ((ISerialiseState) travMeasSummary).toJson();

        List<ITraverseMeasurementSummary> listTrav = TraverseMeasurementSummaryAdapter.getForPathQuery(m_connDb, 1, 1);

        assertEquals(1, listTrav.size());

        gsonBuild = new GsonBuilder()
            .registerTypeAdapter(ITraverse.class, new TraverseAdapter())
            .setDateFormat("yyyy-MM-dd hh:mm:ss");
        gsonInstance = gsonBuild.create();
        ITraverse traverseSerial = gsonInstance.fromJson(TRAVERSE_JSON, ITraverse.class);

        assertNotNull(traverseSerial);
    }
}

