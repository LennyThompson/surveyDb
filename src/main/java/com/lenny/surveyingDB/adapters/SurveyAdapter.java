// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Jul 19 20:45:27 AEST 2021

package com.lenny.surveyingDB.adapters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.OffsetDateTime;
import java.util.stream.Collectors;

// log4j types
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.google.gson.annotations.SerializedName;
import com.lenny.Utils.*;
import com.lenny.surveyingDB.SqlProvider;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.interfaces.IProjection;
import com.lenny.surveyingDB.adapters.ProjectionAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.adapters.SurveyImageAdapter;
import com.lenny.surveyingDB.adapters.TraverseAdapter;
import com.lenny.surveyingDB.adapters.InstrumentAdapter;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;


public class SurveyAdapter implements JsonDeserializer<ISurvey>
{
    private static final Logger LOGGER = LogManager.getLogger(SurveyAdapter.class.getName());

    // Class implements ISurvey but only accessible through the SurveyAdapter

    public static class Survey extends UndoTarget implements ISurvey
    {
        @SerializedName("ID")
        private int m_nID;
        @SerializedName("created")
        private OffsetDateTime m_dateCreated;
        @SerializedName("updated")
        private OffsetDateTime m_dateUpdated;
        @SerializedName("Name")
        private String m_strName;
        @SerializedName("Description")
        private String m_strDescription;

        @SerializedName("ProjectionID")
        private IProjection m_typeProjection;

        @SerializedName("Measurements")
        private List<ISurveyMeasurement> m_listSurveyMeasurement;
        @SerializedName("Images")
        private List<ISurveyImage> m_listSurveyImage;
        @SerializedName("Traverses")
        private List<ITraverse> m_listTraverse;
        @SerializedName("Survey_Instrument")
        private List<IInstrument> m_listInstrument;
        @SerializedName("Survey_SurveyPoint")
        private List<ISurveyPoint> m_listSurveyPoint;

        Survey()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_strName = "";
            m_strDescription = "";

            m_typeProjection = ProjectionAdapter.createNewProjection();

            m_listSurveyMeasurement = new ArrayList<>();
            m_listSurveyImage = new ArrayList<>();
            m_listTraverse = new ArrayList<>();
            m_listInstrument = new ArrayList<>();
            m_listSurveyPoint = new ArrayList<>();

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        Survey(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strName, String strDescription, IProjection typeProjection, List<ISurveyMeasurement> listSurveyMeasurement, List<ISurveyImage> listSurveyImage, List<ITraverse> listTraverse, List<IInstrument> listInstrument, List<ISurveyPoint> listSurveyPoint)
        {
            super();
            m_nID = nID;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_strName = strName;
            m_strDescription = strDescription;
            m_typeProjection = typeProjection;
            m_listSurveyMeasurement = listSurveyMeasurement;
            m_listSurveyImage = listSurveyImage;
            m_listTraverse = listTraverse;
            m_listInstrument = listInstrument;
            m_listSurveyPoint = listSurveyPoint;
            m_saveState = DataSaveState.SAVE_STATE_SAVED;
        }

        public int getID()
        {
            return  m_nID;
        }
        public OffsetDateTime getCreated()
        {
            return  m_dateCreated;
        }
        public OffsetDateTime getUpdated()
        {
            return  m_dateUpdated;
        }
        public String getName()
        {
            return  m_strName;
        }
        public String getDescription()
        {
            return  m_strDescription;
        }

        public IProjection getProjection()
        {
            return  m_typeProjection;
        }

        public List<ISurveyMeasurement> getSurveyMeasurements()
        {
            return  m_listSurveyMeasurement;
        }
        public List<ISurveyImage> getSurveyImages()
        {
            return  m_listSurveyImage;
        }
        public List<ITraverse> getTraverses()
        {
            return  m_listTraverse;
        }
        public List<IInstrument> getInstruments()
        {
            return  m_listInstrument;
        }
        public List<ISurveyPoint> getSurveyPoints()
        {
            return  m_listSurveyPoint;
        }

