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
import com.lenny.surveyingDB.interfaces.ISurveyPointType;


public class SurveyPointTypeAdapter implements JsonDeserializer<ISurveyPointType>
{
    private static final Logger LOGGER = LogManager.getLogger(SurveyPointTypeAdapter.class.getName());

    // Class implements ISurveyPointType but only accessible through the SurveyPointTypeAdapter

    public static class SurveyPointType extends UndoTarget implements ISurveyPointType
    {
        @SerializedName("ID")
        private int m_nID;
        @SerializedName("created")
        private OffsetDateTime m_dateCreated;
        @SerializedName("updated")
        private OffsetDateTime m_dateUpdated;
        @SerializedName("Name")
        private String m_strName;
        @SerializedName("Abbreviation")
        private String m_strAbbreviation;
        @SerializedName("UserDefined")
        private boolean m_bUserDefined;

        SurveyPointType()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_strName = "";
            m_strAbbreviation = "";
            m_bUserDefined = false;

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        SurveyPointType(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strName, String strAbbreviation, boolean bUserDefined)
        {
            super();
            m_nID = nID;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_strName = strName;
            m_strAbbreviation = strAbbreviation;
            m_bUserDefined = bUserDefined;
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
        public String getAbbreviation()
        {
            return  m_strAbbreviation;
        }
        public boolean getUserDefined()
        {
            return  m_bUserDefined;
        }

        public void setName(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPointType.this.m_saveState, "Undo set SurveyPointType member Name = " + SurveyPointType.this.m_strName)
                {
                    String m_undoName = SurveyPointType.this.m_strName;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPointType.this.m_strName = m_undoName;
                            if(SurveyPointType.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPointType.this.m_saveState = m_dataSaveState;
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
        public void setAbbreviation(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPointType.this.m_saveState, "Undo set SurveyPointType member Abbreviation = " + SurveyPointType.this.m_strAbbreviation)
                {
                    String m_undoAbbreviation = SurveyPointType.this.m_strAbbreviation;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPointType.this.m_strAbbreviation = m_undoAbbreviation;
                            if(SurveyPointType.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPointType.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_strAbbreviation = strSet;
            setUpdated();
        }
        public void setUserDefined(boolean bSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPointType.this.m_saveState, "Undo set SurveyPointType member UserDefined = " + SurveyPointType.this.m_bUserDefined)
                {
                    boolean m_undoUserDefined = SurveyPointType.this.m_bUserDefined;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPointType.this.m_bUserDefined = m_undoUserDefined;
                            if(SurveyPointType.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPointType.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_bUserDefined = bSet;
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
            strJson += "\"Abbreviation\":" + "\"" + m_strAbbreviation + "\"" + ",";
            strJson += "\"UserDefined\":" + m_bUserDefined;
            strJson += "}";
            return strJson;
        }
    }
    public static final String TABLE_NAME = "SurveyPointType";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_ABBREVIATION = "Abbreviation";
    public static final String FIELD_USERDEFINED = "UserDefined";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyPointType createNewSurveyPointType()
    {
        return new SurveyPointType();
    }

    public static ISurveyPointType createSurveyPointType
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strAbbreviation,
        boolean bUserDefined
    )
    {
        return new SurveyPointType(nID, dateCreated, dateUpdated, strName, strAbbreviation, bUserDefined);
    }

    public static ISurveyPointType updateSurveyPointType
    (
        ISurveyPointType typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strAbbreviation,
        boolean bUserDefined
    )
    {
        SurveyPointType updating = (SurveyPointType) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strName = strName;;
        updating.m_strAbbreviation = strAbbreviation;;
        updating.m_bUserDefined = bUserDefined;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyPointType
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyPointType.class, new SurveyPointTypeAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyPointType serialised = gsonInstance.fromJson(strJson, ISurveyPointType.class);

    public ISurveyPointType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        SurveyPointTypeAdapter.SurveyPointType typeSurveyPointType = gsonInstance.fromJson(json, SurveyPointTypeAdapter.SurveyPointType.class);
        if (typeSurveyPointType.m_nID > 0)
        {
            typeSurveyPointType.setSaved();
        }
        return typeSurveyPointType;
    }

    public static ISurveyPointType get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyPointType typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting SurveyPointType id = " + nIdGet + " from db");
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
                typeReturn = createSurveyPointTypeFromQueryResults(connDb, results);
                LOGGER.debug("SurveyPointType data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No SurveyPointType data for id = " + nIdGet + " from db");
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
    public static ISurveyPointType getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last SurveyPointType from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyPointTypeFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last SurveyPointType data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last SurveyPointType  from db", exc);
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
    public static ISurveyPointType updateFromLast(Connection connDb, ISurveyPointType typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating SurveyPointType id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyPointTypeFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find SurveyPointType id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of SurveyPointType id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting SurveyPointType id from db");
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
                LOGGER.debug("No last SurveyPointType in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last SurveyPointType id from db failed", exc);
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

    public static List<ISurveyPointType> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyPointType> listReturn = new ArrayList<ISurveyPointType>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all SurveyPointType data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyPointTypeFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " SurveyPointType data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all SurveyPointType from db failed", exc);
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

    public static ISurveyPointType add(Connection connDb, ISurveyPointType typeAdd) throws SQLException
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
        LOGGER.info("Adding SurveyPointType data to db");
        LOGGER.debug("Adding SurveyPointType data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added SurveyPointType data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding SurveyPointType to db failed", exc);
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
    public static ISurveyPointType update(Connection connDb, ISurveyPointType typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating SurveyPointType data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating SurveyPointType, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating SurveyPointType data - " + ((ISerialiseState) typeUpdate).toJson());
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
                LOGGER.error("Adding SurveyPointType to db failed", exc);
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

    public static ISurveyPointType updateFromDatabase(Connection connDb, ISurveyPointType typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database SurveyPointType, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyPointTypeFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database SurveyPointType, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for SurveyPointType, id = " + typeUpdate.getID() + " from db failed", exc);
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


    private static ISurveyPointType createSurveyPointTypeFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ISurveyPointType) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ISurveyPointType updateSurveyPointTypeFromQueryResults(Connection connDb, ResultSet results, ISurveyPointType typeUpdate) throws SQLException
    {
        return (ISurveyPointType) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_ABBREVIATION + ",  " +
            FIELD_USERDEFINED
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
            FIELD_ABBREVIATION + ",  " +
            FIELD_USERDEFINED
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
            FIELD_ABBREVIATION + ",  " +
            FIELD_USERDEFINED
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_ABBREVIATION + " = ?,  " +
            FIELD_USERDEFINED + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyPointType` " + 
        "( " + 
        "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name` TEXT NOT NULL UNIQUE, " + 
        "`Abbreviation`  TEXT NOT NULL UNIQUE, " + 
        "`UserDefined` BOOLEAN NOT NULL " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateSurveyPointType after update on `SurveyPointType` " + 
            "for each row " + 
            "begin " + 
            "update SurveyPointType set updated = current_timestamp where ID == OLD.ID; " + 
            "end;",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Survey Mark', 'SM', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Old Survey Mark', 'OSM', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Permanent Survey Mark', 'PSM', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Trig Point', 'Trig', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('General Level', 'GL', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Corner of House', 'Cnr H', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Tree', 'Tree', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Boundary', 'Bdy', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Fence', 'Fnc', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Fence Line', 'FL', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Post', 'Post', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Edge of Concrete', 'EoC', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Edge of Road', 'EoR', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Top of Kerb', 'ToK', 0);",
            "INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Drain', 'Dr', 0);"
    };

    public static String[] getExtraTableScripts()
    {
        return TABLE_EXTRA_SCRIPTS;
    }

    public static void createInDatabase(Connection connDb) throws SQLException
    {
        LOGGER.debug("Creating SurveyPointType in database");
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(SQL_PROVIDER.createScript());
        LOGGER.debug("SurveyPointType create script - " + SQL_PROVIDER.createScript());
        stmtExecute.execute(SQL_PROVIDER.triggerScript());
        LOGGER.debug("SurveyPointType extra script - " + SQL_PROVIDER.triggerScript());
        stmtExecute.execute(SQL_PROVIDER.staticInsertsScript());
        LOGGER.debug("SurveyPointType extra script - " + SQL_PROVIDER.staticInsertsScript());
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
            return "surveypointtype";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_NAME + ",  " +
                       FIELD_ABBREVIATION + ",  " +
                       FIELD_USERDEFINED
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
            FIELD_ABBREVIATION + ",  " +
            FIELD_USERDEFINED
            + " FROM " +
            TABLE_NAME + " WHERE " + PRIMARY_KEY + " = ?";
        }
        public String selectFor(String strContext)
        {
            switch(strContext)
            {
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
                             FIELD_ABBREVIATION + ",  " +
                             FIELD_USERDEFINED
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
                        FIELD_ABBREVIATION + ",  " +
                        FIELD_USERDEFINED
                        + ") VALUES (?,  ?,  ?)";
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
                               FIELD_ABBREVIATION + " = ?,  " +
                               FIELD_USERDEFINED + " = ?"
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

        private SqlProvider.SqlResultHandler<ISurveyPointType> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ISurveyPointType> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<ISurveyPointType>()
                           {
                                @Override
                                public ISurveyPointType fromResults(Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return createSurveyPointType
                                        (
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_ABBREVIATION),
                                            SQLiteConverter.convertIntegerToBoolean(results.getInt(FIELD_USERDEFINED))
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public ISurveyPointType updateFromResults(ISurveyPointType typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateSurveyPointType
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_ABBREVIATION),
                                            SQLiteConverter.convertIntegerToBoolean(results.getInt(FIELD_USERDEFINED))
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public boolean insertNew(ISurveyPointType typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeInsert.getName());
                                        stmtSelect.setString(2, typeInsert.getAbbreviation());
                                        stmtSelect.setInt(3, SQLiteConverter.convertBooleanToInteger(typeInsert.getUserDefined()));

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(ISurveyPointType typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeUpdate.getName());
                                        stmtSelect.setString(2, typeUpdate.getAbbreviation());
                                        stmtSelect.setInt(3, SQLiteConverter.convertBooleanToInteger(typeUpdate.getUserDefined()));
                                        stmtSelect.setInt(4, typeUpdate.getID());

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
