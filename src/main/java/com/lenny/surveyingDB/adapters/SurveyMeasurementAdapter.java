// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon May 03 16:27:59 AEST 2021

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
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.SurveyAdjustmentAdapter;
import com.lenny.surveyingDB.interfaces.ITraverse;


public class SurveyMeasurementAdapter implements JsonDeserializer<ISurveyMeasurement>
{
    private static final Logger LOGGER = LogManager.getLogger(SurveyMeasurementAdapter.class.getName());

    // Class implements ISurveyMeasurement but only accessible through the SurveyMeasurementAdapter

    public static class SurveyMeasurement extends UndoTarget implements ISurveyMeasurement
    {
        @SerializedName("ID")
        private int m_nID;
        @SerializedName("created")
        private OffsetDateTime m_dateCreated;
        @SerializedName("updated")
        private OffsetDateTime m_dateUpdated;
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
        @SerializedName("SurveyAdjustmentID")
        private ISurveyAdjustment m_typeAdjustment;

        @SerializedName("SurveyID")
        private int m_nSurveyID;


        // This constructor is specically for json serialisation, not to be used...
        SurveyMeasurement()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_dHorizDistance = 0.0;
            m_dVertDistance = 0.0;
            m_dBearing = 0.0;

            m_typePointFrom = SurveyPointAdapter.createNewSurveyPoint();
            m_typePointTo = SurveyPointAdapter.createNewSurveyPoint();
            m_typeAdjustment = SurveyAdjustmentAdapter.createNewSurveyAdjustment();

            m_nSurveyID = 0;

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }

        SurveyMeasurement
        (
            int nSurveyID
        )
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_dHorizDistance = 0.0;
            m_dVertDistance = 0.0;
            m_dBearing = 0.0;

            m_typePointFrom = SurveyPointAdapter.createNewSurveyPoint();
            m_typePointTo = SurveyPointAdapter.createNewSurveyPoint();
            m_typeAdjustment = SurveyAdjustmentAdapter.createNewSurveyAdjustment();

