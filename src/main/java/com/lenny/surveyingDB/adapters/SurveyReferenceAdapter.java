// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

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
import java.util.Date;
import java.util.stream.Collectors;

import com.google.gson.annotations.SerializedName;
import com.lenny.Utils.*;
import com.lenny.surveyingDB.interfaces.ISurveyReference;


public class SurveyReferenceAdapter implements JsonDeserializer<ISurveyReference>
{

        // Class implements ISurveyReference but only accessible through the SurveyReferenceAdapter

        static class SurveyReference extends UndoTarget implements ISurveyReference
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private Date m_dateCreated;
            @SerializedName("updated")
            private Date m_dateUpdated;
            @SerializedName("Name")
            private String m_strName;
            @SerializedName("Description")
            private String m_strDescription;
            @SerializedName("Date")
            private Date m_dateDate;
            @SerializedName("Reference")
            private String m_strReference;

            SurveyReference()
            {
                m_nID = 0;
                m_dateCreated = new Date();
                m_dateUpdated = new Date();
                m_strName = "";
                m_strDescription = "";
                m_dateDate = new Date();
                m_strReference = "";

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            SurveyReference(int nID, Date dateCreated, Date dateUpdated, String strName, String strDescription, Date dateDate, String strReference)
            {
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
            public Date getCreated()
            {
                return  m_dateCreated;
            }
            public Date getUpdated()
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
            public Date getDate()
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
            public void setDate(Date dateSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyReference.this.m_saveState, "Undo set SurveyReference member Date = " + SurveyReference.this.m_dateDate)
                    {
                        Date m_undoDate = SurveyReference.this.m_dateDate;
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
        Date dateCreated,
        Date dateUpdated,
        String strName,
        String strDescription,
        Date dateDate,
        String strReference
    )
    {
        return new SurveyReference(nID, dateCreated, dateUpdated, strName, strDescription, dateDate, strReference);
    }

    public ISurveyReference deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss");
        Gson gsonInstance = gsonBuilder.create();
        return gsonInstance.fromJson(json, SurveyReferenceAdapter.SurveyReference.class);
    }

    public static ISurveyReference get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyReference typeReturn = null;
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
                typeReturn = createSurveyReferenceFromQueryResults(connDb, results);
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
    public static ISurveyReference getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return createSurveyReferenceFromQueryResults(connDb, results);
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
    public static ISurveyReference updateFromLast(Connection connDb, ISurveyReference typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return updateSurveyReferenceFromQueryResults(connDb, results, typeUpdate);
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

    public static List<ISurveyReference> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyReference> listReturn = new ArrayList<ISurveyReference>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createSurveyReferenceFromQueryResults(connDb, results));
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

    public static ISurveyReference add(Connection connDb, ISurveyReference typeAdd) throws SQLException
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
        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setString(1, typeAdd.getName());
            stmtSelect.setString(2, typeAdd.getDescription());
            stmtSelect.setString(3, SQLiteConverter.convertDateTimeToString(typeAdd.getDate()));
            stmtSelect.setString(4, typeAdd.getReference());

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
    public static ISurveyReference update(Connection connDb, ISurveyReference typeUpdate) throws SQLException
    {
        if(((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getUpdateQuery());
            stmtSelect.setString(1, typeUpdate.getName());
            stmtSelect.setString(2, typeUpdate.getDescription());
            stmtSelect.setString(3, SQLiteConverter.convertDateTimeToString(typeUpdate.getDate()));
            stmtSelect.setString(4, typeUpdate.getReference());
            stmtSelect.setInt(5, typeUpdate.getID());

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

    public static ISurveyReference updateFromDatabase(Connection connDb, ISurveyReference typeUpdate) throws SQLException
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
                return updateSurveyReferenceFromQueryResults(connDb, results, typeUpdate);
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

    private static ISurveyReference createSurveyReferenceFromQueryResults(Connection connDb, ResultSet results) throws SQLException
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
    private static ISurveyReference updateSurveyReferenceFromQueryResults(Connection connDb, ResultSet results, ISurveyReference typeUpdate) throws SQLException
    {
       ((SurveyReference)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((SurveyReference)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((SurveyReference)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((SurveyReference)typeUpdate).m_strName = results.getString(FIELD_NAME);
       ((SurveyReference)typeUpdate).m_strDescription = results.getString(FIELD_DESCRIPTION);
       ((SurveyReference)typeUpdate).m_dateDate = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_DATE));
       ((SurveyReference)typeUpdate).m_strReference = results.getString(FIELD_REFERENCE);

       return typeUpdate;
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
        if(nIdFor > 0)
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
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
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
