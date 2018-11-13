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
import com.lenny.surveyingDB.interfaces.ISurveyPointType;


public class SurveyPointTypeAdapter implements JsonDeserializer<ISurveyPointType>
{

        // Class implements ISurveyPointType but only accessible through the SurveyPointTypeAdapter

        static class SurveyPointType extends UndoTarget implements ISurveyPointType
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
            @SerializedName("Name")
            private String m_strName;
            @SerializedName("Abbreviation")
            private String m_strAbbreviation;
            @SerializedName("UserDefined")
            private boolean m_bUserDefined;

            SurveyPointType()
            {
                m_nID = 0;
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_strName = "";
                m_strAbbreviation = "";
                m_bUserDefined = false;

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            SurveyPointType(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, String strName, String strAbbreviation, boolean bUserDefined)
            {
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
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String strName,
        String strAbbreviation,
        boolean bUserDefined
    )
    {
        return new SurveyPointType(nID, dateCreated, dateUpdated, strName, strAbbreviation, bUserDefined);
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyPointType
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyPointType.class, new SurveyPointTypeAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyPointType serialised = gsonInstance.fromJson(strJson, ISurveyPointType.class);

    public ISurveyPointType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
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
                typeReturn = createSurveyPointTypeFromQueryResults(connDb, results);
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
    public static ISurveyPointType getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyPointTypeFromQueryResults(connDb, results);
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
    public static ISurveyPointType updateFromLast(Connection connDb, ISurveyPointType typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyPointTypeFromQueryResults(connDb, results, typeUpdate);
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

    public static List<ISurveyPointType> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyPointType> listReturn = new ArrayList<ISurveyPointType>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyPointTypeFromQueryResults(connDb, results));
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
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setString(1, typeAdd.getName());
            stmtSelect.setString(2, typeAdd.getAbbreviation());
            stmtSelect.setInt(3, SQLiteConverter.convertBooleanToInteger(typeAdd.getUserDefined()));

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
    public static ISurveyPointType update(Connection connDb, ISurveyPointType typeUpdate) throws SQLException
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
                stmtSelect.setString(2, typeUpdate.getAbbreviation());
                stmtSelect.setInt(3, SQLiteConverter.convertBooleanToInteger(typeUpdate.getUserDefined()));
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

    public static ISurveyPointType updateFromDatabase(Connection connDb, ISurveyPointType typeUpdate) throws SQLException
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
                return updateSurveyPointTypeFromQueryResults(connDb, results, typeUpdate);
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


    private static ISurveyPointType createSurveyPointTypeFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createSurveyPointType
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getString(FIELD_NAME),
                       results.getString(FIELD_ABBREVIATION),
                       SQLiteConverter.convertIntegerToBoolean(results.getInt(FIELD_USERDEFINED))
                   );

    }
    private static ISurveyPointType updateSurveyPointTypeFromQueryResults(Connection connDb, ResultSet results, ISurveyPointType typeUpdate) throws SQLException
    {
       ((SurveyPointType)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((SurveyPointType)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((SurveyPointType)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((SurveyPointType)typeUpdate).m_strName = results.getString(FIELD_NAME);
       ((SurveyPointType)typeUpdate).m_strAbbreviation = results.getString(FIELD_ABBREVIATION);
       ((SurveyPointType)typeUpdate).m_bUserDefined = SQLiteConverter.convertIntegerToBoolean(results.getInt(FIELD_USERDEFINED));

       return typeUpdate;
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
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
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
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(CREATE_TABLE_SCRIPT);
        for(String strScript : TABLE_EXTRA_SCRIPTS)
        {
            stmtExecute.execute(strScript);
        }
    }
}
