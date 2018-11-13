// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:53 AEST 2018

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
import com.lenny.surveyingDB.interfaces.ISurveyImage;


public class SurveyImageAdapter implements JsonDeserializer<ISurveyImage>
{

        // Class implements ISurveyImage but only accessible through the SurveyImageAdapter

        static class SurveyImage extends UndoTarget implements ISurveyImage
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
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
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_strPath = "";
                m_strDescription = "";

                m_nSurveyID = 0;
                m_nPointAtID = 0;

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            SurveyImage(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, String strPath, String strDescription, int nSurveyID, int nPointAtID)
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
            public LocalDateTime getCreated()
            {
                return  m_dateCreated;
            }
            public LocalDateTime getUpdated()
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
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String strPath,
        String strDescription,
        int nSurveyID,
        int nPointAtID
    )
    {
        return new SurveyImage(nID, dateCreated, dateUpdated, strPath, strDescription, nSurveyID, nPointAtID);
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyImage
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyImage.class, new SurveyImageAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyImage serialised = gsonInstance.fromJson(strJson, ISurveyImage.class);

    public ISurveyImage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
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
                typeReturn = createSurveyImageFromQueryResults(connDb, results);
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
    public static ISurveyImage getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyImageFromQueryResults(connDb, results);
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
    public static ISurveyImage updateFromLast(Connection connDb, ISurveyImage typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyImageFromQueryResults(connDb, results, typeUpdate);
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

    public static List<ISurveyImage> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyImage> listReturn = new ArrayList<ISurveyImage>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
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

    public static List<ISurveyImage> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyImage> listReturn = new ArrayList<ISurveyImage>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectForSurveyQuery());
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
            stmtSelect = connDb.prepareStatement(getSelectForSurveyPointQuery());
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
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setString(1, typeAdd.getPath());
            stmtSelect.setString(2, typeAdd.getDescription());
            stmtSelect.setInt(3, ((SurveyImage) typeAdd).m_nSurveyID);
            stmtSelect.setInt(4, ((SurveyImage) typeAdd).m_nPointAtID);

            stmtSelect.executeUpdate();

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
    public static ISurveyImage update(Connection connDb, ISurveyImage typeUpdate) throws SQLException
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
                stmtSelect.setString(1, typeUpdate.getPath());
                stmtSelect.setString(2, typeUpdate.getDescription());
                stmtSelect.setInt(3, ((SurveyImage) typeUpdate).m_nSurveyID);
                stmtSelect.setInt(4, ((SurveyImage) typeUpdate).m_nPointAtID);
                stmtSelect.setInt(5, typeUpdate.getID());

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

    public static ISurveyImage updateFromDatabase(Connection connDb, ISurveyImage typeUpdate) throws SQLException
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
                return updateSurveyImageFromQueryResults(connDb, results, typeUpdate);
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


    private static ISurveyImage createSurveyImageFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createSurveyImage
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getString(FIELD_PATH),
                       results.getString(FIELD_DESCRIPTION),
                       results.getInt(FIELD_SURVEYID),
                       results.getInt(FIELD_POINTATID)
                   );

    }
    private static ISurveyImage updateSurveyImageFromQueryResults(Connection connDb, ResultSet results, ISurveyImage typeUpdate) throws SQLException
    {
       ((SurveyImage)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((SurveyImage)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((SurveyImage)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((SurveyImage)typeUpdate).m_strPath = results.getString(FIELD_PATH);
       ((SurveyImage)typeUpdate).m_strDescription = results.getString(FIELD_DESCRIPTION);
       ((SurveyImage)typeUpdate).m_nSurveyID = results.getInt(FIELD_SURVEYID);
       ((SurveyImage)typeUpdate).m_nPointAtID = results.getInt(FIELD_POINTATID);

       return typeUpdate;
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
        String strSelect = "SELECT " +
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
        return strSelect;
    }private static String getSelectForSurveyPointQuery()
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
            TABLE_NAME  +
            " WHERE " +
            FIELD_POINTATID + " = ?";
        return strSelect;
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
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
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
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(CREATE_TABLE_SCRIPT);
        for(String strScript : TABLE_EXTRA_SCRIPTS)
        {
            stmtExecute.execute(strScript);
        }
    }
}
