// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon May 08 10:06:02 AEST 2017

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
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ITraverse;


public class SurveyMeasurementAdapter implements JsonDeserializer<ISurveyMeasurement>
{

        // Class implements ISurveyMeasurement but only accessible through the SurveyMeasurementAdapter

        static class SurveyMeasurement extends UndoTarget implements ISurveyMeasurement
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
            @SerializedName("HorizDistance")
            private double m_dHorizDistance;
            @SerializedName("VertDistance")
            private double m_dVertDistance;
            @SerializedName("Bearing")
            private double m_dBearing;

            @SerializedName("FromPtID")
            private ISurveyPoint m_typePointFrom;
            @SerializedName("ToPtID")
            private ISurveyPoint m_typePointTo;

            @SerializedName("SurveyID")
            private int m_nSurveyID;


            SurveyMeasurement()
            {
                m_nID = 0;
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_dHorizDistance = 0.0;
                m_dVertDistance = 0.0;
                m_dBearing = 0.0;

                m_typePointFrom = SurveyPointAdapter.createNewSurveyPoint();
                m_typePointTo = SurveyPointAdapter.createNewSurveyPoint();

                m_nSurveyID = 0;

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            SurveyMeasurement(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, double dHorizDistance, double dVertDistance, double dBearing, ISurveyPoint typePointFrom, ISurveyPoint typePointTo, int nSurveyID)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_dHorizDistance = dHorizDistance;
                m_dVertDistance = dVertDistance;
                m_dBearing = dBearing;
                m_typePointFrom = typePointFrom;
                m_typePointTo = typePointTo;
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
            public double getHorizDistance()
            {
                return  m_dHorizDistance;
            }
            public double getVertDistance()
            {
                return  m_dVertDistance;
            }
            public double getBearing()
            {
                return  m_dBearing;
            }

            public ISurveyPoint getPointFrom()
            {
                return  m_typePointFrom;
            }
            public ISurveyPoint getPointTo()
            {
                return  m_typePointTo;
            }

            public void setHorizDistance(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyMeasurement.this.m_saveState, "Undo set SurveyMeasurement member HorizDistance = " + SurveyMeasurement.this.m_dHorizDistance)
                    {
                        double m_undoHorizDistance = SurveyMeasurement.this.m_dHorizDistance;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyMeasurement.this.m_dHorizDistance = m_undoHorizDistance;
                                if(SurveyMeasurement.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyMeasurement.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dHorizDistance = dSet;
                setUpdated();
            }
            public void setVertDistance(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyMeasurement.this.m_saveState, "Undo set SurveyMeasurement member VertDistance = " + SurveyMeasurement.this.m_dVertDistance)
                    {
                        double m_undoVertDistance = SurveyMeasurement.this.m_dVertDistance;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyMeasurement.this.m_dVertDistance = m_undoVertDistance;
                                if(SurveyMeasurement.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyMeasurement.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dVertDistance = dSet;
                setUpdated();
            }
            public void setBearing(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyMeasurement.this.m_saveState, "Undo set SurveyMeasurement member Bearing = " + SurveyMeasurement.this.m_dBearing)
                    {
                        double m_undoBearing = SurveyMeasurement.this.m_dBearing;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyMeasurement.this.m_dBearing = m_undoBearing;
                                if(SurveyMeasurement.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyMeasurement.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dBearing = dSet;
                setUpdated();
            }

            public void setPointFrom(ISurveyPoint typeSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyMeasurement.this.m_saveState, "Undo set SurveyMeasurement member PointFrom = " + SurveyMeasurement.this.m_typePointFrom)
                    {
                        ISurveyPoint m_undoPointFrom = SurveyMeasurement.this.m_typePointFrom;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyMeasurement.this.m_typePointFrom = m_undoPointFrom;
                                if(SurveyMeasurement.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyMeasurement.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_typePointFrom = typeSet;
                setUpdated();
            }
            public void setPointTo(ISurveyPoint typeSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyMeasurement.this.m_saveState, "Undo set SurveyMeasurement member PointTo = " + SurveyMeasurement.this.m_typePointTo)
                    {
                        ISurveyPoint m_undoPointTo = SurveyMeasurement.this.m_typePointTo;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyMeasurement.this.m_typePointTo = m_undoPointTo;
                                if(SurveyMeasurement.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyMeasurement.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_typePointTo = typeSet;
                setUpdated();
            }

            void setSurveyID(int nSurveyID)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyMeasurement.this.m_saveState, "Undo set SurveyMeasurement member SurveyID = " + SurveyMeasurement.this.m_nSurveyID)
                    {
                        int m_undoSurveyID = SurveyMeasurement.this.m_nSurveyID;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyMeasurement.this.m_nSurveyID = m_undoSurveyID;
                                if(SurveyMeasurement.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyMeasurement.this.m_saveState = m_dataSaveState;
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
                strJson += "\"HorizDistance\":" + m_dHorizDistance + ",";
                strJson += "\"VertDistance\":" + m_dVertDistance + ",";
                strJson += "\"Bearing\":" + m_dBearing + ",";
                strJson += "\"FromPtID\":" + ((ISerialiseState) m_typePointFrom).toJson() + ",";
                strJson += "\"ToPtID\":" + ((ISerialiseState) m_typePointTo).toJson() + ",";
                strJson += "\"SurveyID\":" + m_nSurveyID;
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "SurveyMeasurement";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_HORIZDISTANCE = "HorizDistance";
    public static final String FIELD_VERTDISTANCE = "VertDistance";
    public static final String FIELD_BEARING = "Bearing";
    public static final String FIELD_FROMPTID = "FromPtID";
    public static final String FIELD_TOPTID = "ToPtID";
    public static final String FIELD_SURVEYID = "SurveyID";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyMeasurement createNewSurveyMeasurement()
    {
        return new SurveyMeasurement();
    }

    public static ISurveyMeasurement createSurveyMeasurement
    (
        int nID,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        double dHorizDistance,
        double dVertDistance,
        double dBearing,
        ISurveyPoint typePointFrom,
        ISurveyPoint typePointTo,
        int nSurveyID
    )
    {
        return new SurveyMeasurement(nID, dateCreated, dateUpdated, dHorizDistance, dVertDistance, dBearing, typePointFrom, typePointTo, nSurveyID);
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyMeasurement
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyMeasurement serialised = gsonInstance.fromJson(strJson, ISurveyMeasurement.class);

    public ISurveyMeasurement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());

        Gson gsonInstance = gsonBuilder.create();
        SurveyMeasurementAdapter.SurveyMeasurement typeSurveyMeasurement = gsonInstance.fromJson(json, SurveyMeasurementAdapter.SurveyMeasurement.class);
        if(typeSurveyMeasurement.m_nID > 0)
        {
            typeSurveyMeasurement.setSaved();
        }
        return typeSurveyMeasurement;
    }

    public static ISurveyMeasurement get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyMeasurement typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(nIdGet));
            if(nIdGet > 0)
            {
                stmtSelect.setInt(1, nIdGet);
            }
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                typeReturn = createSurveyMeasurementFromQueryResults(connDb, results);
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return typeReturn;
    }
    public static ISurveyMeasurement getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return createSurveyMeasurementFromQueryResults(connDb, results);
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return null;
    }
    public static ISurveyMeasurement updateFromLast(Connection connDb, ISurveyMeasurement typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return updateSurveyMeasurementFromQueryResults(connDb, results, typeUpdate);
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
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
            if(results.next())
            {
                return results.getInt(1);
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return 0;
    }

    public static List<ISurveyMeasurement> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyMeasurement> listReturn = new ArrayList<ISurveyMeasurement>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createSurveyMeasurementFromQueryResults(connDb, results));
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return listReturn;
    }

    public static List<ISurveyMeasurement> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyMeasurement> listReturn = new ArrayList<ISurveyMeasurement>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectForSurveyQuery());
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createSurveyMeasurementFromQueryResults(connDb, results));
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return listReturn;
    }
    public static List<ISurveyMeasurement> getAllForTraverseParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyMeasurement> listReturn = new ArrayList<ISurveyMeasurement>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectForTraverseQuery());
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createSurveyMeasurementFromQueryResults(connDb, results));
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return listReturn;
    } 
    public static ISurveyMeasurement addForTraverse(Connection connDb, ISurveyMeasurement typeAdd, ITraverse typeParent) throws SQLException
    {
        return SurveyMeasurementAdapter.addForTraverse(connDb, typeAdd, typeParent.getID());
    }

    public static ISurveyMeasurement addForTraverse(Connection connDb, ISurveyMeasurement typeAdd, int nID) throws SQLException
    {
        ISurveyMeasurement typeReturn = typeAdd;
        if(((ISerialiseState) typeAdd).isNew())
        {
            typeReturn = add(connDb, typeAdd);
        }

        PreparedStatement stmtLink = null;
        try
        {
            stmtLink = connDb.prepareStatement(getTraverseInsertLinkQuery());
            stmtLink.setInt(1, nID);
            stmtLink.setInt(2, typeReturn.getID());
            stmtLink.executeUpdate();
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
            typeReturn = null;
        }
        finally
        {
            if(stmtLink != null)
            {
                stmtLink.close();
            }
        }
        return typeReturn;
    } 
    public static ISurveyMeasurement add(Connection connDb, ISurveyMeasurement typeAdd) throws SQLException
    {
        if(!((ISerialiseState) typeAdd).isNew())
        {
            if(((ISerialiseState) typeAdd).isUpdated())
            {
                // Update semantics are slightly different at add
                return update(connDb, typeAdd);
            }
            // Nothing to save...
            return null;
        }
        PreparedStatement stmtSelect = null;
        if(((UndoTarget) typeAdd.getPointFrom()).isNew())
        {
            typeAdd.setPointFrom(SurveyPointAdapter.add(connDb, typeAdd.getPointFrom()));
        }
        else if(((UndoTarget) typeAdd.getPointFrom()).isUpdated())
        {
            typeAdd.setPointFrom(SurveyPointAdapter.update(connDb, typeAdd.getPointFrom()));
        }
        if(((UndoTarget) typeAdd.getPointTo()).isNew())
        {
            typeAdd.setPointTo(SurveyPointAdapter.add(connDb, typeAdd.getPointTo()));
        }
        else if(((UndoTarget) typeAdd.getPointTo()).isUpdated())
        {
            typeAdd.setPointTo(SurveyPointAdapter.update(connDb, typeAdd.getPointTo()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setDouble(1, typeAdd.getHorizDistance());
            stmtSelect.setDouble(2, typeAdd.getVertDistance());
            stmtSelect.setDouble(3, typeAdd.getBearing());
            stmtSelect.setInt(4, typeAdd.getPointFrom().getID());
            stmtSelect.setInt(5, typeAdd.getPointTo().getID());
            stmtSelect.setInt(6, ((SurveyMeasurement) typeAdd).m_nSurveyID);

            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            return updateFromLast(connDb, typeAdd);
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return null;
    }
    public static ISurveyMeasurement updateForTraverse(Connection connDb, ISurveyMeasurement typeUpdate, ITraverse typeParent) throws SQLException
    {
        // A new object has to be added first, and any new links created
        addForTraverse(connDb, typeUpdate, typeParent);
        return update(connDb, typeUpdate);
    } 
    public static ISurveyMeasurement update(Connection connDb, ISurveyMeasurement typeUpdate) throws SQLException
    {
        if(((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if(((ISerialiseState) typeUpdate).isUpdated())
        {
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(getUpdateQuery());
                stmtSelect.setDouble(1, typeUpdate.getHorizDistance());
                stmtSelect.setDouble(2, typeUpdate.getVertDistance());
                stmtSelect.setDouble(3, typeUpdate.getBearing());
                stmtSelect.setInt(4, typeUpdate.getPointFrom().getID());
                stmtSelect.setInt(5, typeUpdate.getPointTo().getID());
                stmtSelect.setInt(6, ((SurveyMeasurement) typeUpdate).m_nSurveyID);
                stmtSelect.setInt(7, typeUpdate.getID());

                stmtSelect.executeUpdate();
                // This will cancel any pending undo items
                ((ISerialiseState) typeUpdate).setSaved();
                return updateFromDatabase(connDb, typeUpdate);
            }
            catch(SQLException exc)
            {
                // TODO: set up error handling
            }
            finally
            {
                if(stmtSelect != null)
                {
                    stmtSelect.close();
                }
            }
            return null;
        }
        return typeUpdate;
    }

    public static ISurveyMeasurement updateFromDatabase(Connection connDb, ISurveyMeasurement typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(typeUpdate.getID()));
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return updateSurveyMeasurementFromQueryResults(connDb, results, typeUpdate);
            }
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(results != null)
            {
                results.close();
            }
            if(stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return null;
    }


    private static ISurveyMeasurement createSurveyMeasurementFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createSurveyMeasurement
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getDouble(FIELD_HORIZDISTANCE),
                       results.getDouble(FIELD_VERTDISTANCE),
                       results.getDouble(FIELD_BEARING),
                       SurveyPointAdapter.get(connDb, results.getInt(FIELD_FROMPTID)),
                       SurveyPointAdapter.get(connDb, results.getInt(FIELD_TOPTID)),
                       results.getInt(FIELD_SURVEYID)
                   );

    }
    private static ISurveyMeasurement updateSurveyMeasurementFromQueryResults(Connection connDb, ResultSet results, ISurveyMeasurement typeUpdate) throws SQLException
    {
       ((SurveyMeasurement)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((SurveyMeasurement)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((SurveyMeasurement)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((SurveyMeasurement)typeUpdate).m_dHorizDistance = results.getDouble(FIELD_HORIZDISTANCE);
       ((SurveyMeasurement)typeUpdate).m_dVertDistance = results.getDouble(FIELD_VERTDISTANCE);
       ((SurveyMeasurement)typeUpdate).m_dBearing = results.getDouble(FIELD_BEARING);
       ((SurveyMeasurement)typeUpdate).m_typePointFrom = SurveyPointAdapter.get(connDb, results.getInt(FIELD_FROMPTID));
       ((SurveyMeasurement)typeUpdate).m_typePointTo = SurveyPointAdapter.get(connDb, results.getInt(FIELD_TOPTID));
       ((SurveyMeasurement)typeUpdate).m_nSurveyID = results.getInt(FIELD_SURVEYID);

       return typeUpdate;
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME;
        if(nIdFor > 0)
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
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME  +
            " WHERE " +
            FIELD_SURVEYID + " = ?";
        return strSelect;
    }
    private static String getSelectForTraverseQuery()
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME  +
            " INNER JOIN " +
            "TraverseMeasurement tableTraverseMeasurement ON tableTraverseMeasurement.MeasurementID == " + FIELD_ID +
            " WHERE tableTraverseMeasurement.TraverseID = ?";
        return strSelect;
    } 
    private static String getTraverseInsertLinkQuery()
    {
        String strInsert = "INSERT OR IGNORE INTO TraverseMeasurement(" +
            "TraverseID" + ",  " +
            "MeasurementID"
            + ") VALUES (?,  ?)";
        return strInsert;
    } 
    private static String getTraverseDeleteLinkQuery()
    {
        String strDelete = "DELETE FROM  WHERE " +
            "TraverseID = ? && " +
            "MeasurementID = ?";
        return strDelete;
    } 
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYID
            + ") VALUES (?,  ?,  ?,  ?,  ?,  ?)";
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
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_HORIZDISTANCE + " = ?,  " +
            FIELD_VERTDISTANCE + " = ?,  " +
            FIELD_BEARING + " = ?,  " +
            FIELD_FROMPTID + " = ?,  " +
            FIELD_TOPTID + " = ?,  " +
            FIELD_SURVEYID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyMeasurement` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`SurveyID`  INTEGER NOT NULL, " + 
        "`HorizDistance` REAL NOT NULL, " + 
        "`VertDistance`  REAL, " + 
        "`Bearing`   REAL NOT NULL, " + 
        "`FromPtID`  INTEGER NOT NULL, " + 
        "`ToPtID`    INTEGER NOT NULL, " + 
        "FOREIGN KEY (SurveyID) REFERENCES Survey(ID), " + 
        "FOREIGN KEY (FromPtID) REFERENCES SurveyPoint(ID), " + 
        "FOREIGN KEY (ToPtID) REFERENCES SurveyPoint(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateSurveyMeasurement after update on `SurveyMeasurement` " + 
            "for each row " + 
            "begin " + 
            "update SurveyMeasurement set updated = current_timestamp where ID == OLD.ID; " + 
            "end;",
            "CREATE TABLE `TraverseMeasurement` " + 
            "( " + 
            "`TraverseID`    INTEGER NOT NULL, " + 
            "`MeasurementID` INTEGER NOT NULL, " + 
            "FOREIGN KEY (MeasurementID) REFERENCES SurveyMeasurement(ID), " + 
            "FOREIGN KEY (TraverseID) REFERENCES Traverse(ID), " + 
            "UNIQUE(TraverseID, MeasurementID) " + 
            ");"
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
