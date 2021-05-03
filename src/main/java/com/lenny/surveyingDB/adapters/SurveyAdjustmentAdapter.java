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
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;


public class SurveyAdjustmentAdapter implements JsonDeserializer<ISurveyAdjustment>
{
    private static final Logger LOGGER = LogManager.getLogger(SurveyAdjustmentAdapter.class.getName());

    // Class implements ISurveyAdjustment but only accessible through the SurveyAdjustmentAdapter

    public static class SurveyAdjustment extends UndoTarget implements ISurveyAdjustment
    {
        @SerializedName("ID")
        private int m_nID;
        @SerializedName("created")
        private OffsetDateTime m_dateCreated;
        @SerializedName("updated")
        private OffsetDateTime m_dateUpdated;
        @SerializedName("DeltaX")
        private double m_dDeltaX;
        @SerializedName("DeltaY")
        private double m_dDeltaY;
        @SerializedName("DeltaZ")
        private double m_dDeltaZ;
        @SerializedName("BearingAdj")
        private double m_dBearingAdj;

        SurveyAdjustment()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_dDeltaX = 0.0;
            m_dDeltaY = 0.0;
            m_dDeltaZ = 0.0;
            m_dBearingAdj = 0.0;

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        SurveyAdjustment(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, double dDeltaX, double dDeltaY, double dDeltaZ, double dBearingAdj)
        {
            super();
            m_nID = nID;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_dDeltaX = dDeltaX;
            m_dDeltaY = dDeltaY;
            m_dDeltaZ = dDeltaZ;
            m_dBearingAdj = dBearingAdj;
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
        public double getDeltaX()
        {
            return  m_dDeltaX;
        }
        public double getDeltaY()
        {
            return  m_dDeltaY;
        }
        public double getDeltaZ()
        {
            return  m_dDeltaZ;
        }
        public double getBearingAdj()
        {
            return  m_dBearingAdj;
        }

        public void setDeltaX(double dSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member DeltaX = " + SurveyAdjustment.this.m_dDeltaX)
                {
                    double m_undoDeltaX = SurveyAdjustment.this.m_dDeltaX;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyAdjustment.this.m_dDeltaX = m_undoDeltaX;
                            if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                            {
                                SurveyAdjustment.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dDeltaX = dSet;
            setUpdated();
        }
        public void setDeltaY(double dSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member DeltaY = " + SurveyAdjustment.this.m_dDeltaY)
                {
                    double m_undoDeltaY = SurveyAdjustment.this.m_dDeltaY;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyAdjustment.this.m_dDeltaY = m_undoDeltaY;
                            if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                            {
                                SurveyAdjustment.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dDeltaY = dSet;
            setUpdated();
        }
        public void setDeltaZ(double dSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member DeltaZ = " + SurveyAdjustment.this.m_dDeltaZ)
                {
                    double m_undoDeltaZ = SurveyAdjustment.this.m_dDeltaZ;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyAdjustment.this.m_dDeltaZ = m_undoDeltaZ;
                            if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                            {
                                SurveyAdjustment.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dDeltaZ = dSet;
            setUpdated();
        }
        public void setBearingAdj(double dSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member BearingAdj = " + SurveyAdjustment.this.m_dBearingAdj)
                {
                    double m_undoBearingAdj = SurveyAdjustment.this.m_dBearingAdj;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyAdjustment.this.m_dBearingAdj = m_undoBearingAdj;
                            if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                            {
                                SurveyAdjustment.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dBearingAdj = dSet;
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
            strJson += "\"DeltaX\":" + m_dDeltaX + ",";
            strJson += "\"DeltaY\":" + m_dDeltaY + ",";
            strJson += "\"DeltaZ\":" + m_dDeltaZ + ",";
            strJson += "\"BearingAdj\":" + m_dBearingAdj;
            strJson += "}";
            return strJson;
        }
    }
    public static final String TABLE_NAME = "SurveyAdjustment";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_DELTAX = "DeltaX";
    public static final String FIELD_DELTAY = "DeltaY";
    public static final String FIELD_DELTAZ = "DeltaZ";
    public static final String FIELD_BEARINGADJ = "BearingAdj";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyAdjustment createNewSurveyAdjustment()
    {
        return new SurveyAdjustment();
    }

    public static ISurveyAdjustment createSurveyAdjustment
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        double dDeltaX,
        double dDeltaY,
        double dDeltaZ,
        double dBearingAdj
    )
    {
        return new SurveyAdjustment(nID, dateCreated, dateUpdated, dDeltaX, dDeltaY, dDeltaZ, dBearingAdj);
    }

    public static ISurveyAdjustment updateSurveyAdjustment
    (
        ISurveyAdjustment typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        double dDeltaX,
        double dDeltaY,
        double dDeltaZ,
        double dBearingAdj
    )
    {
        SurveyAdjustment updating = (SurveyAdjustment) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_dDeltaX = dDeltaX;;
        updating.m_dDeltaY = dDeltaY;;
        updating.m_dDeltaZ = dDeltaZ;;
        updating.m_dBearingAdj = dBearingAdj;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyAdjustment
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyAdjustment.class, new SurveyAdjustmentAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyAdjustment serialised = gsonInstance.fromJson(strJson, ISurveyAdjustment.class);

    public ISurveyAdjustment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        SurveyAdjustmentAdapter.SurveyAdjustment typeSurveyAdjustment = gsonInstance.fromJson(json, SurveyAdjustmentAdapter.SurveyAdjustment.class);
        if (typeSurveyAdjustment.m_nID > 0)
        {
            typeSurveyAdjustment.setSaved();
        }
        return typeSurveyAdjustment;
    }

    public static ISurveyAdjustment get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyAdjustment typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting SurveyAdjustment id = " + nIdGet + " from db");
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
                typeReturn = createSurveyAdjustmentFromQueryResults(connDb, results);
                LOGGER.debug("SurveyAdjustment data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No SurveyAdjustment data for id = " + nIdGet + " from db");
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
    public static ISurveyAdjustment getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last SurveyAdjustment from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyAdjustmentFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last SurveyAdjustment data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last SurveyAdjustment  from db", exc);
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
    public static ISurveyAdjustment updateFromLast(Connection connDb, ISurveyAdjustment typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating SurveyAdjustment id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyAdjustmentFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find SurveyAdjustment id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of SurveyAdjustment id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting SurveyAdjustment id from db");
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
                LOGGER.debug("No last SurveyAdjustment in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last SurveyAdjustment id from db failed", exc);
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

    public static List<ISurveyAdjustment> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyAdjustment> listReturn = new ArrayList<ISurveyAdjustment>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all SurveyAdjustment data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyAdjustmentFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " SurveyAdjustment data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all SurveyAdjustment from db failed", exc);
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

    public static ISurveyAdjustment add(Connection connDb, ISurveyAdjustment typeAdd) throws SQLException
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
        LOGGER.info("Adding SurveyAdjustment data to db");
        LOGGER.debug("Adding SurveyAdjustment data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added SurveyAdjustment data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding SurveyAdjustment to db failed", exc);
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
    public static ISurveyAdjustment update(Connection connDb, ISurveyAdjustment typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating SurveyAdjustment data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating SurveyAdjustment, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating SurveyAdjustment data - " + ((ISerialiseState) typeUpdate).toJson());
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
                LOGGER.error("Adding SurveyAdjustment to db failed", exc);
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

    public static ISurveyAdjustment updateFromDatabase(Connection connDb, ISurveyAdjustment typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database SurveyAdjustment, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyAdjustmentFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database SurveyAdjustment, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for SurveyAdjustment, id = " + typeUpdate.getID() + " from db failed", exc);
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


    private static ISurveyAdjustment createSurveyAdjustmentFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ISurveyAdjustment) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ISurveyAdjustment updateSurveyAdjustmentFromQueryResults(Connection connDb, ResultSet results, ISurveyAdjustment typeUpdate) throws SQLException
    {
        return (ISurveyAdjustment) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_DELTAX + ",  " +
            FIELD_DELTAY + ",  " +
            FIELD_DELTAZ + ",  " +
            FIELD_BEARINGADJ
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
            FIELD_DELTAX + ",  " +
            FIELD_DELTAY + ",  " +
            FIELD_DELTAZ + ",  " +
            FIELD_BEARINGADJ
            + ") VALUES (?,  ?,  ?,  ?)";
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
            FIELD_DELTAX + ",  " +
            FIELD_DELTAY + ",  " +
            FIELD_DELTAZ + ",  " +
            FIELD_BEARINGADJ
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_DELTAX + " = ?,  " +
            FIELD_DELTAY + " = ?,  " +
            FIELD_DELTAZ + " = ?,  " +
            FIELD_BEARINGADJ + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyAdjustment` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`DeltaX`    REAL NOT NULL, " + 
        "`DeltaY`    REAL NOT NULL, " + 
        "`DeltaZ`    REAL NOT NULL, " + 
        "`BearingAdj`    REAL NOT NULL " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateSurveyAdjustment after update on `SurveyAdjustment` " + 
            "for each row " + 
            "begin " + 
            "update SurveyAdjustment set updated = current_timestamp where ID == OLD.ID; " + 
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
            return "surveyadjustment";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_DELTAX + ",  " +
                       FIELD_DELTAY + ",  " +
                       FIELD_DELTAZ + ",  " +
                       FIELD_BEARINGADJ
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
            FIELD_DELTAX + ",  " +
            FIELD_DELTAY + ",  " +
            FIELD_DELTAZ + ",  " +
            FIELD_BEARINGADJ
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
                             FIELD_DELTAX + ",  " +
                             FIELD_DELTAY + ",  " +
                             FIELD_DELTAZ + ",  " +
                             FIELD_BEARINGADJ
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
                        FIELD_DELTAX + ",  " +
                        FIELD_DELTAY + ",  " +
                        FIELD_DELTAZ + ",  " +
                        FIELD_BEARINGADJ
                        + ") VALUES (?,  ?,  ?,  ?)";
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
        public String updateScript()
        {
            return "UPDATE " + TABLE_NAME + " SET " +
                               FIELD_DELTAX + " = ?,  " +
                               FIELD_DELTAY + " = ?,  " +
                               FIELD_DELTAZ + " = ?,  " +
                               FIELD_BEARINGADJ + " = ?"
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
                LOGGER.debug("Creating SurveyAdjustment in database");
                Statement stmtExecute = connDb.createStatement();
                stmtExecute.execute(createScript());
                LOGGER.debug("SurveyAdjustment create script - " + createScript());

                for(String strStatement : TABLE_EXTRA_SCRIPTS)
                {
                    stmtExecute.execute(strStatement);
                }
                LOGGER.debug("SurveyAdjustment extra script - " + triggerScript());

                if(!SQL_PROVIDER.staticInsertsScript().isEmpty())
                {
                    String[] listStatements = staticInsertsScript().split(";");
                    for(String strStatement : listStatements)
                    {
                        stmtExecute.execute(strStatement);
                    }
                    LOGGER.debug("SurveyAdjustment extra script - " + staticInsertsScript());
                }
                return true;
            }
            catch(SQLException exc)
            {
                LOGGER.error("Error executing scripts", exc);
            }
            return false;
        }

        private SqlProvider.SqlResultHandler<ISurveyAdjustment> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ISurveyAdjustment> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<ISurveyAdjustment>()
                           {
                                @Override
                                public ISurveyAdjustment fromResults(Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return createSurveyAdjustment
                                        (
                                            results.getInt(FIELD_ID),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                            results.getDouble(FIELD_DELTAX),
                                            results.getDouble(FIELD_DELTAY),
                                            results.getDouble(FIELD_DELTAZ),
                                            results.getDouble(FIELD_BEARINGADJ)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public ISurveyAdjustment updateFromResults(ISurveyAdjustment typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateSurveyAdjustment
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                            results.getDouble(FIELD_DELTAX),
                                            results.getDouble(FIELD_DELTAY),
                                            results.getDouble(FIELD_DELTAZ),
                                            results.getDouble(FIELD_BEARINGADJ)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public boolean insertNew(ISurveyAdjustment typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setDouble(1, typeInsert.getDeltaX());
                                        stmtSelect.setDouble(2, typeInsert.getDeltaY());
                                        stmtSelect.setDouble(3, typeInsert.getDeltaZ());
                                        stmtSelect.setDouble(4, typeInsert.getBearingAdj());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(ISurveyAdjustment typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setDouble(1, typeUpdate.getDeltaX());
                                        stmtSelect.setDouble(2, typeUpdate.getDeltaY());
                                        stmtSelect.setDouble(3, typeUpdate.getDeltaZ());
                                        stmtSelect.setDouble(4, typeUpdate.getBearingAdj());
                                        stmtSelect.setInt(5, typeUpdate.getID());

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
