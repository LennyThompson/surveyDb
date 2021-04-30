// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Fri Apr 30 12:19:02 AEST 2021

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
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;


public class InstrumentManufacturerAdapter implements JsonDeserializer<IInstrumentManufacturer>
{
    private static final Logger LOGGER = LogManager.getLogger(InstrumentManufacturerAdapter.class.getName());

        // Class implements IInstrumentManufacturer but only accessible through the InstrumentManufacturerAdapter

        public static class InstrumentManufacturer extends UndoTarget implements IInstrumentManufacturer
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

            InstrumentManufacturer()
            {
                m_nID = 0;
                m_dateCreated = OffsetDateTime.now();
                m_dateUpdated = OffsetDateTime.now();
                m_strName = "";
                m_strDescription = "";

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            InstrumentManufacturer(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strName, String strDescription)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_strName = strName;
                m_strDescription = strDescription;
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

            public void setName(String strSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(InstrumentManufacturer.this.m_saveState, "Undo set InstrumentManufacturer member Name = " + InstrumentManufacturer.this.m_strName)
                    {
                        String m_undoName = InstrumentManufacturer.this.m_strName;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                InstrumentManufacturer.this.m_strName = m_undoName;
                                if(InstrumentManufacturer.this.m_saveState != m_dataSaveState)
                                {
                                    InstrumentManufacturer.this.m_saveState = m_dataSaveState;
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
                    new UndoProviderImpl(InstrumentManufacturer.this.m_saveState, "Undo set InstrumentManufacturer member Description = " + InstrumentManufacturer.this.m_strDescription)
                    {
                        String m_undoDescription = InstrumentManufacturer.this.m_strDescription;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                InstrumentManufacturer.this.m_strDescription = m_undoDescription;
                                if(InstrumentManufacturer.this.m_saveState != m_dataSaveState)
                                {
                                    InstrumentManufacturer.this.m_saveState = m_dataSaveState;
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

            public void setSaved(){ onSave(); m_saveState = DataSaveState.SAVE_STATE_SAVED; }
            public void setUpdated(){ if(!isNew()) { onSave(); m_saveState = DataSaveState.SAVE_STATE_UPDATE; } }

            public String toJson()
            {
                String strJson = "{";
                strJson += "\"ID\":" + m_nID + ",";
                strJson += "\"created\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateCreated) + "\"" + ",";
                strJson += "\"updated\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateUpdated) + "\"" + ",";
                strJson += "\"Name\":" + "\"" + m_strName + "\"" + ",";
                strJson += "\"Description\":" + "\"" + m_strDescription + "\"";
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "InstrumentManufacturer";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_DESCRIPTION = "Description";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static IInstrumentManufacturer createNewInstrumentManufacturer()
    {
        return new InstrumentManufacturer();
    }

    public static IInstrumentManufacturer createInstrumentManufacturer
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription
    )
    {
        return new InstrumentManufacturer(nID, dateCreated, dateUpdated, strName, strDescription);
    }

    public static IInstrumentManufacturer updateInstrumentManufacturer
    (
        IInstrumentManufacturer typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription
    )
    {
        InstrumentManufacturer updating = (InstrumentManufacturer) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strName = strName;;
        updating.m_strDescription = strDescription;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as IInstrumentManufacturer
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(IInstrumentManufacturer.class, new InstrumentManufacturerAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      IInstrumentManufacturer serialised = gsonInstance.fromJson(strJson, IInstrumentManufacturer.class);

    public IInstrumentManufacturer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        InstrumentManufacturerAdapter.InstrumentManufacturer typeInstrumentManufacturer = gsonInstance.fromJson(json, InstrumentManufacturerAdapter.InstrumentManufacturer.class);
        if (typeInstrumentManufacturer.m_nID > 0)
        {
            typeInstrumentManufacturer.setSaved();
        }
        return typeInstrumentManufacturer;
    }

    public static IInstrumentManufacturer get(Connection connDb, int nIdGet) throws SQLException
    {
        IInstrumentManufacturer typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting InstrumentManufacturer id = " + nIdGet + " from db");
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
                typeReturn = createInstrumentManufacturerFromQueryResults(connDb, results);
                LOGGER.debug("InstrumentManufacturer data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No InstrumentManufacturer data for id = " + nIdGet + " from db");
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
    public static IInstrumentManufacturer getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last InstrumentManufacturer from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createInstrumentManufacturerFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last InstrumentManufacturer data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last InstrumentManufacturer  from db", exc);
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
    public static IInstrumentManufacturer updateFromLast(Connection connDb, IInstrumentManufacturer typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating InstrumentManufacturer id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateInstrumentManufacturerFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find InstrumentManufacturer id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of InstrumentManufacturer id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting InstrumentManufacturer id from db");
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
                LOGGER.debug("No last InstrumentManufacturer in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last InstrumentManufacturer id from db failed", exc);
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

    public static List<IInstrumentManufacturer> getAll(Connection connDb) throws SQLException
    {
        List<IInstrumentManufacturer> listReturn = new ArrayList<IInstrumentManufacturer>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all InstrumentManufacturer data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createInstrumentManufacturerFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " InstrumentManufacturer data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all InstrumentManufacturer from db failed", exc);
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

    public static IInstrumentManufacturer add(Connection connDb, IInstrumentManufacturer typeAdd) throws SQLException
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
        LOGGER.info("Adding InstrumentManufacturer data to db");
        LOGGER.debug("Adding InstrumentManufacturer data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added InstrumentManufacturer data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding InstrumentManufacturer to db failed", exc);
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
    public static IInstrumentManufacturer update(Connection connDb, IInstrumentManufacturer typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating InstrumentManufacturer data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating InstrumentManufacturer, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating InstrumentManufacturer data - " + ((ISerialiseState) typeUpdate).toJson());
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
                LOGGER.error("Adding InstrumentManufacturer to db failed", exc);
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

    public static IInstrumentManufacturer updateFromDatabase(Connection connDb, IInstrumentManufacturer typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database InstrumentManufacturer, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateInstrumentManufacturerFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database InstrumentManufacturer, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for InstrumentManufacturer, id = " + typeUpdate.getID() + " from db failed", exc);
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


    private static IInstrumentManufacturer createInstrumentManufacturerFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (IInstrumentManufacturer) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static IInstrumentManufacturer updateInstrumentManufacturerFromQueryResults(Connection connDb, ResultSet results, IInstrumentManufacturer typeUpdate) throws SQLException
    {
        return (IInstrumentManufacturer) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION
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
            FIELD_DESCRIPTION
            + ") VALUES (?,  ?)";
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
            FIELD_DESCRIPTION
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_DESCRIPTION + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE InstrumentManufacturer " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name`  TEXT NOT NULL UNIQUE, " + 
        "`Description`   TEXT " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateInstrumentManufacturer after update on `InstrumentManufacturer` " + 
            "for each row " + 
            "begin " + 
            "update InstrumentManufacturer set updated = current_timestamp where ID == OLD.ID; " + 
            "end;"
    };

    public static String[] getExtraTableScripts()
    {
        return TABLE_EXTRA_SCRIPTS;
    }

    public static void createInDatabase(Connection connDb) throws SQLException
    {
        LOGGER.debug("Creating InstrumentManufacturer in database");
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(SQL_PROVIDER.createScript());
        LOGGER.debug("InstrumentManufacturer create script - " + SQL_PROVIDER.createScript());
        stmtExecute.execute(SQL_PROVIDER.triggerScript());
        LOGGER.debug("InstrumentManufacturer extra script - " + SQL_PROVIDER.triggerScript());
        stmtExecute.execute(SQL_PROVIDER.staticInsertsScript());
        LOGGER.debug("InstrumentManufacturer extra script - " + SQL_PROVIDER.staticInsertsScript());
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
            return "instrumentmanufacturer";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_NAME + ",  " +
                       FIELD_DESCRIPTION
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
            FIELD_DESCRIPTION
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
                             FIELD_DESCRIPTION
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
                        FIELD_DESCRIPTION
                        + ") VALUES (?,  ?)";
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
                               FIELD_DESCRIPTION + " = ?"
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

        private SqlProvider.SqlResultHandler<IInstrumentManufacturer> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<IInstrumentManufacturer> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<IInstrumentManufacturer>()
                           {
                                @Override
                                public IInstrumentManufacturer fromResults(Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return createInstrumentManufacturer
                                        (
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_DESCRIPTION)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public IInstrumentManufacturer updateFromResults(IInstrumentManufacturer typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateInstrumentManufacturer
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            results.getString(FIELD_DESCRIPTION)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public boolean insertNew(IInstrumentManufacturer typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeInsert.getName());
                                        stmtSelect.setString(2, typeInsert.getDescription());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(IInstrumentManufacturer typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeUpdate.getName());
                                        stmtSelect.setString(2, typeUpdate.getDescription());
                                        stmtSelect.setInt(3, typeUpdate.getID());

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
