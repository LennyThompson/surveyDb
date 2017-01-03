// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Tue Jan 03 14:03:01 AEST 2017

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
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;


public class SurveyAdjustmentAdapter implements JsonDeserializer<ISurveyAdjustment>
{

        // Class implements ISurveyAdjustment but only accessible through the SurveyAdjustmentAdapter

        static class SurveyAdjustment extends UndoTarget implements ISurveyAdjustment
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
            @SerializedName("DeltaX")
            private double m_dDeltaX;
            @SerializedName("DeltaY")
            private double m_dDeltaY;
            @SerializedName("DeltaZ")
            private double m_dDeltaZ;
            @SerializedName("BearingAdj")
            private double m_dBearingAdj;

            @SerializedName("MeasurementID")
            private ISurveyMeasurement m_typeMeasurement;

            SurveyAdjustment()
            {
                m_nID = 0;
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_dDeltaX = 0.0;
                m_dDeltaY = 0.0;
                m_dDeltaZ = 0.0;
                m_dBearingAdj = 0.0;

                m_typeMeasurement = SurveyMeasurementAdapter.createNewSurveyMeasurement();

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            SurveyAdjustment(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, double dDeltaX, double dDeltaY, double dDeltaZ, double dBearingAdj, ISurveyMeasurement typeMeasurement)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_dDeltaX = dDeltaX;
                m_dDeltaY = dDeltaY;
                m_dDeltaZ = dDeltaZ;
                m_dBearingAdj = dBearingAdj;
                m_typeMeasurement = typeMeasurement;
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
            public double getDeltaX()
            {
                return  m_dDeltaX;
            }
            public double getDeltaY()
            {
                return  m_dDeltaY;
            }
            public double getDeltaZ()
            {
                return  m_dDeltaZ;
            }
            public double getBearingAdj()
            {
                return  m_dBearingAdj;
            }

            public ISurveyMeasurement getMeasurement()
            {
                return  m_typeMeasurement;
            }

            public void setDeltaX(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member DeltaX = " + SurveyAdjustment.this.m_dDeltaX)
                    {
                        double m_undoDeltaX = SurveyAdjustment.this.m_dDeltaX;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyAdjustment.this.m_dDeltaX = m_undoDeltaX;
                                if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyAdjustment.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dDeltaX = dSet;
                setUpdated();
            }
            public void setDeltaY(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member DeltaY = " + SurveyAdjustment.this.m_dDeltaY)
                    {
                        double m_undoDeltaY = SurveyAdjustment.this.m_dDeltaY;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyAdjustment.this.m_dDeltaY = m_undoDeltaY;
                                if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyAdjustment.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dDeltaY = dSet;
                setUpdated();
            }
            public void setDeltaZ(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member DeltaZ = " + SurveyAdjustment.this.m_dDeltaZ)
                    {
                        double m_undoDeltaZ = SurveyAdjustment.this.m_dDeltaZ;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyAdjustment.this.m_dDeltaZ = m_undoDeltaZ;
                                if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyAdjustment.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dDeltaZ = dSet;
                setUpdated();
            }
            public void setBearingAdj(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member BearingAdj = " + SurveyAdjustment.this.m_dBearingAdj)
                    {
                        double m_undoBearingAdj = SurveyAdjustment.this.m_dBearingAdj;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyAdjustment.this.m_dBearingAdj = m_undoBearingAdj;
                                if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyAdjustment.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dBearingAdj = dSet;
                setUpdated();
            }

            public void setMeasurement(ISurveyMeasurement typeSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(SurveyAdjustment.this.m_saveState, "Undo set SurveyAdjustment member Measurement = " + SurveyAdjustment.this.m_typeMeasurement)
                    {
                        ISurveyMeasurement m_undoMeasurement = SurveyAdjustment.this.m_typeMeasurement;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyAdjustment.this.m_typeMeasurement = m_undoMeasurement;
                                if(SurveyAdjustment.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyAdjustment.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_typeMeasurement = typeSet;
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
                strJson += "\"DeltaX\":" + m_dDeltaX + ",";
                strJson += "\"DeltaY\":" + m_dDeltaY + ",";
                strJson += "\"DeltaZ\":" + m_dDeltaZ + ",";
                strJson += "\"BearingAdj\":" + m_dBearingAdj + ",";
                strJson += "\"MeasurementID\":" + ((ISerialiseState) m_typeMeasurement).toJson();
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "SurveyAdjustment";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_MEASUREMENTID = "MeasurementID";
    public static final String FIELD_DELTAX = "DeltaX";
    public static final String FIELD_DELTAY = "DeltaY";
    public static final String FIELD_DELTAZ = "DeltaZ";
    public static final String FIELD_BEARINGADJ = "BearingAdj";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyAdjustment createNewSurveyAdjustment()
    {
        return new SurveyAdjustment();
    }

    public static ISurveyAdjustment createSurveyAdjustment
    (
        int nID,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        double dDeltaX,
        double dDeltaY,
        double dDeltaZ,
        double dBearingAdj,
        ISurveyMeasurement typeMeasurement
    )
    {
        return new SurveyAdjustment(nID, dateCreated, dateUpdated, dDeltaX, dDeltaY, dDeltaZ, dBearingAdj, typeMeasurement);
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyAdjustment
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyAdjustment.class, new SurveyAdjustmentAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyAdjustment serialised = gsonInstance.fromJson(strJson, ISurveyAdjustment.class);

    public ISurveyAdjustment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter());

        Gson gsonInstance = gsonBuilder.create();
        return gsonInstance.fromJson(json, SurveyAdjustmentAdapter.SurveyAdjustment.class);
    }

    public static ISurveyAdjustment get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyAdjustment typeReturn = null;
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
                typeReturn = createSurveyAdjustmentFromQueryResults(connDb, results);
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
    public static ISurveyAdjustment getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return createSurveyAdjustmentFromQueryResults(connDb, results);
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
    public static ISurveyAdjustment updateFromLast(Connection connDb, ISurveyAdjustment typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return updateSurveyAdjustmentFromQueryResults(connDb, results, typeUpdate);
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

    public static List<ISurveyAdjustment> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyAdjustment> listReturn = new ArrayList<ISurveyAdjustment>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createSurveyAdjustmentFromQueryResults(connDb, results));
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

    public static ISurveyAdjustment add(Connection connDb, ISurveyAdjustment typeAdd) throws SQLException
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
        if(((UndoTarget) typeAdd.getMeasurement()).isNew())
        {
            typeAdd.setMeasurement(SurveyMeasurementAdapter.add(connDb, typeAdd.getMeasurement()));
        }
        else if(((UndoTarget) typeAdd.getMeasurement()).isUpdated())
        {
            typeAdd.setMeasurement(SurveyMeasurementAdapter.update(connDb, typeAdd.getMeasurement()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setDouble(1, typeAdd.getDeltaX());
            stmtSelect.setDouble(2, typeAdd.getDeltaY());
            stmtSelect.setDouble(3, typeAdd.getDeltaZ());
            stmtSelect.setDouble(4, typeAdd.getBearingAdj());
            stmtSelect.setInt(5, typeAdd.getMeasurement().getID());

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
    public static ISurveyAdjustment update(Connection connDb, ISurveyAdjustment typeUpdate) throws SQLException
    {
        if(((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if(((ISerialiseState) typeUpdate).isUpdated())
        {
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(getUpdateQuery());
                stmtSelect.setDouble(1, typeUpdate.getDeltaX());
                stmtSelect.setDouble(2, typeUpdate.getDeltaY());
                stmtSelect.setDouble(3, typeUpdate.getDeltaZ());
                stmtSelect.setDouble(4, typeUpdate.getBearingAdj());
                stmtSelect.setInt(5, typeUpdate.getMeasurement().getID());
                stmtSelect.setInt(6, typeUpdate.getID());

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
        return typeUpdate;
    }

    public static ISurveyAdjustment updateFromDatabase(Connection connDb, ISurveyAdjustment typeUpdate) throws SQLException
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
                return updateSurveyAdjustmentFromQueryResults(connDb, results, typeUpdate);
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

    private static ISurveyAdjustment createSurveyAdjustmentFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createSurveyAdjustment
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getDouble(FIELD_DELTAX),
                       results.getDouble(FIELD_DELTAY),
                       results.getDouble(FIELD_DELTAZ),
                       results.getDouble(FIELD_BEARINGADJ),
                       SurveyMeasurementAdapter.get(connDb, results.getInt(FIELD_MEASUREMENTID))
                   );

    }
    private static ISurveyAdjustment updateSurveyAdjustmentFromQueryResults(Connection connDb, ResultSet results, ISurveyAdjustment typeUpdate) throws SQLException
    {
       ((SurveyAdjustment)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((SurveyAdjustment)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((SurveyAdjustment)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((SurveyAdjustment)typeUpdate).m_dDeltaX = results.getDouble(FIELD_DELTAX);
       ((SurveyAdjustment)typeUpdate).m_dDeltaY = results.getDouble(FIELD_DELTAY);
       ((SurveyAdjustment)typeUpdate).m_dDeltaZ = results.getDouble(FIELD_DELTAZ);
       ((SurveyAdjustment)typeUpdate).m_dBearingAdj = results.getDouble(FIELD_BEARINGADJ);
       ((SurveyAdjustment)typeUpdate).m_typeMeasurement = SurveyMeasurementAdapter.get(connDb, results.getInt(FIELD_MEASUREMENTID));

       return typeUpdate;
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_DELTAX + ",  " +
            FIELD_DELTAY + ",  " +
            FIELD_DELTAZ + ",  " +
            FIELD_BEARINGADJ + ",  " +
            FIELD_MEASUREMENTID
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
            FIELD_DELTAX + ",  " +
            FIELD_DELTAY + ",  " +
            FIELD_DELTAZ + ",  " +
            FIELD_BEARINGADJ + ",  " +
            FIELD_MEASUREMENTID
            + ") VALUES (?,  ?,  ?,  ?,  ?)";
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
            FIELD_DELTAX + ",  " +
            FIELD_DELTAY + ",  " +
            FIELD_DELTAZ + ",  " +
            FIELD_BEARINGADJ + ",  " +
            FIELD_MEASUREMENTID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_DELTAX + " = ?,  " +
            FIELD_DELTAY + " = ?,  " +
            FIELD_DELTAZ + " = ?,  " +
            FIELD_BEARINGADJ + " = ?,  " +
            FIELD_MEASUREMENTID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyAdjustment` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`MeasurementID` INTEGER NOT NULL, " + 
        "`DeltaX`    REAL NOT NULL, " + 
        "`DeltaY`    REAL NOT NULL, " + 
        "`DeltaZ`    REAL NOT NULL, " + 
        "`BearingAdj`    REAL NOT NULL, " + 
        "FOREIGN KEY (MeasurementID) REFERENCES SurveyMeasurement(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateSurveyAdjustment after update on `SurveyAdjustment` " + 
            "for each row " + 
            "begin " + 
            "update SurveyAdjustment set updated = current_timestamp where ID == OLD.ID; " + 
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
