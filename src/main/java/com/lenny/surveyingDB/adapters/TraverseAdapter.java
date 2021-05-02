// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun May 02 18:32:07 AEST 2021

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
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.TraverseClosureAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;


public class TraverseAdapter implements JsonDeserializer<ITraverse>
{
    private static final Logger LOGGER = LogManager.getLogger(TraverseAdapter.class.getName());

    // Class implements ITraverse but only accessible through the TraverseAdapter

    public static class Traverse extends UndoTarget implements ITraverse
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

        @SerializedName("StartPointID")
        private ISurveyPoint m_typeStartPoint;
        @SerializedName("EndPointID")
        private ISurveyPoint m_typeEndPoint;

        @SerializedName("TraverseClosure")
        private List<ITraverseClosure> m_listTraverseClosure;
        @SerializedName("Traverse_SurveyMeasurement")
        private List<ISurveyMeasurement> m_listSurveyMeasurement;

        @SerializedName("SurveyID")
        private int m_nSurveyID;


        // This constructor is specically for json serialisation, not to be used...
        Traverse()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_strName = "";
            m_strDescription = "";

            m_typeStartPoint = SurveyPointAdapter.createNewSurveyPoint();
            m_typeEndPoint = SurveyPointAdapter.createNewSurveyPoint();

            m_listTraverseClosure = new ArrayList<>();
            m_listSurveyMeasurement = new ArrayList<>();

