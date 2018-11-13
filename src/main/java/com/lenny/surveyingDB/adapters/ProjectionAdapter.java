// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:54 AEST 2018

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
import com.lenny.surveyingDB.interfaces.IProjection;


public class ProjectionAdapter implements JsonDeserializer<IProjection>
{

        // Class implements IProjection but only accessible through the ProjectionAdapter

        static class Projection extends UndoTarget implements IProjection
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
            @SerializedName("Name")
            private String m_strName;
            @SerializedName("Date")
            private LocalDateTime m_dateDate;
            @SerializedName("Description")
            private String m_strDescription;

            Projection()
            {
                m_nID = 0;
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_strName = "";
                m_dateDate = LocalDateTime.now();
                m_strDescription = "";

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            Projection(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, String strName, LocalDateTime dateDate, String strDescription)
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
            public LocalDateTime getDate()
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
            public void setDate(LocalDateTime dateSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Projection.this.m_saveState, "Undo set Projection member Date = " + Projection.this.m_dateDate)
                    {
                        LocalDateTime m_undoDate = Projection.this.m_dateDate;
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
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String strName,
        LocalDateTime dateDate,
        String strDescription
    )
    {
        return new Projection(nID, dateCreated, dateUpdated, strName, dateDate, strDescription);
    }

    // This method enables the adapter type to be registered to deserialise json as IProjection
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(IProjection.class, new ProjectionAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      IProjection serialised = gsonInstance.fromJson(strJson, IProjection.class);

    public IProjection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
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
                typeReturn = createProjectionFromQueryResults(connDb, results);
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
    public static IProjection getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createProjectionFromQueryResults(connDb, results);
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
    public static IProjection updateFromLast(Connection connDb, IProjection typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateProjectionFromQueryResults(connDb, results, typeUpdate);
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

    public static List<IProjection> getAll(Connection connDb) throws SQLException
    {
        List<IProjection> listReturn = new ArrayList<IProjection>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createProjectionFromQueryResults(connDb, results));
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
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setString(1, typeAdd.getName());
            stmtSelect.setString(2, SQLiteConverter.convertDateTimeToString(typeAdd.getDate()));
            stmtSelect.setString(3, typeAdd.getDescription());

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
    public static IProjection update(Connection connDb, IProjection typeUpdate) throws SQLException
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
                stmtSelect.setString(2, SQLiteConverter.convertDateTimeToString(typeUpdate.getDate()));
                stmtSelect.setString(3, typeUpdate.getDescription());
                stmtSelect.setInt(4, typeUpdate.getID());

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

    public static IProjection updateFromDatabase(Connection connDb, IProjection typeUpdate) throws SQLException
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
                return updateProjectionFromQueryResults(connDb, results, typeUpdate);
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


    private static IProjection createProjectionFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createProjection
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getString(FIELD_NAME),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_DATE)),
                       results.getString(FIELD_DESCRIPTION)
                   );

    }
    private static IProjection updateProjectionFromQueryResults(Connection connDb, ResultSet results, IProjection typeUpdate) throws SQLException
    {
       ((Projection)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((Projection)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((Projection)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((Projection)typeUpdate).m_strName = results.getString(FIELD_NAME);
       ((Projection)typeUpdate).m_dateDate = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_DATE));
       ((Projection)typeUpdate).m_strDescription = results.getString(FIELD_DESCRIPTION);

       return typeUpdate;
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
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
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
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(CREATE_TABLE_SCRIPT);
        for(String strScript : TABLE_EXTRA_SCRIPTS)
        {
            stmtExecute.execute(strScript);
        }
    }
}
