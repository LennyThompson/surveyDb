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
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;
import com.lenny.surveyingDB.adapters.InstrumentManufacturerAdapter;
import com.lenny.surveyingDB.interfaces.ISurvey;


public class InstrumentAdapter implements JsonDeserializer<IInstrument>
{

        // Class implements IInstrument but only accessible through the InstrumentAdapter

        static class Instrument extends UndoTarget implements IInstrument
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

            @SerializedName("ManufacturerID")
            private IInstrumentManufacturer m_typeManufacturer;

            Instrument()
            {
                m_nID = 0;
                m_dateCreated = new Date();
                m_dateUpdated = new Date();
                m_strName = "";
                m_strDescription = "";

                m_typeManufacturer = InstrumentManufacturerAdapter.createNewInstrumentManufacturer();

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            Instrument(int nID, Date dateCreated, Date dateUpdated, String strName, String strDescription, IInstrumentManufacturer typeManufacturer)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_strName = strName;
                m_strDescription = strDescription;
                m_typeManufacturer = typeManufacturer;
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

            public IInstrumentManufacturer getManufacturer()
            {
                return  m_typeManufacturer;
            }

            public void setName(String strSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Instrument.this.m_saveState, "Undo set Instrument member Name = " + Instrument.this.m_strName)
                    {
                        String m_undoName = Instrument.this.m_strName;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Instrument.this.m_strName = m_undoName;
                                if(Instrument.this.m_saveState != m_dataSaveState)
                                {
                                    Instrument.this.m_saveState = m_dataSaveState;
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
                    new UndoProviderImpl(Instrument.this.m_saveState, "Undo set Instrument member Description = " + Instrument.this.m_strDescription)
                    {
                        String m_undoDescription = Instrument.this.m_strDescription;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Instrument.this.m_strDescription = m_undoDescription;
                                if(Instrument.this.m_saveState != m_dataSaveState)
                                {
                                    Instrument.this.m_saveState = m_dataSaveState;
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

            public void setManufacturer(IInstrumentManufacturer typeSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Instrument.this.m_saveState, "Undo set Instrument member Manufacturer = " + Instrument.this.m_typeManufacturer)
                    {
                        IInstrumentManufacturer m_undoManufacturer = Instrument.this.m_typeManufacturer;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Instrument.this.m_typeManufacturer = m_undoManufacturer;
                                if(Instrument.this.m_saveState != m_dataSaveState)
                                {
                                    Instrument.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_typeManufacturer = typeSet;
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
                strJson += "\"ManufacturerID\":" + ((ISerialiseState) m_typeManufacturer).toJson();
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "Instrument";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_DESCRIPTION = "Description";
    public static final String FIELD_MANUFACTURERID = "ManufacturerID";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static IInstrument createNewInstrument()
    {
        return new Instrument();
    }

    public static IInstrument createInstrument
    (
        int nID,
        Date dateCreated,
        Date dateUpdated,
        String strName,
        String strDescription,
        IInstrumentManufacturer typeManufacturer
    )
    {
        return new Instrument(nID, dateCreated, dateUpdated, strName, strDescription, typeManufacturer);
    }

    public IInstrument deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss");
        gsonBuilder.registerTypeAdapter(IInstrumentManufacturer.class, new InstrumentManufacturerAdapter());

        Gson gsonInstance = gsonBuilder.create();
        return gsonInstance.fromJson(json, InstrumentAdapter.Instrument.class);
    }

    public static IInstrument get(Connection connDb, int nIdGet) throws SQLException
    {
        IInstrument typeReturn = null;
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
                typeReturn = createInstrumentFromQueryResults(connDb, results);
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
    public static IInstrument getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return createInstrumentFromQueryResults(connDb, results);
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
    public static IInstrument updateFromLast(Connection connDb, IInstrument typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return updateInstrumentFromQueryResults(connDb, results, typeUpdate);
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

    public static List<IInstrument> getAll(Connection connDb) throws SQLException
    {
        List<IInstrument> listReturn = new ArrayList<IInstrument>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createInstrumentFromQueryResults(connDb, results));
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

    public static List<IInstrument> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<IInstrument> listReturn = new ArrayList<IInstrument>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectForSurveyQuery());
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createInstrumentFromQueryResults(connDb, results));
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
    public static IInstrument addForSurvey(Connection connDb, IInstrument typeAdd, ISurvey typeParent) throws SQLException
    {
        IInstrument typeReturn = typeAdd;
        if(((ISerialiseState) typeAdd).isNew())
        {
            typeReturn = add(connDb, typeAdd);
        }

        PreparedStatement stmtLink = null;
        try
        {
            stmtLink = connDb.prepareStatement(getSurveyInsertLinkQuery());
            stmtLink.setInt(1, typeParent.getID());
            stmtLink.setInt(2, typeReturn.getID());
            stmtLink.executeUpdate();
        }
        catch(SQLException exc)
        {
            // TODO: set up error handling
        }
        finally
        {
            if(stmtLink != null)
            {
                stmtLink.close();
            }
        }
        return typeReturn;
    } 
    public static IInstrument add(Connection connDb, IInstrument typeAdd) throws SQLException
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
        if(((UndoTarget) typeAdd.getManufacturer()).isNew())
        {
            typeAdd.setManufacturer(InstrumentManufacturerAdapter.add(connDb, typeAdd.getManufacturer()));
        }
        else if(((UndoTarget) typeAdd.getManufacturer()).isUpdated())
        {
            typeAdd.setManufacturer(InstrumentManufacturerAdapter.update(connDb, typeAdd.getManufacturer()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setString(1, typeAdd.getName());
            stmtSelect.setString(2, typeAdd.getDescription());
            stmtSelect.setInt(3, typeAdd.getManufacturer().getID());

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
    public static IInstrument updateForSurvey(Connection connDb, IInstrument typeUpdate, ISurvey typeParent) throws SQLException
    {
        if(((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return addForSurvey(connDb, typeUpdate, typeParent);
        }
        return update(connDb, typeUpdate);
    } 
    public static IInstrument update(Connection connDb, IInstrument typeUpdate) throws SQLException
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
            stmtSelect.setInt(3, typeUpdate.getManufacturer().getID());
            stmtSelect.setInt(4, typeUpdate.getID());

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

    public static IInstrument updateFromDatabase(Connection connDb, IInstrument typeUpdate) throws SQLException
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
                return updateInstrumentFromQueryResults(connDb, results, typeUpdate);
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

    private static IInstrument createInstrumentFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createInstrument
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getString(FIELD_NAME),
                       results.getString(FIELD_DESCRIPTION),
                       InstrumentManufacturerAdapter.get(connDb, results.getInt(FIELD_MANUFACTURERID))
                   );

    }
    private static IInstrument updateInstrumentFromQueryResults(Connection connDb, ResultSet results, IInstrument typeUpdate) throws SQLException
    {
       ((Instrument)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((Instrument)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((Instrument)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((Instrument)typeUpdate).m_strName = results.getString(FIELD_NAME);
       ((Instrument)typeUpdate).m_strDescription = results.getString(FIELD_DESCRIPTION);
       ((Instrument)typeUpdate).m_typeManufacturer = InstrumentManufacturerAdapter.get(connDb, results.getInt(FIELD_MANUFACTURERID));

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
            FIELD_MANUFACTURERID
            + " FROM " +
            TABLE_NAME;
        if(nIdFor > 0)
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
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_MANUFACTURERID
            + " FROM " +
            TABLE_NAME  +
            " INNER JOIN " +
            "SurveyInstruments tableSurveyInstruments ON tableSurveyInstruments.InstrumentID == " + FIELD_ID +
            " WHERE tableSurveyInstruments.SurveyID = ?";
        return strSelect;
    } 
    private static String getSurveyInsertLinkQuery()
    {
        String strInsert = "INSERT OR IGNORE INTO SurveyInstruments(" +
            "SurveyID" + ",  " +
            "InstrumentID" + ",  " +
            "SurveyID"
            + ") VALUES (?,  ?,  ?)";
        return strInsert;
    } 
    private static String getSurveyDeleteLinkQuery()
    {
        String strDelete = "DELETE FROM  WHERE " +
            "SurveyID = ? && " +
            "InstrumentID = ?";
        return strDelete;
    } 
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_MANUFACTURERID
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
            FIELD_DESCRIPTION + ",  " +
            FIELD_MANUFACTURERID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_DESCRIPTION + " = ?,  " +
            FIELD_MANUFACTURERID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE Instrument " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name`  TEXT NOT NULL, " + 
        "`Description`   TEXT, " + 
        "`ManufacturerID` INTEGER, " + 
        "FOREIGN KEY (ManufacturerID) REFERENCES InstrumentManufacturer(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateInstrument after update on `Instrument` " + 
            "for each row " + 
            "begin " + 
            "update Instrument set updated = current_timestamp where ID == OLD.ID; " + 
            "end;",
            "CREATE TABLE `SurveyInstruments` " + 
            "( " + 
            "`SurveyID`  INTEGER NOT NULL, " + 
            "`InstrumentID`  INTEGER NOT NULL, " + 
            "FOREIGN KEY (InstrumentID) REFERENCES Instrument(ID), " + 
            "FOREIGN KEY (SurveyID) REFERENCES Survey(ID), " + 
            "UNIQUE(SurveyID, InstrumentID) " + 
            ");"
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