            m_nSurveyID = 0;

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }

        Traverse
        (
            int nSurveyID
        )
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_strName = "";
            m_strDescription = "";

            m_typeStartPoint = SurveyPointAdapter.createNewSurveyPoint();
            m_typeEndPoint = SurveyPointAdapter.createNewSurveyPoint();

            m_listTraverseClosure = new ArrayList<>();
            m_listSurveyMeasurement = new ArrayList<>();

            m_nSurveyID = nSurveyID;
            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        Traverse(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strName, String strDescription, ISurveyPoint typeStartPoint, ISurveyPoint typeEndPoint, int nSurveyID, List<ITraverseClosure> listTraverseClosure, List<ISurveyMeasurement> listSurveyMeasurement)
        {
            super();
            m_nID = nID;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_strName = strName;
            m_strDescription = strDescription;
            m_typeStartPoint = typeStartPoint;
            m_typeEndPoint = typeEndPoint;
            m_listTraverseClosure = listTraverseClosure;
            m_listSurveyMeasurement = listSurveyMeasurement;
            m_nSurveyID = nSurveyID;
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

        public ISurveyPoint getStartPoint()
        {
            return  m_typeStartPoint;
        }
        public ISurveyPoint getEndPoint()
        {
            return  m_typeEndPoint;
        }

        public List<ITraverseClosure> getTraverseClosures()
        {
            return  m_listTraverseClosure;
        }
        public List<ISurveyMeasurement> getSurveyMeasurements()
        {
            return  m_listSurveyMeasurement;
        }

        public void setName(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(Traverse.this.m_saveState, "Undo set Traverse member Name = " + Traverse.this.m_strName)
                {
                    String m_undoName = Traverse.this.m_strName;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Traverse.this.m_strName = m_undoName;
                            if(Traverse.this.m_saveState != m_dataSaveState)
                            {
                                Traverse.this.m_saveState = m_dataSaveState;
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
                new UndoProviderImpl(Traverse.this.m_saveState, "Undo set Traverse member Description = " + Traverse.this.m_strDescription)
                {
                    String m_undoDescription = Traverse.this.m_strDescription;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Traverse.this.m_strDescription = m_undoDescription;
                            if(Traverse.this.m_saveState != m_dataSaveState)
                            {
                                Traverse.this.m_saveState = m_dataSaveState;
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

        public void setStartPoint(ISurveyPoint typeSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(Traverse.this.m_saveState, "Undo set Traverse member StartPoint = " + Traverse.this.m_typeStartPoint)
                {
                    ISurveyPoint m_undoStartPoint = Traverse.this.m_typeStartPoint;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Traverse.this.m_typeStartPoint = m_undoStartPoint;
                            if(Traverse.this.m_saveState != m_dataSaveState)
                            {
                                Traverse.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_typeStartPoint = typeSet;
            setUpdated();
        }
        public void setEndPoint(ISurveyPoint typeSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(Traverse.this.m_saveState, "Undo set Traverse member EndPoint = " + Traverse.this.m_typeEndPoint)
                {
                    ISurveyPoint m_undoEndPoint = Traverse.this.m_typeEndPoint;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Traverse.this.m_typeEndPoint = m_undoEndPoint;
                            if(Traverse.this.m_saveState != m_dataSaveState)
                            {
                                Traverse.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_typeEndPoint = typeSet;
            setUpdated();
        }

        public void addTraverseClosure(ITraverseClosure typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(Traverse.this.m_saveState, "Undo set Traverse member TraverseClosure = " + Traverse.this.m_listTraverseClosure)
                    {
                        ITraverseClosure m_undoTraverseClosure = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Traverse.this.m_listTraverseClosure.remove(m_undoTraverseClosure);
                                if(Traverse.this.m_saveState != m_dataSaveState)
                                {
                                    Traverse.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listTraverseClosure.add(typeAdd);
            ((TraverseClosureAdapter.TraverseClosure) typeAdd).setTraverseID(getID());
            setUpdated();
        }
        public void addSurveyMeasurement(ISurveyMeasurement typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(Traverse.this.m_saveState, "Undo set Traverse member SurveyMeasurement = " + Traverse.this.m_listSurveyMeasurement)
                    {
                        ISurveyMeasurement m_undoSurveyMeasurement = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Traverse.this.m_listSurveyMeasurement.remove(m_undoSurveyMeasurement);
                                if(Traverse.this.m_saveState != m_dataSaveState)
                                {
                                    Traverse.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listSurveyMeasurement.add(typeAdd);
            setUpdated();
        }

        public int getSurveyID()
        {
            return m_nSurveyID;
        }
        void setSurveyID(int nSurveyID)
        {
            addUndoProvider
            (
                new UndoProviderImpl(Traverse.this.m_saveState, "Undo set Traverse member SurveyID = " + Traverse.this.m_nSurveyID)
                {
                    int m_undoSurveyID = Traverse.this.m_nSurveyID;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            Traverse.this.m_nSurveyID = m_undoSurveyID;
                            if(Traverse.this.m_saveState != m_dataSaveState)
                            {
                                Traverse.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_nSurveyID = nSurveyID;
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
            strJson += "\"StartPointID\":" + ((ISerialiseState) m_typeStartPoint).toJson() + ",";
            strJson += "\"EndPointID\":" + ((ISerialiseState) m_typeEndPoint).toJson() + ",";
            strJson += "\"SurveyID\":" + m_nSurveyID + ",";
            strJson += "\"TraverseClosure\":[" + m_listTraverseClosure.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
            strJson += "\"Traverse_SurveyMeasurement\":[" + m_listSurveyMeasurement.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]";
            strJson += "}";
            return strJson;
        }
    }
    public static final String TABLE_NAME = "Traverse";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_DESCRIPTION = "Description";
    public static final String FIELD_STARTPOINTID = "StartPointID";
    public static final String FIELD_ENDPOINTID = "EndPointID";
    public static final String FIELD_SURVEYID = "SurveyID";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ITraverse createNewTraverse
    (
        int nSurveyID
    )
    {
        return new Traverse
        (
            nSurveyID
        );
    }
    public static ITraverse createTraverse
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        ISurveyPoint typeStartPoint,
        ISurveyPoint typeEndPoint,
        int nSurveyID,
        List<ITraverseClosure> listTraverseClosure,
        List<ISurveyMeasurement> listSurveyMeasurement
    )
    {
        return new Traverse(nID, dateCreated, dateUpdated, strName, strDescription, typeStartPoint, typeEndPoint, nSurveyID, listTraverseClosure, listSurveyMeasurement);
    }

    public static ITraverse updateTraverse
    (
        ITraverse typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        ISurveyPoint typeStartPoint,
        ISurveyPoint typeEndPoint,
        int nSurveyID,
        List<ITraverseClosure> listTraverseClosure,
        List<ISurveyMeasurement> listSurveyMeasurement
    )
    {
        Traverse updating = (Traverse) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strName = strName;;
        updating.m_strDescription = strDescription;;
        updating.m_typeStartPoint = typeStartPoint;;
        updating.m_typeEndPoint = typeEndPoint;;
        updating.m_nSurveyID = nSurveyID;;
        updating.m_listTraverseClosure = listTraverseClosure;;
        updating.m_listSurveyMeasurement = listSurveyMeasurement;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ITraverse
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ITraverse.class, new TraverseAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ITraverse serialised = gsonInstance.fromJson(strJson, ITraverse.class);

    public ITraverse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
        gsonBuilder.registerTypeAdapter(ITraverseClosure.class, new TraverseClosureAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter());

        Gson gsonInstance = gsonBuilder.create();
        TraverseAdapter.Traverse typeTraverse = gsonInstance.fromJson(json, TraverseAdapter.Traverse.class);
        if (typeTraverse.m_nID > 0)
        {
            typeTraverse.setSaved();
        }
        return typeTraverse;
    }

    public static ITraverse get(Connection connDb, int nIdGet) throws SQLException
    {
        ITraverse typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting Traverse id = " + nIdGet + " from db");
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
                typeReturn = createTraverseFromQueryResults(connDb, results);
                LOGGER.debug("Traverse data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No Traverse data for id = " + nIdGet + " from db");
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
    public static ITraverse getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last Traverse from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createTraverseFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last Traverse data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last Traverse  from db", exc);
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
    public static ITraverse updateFromLast(Connection connDb, ITraverse typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating Traverse id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateTraverseFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find Traverse id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of Traverse id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting Traverse id from db");
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
                LOGGER.debug("No last Traverse in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last Traverse id from db failed", exc);
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

    public static List<ITraverse> getAll(Connection connDb) throws SQLException
    {
        List<ITraverse> listReturn = new ArrayList<ITraverse>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all Traverse data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createTraverseFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " Traverse data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all Traverse from db failed", exc);
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

    public static List<ITraverse> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ITraverse> listReturn = new ArrayList<ITraverse>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("Survey"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createTraverseFromQueryResults(connDb, results));
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
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
    public static ITraverse add(Connection connDb, ITraverse typeAdd) throws SQLException
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
        LOGGER.info("Adding Traverse data to db");
        LOGGER.debug("Adding Traverse data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        if (((UndoTarget) typeAdd.getStartPoint()).isNew())
        {
            typeAdd.setStartPoint(SurveyPointAdapter.add(connDb, typeAdd.getStartPoint()));
        }
        else if (((UndoTarget) typeAdd.getStartPoint()).isUpdated())
        {
            typeAdd.setStartPoint(SurveyPointAdapter.update(connDb, typeAdd.getStartPoint()));
        }
        if (((UndoTarget) typeAdd.getEndPoint()).isNew())
        {
            typeAdd.setEndPoint(SurveyPointAdapter.add(connDb, typeAdd.getEndPoint()));
        }
        else if (((UndoTarget) typeAdd.getEndPoint()).isUpdated())
        {
            typeAdd.setEndPoint(SurveyPointAdapter.update(connDb, typeAdd.getEndPoint()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            ((Traverse) typeAdd).m_nID = getLastId(connDb);

            ((Traverse) typeAdd).m_listTraverseClosure = typeAdd.getTraverseClosures().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return TraverseClosureAdapter.add(connDb, item);
                        }
                        catch (SQLException exc)
                        {
                            LOGGER.error("Error updating external references", exc);
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Traverse) typeAdd).m_listSurveyMeasurement = typeAdd.getSurveyMeasurements().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return SurveyMeasurementAdapter.addForTraverse(connDb, item, typeAdd);
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
            LOGGER.info("Added Traverse data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding Traverse to db failed", exc);
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
    public static ITraverse update(Connection connDb, ITraverse typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating Traverse data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating Traverse, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating Traverse data - " + ((ISerialiseState) typeUpdate).toJson());
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(SQL_PROVIDER.updateScript());
                SQL_PROVIDER.resultsHandler().updateExisting(typeUpdate, stmtSelect);
                ((Traverse) typeUpdate).m_listTraverseClosure = typeUpdate.getTraverseClosures().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return TraverseClosureAdapter.update(connDb, item);
                            }
                            catch (SQLException exc)
                            {
                                LOGGER.error("Error updating external references", exc);
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Traverse) typeUpdate).m_listSurveyMeasurement = typeUpdate.getSurveyMeasurements().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return SurveyMeasurementAdapter.updateForTraverse(connDb, item, typeUpdate);
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
                LOGGER.error("Adding Traverse to db failed", exc);
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

    public static ITraverse updateFromDatabase(Connection connDb, ITraverse typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database Traverse, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateTraverseFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database Traverse, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for Traverse, id = " + typeUpdate.getID() + " from db failed", exc);
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



    static boolean addTraverseForSurveyMeasurement(Connection connDb, int nID, ISurveyMeasurement typeUpdate) throws SQLException
    {
        return SurveyMeasurementAdapter.addForTraverse(connDb, typeUpdate, nID) != null;
    }



    private static ITraverse createTraverseFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ITraverse) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ITraverse updateTraverseFromQueryResults(Connection connDb, ResultSet results, ITraverse typeUpdate) throws SQLException
    {
        return (ITraverse) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_STARTPOINTID + ",  " +
            FIELD_ENDPOINTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME;
        if (nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }
    private static String getSelectForSurveyQuery()
    {
        return "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_STARTPOINTID + ",  " +
            FIELD_ENDPOINTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME  +
            " WHERE " +
            FIELD_SURVEYID + " = ?";
    }
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_STARTPOINTID + ",  " +
            FIELD_ENDPOINTID + ",  " +
            FIELD_SURVEYID
            + ") VALUES (?,  ?,  ?,  ?,  ?)";
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
            FIELD_STARTPOINTID + ",  " +
            FIELD_ENDPOINTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_DESCRIPTION + " = ?,  " +
            FIELD_STARTPOINTID + " = ?,  " +
            FIELD_ENDPOINTID + " = ?,  " +
            FIELD_SURVEYID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `Traverse` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name`  TEXT, " + 
        "`Description`   TEXT, " + 
        "`SurveyID` INTEGER NOT NULL, " + 
        "`StartPointID` INTEGER NOT NULL, " + 
        "`EndPointID` INTEGER NOT NULL, " + 
        "FOREIGN KEY (SurveyID) REFERENCES Survey(ID), " + 
        "FOREIGN KEY (StartPointID) REFERENCES SurveyPoint(ID), " + 
        "FOREIGN KEY (EndPointID) REFERENCES SurveyPoint(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateTraverse after update on `Traverse` " + 
            "for each row " + 
            "begin " + 
            "update Traverse set updated = current_timestamp where ID == OLD.ID; " + 
            "end;"
    };

    public static String[] getExtraTableScripts()
    {
        return TABLE_EXTRA_SCRIPTS;
    }

    public static void createInDatabase(Connection connDb) throws SQLException
    {
        LOGGER.debug("Creating Traverse in database");
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(SQL_PROVIDER.createScript());
        LOGGER.debug("Traverse create script - " + SQL_PROVIDER.createScript());
        stmtExecute.execute(SQL_PROVIDER.triggerScript());
        LOGGER.debug("Traverse extra script - " + SQL_PROVIDER.triggerScript());
        stmtExecute.execute(SQL_PROVIDER.staticInsertsScript());
        LOGGER.debug("Traverse extra script - " + SQL_PROVIDER.staticInsertsScript());
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
            return "traverse";
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
                       FIELD_STARTPOINTID + ",  " +
                       FIELD_ENDPOINTID + ",  " +
                       FIELD_SURVEYID
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
            FIELD_STARTPOINTID + ",  " +
            FIELD_ENDPOINTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME + " WHERE " + PRIMARY_KEY + " = ?";
        }
        public String selectFor(String strContext)
        {
            switch(strContext)
            {
                case "survey":
                    return "SELECT " +
                        FIELD_ID + ",  " +
                        FIELD_CREATED + ",  " +
                        FIELD_UPDATED + ",  " +
                        FIELD_NAME + ",  " +
                        FIELD_DESCRIPTION + ",  " +
                        FIELD_STARTPOINTID + ",  " +
                        FIELD_ENDPOINTID + ",  " +
                        FIELD_SURVEYID
                        + " FROM " +
                        TABLE_NAME  +
                        " WHERE " +
                        FIELD_SURVEYID + " = ?";
                default:
                    return "";
            }
        }
        @Override
        public String selectLastId()
        {
            return "SELECT MAX(" + PRIMARY_KEY + ") AS maxPK, FROM " + TABLE_NAME;
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
                             FIELD_STARTPOINTID + ",  " +
                             FIELD_ENDPOINTID + ",  " +
                             FIELD_SURVEYID
                             + " FROM " +
                             TABLE_NAME +
                             " WHERE PRIMARY_KEY = (" + selectLastId() + ")";
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
                        FIELD_STARTPOINTID + ",  " +
                        FIELD_ENDPOINTID + ",  " +
                        FIELD_SURVEYID
                        + ") VALUES (?,  ?,  ?,  ?,  ?)";
        }
        @Override
        public String insertFor(String strContext)
        {
            switch(strContext)
            {
                default:
                    return "";
            }
        }
        @Override
        public String updateScript()
        {
            return "UPDATE " + TABLE_NAME + " SET " +
                               FIELD_NAME + " = ?,  " +
                               FIELD_DESCRIPTION + " = ?,  " +
                               FIELD_STARTPOINTID + " = ?,  " +
                               FIELD_ENDPOINTID + " = ?,  " +
                               FIELD_SURVEYID + " = ?"
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
            switch(strContext)
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
        public String triggerScript()
        {
            return Arrays.stream(TABLE_EXTRA_SCRIPTS).collect(Collectors.joining(" \n"));
        }
        @Override
        public String staticInsertsScript()
        {
            return "";
        }

        private SqlProvider.SqlResultHandler<ITraverse> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ITraverse> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<ITraverse>()
                           {
                                @Override
                                public ITraverse fromResults(Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return createTraverse
                                        (
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_DESCRIPTION),
                                            SurveyPointAdapter.get(connDb, results.getInt(FIELD_STARTPOINTID)),
                                            SurveyPointAdapter.get(connDb, results.getInt(FIELD_ENDPOINTID)),
                                            results.getInt(FIELD_SURVEYID),
                                            TraverseClosureAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID)),
                                            SurveyMeasurementAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID))
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public ITraverse updateFromResults(ITraverse typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateTraverse
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_DESCRIPTION),
                                            SurveyPointAdapter.get(connDb, results.getInt(FIELD_STARTPOINTID)),
                                            SurveyPointAdapter.get(connDb, results.getInt(FIELD_ENDPOINTID)),
                                            results.getInt(FIELD_SURVEYID),
                                            TraverseClosureAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID)),
                                            SurveyMeasurementAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID))
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public boolean insertNew(ITraverse typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeInsert.getName());
                                        stmtSelect.setString(2, typeInsert.getDescription());
                                        stmtSelect.setInt(3, typeInsert.getStartPoint().getID());
                                        stmtSelect.setInt(4, typeInsert.getEndPoint().getID());
                                        stmtSelect.setInt(5, ((TraverseAdapter.Traverse) typeInsert).getSurveyID());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(ITraverse typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeUpdate.getName());
                                        stmtSelect.setString(2, typeUpdate.getDescription());
                                        stmtSelect.setInt(3, typeUpdate.getStartPoint().getID());
                                        stmtSelect.setInt(4, typeUpdate.getEndPoint().getID());
                                        stmtSelect.setInt(5, ((TraverseAdapter.Traverse) typeUpdate).getSurveyID());
                                        stmtSelect.setInt(6, typeUpdate.getID());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;

                                }

                           };
               }
               return m_resultsHandler;
        }

    };
    private static SqlProvider.SqlScriptProvider SQL_PROVIDER = SQL_PROVIDER_DEFAULT;

}