            m_nSurveyID = nSurveyID;
            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        SurveyMeasurement(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, double dHorizDistance, double dVertDistance, double dBearing, ISurveyPoint typePointFrom, ISurveyPoint typePointTo, ISurveyAdjustment typeAdjustment, int nSurveyID)
        {
            super();
            m_nID = nID;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_dHorizDistance = dHorizDistance;
            m_dVertDistance = dVertDistance;
            m_dBearing = dBearing;
            m_typePointFrom = typePointFrom;
            m_typePointTo = typePointTo;
            m_typeAdjustment = typeAdjustment;
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
        public ISurveyAdjustment getAdjustment()
        {
            return  m_typeAdjustment;
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
        public void setAdjustment(ISurveyAdjustment typeSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyMeasurement.this.m_saveState, "Undo set SurveyMeasurement member Adjustment = " + SurveyMeasurement.this.m_typeAdjustment)
                {
                    ISurveyAdjustment m_undoAdjustment = SurveyMeasurement.this.m_typeAdjustment;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyMeasurement.this.m_typeAdjustment = m_undoAdjustment;
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
            m_typeAdjustment = typeSet;
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
            strJson += "\"SurveyAdjustmentID\":" + ((ISerialiseState) m_typeAdjustment).toJson() + ",";
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
    public static final String FIELD_SURVEYADJUSTMENTID = "SurveyAdjustmentID";
    public static final String FIELD_SURVEYID = "SurveyID";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyMeasurement createNewSurveyMeasurement
    (
        int nSurveyID
    )
    {
        return new SurveyMeasurement
        (
            nSurveyID
        );
    }
    public static ISurveyMeasurement createSurveyMeasurement
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        double dHorizDistance,
        double dVertDistance,
        double dBearing,
        ISurveyPoint typePointFrom,
        ISurveyPoint typePointTo,
        ISurveyAdjustment typeAdjustment,
        int nSurveyID
    )
    {
        return new SurveyMeasurement(nID, dateCreated, dateUpdated, dHorizDistance, dVertDistance, dBearing, typePointFrom, typePointTo, typeAdjustment, nSurveyID);
    }

    public static ISurveyMeasurement updateSurveyMeasurement
    (
        ISurveyMeasurement typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        double dHorizDistance,
        double dVertDistance,
        double dBearing,
        ISurveyPoint typePointFrom,
        ISurveyPoint typePointTo,
        ISurveyAdjustment typeAdjustment,
        int nSurveyID
    )
    {
        SurveyMeasurement updating = (SurveyMeasurement) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_dHorizDistance = dHorizDistance;;
        updating.m_dVertDistance = dVertDistance;;
        updating.m_dBearing = dBearing;;
        updating.m_typePointFrom = typePointFrom;;
        updating.m_typePointTo = typePointTo;;
        updating.m_typeAdjustment = typeAdjustment;;
        updating.m_nSurveyID = nSurveyID;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyMeasurement
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyMeasurement serialised = gsonInstance.fromJson(strJson, ISurveyMeasurement.class);

    public ISurveyMeasurement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyAdjustment.class, new SurveyAdjustmentAdapter());

        Gson gsonInstance = gsonBuilder.create();
        SurveyMeasurementAdapter.SurveyMeasurement typeSurveyMeasurement = gsonInstance.fromJson(json, SurveyMeasurementAdapter.SurveyMeasurement.class);
        if (typeSurveyMeasurement.m_nID > 0)
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
        LOGGER.info("Getting SurveyMeasurement id = " + nIdGet + " from db");
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
                typeReturn = createSurveyMeasurementFromQueryResults(connDb, results);
                LOGGER.debug("SurveyMeasurement data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No SurveyMeasurement data for id = " + nIdGet + " from db");
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
    public static ISurveyMeasurement getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last SurveyMeasurement from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyMeasurementFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last SurveyMeasurement data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last SurveyMeasurement  from db", exc);
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
    public static ISurveyMeasurement updateFromLast(Connection connDb, ISurveyMeasurement typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating SurveyMeasurement id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyMeasurementFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find SurveyMeasurement id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of SurveyMeasurement id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting SurveyMeasurement id from db");
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
                LOGGER.debug("No last SurveyMeasurement in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last SurveyMeasurement id from db failed", exc);
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

    public static List<ISurveyMeasurement> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyMeasurement> listReturn = new ArrayList<ISurveyMeasurement>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all SurveyMeasurement data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyMeasurementFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " SurveyMeasurement data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all SurveyMeasurement from db failed", exc);
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

    public static List<ISurveyMeasurement> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyMeasurement> listReturn = new ArrayList<ISurveyMeasurement>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("Survey"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyMeasurementFromQueryResults(connDb, results));
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
    public static List<ISurveyMeasurement> getAllForTraverseParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyMeasurement> listReturn = new ArrayList<ISurveyMeasurement>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("Traverse"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyMeasurementFromQueryResults(connDb, results));
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
    public static ISurveyMeasurement addForTraverse(Connection connDb, ISurveyMeasurement typeAdd, ITraverse typeParent) throws SQLException
    {
        return SurveyMeasurementAdapter.addForTraverse(connDb, typeAdd, typeParent.getID());
    }

    public static ISurveyMeasurement addForTraverse(Connection connDb, ISurveyMeasurement typeAdd, int nID) throws SQLException
    {
        ISurveyMeasurement typeReturn = typeAdd;
        if (((ISerialiseState) typeAdd).isNew())
        {
            typeReturn = add(connDb, typeAdd);
        }

        PreparedStatement stmtLink = null;
        try
        {
            stmtLink = connDb.prepareStatement(SQL_PROVIDER.insertFor("Traverse"));
            stmtLink.setInt(1, nID);
            stmtLink.setInt(2, typeReturn.getID());
            stmtLink.executeUpdate();
        }
        catch (SQLException exc)
        {
            LOGGER.error("Unable to insert link table record", exc);
            typeReturn = null;
        }
        finally
        {
            if (stmtLink != null)
            {
                stmtLink.close();
            }
        }
        return typeReturn;
    } 
    public static ISurveyMeasurement add(Connection connDb, ISurveyMeasurement typeAdd) throws SQLException
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
        LOGGER.info("Adding SurveyMeasurement data to db");
        LOGGER.debug("Adding SurveyMeasurement data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        if (((UndoTarget) typeAdd.getPointFrom()).isNew())
        {
            typeAdd.setPointFrom(SurveyPointAdapter.add(connDb, typeAdd.getPointFrom()));
        }
        else if (((UndoTarget) typeAdd.getPointFrom()).isUpdated())
        {
            typeAdd.setPointFrom(SurveyPointAdapter.update(connDb, typeAdd.getPointFrom()));
        }
        if (((UndoTarget) typeAdd.getPointTo()).isNew())
        {
            typeAdd.setPointTo(SurveyPointAdapter.add(connDb, typeAdd.getPointTo()));
        }
        else if (((UndoTarget) typeAdd.getPointTo()).isUpdated())
        {
            typeAdd.setPointTo(SurveyPointAdapter.update(connDb, typeAdd.getPointTo()));
        }
        if (((UndoTarget) typeAdd.getAdjustment()).isNew())
        {
            typeAdd.setAdjustment(SurveyAdjustmentAdapter.add(connDb, typeAdd.getAdjustment()));
        }
        else if (((UndoTarget) typeAdd.getAdjustment()).isUpdated())
        {
            typeAdd.setAdjustment(SurveyAdjustmentAdapter.update(connDb, typeAdd.getAdjustment()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added SurveyMeasurement data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding SurveyMeasurement to db failed", exc);
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
    public static ISurveyMeasurement updateForTraverse(Connection connDb, ISurveyMeasurement typeUpdate, ITraverse typeParent) throws SQLException
    {
        // A new object has to be added first, and any new links created
        addForTraverse(connDb, typeUpdate, typeParent);
        return update(connDb, typeUpdate);
    } 
    public static ISurveyMeasurement update(Connection connDb, ISurveyMeasurement typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating SurveyMeasurement data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating SurveyMeasurement, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating SurveyMeasurement data - " + ((ISerialiseState) typeUpdate).toJson());
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(SQL_PROVIDER.updateScript());
                SQL_PROVIDER.resultsHandler().updateExisting(typeUpdate, stmtSelect);
                stmtSelect.executeUpdate();
                // This will cancel any pending undo items
                ((ISerialiseState) typeUpdate).setSaved();
                return updateFromDatabase(connDb, typeUpdate);
            }
            catch (SQLException exc)
            {
                // TODO: set up error handling
                LOGGER.error("Adding SurveyMeasurement to db failed", exc);
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

    public static ISurveyMeasurement updateFromDatabase(Connection connDb, ISurveyMeasurement typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database SurveyMeasurement, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyMeasurementFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database SurveyMeasurement, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for SurveyMeasurement, id = " + typeUpdate.getID() + " from db failed", exc);
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


    private static ISurveyMeasurement createSurveyMeasurementFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ISurveyMeasurement) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ISurveyMeasurement updateSurveyMeasurementFromQueryResults(Connection connDb, ResultSet results, ISurveyMeasurement typeUpdate) throws SQLException
    {
        return (ISurveyMeasurement) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
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
            FIELD_SURVEYADJUSTMENTID + ",  " +
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
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYADJUSTMENTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME  +
            " WHERE " +
            FIELD_SURVEYID + " = ?";
    }
    private static String getSelectForTraverseQuery()
    {
        return "SELECT " +
                FIELD_ID + ",  " +
                FIELD_CREATED + ",  " +
                FIELD_UPDATED + ",  " +
                FIELD_HORIZDISTANCE + ",  " +
                FIELD_VERTDISTANCE + ",  " +
                FIELD_BEARING + ",  " +
                FIELD_FROMPTID + ",  " +
                FIELD_TOPTID + ",  " +
                FIELD_SURVEYADJUSTMENTID + ",  " +
                FIELD_SURVEYID
                + " FROM " +
                TABLE_NAME  +
                " INNER JOIN " +
                "TraverseMeasurement tableTraverseMeasurement ON tableTraverseMeasurement.MeasurementID = " + FIELD_ID +
                " WHERE tableTraverseMeasurement.TraverseID = ?";
    } 
    private static String getTraverseInsertLinkQuery()
    {
        return "INSERT OR IGNORE INTO TraverseMeasurement(" +
                "TraverseID" + ",  " +
                "MeasurementID"
                + ") VALUES (?,  ?)";
    } 
    private static String getTraverseDeleteLinkQuery()
    {
            return "DELETE FROM TraverseMeasurement WHERE " +
                "TraverseID = ? && " +
                "MeasurementID = ?";
    } 
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYADJUSTMENTID + ",  " +
            FIELD_SURVEYID
            + ") VALUES (?,  ?,  ?,  ?,  ?,  ?,  ?)";
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
            FIELD_SURVEYADJUSTMENTID + ",  " +
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
            FIELD_SURVEYADJUSTMENTID + " = ?,  " +
            FIELD_SURVEYID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyMeasurement` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`SurveyID`  INTEGER NOT NULL, " + 
        "`HorizDistance` REAL NOT NULL, " + 
        "`VertDistance`  REAL, " + 
        "`Bearing`   REAL NOT NULL, " + 
        "`FromPtID`  INTEGER NOT NULL, " + 
        "`ToPtID`    INTEGER NOT NULL, " + 
        "`SurveyAdjustmentID` INTEGER, " + 
        "FOREIGN KEY (SurveyID) REFERENCES Survey(ID), " + 
        "FOREIGN KEY (FromPtID) REFERENCES SurveyPoint(ID), " + 
        "FOREIGN KEY (ToPtID) REFERENCES SurveyPoint(ID), " + 
        "FOREIGN KEY (SurveyAdjustmentID) REFERENCES SurveyAdjustment(ID) " + 
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
            return "surveymeasurement";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_HORIZDISTANCE + ",  " +
                       FIELD_VERTDISTANCE + ",  " +
                       FIELD_BEARING + ",  " +
                       FIELD_FROMPTID + ",  " +
                       FIELD_TOPTID + ",  " +
                       FIELD_SURVEYADJUSTMENTID + ",  " +
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
            FIELD_HORIZDISTANCE + ",  " +
            FIELD_VERTDISTANCE + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_FROMPTID + ",  " +
            FIELD_TOPTID + ",  " +
            FIELD_SURVEYADJUSTMENTID + ",  " +
            FIELD_SURVEYID
            + " FROM " +
            TABLE_NAME + " WHERE " + PRIMARY_KEY + " = ?";
        }
        public String selectFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                case "survey":
                    return "SELECT " +
                        FIELD_ID + ",  " +
                        FIELD_CREATED + ",  " +
                        FIELD_UPDATED + ",  " +
                        FIELD_HORIZDISTANCE + ",  " +
                        FIELD_VERTDISTANCE + ",  " +
                        FIELD_BEARING + ",  " +
                        FIELD_FROMPTID + ",  " +
                        FIELD_TOPTID + ",  " +
                        FIELD_SURVEYADJUSTMENTID + ",  " +
                        FIELD_SURVEYID
                        + " FROM " +
                        TABLE_NAME  +
                        " WHERE " +
                        FIELD_SURVEYID + " = ?";
                case "traverse":
                    return "SELECT " +
                            FIELD_ID + ",  " +
                            FIELD_CREATED + ",  " +
                            FIELD_UPDATED + ",  " +
                            FIELD_HORIZDISTANCE + ",  " +
                            FIELD_VERTDISTANCE + ",  " +
                            FIELD_BEARING + ",  " +
                            FIELD_FROMPTID + ",  " +
                            FIELD_TOPTID + ",  " +
                            FIELD_SURVEYADJUSTMENTID + ",  " +
                            FIELD_SURVEYID
                            + " FROM " +
                            TABLE_NAME  +
                            " INNER JOIN " +
                            "TraverseMeasurement tableTraverseMeasurement ON tableTraverseMeasurement.MeasurementID = " + FIELD_ID +
                            " WHERE tableTraverseMeasurement.TraverseID = ?"; 
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
                             FIELD_HORIZDISTANCE + ",  " +
                             FIELD_VERTDISTANCE + ",  " +
                             FIELD_BEARING + ",  " +
                             FIELD_FROMPTID + ",  " +
                             FIELD_TOPTID + ",  " +
                             FIELD_SURVEYADJUSTMENTID + ",  " +
                             FIELD_SURVEYID
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
                        FIELD_HORIZDISTANCE + ",  " +
                        FIELD_VERTDISTANCE + ",  " +
                        FIELD_BEARING + ",  " +
                        FIELD_FROMPTID + ",  " +
                        FIELD_TOPTID + ",  " +
                        FIELD_SURVEYADJUSTMENTID + ",  " +
                        FIELD_SURVEYID
                        + ") VALUES (?,  ?,  ?,  ?,  ?,  ?,  ?)";
        }
        @Override
        public String insertFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                case "traverse":
                    return "INSERT OR IGNORE INTO TraverseMeasurement(" +
                            "TraverseID" + ",  " +
                            "MeasurementID"
                            + ") VALUES (?,  ?)"; 
                default:
                    return "";
            }
        }
        @Override
        public String updateScript()
        {
            return "UPDATE " + TABLE_NAME + " SET " +
                               FIELD_HORIZDISTANCE + " = ?,  " +
                               FIELD_VERTDISTANCE + " = ?,  " +
                               FIELD_BEARING + " = ?,  " +
                               FIELD_FROMPTID + " = ?,  " +
                               FIELD_TOPTID + " = ?,  " +
                               FIELD_SURVEYADJUSTMENTID + " = ?,  " +
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
            switch(strContext.toLowerCase())
            {
                case "traverse":
                        return "DELETE FROM TraverseMeasurement WHERE " +
                            "TraverseID = ? && " +
                            "MeasurementID = ?"; 
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
        @Override
        public boolean createInDatabase(Connection connDb)
        {
            try
            {
                LOGGER.debug("Creating SurveyMeasurement in database");
                Statement stmtExecute = connDb.createStatement();
                stmtExecute.execute(createScript());
                LOGGER.debug("SurveyMeasurement create script - " + createScript());

                for(String strStatement : TABLE_EXTRA_SCRIPTS)
                {
                    stmtExecute.execute(strStatement);
                }
                LOGGER.debug("SurveyMeasurement extra script - " + triggerScript());

                if(!SQL_PROVIDER.staticInsertsScript().isEmpty())
                {
                    String[] listStatements = staticInsertsScript().split(";");
                    for(String strStatement : listStatements)
                    {
                        stmtExecute.execute(strStatement);
                    }
                    LOGGER.debug("SurveyMeasurement extra script - " + staticInsertsScript());
                }
                return true;
            }
            catch(SQLException exc)
            {
                LOGGER.error("Error executing scripts", exc);
            }
            return false;
        }

        private SqlProvider.SqlResultHandler<ISurveyMeasurement> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ISurveyMeasurement> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<ISurveyMeasurement>()
                           {
                                @Override
                                public ISurveyMeasurement fromResults(Connection connDb, ResultSet results)
                                {
                                    try
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
                                            SurveyAdjustmentAdapter.get(connDb, results.getInt(FIELD_SURVEYADJUSTMENTID)),
                                            results.getInt(FIELD_SURVEYID)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public ISurveyMeasurement updateFromResults(ISurveyMeasurement typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateSurveyMeasurement
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                            results.getDouble(FIELD_HORIZDISTANCE),
                                            results.getDouble(FIELD_VERTDISTANCE),
                                            results.getDouble(FIELD_BEARING),
                                            SurveyPointAdapter.get(connDb, results.getInt(FIELD_FROMPTID)),
                                            SurveyPointAdapter.get(connDb, results.getInt(FIELD_TOPTID)),
                                            SurveyAdjustmentAdapter.get(connDb, results.getInt(FIELD_SURVEYADJUSTMENTID)),
                                            results.getInt(FIELD_SURVEYID)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public boolean insertNew(ISurveyMeasurement typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setDouble(1, typeInsert.getHorizDistance());
                                        stmtSelect.setDouble(2, typeInsert.getVertDistance());
                                        stmtSelect.setDouble(3, typeInsert.getBearing());
                                        stmtSelect.setInt(4, typeInsert.getPointFrom().getID());
                                        stmtSelect.setInt(5, typeInsert.getPointTo().getID());
                                        stmtSelect.setInt(6, typeInsert.getAdjustment().getID());
                                        stmtSelect.setInt(7, ((SurveyMeasurementAdapter.SurveyMeasurement) typeInsert).getSurveyID());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(ISurveyMeasurement typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setDouble(1, typeUpdate.getHorizDistance());
                                        stmtSelect.setDouble(2, typeUpdate.getVertDistance());
                                        stmtSelect.setDouble(3, typeUpdate.getBearing());
                                        stmtSelect.setInt(4, typeUpdate.getPointFrom().getID());
                                        stmtSelect.setInt(5, typeUpdate.getPointTo().getID());
                                        stmtSelect.setInt(6, typeUpdate.getAdjustment().getID());
                                        stmtSelect.setInt(7, ((SurveyMeasurementAdapter.SurveyMeasurement) typeUpdate).getSurveyID());
                                        stmtSelect.setInt(8, typeUpdate.getID());

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
