// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 20:29:43 AEST 2021

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
import com.lenny.surveyingDB.interfaces.IProjection;


public class ProjectionAdapter implements JsonDeserializer<IProjection>
{
    private static final Logger LOGGER = LogManager.getLogger(ProjectionAdapter.class.getName());

        // Class implements IProjection but only accessible through the ProjectionAdapter

        public static class Projection extends UndoTarget implements IProjection
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private OffsetDateTime m_dateCreated;
            @SerializedName("updated")
            private OffsetDateTime m_dateUpdated;
            @SerializedName("Name")
            private String m_strName;
            @SerializedName("Date")
            private OffsetDateTime m_dateDate;
            @SerializedName("Description")
            private String m_strDescription;

            Projection()
            {
                m_nID = 0;
                m_dateCreated = OffsetDateTime.now();
                m_dateUpdated = OffsetDateTime.now();
                m_strName = "";
                m_dateDate = OffsetDateTime.now();
                m_strDescription = "";

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            Projection(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strName, OffsetDateTime dateDate, String strDescription)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_strName = strName;
                m_dateDate = dateDate;
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
            public OffsetDateTime getDate()
            {
                return  m_dateDate;
            }
            public String getDescription()
            {
                return  m_strDescription;
            }

            public void setID(int nSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Projection.this.m_saveState, "Undo set Projection member ID = " + Projection.this.m_nID)
                    {
                        int m_undoID = Projection.this.m_nID;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Projection.this.m_nID = m_undoID;
                                if(Projection.this.m_saveState != m_dataSaveState)
                                {
                                    Projection.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_nID = nSet;
                setUpdated();
            }
            public void setName(String strSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Projection.this.m_saveState, "Undo set Projection member Name = " + Projection.this.m_strName)
                    {
                        String m_undoName = Projection.this.m_strName;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Projection.this.m_strName = m_undoName;
                                if(Projection.this.m_saveState != m_dataSaveState)
                                {
                                    Projection.this.m_saveState = m_dataSaveState;
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
            public void setDate(OffsetDateTime dateSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Projection.this.m_saveState, "Undo set Projection member Date = " + Projection.this.m_dateDate)
                    {
                        OffsetDateTime m_undoDate = Projection.this.m_dateDate;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Projection.this.m_dateDate = m_undoDate;
                                if(Projection.this.m_saveState != m_dataSaveState)
                                {
                                    Projection.this.m_saveState = m_dataSaveState;
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
            public void setDescription(String strSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Projection.this.m_saveState, "Undo set Projection member Description = " + Projection.this.m_strDescription)
                    {
                        String m_undoDescription = Projection.this.m_strDescription;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Projection.this.m_strDescription = m_undoDescription;
                                if(Projection.this.m_saveState != m_dataSaveState)
                                {
                                    Projection.this.m_saveState = m_dataSaveState;
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
                strJson += "\"Date\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateDate) + "\"" + ",";
                strJson += "\"Description\":" + "\"" + m_strDescription + "\"";
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "Projection";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_DATE = "Date";
    public static final String FIELD_DESCRIPTION = "Description";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static IProjection createNewProjection()
    {
        return new Projection();
    }

    public static IProjection createProjection
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        OffsetDateTime dateDate,
        String strDescription
    )
    {
        return new Projection(nID, dateCreated, dateUpdated, strName, dateDate, strDescription);
    }

    public static IProjection updateProjection
    (
        IProjection typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        OffsetDateTime dateDate,
        String strDescription
    )
    {
        Projection updating = (Projection) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strName = strName;;
        updating.m_dateDate = dateDate;;
        updating.m_strDescription = strDescription;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as IProjection
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(IProjection.class, new ProjectionAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      IProjection serialised = gsonInstance.fromJson(strJson, IProjection.class);

    public IProjection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        ProjectionAdapter.Projection typeProjection = gsonInstance.fromJson(json, ProjectionAdapter.Projection.class);
        if (typeProjection.m_nID > 0)
        {
            typeProjection.setSaved();
        }
        return typeProjection;
    }

    public static IProjection get(Connection connDb, int nIdGet) throws SQLException
    {
        IProjection typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting Projection id = " + nIdGet + " from db");
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
                typeReturn = createProjectionFromQueryResults(connDb, results);
                LOGGER.debug("Projection data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No Projection data for id = " + nIdGet + " from db");
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
    public static IProjection getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last Projection from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createProjectionFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last Projection data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last Projection  from db", exc);
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
    public static IProjection updateFromLast(Connection connDb, IProjection typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating Projection id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateProjectionFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find Projection id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of Projection id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting Projection id from db");
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
                LOGGER.debug("No last Projection in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last Projection id from db failed", exc);
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

    public static List<IProjection> getAll(Connection connDb) throws SQLException
    {
        List<IProjection> listReturn = new ArrayList<IProjection>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all Projection data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createProjectionFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " Projection data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all Projection from db failed", exc);
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

    public static IProjection add(Connection connDb, IProjection typeAdd) throws SQLException
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
        LOGGER.info("Adding Projection data to db");
        LOGGER.debug("Adding Projection data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added Projection data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding Projection to db failed", exc);
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
    public static IProjection update(Connection connDb, IProjection typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating Projection data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating Projection, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating Projection data - " + ((ISerialiseState) typeUpdate).toJson());
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
                LOGGER.error("Adding Projection to db failed", exc);
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

    public static IProjection updateFromDatabase(Connection connDb, IProjection typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database Projection, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateProjectionFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database Projection, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for Projection, id = " + typeUpdate.getID() + " from db failed", exc);
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


    private static IProjection createProjectionFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (IProjection) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static IProjection updateProjectionFromQueryResults(Connection connDb, ResultSet results, IProjection typeUpdate) throws SQLException
    {
        return (IProjection) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DATE + ",  " +
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
            FIELD_DATE + ",  " +
            FIELD_DESCRIPTION
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
            FIELD_DATE + ",  " +
            FIELD_DESCRIPTION
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_DATE + " = ?,  " +
            FIELD_DESCRIPTION + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE Projection " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name`  TEXT NOT NULL, " + 
        "`Date`      TIMESTAMP, " + 
        "`Description`   TEXT " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateProjection after update on `Projection` " + 
            "for each row " + 
            "begin " + 
            "update Projection set updated = current_timestamp where ID == OLD.ID; " + 
            "end;",
            "INSERT INTO Projection (Name, Description, Date) VALUES ('UTM XX', 'Transverse Mercator Projection - TODO', '2000-01-01 00:00:00');",
            "INSERT INTO Projection (Name, Description, Date) VALUES ('Local UTM', 'UTM Projection centred on survey', '2000-01-01 00:00:00');"
    };

    public static String[] getExtraTableScripts()
    {
        return TABLE_EXTRA_SCRIPTS;
    }

    public static void createInDatabase(Connection connDb) throws SQLException
    {
        LOGGER.debug("Creating Projection in database");
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(SQL_PROVIDER.createScript());
        LOGGER.debug("Projection create script - " + SQL_PROVIDER.createScript());
        stmtExecute.execute(SQL_PROVIDER.triggerScript());
        LOGGER.debug("Projection extra script - " + SQL_PROVIDER.triggerScript());
        stmtExecute.execute(SQL_PROVIDER.staticInsertsScript());
        LOGGER.debug("Projection extra script - " + SQL_PROVIDER.staticInsertsScript());
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
            return "projection";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_NAME + ",  " +
                       FIELD_DATE + ",  " +
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
            FIELD_DATE + ",  " +
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
            return "SELECT MAX(" + PRIMARY_KEY + ") AS maxPK, " +
                             FIELD_ID + ",  " +
                             FIELD_CREATED + ",  " +
                             FIELD_UPDATED + ",  " +
                             FIELD_NAME + ",  " +
                             FIELD_DATE + ",  " +
                             FIELD_DESCRIPTION
                             + " FROM " +
                             TABLE_NAME;
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
                        FIELD_DATE + ",  " +
                        FIELD_DESCRIPTION
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
                               FIELD_DATE + " = ?,  " +
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

        private SqlProvider.SqlResultHandler<IProjection> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<IProjection> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<IProjection>()
                           {
                                @Override
                                public IProjection fromResults(Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return createProjection
                                        (
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            OffsetDateTime.parse(results.getString(FIELD_DATE)),
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
                                public IProjection updateFromResults(IProjection typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateProjection
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_NAME),
                                            OffsetDateTime.parse(results.getString(FIELD_DATE)),
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
                                public boolean insertNew(IProjection typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeInsert.getName());
                                        stmtSelect.setString(2, SQLiteConverter.convertDateTimeToString(typeInsert.getDate()));
                                        stmtSelect.setString(3, typeInsert.getDescription());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(IProjection typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeUpdate.getName());
                                        stmtSelect.setString(2, SQLiteConverter.convertDateTimeToString(typeUpdate.getDate()));
                                        stmtSelect.setString(3, typeUpdate.getDescription());
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