        public void setName(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Name = " + Survey.this.m_strName)
                {
                    String m_undoName = Survey.this.m_strName;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Survey.this.m_strName = m_undoName;
                            if(Survey.this.m_saveState != m_dataSaveState)
                            {
                                Survey.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_strName = strSet;
            setUpdated();
        }
        public void setDescription(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Description = " + Survey.this.m_strDescription)
                {
                    String m_undoDescription = Survey.this.m_strDescription;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Survey.this.m_strDescription = m_undoDescription;
                            if(Survey.this.m_saveState != m_dataSaveState)
                            {
                                Survey.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_strDescription = strSet;
            setUpdated();
        }

        public void setProjection(IProjection typeSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Projection = " + Survey.this.m_typeProjection)
                {
                    IProjection m_undoProjection = Survey.this.m_typeProjection;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Survey.this.m_typeProjection = m_undoProjection;
                            if(Survey.this.m_saveState != m_dataSaveState)
                            {
                                Survey.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_typeProjection = typeSet;
            setUpdated();
        }

        public void addSurveyMeasurement(ISurveyMeasurement typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member SurveyMeasurement = " + Survey.this.m_listSurveyMeasurement)
                    {
                        ISurveyMeasurement m_undoSurveyMeasurement = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_listSurveyMeasurement.remove(m_undoSurveyMeasurement);
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listSurveyMeasurement.add(typeAdd);
            ((SurveyMeasurementAdapter.SurveyMeasurement) typeAdd).setSurveyID(getID());
            setUpdated();
        }
        public void addSurveyImage(ISurveyImage typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member SurveyImage = " + Survey.this.m_listSurveyImage)
                    {
                        ISurveyImage m_undoSurveyImage = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_listSurveyImage.remove(m_undoSurveyImage);
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listSurveyImage.add(typeAdd);
            ((SurveyImageAdapter.SurveyImage) typeAdd).setSurveyID(getID());
            setUpdated();
        }
        public void addTraverse(ITraverse typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Traverse = " + Survey.this.m_listTraverse)
                    {
                        ITraverse m_undoTraverse = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_listTraverse.remove(m_undoTraverse);
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listTraverse.add(typeAdd);
            ((TraverseAdapter.Traverse) typeAdd).setSurveyID(getID());
            setUpdated();
        }
        public void addInstrument(IInstrument typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Instrument = " + Survey.this.m_listInstrument)
                    {
                        IInstrument m_undoInstrument = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_listInstrument.remove(m_undoInstrument);
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listInstrument.add(typeAdd);
            setUpdated();
        }
        public void addSurveyPoint(ISurveyPoint typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member SurveyPoint = " + Survey.this.m_listSurveyPoint)
                    {
                        ISurveyPoint m_undoSurveyPoint = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_listSurveyPoint.remove(m_undoSurveyPoint);
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listSurveyPoint.add(typeAdd);
            setUpdated();
        }

        public void setSaved(){ onSave(); m_saveState = DataSaveState.SAVE_STATE_SAVED; }
        public void setUpdated(){ if(!isNew()) { onSave(); m_saveState = DataSaveState.SAVE_STATE_UPDATE; } }

        public String toJson()
        {
            String strJson = "{";
            strJson += "\"ID\":" + m_nID + ",";
            strJson += "\"created\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateCreated) + "\"" + ",";
            strJson += "\"updated\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateUpdated) + "\"" + ",";
            strJson += "\"Name\":" + "\"" + m_strName + "\"" + ",";
            strJson += "\"Description\":" + "\"" + m_strDescription + "\"" + ",";
            strJson += "\"ProjectionID\":" + ((ISerialiseState) m_typeProjection).toJson() + ",";
            strJson += "\"Measurements\":[" + m_listSurveyMeasurement.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
            strJson += "\"Images\":[" + m_listSurveyImage.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
            strJson += "\"Traverses\":[" + m_listTraverse.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
            strJson += "\"Survey_Instrument\":[" + m_listInstrument.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
            strJson += "\"Survey_SurveyPoint\":[" + m_listSurveyPoint.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
            strJson += "\"SaveState\":\"" + m_saveState + "\"";
            strJson += "}";
            return strJson;
        }
    }
    public static final String TABLE_NAME = "Survey";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_PROJECTIONID = "ProjectionID";
    public static final String FIELD_DESCRIPTION = "Description";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurvey createNewSurvey()
    {
        return new Survey();
    }

    public static ISurvey createSurvey
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        IProjection typeProjection,
        List<ISurveyMeasurement> listSurveyMeasurement,
        List<ISurveyImage> listSurveyImage,
        List<ITraverse> listTraverse,
        List<IInstrument> listInstrument,
        List<ISurveyPoint> listSurveyPoint
    )
    {
        return new Survey(nID, dateCreated, dateUpdated, strName, strDescription, typeProjection, listSurveyMeasurement, listSurveyImage, listTraverse, listInstrument, listSurveyPoint);
    }

    public static ISurvey updateSurvey
    (
        ISurvey typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        IProjection typeProjection,
        List<ISurveyMeasurement> listSurveyMeasurement,
        List<ISurveyImage> listSurveyImage,
        List<ITraverse> listTraverse,
        List<IInstrument> listInstrument,
        List<ISurveyPoint> listSurveyPoint
    )
    {
        Survey updating = (Survey) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strName = strName;;
        updating.m_strDescription = strDescription;;
        updating.m_typeProjection = typeProjection;;
        updating.m_listSurveyMeasurement = listSurveyMeasurement;;
        updating.m_listSurveyImage = listSurveyImage;;
        updating.m_listTraverse = listTraverse;;
        updating.m_listInstrument = listInstrument;;
        updating.m_listSurveyPoint = listSurveyPoint;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ISurvey
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurvey.class, new SurveyAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurvey serialised = gsonInstance.fromJson(strJson, ISurvey.class);

    public ISurvey deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(IProjection.class, new ProjectionAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyImage.class, new SurveyImageAdapter());
        gsonBuilder.registerTypeAdapter(ITraverse.class, new TraverseAdapter());
        gsonBuilder.registerTypeAdapter(IInstrument.class, new InstrumentAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());

        Gson gsonInstance = gsonBuilder.create();
        SurveyAdapter.Survey typeSurvey = gsonInstance.fromJson(json, SurveyAdapter.Survey.class);
        return typeSurvey;
    }

    public static ISurvey get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurvey typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting Survey id = " + nIdGet + " from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            if (nIdGet > 0)
            {
                stmtSelect.setInt(1, nIdGet);
            }
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                typeReturn = createSurveyFromQueryResults(connDb, results);
                LOGGER.debug("Survey data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No Survey data for id = " + nIdGet + " from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading from db for id = " + nIdGet, exc);
        }
        finally
        {
            if (results != null)
            {
                results.close();
            }
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return typeReturn;
    }
    public static ISurvey getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last Survey from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last Survey data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last Survey  from db", exc);
        }
        finally
        {
            if (results != null)
            {
                results.close();
            }
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return null;
    }
    public static ISurvey updateFromLast(Connection connDb, ISurvey typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating Survey id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find Survey id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of Survey id = " + typeUpdate.getID() + " to db failed", exc);
        }
        finally
        {
            if (results != null)
            {
                results.close();
            }
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return null;
    }
    public static int getLastId(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting Survey id from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return results.getInt(1);
            }
            else
            {
                LOGGER.debug("No last Survey in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last Survey id from db failed", exc);
        }
        finally
        {
            if (results != null)
            {
                results.close();
            }
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return 0;
    }

    public static List<ISurvey> getAll(Connection connDb) throws SQLException
    {
        List<ISurvey> listReturn = new ArrayList<ISurvey>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all Survey data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " Survey data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all Survey from db failed", exc);
        }
        finally
        {
            if (results != null)
            {
                results.close();
            }
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return listReturn;
    }

    public static ISurvey add(Connection connDb, ISurvey typeAdd) throws SQLException
    {
        if (!((ISerialiseState) typeAdd).isNew())
        {
            if (((ISerialiseState) typeAdd).isUpdated())
            {
                // Update semantics are slightly different at add
                return update(connDb, typeAdd);
            }
            // Nothing to save...
            return null;
        }
        LOGGER.info("Adding Survey data to db");
        LOGGER.debug("Adding Survey data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        if (((UndoTarget) typeAdd.getProjection()).isNew())
        {
            typeAdd.setProjection(ProjectionAdapter.add(connDb, typeAdd.getProjection()));
        }
        else if (((UndoTarget) typeAdd.getProjection()).isUpdated())
        {
            typeAdd.setProjection(ProjectionAdapter.update(connDb, typeAdd.getProjection()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.parametersHandler().prepareInsert(stmtSelect, typeAdd);
            stmtSelect.executeUpdate();

            ((Survey) typeAdd).m_nID = getLastId(connDb);

            ((Survey) typeAdd).m_listSurveyMeasurement = typeAdd.getSurveyMeasurements().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return SurveyMeasurementAdapter.add(connDb, item);
                        }
                        catch (SQLException exc)
                        {
                            LOGGER.error("Error updating external references", exc);
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listSurveyImage = typeAdd.getSurveyImages().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return SurveyImageAdapter.add(connDb, item);
                        }
                        catch (SQLException exc)
                        {
                            LOGGER.error("Error updating external references", exc);
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listTraverse = typeAdd.getTraverses().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return TraverseAdapter.add(connDb, item);
                        }
                        catch (SQLException exc)
                        {
                            LOGGER.error("Error updating external references", exc);
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listInstrument = typeAdd.getInstruments().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return InstrumentAdapter.addForSurvey(connDb, item, typeAdd);
                        }
                        catch (SQLException exc)
                        {
                            LOGGER.error("Error updating external references", exc);
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listSurveyPoint = typeAdd.getSurveyPoints().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return SurveyPointAdapter.addForSurvey(connDb, item, typeAdd);
                        }
                        catch (SQLException exc)
                        {
                            LOGGER.error("Error updating external references", exc);
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added Survey data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding Survey to db failed", exc);
        }
        finally
        {
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return null;
    }
    public static ISurvey update(Connection connDb, ISurvey typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating Survey data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating Survey, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating Survey data - " + ((ISerialiseState) typeUpdate).toJson());
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(SQL_PROVIDER.updateScript());
                SQL_PROVIDER.parametersHandler().prepareUpdate(stmtSelect, typeUpdate);
                ((Survey) typeUpdate).m_listSurveyMeasurement = typeUpdate.getSurveyMeasurements().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return SurveyMeasurementAdapter.update(connDb, item);
                            }
                            catch (SQLException exc)
                            {
                                LOGGER.error("Error updating external references", exc);
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listSurveyImage = typeUpdate.getSurveyImages().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return SurveyImageAdapter.update(connDb, item);
                            }
                            catch (SQLException exc)
                            {
                                LOGGER.error("Error updating external references", exc);
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listTraverse = typeUpdate.getTraverses().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return TraverseAdapter.update(connDb, item);
                            }
                            catch (SQLException exc)
                            {
                                LOGGER.error("Error updating external references", exc);
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listInstrument = typeUpdate.getInstruments().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return InstrumentAdapter.updateForSurvey(connDb, item, typeUpdate);
                            }
                            catch (SQLException exc)
                            {
                                LOGGER.error("Error updating external references", exc);
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listSurveyPoint = typeUpdate.getSurveyPoints().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return SurveyPointAdapter.updateForSurvey(connDb, item, typeUpdate);
                            }
                            catch (SQLException exc)
                            {
                                LOGGER.error("Error updating external references", exc);
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());

                stmtSelect.executeUpdate();
                // This will cancel any pending undo items
                ((ISerialiseState) typeUpdate).setSaved();
                return updateFromDatabase(connDb, typeUpdate);
            }
            catch (SQLException exc)
            {
                // TODO: set up error handling
                LOGGER.error("Adding Survey to db failed", exc);
            }
            finally
            {
                if (stmtSelect != null)
                {
                    stmtSelect.close();
                }
            }
            return null;
        }
        return typeUpdate;
    }

    public static ISurvey updateFromDatabase(Connection connDb, ISurvey typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database Survey, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database Survey, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for Survey, id = " + typeUpdate.getID() + " from db failed", exc);
        }
        finally
        {
            if (results != null)
            {
                results.close();
            }
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return null;
    }
    public static boolean remove(Connection connDb, ISurvey typeRemove) throws SQLException
    {
        LOGGER.info("Removing Survey data in db");
        LOGGER.debug("Removing Survey data - " + ((ISerialiseState) typeRemove).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.deleteByPrimaryKeyScript());
            SQL_PROVIDER.parametersHandler().prepareDelete(stmtSelect, typeRemove);
            if(stmtSelect.executeUpdate() == 1)
            {
                LOGGER.info("Removed Survey data from db");
                LOGGER.debug("Removed " + ((ISerialiseState) typeRemove).toJson());
                return true;
            }
            else
            {
                LOGGER.info("Could not remove Survey data from db");
                return false;
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Removing Survey from db failed", exc);
        }
        finally
        {
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return false;
    }





    static boolean addSurveyForInstrument(Connection connDb, int nID, IInstrument typeUpdate) throws SQLException
    {
        return InstrumentAdapter.addForSurvey(connDb, typeUpdate, nID) != null;
    }


    static boolean addSurveyForSurveyPoint(Connection connDb, int nID, ISurveyPoint typeUpdate) throws SQLException
    {
        return SurveyPointAdapter.addForSurvey(connDb, typeUpdate, nID) != null;
    }



    private static ISurvey createSurveyFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ISurvey) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ISurvey updateSurveyFromQueryResults(Connection connDb, ResultSet results, ISurvey typeUpdate) throws SQLException
    {
        return (ISurvey) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_PROJECTIONID
            + " FROM " +
            TABLE_NAME;
        if (nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_PROJECTIONID
            + ") VALUES (?,  ?,  ?)";
        return strInsert;
    }
    private static String getSelectLastIdQuery()
    {
        return "SELECT MAX(" + PRIMARY_KEY + ") AS maxPK FROM " + TABLE_NAME;
    }
    private static String getSelectLastQuery()
    {
        String strSelectLast = "SELECT MAX(" + PRIMARY_KEY + ") AS maxPK, " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_PROJECTIONID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_DESCRIPTION + " = ?,  " +
            FIELD_PROJECTIONID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `Survey` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name`  TEXT NOT NULL, " + 
        "`ProjectionID` INTEGER NOT NULL, " + 
        "`Description`   TEXT, " + 
        "FOREIGN KEY (ProjectionID) REFERENCES Projection(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger Survey after update on `Survey` " + 
            "for each row " + 
            "begin " + 
            "update Survey set updated = current_timestamp where ID == OLD.ID; " + 
            "end;"
    };

    public static String[] getExtraTableScripts()
    {
        return TABLE_EXTRA_SCRIPTS;
    }

    public static void createInDatabase(Connection connDb)
    {
        SQL_PROVIDER.createInDatabase(connDb);
    }

    public static boolean setSqlProvider(SqlProvider.SqlScriptProvider provider)
    {
        if(provider != null)
        {
            SQL_PROVIDER = provider;
            return true;
        }
        else
        {
            SQL_PROVIDER = SQL_PROVIDER_DEFAULT;
        }
        return false;
    }

    private static SqlProvider.SqlScriptProvider SQL_PROVIDER_DEFAULT = new SqlProvider.SqlScriptProvider()
    {
        @Override
        public String target()
        {
            return "survey";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_NAME + ",  " +
                       FIELD_DESCRIPTION + ",  " +
                       FIELD_PROJECTIONID
                       + " FROM " +
                       TABLE_NAME;
        }
        @Override
        public String selectByPrimaryKeyScript()
        {
            return "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_PROJECTIONID
            + " FROM " +
            TABLE_NAME + " WHERE " + PRIMARY_KEY + " = ?";
        }
        public String selectFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                default:
                    return "";
            }
        }
        @Override
        public String selectLastId()
        {
            return "SELECT MAX(" + PRIMARY_KEY + ") AS maxPK FROM " + TABLE_NAME;
        }
        @Override
        public String selectLast()
        {
            return "SELECT " +
                             FIELD_ID + ",  " +
                             FIELD_CREATED + ",  " +
                             FIELD_UPDATED + ",  " +
                             FIELD_NAME + ",  " +
                             FIELD_DESCRIPTION + ",  " +
                             FIELD_PROJECTIONID
                             + " FROM " +
                             TABLE_NAME +
                             " WHERE " + PRIMARY_KEY + " = (" + selectLastId() + ")";
        }
        @Override
        public String selectForPath(Integer[] path)
        {
            return "";
        }
        @Override
        public String insertScript()
        {
            return "INSERT INTO " + TABLE_NAME + "(" +
                        FIELD_NAME + ",  " +
                        FIELD_DESCRIPTION + ",  " +
                        FIELD_PROJECTIONID
                        + ") VALUES (?,  ?,  ?)";
        }
        @Override
        public String insertFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                default:
                    return "";
            }
        }
        @Override
        public String selectHistory()
        {
            return "";
        }
        @Override
        public String updateScript()
        {
            return "UPDATE " + TABLE_NAME + " SET " +
                               FIELD_NAME + " = ?,  " +
                               FIELD_DESCRIPTION + " = ?,  " +
                               FIELD_PROJECTIONID + " = ?"
                           + " WHERE " + PRIMARY_KEY + " = ?";
        }
        @Override
        public String deleteScript()
        {
            return "";
        }
        @Override
        public String deleteByPrimaryKeyScript()
        {
            return "";
        }
        public String deleteFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                default:
                    return "";
            }
        }
        @Override
        public String createScript()
        {
            return CREATE_TABLE_SCRIPT;
        }
        @Override
        public String removeScript()
        {
            return "";
        }
        @Override
        public String triggerScript()
        {
            return Arrays.stream(TABLE_EXTRA_SCRIPTS).collect(Collectors.joining(" \n"));
        }
        @Override
        public String staticInsertsScript()
        {
            return "";
        }
        @Override
        public boolean createInDatabase(Connection connDb)
        {
            try
            {
                LOGGER.debug("Creating Survey in database");
                Statement stmtExecute = connDb.createStatement();
                stmtExecute.execute(createScript());
                LOGGER.debug("Survey create script - " + createScript());

                for(String strStatement : TABLE_EXTRA_SCRIPTS)
                {
                    stmtExecute.execute(strStatement);
                }
                LOGGER.debug("Survey extra script - " + triggerScript());

                if(!SQL_PROVIDER.staticInsertsScript().isEmpty())
                {
                    String[] listStatements = staticInsertsScript().split(";");
                    for(String strStatement : listStatements)
                    {
                        stmtExecute.execute(strStatement);
                    }
                    LOGGER.debug("Survey extra script - " + staticInsertsScript());
                }
                return true;
            }
            catch(SQLException exc)
            {
                LOGGER.error("Error executing scripts", exc);
            }
            return false;
        }

        private SqlProvider.SqlResultHandler<ISurvey> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ISurvey> resultsHandler()
        {
            if(m_resultsHandler == null)
            {
                m_resultsHandler = new SqlProvider.SqlResultHandler<ISurvey>()
                   {
                        @Override
                        public ISurvey fromResults(Connection connDb, ResultSet results)
                        {
                            try
                            {
                                return createSurvey
                                (
                                    results.getInt(FIELD_ID),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                    results.getString(FIELD_NAME),
                                    results.getString(FIELD_DESCRIPTION),
                                    ProjectionAdapter.get(connDb, results.getInt(FIELD_PROJECTIONID)),
                                    SurveyMeasurementAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    SurveyImageAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    TraverseAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    InstrumentAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    SurveyPointAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID))
                                );
                            }
                            catch(SQLException exc)
                            {
                                LOGGER.error("Error parsing result set", exc);
                            }
                            return null;
                        }
                        @Override
                        public ISurvey updateFromResults(ISurvey typeUpdate, Connection connDb, ResultSet results)
                        {
                            try
                            {
                                return updateSurvey
                                (
                                    typeUpdate,
                                    results.getInt(FIELD_ID),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                    results.getString(FIELD_NAME),
                                    results.getString(FIELD_DESCRIPTION),
                                    ProjectionAdapter.get(connDb, results.getInt(FIELD_PROJECTIONID)),
                                    SurveyMeasurementAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    SurveyImageAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    TraverseAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    InstrumentAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                                    SurveyPointAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID))
                                );
                            }
                            catch(SQLException exc)
                            {
                                LOGGER.error("Error parsing result set", exc);
                            }
                            return null;
                        }
                   };
            }
            return m_resultsHandler;
        }
        private SqlProvider.SqlParameterHandler<ISurvey> m_parametersHandler;
        @Override
        public SqlProvider.SqlParameterHandler<ISurvey> parametersHandler()
        {
            if(m_parametersHandler == null)
            {
                m_parametersHandler = new SqlProvider.SqlParameterHandler<ISurvey>()
                {
                    @Override
                    public boolean prepareInsert(PreparedStatement stmtSelect, ISurvey typeInsert)
                    {
                        try
                        {
                            stmtSelect.setString(1, typeInsert.getName());
                            stmtSelect.setString(2, typeInsert.getDescription());
                            stmtSelect.setInt(3, typeInsert.getProjection().getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;
                    }
                    @Override
                    public boolean prepareInsertFor(PreparedStatement stmt, ISurvey type, String strContext)
                    {
                        return false;
                    }
                    @Override
                    public boolean prepareUpdate(PreparedStatement stmtSelect, ISurvey typeUpdate)
                    {
                        try
                        {
                            stmtSelect.setString(1, typeUpdate.getName());
                            stmtSelect.setString(2, typeUpdate.getDescription());
                            stmtSelect.setInt(3, typeUpdate.getProjection().getID());
                            stmtSelect.setInt(4, typeUpdate.getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;

                    }
                    @Override
                    public boolean prepareDelete(PreparedStatement stmtSelect, ISurvey typeDelete)
                    {
                        try
                        {
                            stmtSelect.setInt(1, typeDelete.getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;

                    }
                    @Override
                    public boolean prepareDeleteFor(PreparedStatement stmt, ISurvey type, String strContext)
                    {
                        return false;
                    }
                };
            }
            return m_parametersHandler;
        }

    };
    private static SqlProvider.SqlScriptProvider SQL_PROVIDER = SQL_PROVIDER_DEFAULT;

}
