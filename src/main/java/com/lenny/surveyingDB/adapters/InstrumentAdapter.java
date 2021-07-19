// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Jul 19 20:45:27 AEST 2021

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
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;
import com.lenny.surveyingDB.adapters.InstrumentManufacturerAdapter;
import com.lenny.surveyingDB.interfaces.ISurvey;


public class InstrumentAdapter implements JsonDeserializer<IInstrument>
{
    private static final Logger LOGGER = LogManager.getLogger(InstrumentAdapter.class.getName());

    // Class implements IInstrument but only accessible through the InstrumentAdapter

    public static class Instrument extends UndoTarget implements IInstrument
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

        @SerializedName("ManufacturerID")
        private IInstrumentManufacturer m_typeManufacturer;

        Instrument()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_strName = "";
            m_strDescription = "";

            m_typeManufacturer = InstrumentManufacturerAdapter.createNewInstrumentManufacturer();

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        Instrument(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, String strName, String strDescription, IInstrumentManufacturer typeManufacturer)
        {
            super();
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
            strJson += "\"ManufacturerID\":" + ((ISerialiseState) m_typeManufacturer).toJson() + ",";
            strJson += "\"SaveState\":\"" + m_saveState + "\"";
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
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        IInstrumentManufacturer typeManufacturer
    )
    {
        return new Instrument(nID, dateCreated, dateUpdated, strName, strDescription, typeManufacturer);
    }

