// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Tue Jun 15 14:08:17 AEST 2021

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
import com.lenny.surveyingDB.interfaces.ISurveyReference;


public class SurveyReferenceAdapter implements JsonDeserializer<ISurveyReference>
{
    private static final Logger LOGGER = LogManager.getLogger(SurveyReferenceAdapter.class.getName());

    // Class implements ISurveyReference but only accessible through the SurveyReferenceAdapter

    public static class SurveyReference extends UndoTarget implements ISurveyReference
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
        @SerializedName("Date")
        private OffsetDateTime m_dateDate;
        @SerializedName("Reference")
        private String m_strReference;

        SurveyReference()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_strName = "";
            m_strDescription = "";
            m_dateDate = OffsetDateTime.now();
            m_strReference = "";

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        SurveyReference(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strName, String strDescription, OffsetDateTime dateDate, String strReference)
        {
            super();
            m_nID = nID;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_strName = strName;
            m_strDescription = strDescription;
            m_dateDate = dateDate;
            m_strReference = strReference;
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
        public OffsetDateTime getDate()
        {
            return  m_dateDate;
        }
        public String getReference()
        {
            return  m_strReference;
        }

        public void setName(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyReference.this.m_saveState, "Undo set SurveyReference member Name = " + SurveyReference.this.m_strName)
                {
                    String m_undoName = SurveyReference.this.m_strName;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyReference.this.m_strName = m_undoName;
                            if(SurveyReference.this.m_saveState != m_dataSaveState)
                            {
                                SurveyReference.this.m_saveState = m_dataSaveState;
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
                new UndoProviderImpl(SurveyReference.this.m_saveState, "Undo set SurveyReference member Description = " + SurveyReference.this.m_strDescription)
                {
                    String m_undoDescription = SurveyReference.this.m_strDescription;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyReference.this.m_strDescription = m_undoDescription;
                            if(SurveyReference.this.m_saveState != m_dataSaveState)
                            {
                                SurveyReference.this.m_saveState = m_dataSaveState;
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
        public void setDate(OffsetDateTime dateSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyReference.this.m_saveState, "Undo set SurveyReference member Date = " + SurveyReference.this.m_dateDate)
                {
                    OffsetDateTime m_undoDate = SurveyReference.this.m_dateDate;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyReference.this.m_dateDate = m_undoDate;
                            if(SurveyReference.this.m_saveState != m_dataSaveState)
                            {
                                SurveyReference.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dateDate = dateSet;
            setUpdated();
        }
        public void setReference(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyReference.this.m_saveState, "Undo set SurveyReference member Reference = " + SurveyReference.this.m_strReference)
                {
                    String m_undoReference = SurveyReference.this.m_strReference;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyReference.this.m_strReference = m_undoReference;
                            if(SurveyReference.this.m_saveState != m_dataSaveState)
                            {
                                SurveyReference.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_strReference = strSet;
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
            strJson += "\"Date\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateDate) + "\"" + ",";
            strJson += "\"Reference\":" + "\"" + m_strReference + "\"";
            strJson += "}";
            return strJson;
        }
    }
    public static final String TABLE_NAME = "SurveyReference";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_DESCRIPTION = "Description";
    public static final String FIELD_DATE = "Date";
    public static final String FIELD_REFERENCE = "Reference";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyReference createNewSurveyReference()
    {
        return new SurveyReference();
    }

    public static ISurveyReference createSurveyReference
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        OffsetDateTime dateDate,
        String strReference
    )
    {
        return new SurveyReference(nID, dateCreated, dateUpdated, strName, strDescription, dateDate, strReference);
    }

    public static ISurveyReference updateSurveyReference
    (
        ISurveyReference typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        OffsetDateTime dateDate,
        String strReference
    )
    {
        SurveyReference updating = (SurveyReference) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strName = strName;;
        updating.m_strDescription = strDescription;;
        updating.m_dateDate = dateDate;;
        updating.m_strReference = strReference;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyReference
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyReference.class, new SurveyReferenceAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyReference serialised = gsonInstance.fromJson(strJson, ISurveyReference.class);

    public ISurveyReference deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        SurveyReferenceAdapter.SurveyReference typeSurveyReference = gsonInstance.fromJson(json, SurveyReferenceAdapter.SurveyReference.class);
        if (typeSurveyReference.m_nID > 0)
        {
            typeSurveyReference.setSaved();
        }
        return typeSurveyReference;
    }

    public static ISurveyReference get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyReference typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting SurveyReference id = " + nIdGet + " from db");
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
                typeReturn = createSurveyReferenceFromQueryResults(connDb, results);
                LOGGER.debug("SurveyReference data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No SurveyReference data for id = " + nIdGet + " from db");
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
    public static ISurveyReference getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last SurveyReference from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyReferenceFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last SurveyReference data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last SurveyReference  from db", exc);
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
    public static ISurveyReference updateFromLast(Connection connDb, ISurveyReference typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating SurveyReference id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyReferenceFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find SurveyReference id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of SurveyReference id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting SurveyReference id from db");
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
                LOGGER.debug("No last SurveyReference in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last SurveyReference id from db failed", exc);
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

    public static List<ISurveyReference> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyReference> listReturn = new ArrayList<ISurveyReference>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all SurveyReference data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyReferenceFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " SurveyReference data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all SurveyReference from db failed", exc);
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

    public static ISurveyReference add(Connection connDb, ISurveyReference typeAdd) throws SQLException
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
        LOGGER.info("Adding SurveyReference data to db");
        LOGGER.debug("Adding SurveyReference data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added SurveyReference data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding SurveyReference to db failed", exc);
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
    public static ISurveyReference update(Connection connDb, ISurveyReference typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating SurveyReference data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating SurveyReference, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating SurveyReference data - " + ((ISerialiseState) typeUpdate).toJson());
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
                LOGGER.error("Adding SurveyReference to db failed", exc);
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

    public static ISurveyReference updateFromDatabase(Connection connDb, ISurveyReference typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database SurveyReference, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyReferenceFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database SurveyReference, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for SurveyReference, id = " + typeUpdate.getID() + " from db failed", exc);
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


    private static ISurveyReference createSurveyReferenceFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ISurveyReference) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ISurveyReference updateSurveyReferenceFromQueryResults(Connection connDb, ResultSet results, ISurveyReference typeUpdate) throws SQLException
    {
        return (ISurveyReference) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_DATE + ",  " +
            FIELD_REFERENCE
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
            FIELD_DATE + ",  " +
            FIELD_REFERENCE
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
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_DATE + ",  " +
            FIELD_REFERENCE
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_DESCRIPTION + " = ?,  " +
            FIELD_DATE + " = ?,  " +
            FIELD_REFERENCE + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyReference` " + 
        "( " + 
        "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name` TEXT NOT NULL, " + 
        "`Description` TEXT NOT NULL, " + 
        "`Date`      TIMESTAMP, " + 
        "`Reference` TEXT " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateSurveyReference after update on `SurveyReference` " + 
            "for each row " + 
            "begin " + 
            "update SurveyReference set updated = current_timestamp where ID == OLD.ID; " + 
            "end;",
            "INSERT INTO SurveyReference (Name, Description, Date, Reference) VALUES ('Current Survey', 'Current Survey', '2000-01-01 00:00:00', 'No Ref');",
            "INSERT INTO SurveyReference (Name, Description, Date, Reference) VALUES ('Existing Survey', 'Existing Survey', '2000-01-01 00:00:00', 'Unknown reference');"
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
            return "surveyreference";
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
                       FIELD_DATE + ",  " +
                       FIELD_REFERENCE
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
            FIELD_DATE + ",  " +
            FIELD_REFERENCE
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
                             FIELD_DATE + ",  " +
                             FIELD_REFERENCE
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
                        FIELD_DATE + ",  " +
                        FIELD_REFERENCE
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
                               FIELD_NAME + " = ?,  " +
                               FIELD_DESCRIPTION + " = ?,  " +
                               FIELD_DATE + " = ?,  " +
                               FIELD_REFERENCE + " = ?"
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
                LOGGER.debug("Creating SurveyReference in database");
                Statement stmtExecute = connDb.createStatement();
                stmtExecute.execute(createScript());
                LOGGER.debug("SurveyReference create script - " + createScript());

                for(String strStatement : TABLE_EXTRA_SCRIPTS)
                {
                    stmtExecute.execute(strStatement);
                }
                LOGGER.debug("SurveyReference extra script - " + triggerScript());

                if(!SQL_PROVIDER.staticInsertsScript().isEmpty())
                {
                    String[] listStatements = staticInsertsScript().split(";");
                    for(String strStatement : listStatements)
                    {
                        stmtExecute.execute(strStatement);
                    }
                    LOGGER.debug("SurveyReference extra script - " + staticInsertsScript());
                }
                return true;
            }
            catch(SQLException exc)
            {
                LOGGER.error("Error executing scripts", exc);
            }
            return false;
        }

        private SqlProvider.SqlResultHandler<ISurveyReference> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ISurveyReference> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<ISurveyReference>()
                           {
                                @Override
                                public ISurveyReference fromResults(Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return createSurveyReference
                                        (
                                            results.getInt(FIELD_ID),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_DESCRIPTION),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_DATE)),
                                            results.getString(FIELD_REFERENCE)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public ISurveyReference updateFromResults(ISurveyReference typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateSurveyReference
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_DESCRIPTION),
                                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_DATE)),
                                            results.getString(FIELD_REFERENCE)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public boolean insertNew(ISurveyReference typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeInsert.getName());
                                        stmtSelect.setString(2, typeInsert.getDescription());
                                        stmtSelect.setString(3, SQLiteConverter.convertDateTimeToString(typeInsert.getDate()));
                                        stmtSelect.setString(4, typeInsert.getReference());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(ISurveyReference typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeUpdate.getName());
                                        stmtSelect.setString(2, typeUpdate.getDescription());
                                        stmtSelect.setString(3, SQLiteConverter.convertDateTimeToString(typeUpdate.getDate()));
                                        stmtSelect.setString(4, typeUpdate.getReference());
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
