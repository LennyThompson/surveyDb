// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sat May 13 12:52:41 AEST 2017

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
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import com.google.gson.annotations.SerializedName;
import com.lenny.Utils.*;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.TraverseClosureAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;


public class TraverseAdapter implements JsonDeserializer<ITraverse>
{

        // Class implements ITraverse but only accessible through the TraverseAdapter

        static class Traverse extends UndoTarget implements ITraverse
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
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


            Traverse()
            {
                m_nID = 0;
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_strName = "";
                m_strDescription = "";

                m_typeStartPoint = SurveyPointAdapter.createNewSurveyPoint();
                m_typeEndPoint = SurveyPointAdapter.createNewSurveyPoint();

                m_listTraverseClosure = new ArrayList<>();
                m_listSurveyMeasurement = new ArrayList<>();

                m_nSurveyID = 0;

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            Traverse(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, String strName, String strDescription, ISurveyPoint typeStartPoint, ISurveyPoint typeEndPoint, int nSurveyID, List<ITraverseClosure> listTraverseClosure, List<ISurveyMeasurement> listSurveyMeasurement)
            {
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
            public LocalDateTime getCreated()
            {
                return  m_dateCreated;
            }
            public LocalDateTime getUpdated()
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

    public static ITraverse createNewTraverse()
    {
        return new Traverse();
    }

    public static ITraverse createTraverse
    (
        int nID,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
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

    // This method enables the adapter type to be registered to deserialise json as ITraverse
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ITraverse.class, new TraverseAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ITraverse serialised = gsonInstance.fromJson(strJson, ITraverse.class);

    public ITraverse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
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
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(nIdGet));
            if (nIdGet > 0)
            {
                stmtSelect.setInt(1, nIdGet);
            }
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                typeReturn = createTraverseFromQueryResults(connDb, results);
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
        return typeReturn;
    }
    public static ITraverse getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createTraverseFromQueryResults(connDb, results);
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
        return null;
    }
    public static ITraverse updateFromLast(Connection connDb, ITraverse typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateTraverseFromQueryResults(connDb, results, typeUpdate);
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
        return null;
    }
    public static int getLastId(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastIdQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return results.getInt(1);
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
        return 0;
    }

    public static List<ITraverse> getAll(Connection connDb) throws SQLException
    {
        List<ITraverse> listReturn = new ArrayList<ITraverse>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
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

    public static List<ITraverse> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ITraverse> listReturn = new ArrayList<ITraverse>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectForSurveyQuery());
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
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setString(1, typeAdd.getName());
            stmtSelect.setString(2, typeAdd.getDescription());
            stmtSelect.setInt(3, typeAdd.getStartPoint().getID());
            stmtSelect.setInt(4, typeAdd.getEndPoint().getID());
            stmtSelect.setInt(5, ((Traverse) typeAdd).m_nSurveyID);

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
                        // TODO: set up error handling
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
                        // TODO: set up error handling
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
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
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(getUpdateQuery());
                stmtSelect.setString(1, typeUpdate.getName());
                stmtSelect.setString(2, typeUpdate.getDescription());
                stmtSelect.setInt(3, typeUpdate.getStartPoint().getID());
                stmtSelect.setInt(4, typeUpdate.getEndPoint().getID());
                stmtSelect.setInt(5, ((Traverse) typeUpdate).m_nSurveyID);
                stmtSelect.setInt(6, typeUpdate.getID());

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
                            // TODO: set up error handling
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
                            // TODO: set up error handling
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
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(typeUpdate.getID()));
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateTraverseFromQueryResults(connDb, results, typeUpdate);
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
        return null;
    }



    static boolean addTraverseForSurveyMeasurement(Connection connDb, int nID, ISurveyMeasurement typeUpdate) throws SQLException
    {
        return SurveyMeasurementAdapter.addForTraverse(connDb, typeUpdate, nID) != null;
    }



    private static ITraverse createTraverseFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createTraverse
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getString(FIELD_NAME),
                       results.getString(FIELD_DESCRIPTION),
                       SurveyPointAdapter.get(connDb, results.getInt(FIELD_STARTPOINTID)),
                       SurveyPointAdapter.get(connDb, results.getInt(FIELD_ENDPOINTID)),
                       results.getInt(FIELD_SURVEYID),
                       TraverseClosureAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID)),
                       SurveyMeasurementAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID))
                   );

    }
    private static ITraverse updateTraverseFromQueryResults(Connection connDb, ResultSet results, ITraverse typeUpdate) throws SQLException
    {
       ((Traverse)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((Traverse)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((Traverse)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((Traverse)typeUpdate).m_strName = results.getString(FIELD_NAME);
       ((Traverse)typeUpdate).m_strDescription = results.getString(FIELD_DESCRIPTION);
       ((Traverse)typeUpdate).m_typeStartPoint = SurveyPointAdapter.get(connDb, results.getInt(FIELD_STARTPOINTID));
       ((Traverse)typeUpdate).m_typeEndPoint = SurveyPointAdapter.get(connDb, results.getInt(FIELD_ENDPOINTID));
       ((Traverse)typeUpdate).m_nSurveyID = results.getInt(FIELD_SURVEYID);
       ((Traverse)typeUpdate).m_listTraverseClosure = TraverseClosureAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID));
       ((Traverse)typeUpdate).m_listSurveyMeasurement = SurveyMeasurementAdapter.getAllForTraverseParent(connDb, results.getInt(FIELD_ID));

       return typeUpdate;
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
            TABLE_NAME  +
            " WHERE " +
            FIELD_SURVEYID + " = ?";
        return strSelect;
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
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
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
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(CREATE_TABLE_SCRIPT);
        for(String strScript : TABLE_EXTRA_SCRIPTS)
        {
            stmtExecute.execute(strScript);
        }
    }
}