    public static IInstrument updateInstrument
    (
        IInstrument typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        String strName,
        String strDescription,
        IInstrumentManufacturer typeManufacturer
    )
    {
        Instrument updating = (Instrument) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_strName = strName;;
        updating.m_strDescription = strDescription;;
        updating.m_typeManufacturer = typeManufacturer;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as IInstrument
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(IInstrument.class, new InstrumentAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      IInstrument serialised = gsonInstance.fromJson(strJson, IInstrument.class);

    public IInstrument deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(IInstrumentManufacturer.class, new InstrumentManufacturerAdapter());

        Gson gsonInstance = gsonBuilder.create();
        InstrumentAdapter.Instrument typeInstrument = gsonInstance.fromJson(json, InstrumentAdapter.Instrument.class);
        return typeInstrument;
    }

    public static IInstrument get(Connection connDb, int nIdGet) throws SQLException
    {
        IInstrument typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting Instrument id = " + nIdGet + " from db");
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
                typeReturn = createInstrumentFromQueryResults(connDb, results);
                LOGGER.debug("Instrument data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No Instrument data for id = " + nIdGet + " from db");
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
    public static IInstrument getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last Instrument from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createInstrumentFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last Instrument data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last Instrument  from db", exc);
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
    public static IInstrument updateFromLast(Connection connDb, IInstrument typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating Instrument id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateInstrumentFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find Instrument id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of Instrument id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting Instrument id from db");
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
                LOGGER.debug("No last Instrument in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last Instrument id from db failed", exc);
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

    public static List<IInstrument> getAll(Connection connDb) throws SQLException
    {
        List<IInstrument> listReturn = new ArrayList<IInstrument>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all Instrument data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createInstrumentFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " Instrument data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all Instrument from db failed", exc);
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

    public static List<IInstrument> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<IInstrument> listReturn = new ArrayList<IInstrument>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("Survey"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createInstrumentFromQueryResults(connDb, results));
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
    public static IInstrument addForSurvey(Connection connDb, IInstrument typeAdd, ISurvey typeParent) throws SQLException
    {
        return InstrumentAdapter.addForSurvey(connDb, typeAdd, typeParent.getID());
    }

    public static IInstrument addForSurvey(Connection connDb, IInstrument typeAdd, int nID) throws SQLException
    {
        IInstrument typeReturn = typeAdd;
        if (((ISerialiseState) typeAdd).isNew())
        {
            typeReturn = add(connDb, typeAdd);
        }

        PreparedStatement stmtLink = null;
        try
        {
            stmtLink = connDb.prepareStatement(SQL_PROVIDER.insertFor("Survey"));
            stmtLink.setInt(1, nID);
            stmtLink.setInt(2, typeReturn.getID());
            stmtLink.executeUpdate();
        }
        catch (SQLException exc)
        {
            LOGGER.error("Unable to insert link table record", exc);
            typeReturn = null;
        }
        finally
        {
            if (stmtLink != null)
            {
                stmtLink.close();
            }
        }
        return typeReturn;
    } 
    public static IInstrument add(Connection connDb, IInstrument typeAdd) throws SQLException
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
        LOGGER.info("Adding Instrument data to db");
        LOGGER.debug("Adding Instrument data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        if (((UndoTarget) typeAdd.getManufacturer()).isNew())
        {
            typeAdd.setManufacturer(InstrumentManufacturerAdapter.add(connDb, typeAdd.getManufacturer()));
        }
        else if (((UndoTarget) typeAdd.getManufacturer()).isUpdated())
        {
            typeAdd.setManufacturer(InstrumentManufacturerAdapter.update(connDb, typeAdd.getManufacturer()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.parametersHandler().prepareInsert(stmtSelect, typeAdd);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added Instrument data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding Instrument to db failed", exc);
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
    public static IInstrument updateForSurvey(Connection connDb, IInstrument typeUpdate, ISurvey typeParent) throws SQLException
    {
        // A new object has to be added first, and any new links created
        addForSurvey(connDb, typeUpdate, typeParent);
        return update(connDb, typeUpdate);
    } 
    public static IInstrument update(Connection connDb, IInstrument typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating Instrument data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating Instrument, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating Instrument data - " + ((ISerialiseState) typeUpdate).toJson());
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(SQL_PROVIDER.updateScript());
                SQL_PROVIDER.parametersHandler().prepareUpdate(stmtSelect, typeUpdate);
                stmtSelect.executeUpdate();
                // This will cancel any pending undo items
                ((ISerialiseState) typeUpdate).setSaved();
                return updateFromDatabase(connDb, typeUpdate);
            }
            catch (SQLException exc)
            {
                // TODO: set up error handling
                LOGGER.error("Adding Instrument to db failed", exc);
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

    public static IInstrument updateFromDatabase(Connection connDb, IInstrument typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database Instrument, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateInstrumentFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database Instrument, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for Instrument, id = " + typeUpdate.getID() + " from db failed", exc);
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
    public static boolean remove(Connection connDb, IInstrument typeRemove) throws SQLException
    {
        LOGGER.info("Removing Instrument data in db");
        LOGGER.debug("Removing Instrument data - " + ((ISerialiseState) typeRemove).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.deleteByPrimaryKeyScript());
            SQL_PROVIDER.parametersHandler().prepareDelete(stmtSelect, typeRemove);
            if(stmtSelect.executeUpdate() == 1)
            {
                LOGGER.info("Removed Instrument data from db");
                LOGGER.debug("Removed " + ((ISerialiseState) typeRemove).toJson());
                return true;
            }
            else
            {
                LOGGER.info("Could not remove Instrument data from db");
                return false;
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Removing Instrument from db failed", exc);
        }
        finally
        {
            if (stmtSelect != null)
            {
                stmtSelect.close();
            }
        }
        return false;
    }


    private static IInstrument createInstrumentFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (IInstrument) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static IInstrument updateInstrumentFromQueryResults(Connection connDb, ResultSet results, IInstrument typeUpdate) throws SQLException
    {
        return (IInstrument) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
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
                FIELD_NAME + ",  " +
                FIELD_DESCRIPTION + ",  " +
                FIELD_MANUFACTURERID
                + " FROM " +
                TABLE_NAME  +
                " INNER JOIN " +
                "SurveyInstruments tableSurveyInstruments ON tableSurveyInstruments.InstrumentID = " + FIELD_ID +
                " WHERE tableSurveyInstruments.SurveyID = ?";
    } 
    private static String getSurveyInsertLinkQuery()
    {
        return "INSERT OR IGNORE INTO SurveyInstruments(" +
                "SurveyID" + ",  " +
                "InstrumentID"
                + ") VALUES (?,  ?)";
    } 
    private static String getSurveyDeleteLinkQuery()
    {
            return "DELETE FROM SurveyInstruments WHERE " +
                "SurveyID = ? && " +
                "InstrumentID = ?";
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
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
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
            return "instrument";
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
                       FIELD_MANUFACTURERID
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
            FIELD_MANUFACTURERID
            + " FROM " +
            TABLE_NAME + " WHERE " + PRIMARY_KEY + " = ?";
        }
        public String selectFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                case "survey":
                    return "SELECT " +
                            FIELD_ID + ",  " +
                            FIELD_CREATED + ",  " +
                            FIELD_UPDATED + ",  " +
                            FIELD_NAME + ",  " +
                            FIELD_DESCRIPTION + ",  " +
                            FIELD_MANUFACTURERID
                            + " FROM " +
                            TABLE_NAME  +
                            " INNER JOIN " +
                            "SurveyInstruments tableSurveyInstruments ON tableSurveyInstruments.InstrumentID = " + FIELD_ID +
                            " WHERE tableSurveyInstruments.SurveyID = ?"; 
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
                             FIELD_MANUFACTURERID
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
                        FIELD_MANUFACTURERID
                        + ") VALUES (?,  ?,  ?)";
        }
        @Override
        public String insertFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                case "survey":
                    return "INSERT OR IGNORE INTO SurveyInstruments(" +
                            "SurveyID" + ",  " +
                            "InstrumentID"
                            + ") VALUES (?,  ?)"; 
                default:
                    return "";
            }
        }
        @Override
        public String selectHistory()
        {
            return "";
        }
        @Override
        public String updateScript()
        {
            return "UPDATE " + TABLE_NAME + " SET " +
                               FIELD_NAME + " = ?,  " +
                               FIELD_DESCRIPTION + " = ?,  " +
                               FIELD_MANUFACTURERID + " = ?"
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
                case "survey":
                        return "DELETE FROM SurveyInstruments WHERE " +
                            "SurveyID = ? && " +
                            "InstrumentID = ?"; 
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
                LOGGER.debug("Creating Instrument in database");
                Statement stmtExecute = connDb.createStatement();
                stmtExecute.execute(createScript());
                LOGGER.debug("Instrument create script - " + createScript());

                for(String strStatement : TABLE_EXTRA_SCRIPTS)
                {
                    stmtExecute.execute(strStatement);
                }
                LOGGER.debug("Instrument extra script - " + triggerScript());

                if(!SQL_PROVIDER.staticInsertsScript().isEmpty())
                {
                    String[] listStatements = staticInsertsScript().split(";");
                    for(String strStatement : listStatements)
                    {
                        stmtExecute.execute(strStatement);
                    }
                    LOGGER.debug("Instrument extra script - " + staticInsertsScript());
                }
                return true;
            }
            catch(SQLException exc)
            {
                LOGGER.error("Error executing scripts", exc);
            }
            return false;
        }

        private SqlProvider.SqlResultHandler<IInstrument> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<IInstrument> resultsHandler()
        {
            if(m_resultsHandler == null)
            {
                m_resultsHandler = new SqlProvider.SqlResultHandler<IInstrument>()
                   {
                        @Override
                        public IInstrument fromResults(Connection connDb, ResultSet results)
                        {
                            try
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
                            catch(SQLException exc)
                            {
                                LOGGER.error("Error parsing result set", exc);
                            }
                            return null;
                        }
                        @Override
                        public IInstrument updateFromResults(IInstrument typeUpdate, Connection connDb, ResultSet results)
                        {
                            try
                            {
                                return updateInstrument
                                (
                                    typeUpdate,
                                    results.getInt(FIELD_ID),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                    results.getString(FIELD_NAME),
                                    results.getString(FIELD_DESCRIPTION),
                                    InstrumentManufacturerAdapter.get(connDb, results.getInt(FIELD_MANUFACTURERID))
                                );
                            }
                            catch(SQLException exc)
                            {
                                LOGGER.error("Error parsing result set", exc);
                            }
                            return null;
                        }
                   };
            }
            return m_resultsHandler;
        }
        private SqlProvider.SqlParameterHandler<IInstrument> m_parametersHandler;
        @Override
        public SqlProvider.SqlParameterHandler<IInstrument> parametersHandler()
        {
            if(m_parametersHandler == null)
            {
                m_parametersHandler = new SqlProvider.SqlParameterHandler<IInstrument>()
                {
                    @Override
                    public boolean prepareInsert(PreparedStatement stmtSelect, IInstrument typeInsert)
                    {
                        try
                        {
                            stmtSelect.setString(1, typeInsert.getName());
                            stmtSelect.setString(2, typeInsert.getDescription());
                            stmtSelect.setInt(3, typeInsert.getManufacturer().getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;
                    }
                    @Override
                    public boolean prepareInsertFor(PreparedStatement stmt, IInstrument type, String strContext)
                    {
                        return false;
                    }
                    @Override
                    public boolean prepareUpdate(PreparedStatement stmtSelect, IInstrument typeUpdate)
                    {
                        try
                        {
                            stmtSelect.setString(1, typeUpdate.getName());
                            stmtSelect.setString(2, typeUpdate.getDescription());
                            stmtSelect.setInt(3, typeUpdate.getManufacturer().getID());
                            stmtSelect.setInt(4, typeUpdate.getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;

                    }
                    @Override
                    public boolean prepareDelete(PreparedStatement stmtSelect, IInstrument typeDelete)
                    {
                        try
                        {
                            stmtSelect.setInt(1, typeDelete.getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;

                    }
                    @Override
                    public boolean prepareDeleteFor(PreparedStatement stmt, IInstrument type, String strContext)
                    {
                        return false;
                    }
                };
            }
            return m_parametersHandler;
        }

    };
    private static SqlProvider.SqlScriptProvider SQL_PROVIDER = SQL_PROVIDER_DEFAULT;

}
