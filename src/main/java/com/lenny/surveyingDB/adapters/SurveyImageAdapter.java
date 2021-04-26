// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 20:29:42 AEST 2021

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
import com.lenny.surveyingDB.interfaces.ISurveyImage;


public class SurveyImageAdapter implements JsonDeserializer<ISurveyImage>
{
    private static final Logger LOGGER = LogManager.getLogger(SurveyImageAdapter.class.getName());

        // Class implements ISurveyImage but only accessible through the SurveyImageAdapter

        public static class SurveyImage extends UndoTarget implements ISurveyImage
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private OffsetDateTime m_dateCreated;
            @SerializedName("updated")
            private OffsetDateTime m_dateUpdated;
            @SerializedName("Path")
            private String m_strPath;
            @SerializedName("Description")
            private String m_strDescription;

            @SerializedName("SurveyID")
            private int m_nSurveyID;
            @SerializedName("PointAtID")
            private int m_nPointAtID;


            SurveyImage()
            {
                m_nID = 0;
                m_dateCreated = OffsetDateTime.now();
                m_dateUpdated = OffsetDateTime.now();
                m_strPath = "";
                m_strDescription = "";

                m_nSurveyID = 0;
                m_nPointAtID = 0;

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            SurveyImage(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strPath, String strDescription, int nSurveyID, int nPointAtID)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_strPath = strPath;
                m_strDescription = strDescription;
                m_nSurveyID = nSurveyID;m_nPointAtID = nPointAtID;
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
            public String getPath()
            {
                return  m_strPath;
            }
            public String getDescription()
            {
                return  m_strDescription;
            }

            public void setPath(String strSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyImage.this.m_saveState, "Undo set SurveyImage member Path = " + SurveyImage.this.m_strPath)
                    {
                        String m_undoPath = SurveyImage.this.m_strPath;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyImage.this.m_strPath = m_undoPath;
                                if(SurveyImage.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyImage.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_strPath = strSet;
                setUpdated();
            }
            public void setDescription(String strSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyImage.this.m_saveState, "Undo set SurveyImage member Description = " + SurveyImage.this.m_strDescription)
                    {
                        String m_undoDescription = SurveyImage.this.m_strDescription;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyImage.this.m_strDescription = m_undoDescription;
                                if(SurveyImage.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyImage.this.m_saveState = m_dataSaveState;
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

            public int getSurveyID()
            {
                return m_nSurveyID;
            }public int getPointAtID()
            {
                return m_nPointAtID;
            }
            void setSurveyID(int nSurveyID)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyImage.this.m_saveState, "Undo set SurveyImage member SurveyID = " + SurveyImage.this.m_nSurveyID)
                    {
                        int m_undoSurveyID = SurveyImage.this.m_nSurveyID;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyImage.this.m_nSurveyID = m_undoSurveyID;
                                if(SurveyImage.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyImage.this.m_saveState = m_dataSaveState;
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
            void setPointAtID(int nPointAtID)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyImage.this.m_saveState, "Undo set SurveyImage member PointAtID = " + SurveyImage.this.m_nPointAtID)
                    {
                        int m_undoPointAtID = SurveyImage.this.m_nPointAtID;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyImage.this.m_nPointAtID = m_undoPointAtID;
                                if(SurveyImage.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyImage.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_nPointAtID = nPointAtID;
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
                strJson += "\"Path\":" + "\"" + m_strPath + "\"" + ",";
                strJson += "\"Description\":" + "\"" + m_strDescription + "\"" + ",";
                strJson += "\"SurveyID\":" + m_nSurveyID + ",";
                strJson += "\"PointAtID\":" + m_nPointAtID;
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "SurveyImage";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_PATH = "Path";
    public static final String FIELD_DESCRIPTION = "Description";
    public static final String FIELD_SURVEYID = "SurveyID";
    public static final String FIELD_POINTATID = "PointAtID";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyImage createNewSurveyImage()
    {
        return new SurveyImage();
    }

    public static ISurveyImage createSurveyImage
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strPath,
        String strDescription,
        int nSurveyID,
        int nPointAtID
    )
    {
        return new SurveyImage(nID, dateCreated, dateUpdated, strPath, strDescription, nSurveyID, nPointAtID);
    }

    public static ISurveyImage updateSurveyImage
    (
        ISurveyImage typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strPath,
        String strDescription,
        int nSurveyID,
        int nPointAtID
    )
    {
        SurveyImage updating = (SurveyImage) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strPath = strPath;;
        updating.m_strDescription = strDescription;;
        updating.m_nSurveyID = nSurveyID;;
        updating.m_nPointAtID = nPointAtID;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyImage
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyImage.class, new SurveyImageAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyImage serialised = gsonInstance.fromJson(strJson, ISurveyImage.class);

    public ISurveyImage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        SurveyImageAdapter.SurveyImage typeSurveyImage = gsonInstance.fromJson(json, SurveyImageAdapter.SurveyImage.class);
        if (typeSurveyImage.m_nID > 0)
        {
            typeSurveyImage.setSaved();
        }
        return typeSurveyImage;
    }

    public static ISurveyImage get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyImage typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting SurveyImage id = " + nIdGet + " from db");
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
                typeReturn = createSurveyImageFromQueryResults(connDb, results);
                LOGGER.debug("SurveyImage data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No SurveyImage data for id = " + nIdGet + " from db");
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
    public static ISurveyImage getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last SurveyImage from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyImageFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last SurveyImage data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last SurveyImage  from db", exc);
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
    public static ISurveyImage updateFromLast(Connection connDb, ISurveyImage typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating SurveyImage id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyImageFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find SurveyImage id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of SurveyImage id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting SurveyImage id from db");
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
                LOGGER.debug("No last SurveyImage in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last SurveyImage id from db failed", exc);
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

    public static List<ISurveyImage> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyImage> listReturn = new ArrayList<ISurveyImage>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all SurveyImage data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyImageFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " SurveyImage data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all SurveyImage from db failed", exc);
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

    public static List<ISurveyImage> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyImage> listReturn = new ArrayList<ISurveyImage>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("Survey"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyImageFromQueryResults(connDb, results));
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
    }public static List<ISurveyImage> getAllForSurveyPointParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyImage> listReturn = new ArrayList<ISurveyImage>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("SurveyPoint"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyImageFromQueryResults(connDb, results));
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
    public static ISurveyImage add(Connection connDb, ISurveyImage typeAdd) throws SQLException
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
        LOGGER.info("Adding SurveyImage data to db");
        LOGGER.debug("Adding SurveyImage data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.resultsHandler().insertNew(typeAdd, stmtSelect);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added SurveyImage data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding SurveyImage to db failed", exc);
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
    public static ISurveyImage update(Connection connDb, ISurveyImage typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating SurveyImage data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating SurveyImage, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating SurveyImage data - " + ((ISerialiseState) typeUpdate).toJson());
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
                LOGGER.error("Adding SurveyImage to db failed", exc);
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

    public static ISurveyImage updateFromDatabase(Connection connDb, ISurveyImage typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database SurveyImage, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyImageFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database SurveyImage, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for SurveyImage, id = " + typeUpdate.getID() + " from db failed", exc);
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


    private static ISurveyImage createSurveyImageFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ISurveyImage) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ISurveyImage updateSurveyImageFromQueryResults(Connection connDb, ResultSet results, ISurveyImage typeUpdate) throws SQLException
    {
        return (ISurveyImage) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_PATH + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_POINTATID
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
            FIELD_PATH + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_POINTATID
            + " FROM " +
            TABLE_NAME  +
            " WHERE " +
            FIELD_SURVEYID + " = ?";
    }private static String getSelectForSurveyPointQuery()
    {
        return "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_PATH + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_POINTATID
            + " FROM " +
            TABLE_NAME  +
            " WHERE " +
            FIELD_POINTATID + " = ?";
    }
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_PATH + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_POINTATID
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
            FIELD_PATH + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_POINTATID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_PATH + " = ?,  " +
            FIELD_DESCRIPTION + " = ?,  " +
            FIELD_SURVEYID + " = ?,  " +
            FIELD_POINTATID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyImage` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Path`  TEXT NOT NULL, " + 
        "`SurveyID` INTEGER NOT NULL, " + 
        "`PointAtID` INTEGER NOT NULL, " + 
        "`Description`   TEXT, " + 
        "FOREIGN KEY (SurveyID) REFERENCES Survey(ID), " + 
        "FOREIGN KEY (PointAtID) REFERENCES SurveyPoint(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateSurveyImage after update on `SurveyImage` " + 
            "for each row " + 
            "begin " + 
            "update SurveyImage set updated = current_timestamp where ID == OLD.ID; " + 
            "end;"
    };

    public static String[] getExtraTableScripts()
    {
        return TABLE_EXTRA_SCRIPTS;
    }

    public static void createInDatabase(Connection connDb) throws SQLException
    {
        LOGGER.debug("Creating SurveyImage in database");
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(SQL_PROVIDER.createScript());
        LOGGER.debug("SurveyImage create script - " + SQL_PROVIDER.createScript());
        stmtExecute.execute(SQL_PROVIDER.triggerScript());
        LOGGER.debug("SurveyImage extra script - " + SQL_PROVIDER.triggerScript());
        stmtExecute.execute(SQL_PROVIDER.staticInsertsScript());
        LOGGER.debug("SurveyImage extra script - " + SQL_PROVIDER.staticInsertsScript());
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
            return "surveyimage";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_PATH + ",  " +
                       FIELD_DESCRIPTION + ",  " +
                       FIELD_SURVEYID + ",  " +
                       FIELD_POINTATID
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
            FIELD_PATH + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_POINTATID
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
                        FIELD_PATH + ",  " +
                        FIELD_DESCRIPTION + ",  " +
                        FIELD_SURVEYID + ",  " +
                        FIELD_POINTATID
                        + " FROM " +
                        TABLE_NAME  +
                        " WHERE " +
                        FIELD_SURVEYID + " = ?";case "surveypoint":
                    return "SELECT " +
                        FIELD_ID + ",  " +
                        FIELD_CREATED + ",  " +
                        FIELD_UPDATED + ",  " +
                        FIELD_PATH + ",  " +
                        FIELD_DESCRIPTION + ",  " +
                        FIELD_SURVEYID + ",  " +
                        FIELD_POINTATID
                        + " FROM " +
                        TABLE_NAME  +
                        " WHERE " +
                        FIELD_POINTATID + " = ?";
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
                             FIELD_PATH + ",  " +
                             FIELD_DESCRIPTION + ",  " +
                             FIELD_SURVEYID + ",  " +
                             FIELD_POINTATID
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
                        FIELD_PATH + ",  " +
                        FIELD_DESCRIPTION + ",  " +
                        FIELD_SURVEYID + ",  " +
                        FIELD_POINTATID
                        + ") VALUES (?,  ?,  ?,  ?)";
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
                               FIELD_PATH + " = ?,  " +
                               FIELD_DESCRIPTION + " = ?,  " +
                               FIELD_SURVEYID + " = ?,  " +
                               FIELD_POINTATID + " = ?"
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

        private SqlProvider.SqlResultHandler<ISurveyImage> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ISurveyImage> resultsHandler()
        {
                if(m_resultsHandler == null)
                {
                    m_resultsHandler = new SqlProvider.SqlResultHandler<ISurveyImage>()
                           {
                                @Override
                                public ISurveyImage fromResults(Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return createSurveyImage
                                        (
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_PATH),
                                            results.getString(FIELD_DESCRIPTION),
                                            results.getInt(FIELD_SURVEYID),
                                            results.getInt(FIELD_POINTATID)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public ISurveyImage updateFromResults(ISurveyImage typeUpdate, Connection connDb, ResultSet results)
                                {
                                    try
                                    {
                                        return updateSurveyImage
                                        (
                                            typeUpdate,
                                            results.getInt(FIELD_ID),
                                            OffsetDateTime.parse(results.getString(FIELD_CREATED)),
                                            OffsetDateTime.parse(results.getString(FIELD_UPDATED)),
                                            results.getString(FIELD_PATH),
                                            results.getString(FIELD_DESCRIPTION),
                                            results.getInt(FIELD_SURVEYID),
                                            results.getInt(FIELD_POINTATID)
                                        );
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error parsing result set", exc);
                                    }
                                    return null;
                                }
                                @Override
                                public boolean insertNew(ISurveyImage typeInsert, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeInsert.getPath());
                                        stmtSelect.setString(2, typeInsert.getDescription());
                                        stmtSelect.setInt(3, ((SurveyImageAdapter.SurveyImage) typeInsert).getSurveyID());
                                        stmtSelect.setInt(4, ((SurveyImageAdapter.SurveyImage) typeInsert).getPointAtID());

                                        return true;
                                    }
                                    catch(SQLException exc)
                                    {
                                        LOGGER.error("Error setting data to prepared statement", exc);
                                    }
                                    return false;
                                }
                                @Override
                                public boolean updateExisting(ISurveyImage typeUpdate, PreparedStatement stmtSelect)
                                {
                                    try
                                    {
                                        stmtSelect.setString(1, typeUpdate.getPath());
                                        stmtSelect.setString(2, typeUpdate.getDescription());
                                        stmtSelect.setInt(3, ((SurveyImageAdapter.SurveyImage) typeUpdate).getSurveyID());
                                        stmtSelect.setInt(4, ((SurveyImageAdapter.SurveyImage) typeUpdate).getPointAtID());
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
