// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 01 14:21:46 AEST 2017

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
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import java.util.Date;


public class TraverseClosureAdapter implements JsonDeserializer<ITraverseClosure>
{

        // Class implements ITraverseClosure but only accessible through the TraverseClosureAdapter

        static class TraverseClosure extends UndoTarget implements ITraverseClosure
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
            @SerializedName("MiscZ")
            private double m_dMiscZ;
            @SerializedName("MiscY")
            private double m_dMiscY;
            @SerializedName("MiscX")
            private double m_dMiscX;
            @SerializedName("BearingMisclose")
            private double m_dBearingMisclose;
            @SerializedName("TraverseLength")
            private double m_dTraverseLength;
            @SerializedName("Adjusted")
            private boolean m_bAdjusted;

            @SerializedName("TraverseID")
            private int m_nTraverseID;


            TraverseClosure()
            {
                m_nID = 0;
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_dMiscZ = 0.0;
                m_dMiscY = 0.0;
                m_dMiscX = 0.0;
                m_dBearingMisclose = 0.0;
                m_dTraverseLength = 0.0;
                m_bAdjusted = false;

                m_nTraverseID = 0;

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            TraverseClosure(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, double dMiscZ, double dMiscY, double dMiscX, double dBearingMisclose, double dTraverseLength, boolean bAdjusted, int nTraverseID)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_dMiscZ = dMiscZ;
                m_dMiscY = dMiscY;
                m_dMiscX = dMiscX;
                m_dBearingMisclose = dBearingMisclose;
                m_dTraverseLength = dTraverseLength;
                m_bAdjusted = bAdjusted;
                m_nTraverseID = nTraverseID;
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
            public double getMiscZ()
            {
                return  m_dMiscZ;
            }
            public double getMiscY()
            {
                return  m_dMiscY;
            }
            public double getMiscX()
            {
                return  m_dMiscX;
            }
            public double getBearingMisclose()
            {
                return  m_dBearingMisclose;
            }
            public double getTraverseLength()
            {
                return  m_dTraverseLength;
            }
            public boolean getAdjusted()
            {
                return  m_bAdjusted;
            }

            public void setMiscZ(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(TraverseClosure.this.m_saveState, "Undo set TraverseClosure member MiscZ = " + TraverseClosure.this.m_dMiscZ)
                    {
                        double m_undoMiscZ = TraverseClosure.this.m_dMiscZ;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                TraverseClosure.this.m_dMiscZ = m_undoMiscZ;
                                if(TraverseClosure.this.m_saveState != m_dataSaveState)
                                {
                                    TraverseClosure.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dMiscZ = dSet;
                setUpdated();
            }
            public void setMiscY(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(TraverseClosure.this.m_saveState, "Undo set TraverseClosure member MiscY = " + TraverseClosure.this.m_dMiscY)
                    {
                        double m_undoMiscY = TraverseClosure.this.m_dMiscY;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                TraverseClosure.this.m_dMiscY = m_undoMiscY;
                                if(TraverseClosure.this.m_saveState != m_dataSaveState)
                                {
                                    TraverseClosure.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dMiscY = dSet;
                setUpdated();
            }
            public void setMiscX(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(TraverseClosure.this.m_saveState, "Undo set TraverseClosure member MiscX = " + TraverseClosure.this.m_dMiscX)
                    {
                        double m_undoMiscX = TraverseClosure.this.m_dMiscX;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                TraverseClosure.this.m_dMiscX = m_undoMiscX;
                                if(TraverseClosure.this.m_saveState != m_dataSaveState)
                                {
                                    TraverseClosure.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dMiscX = dSet;
                setUpdated();
            }
            public void setBearingMisclose(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(TraverseClosure.this.m_saveState, "Undo set TraverseClosure member BearingMisclose = " + TraverseClosure.this.m_dBearingMisclose)
                    {
                        double m_undoBearingMisclose = TraverseClosure.this.m_dBearingMisclose;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                TraverseClosure.this.m_dBearingMisclose = m_undoBearingMisclose;
                                if(TraverseClosure.this.m_saveState != m_dataSaveState)
                                {
                                    TraverseClosure.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dBearingMisclose = dSet;
                setUpdated();
            }
            public void setTraverseLength(double dSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(TraverseClosure.this.m_saveState, "Undo set TraverseClosure member TraverseLength = " + TraverseClosure.this.m_dTraverseLength)
                    {
                        double m_undoTraverseLength = TraverseClosure.this.m_dTraverseLength;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                TraverseClosure.this.m_dTraverseLength = m_undoTraverseLength;
                                if(TraverseClosure.this.m_saveState != m_dataSaveState)
                                {
                                    TraverseClosure.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_dTraverseLength = dSet;
                setUpdated();
            }
            public void setAdjusted(boolean bSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(TraverseClosure.this.m_saveState, "Undo set TraverseClosure member Adjusted = " + TraverseClosure.this.m_bAdjusted)
                    {
                        boolean m_undoAdjusted = TraverseClosure.this.m_bAdjusted;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                TraverseClosure.this.m_bAdjusted = m_undoAdjusted;
                                if(TraverseClosure.this.m_saveState != m_dataSaveState)
                                {
                                    TraverseClosure.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_bAdjusted = bSet;
                setUpdated();
            }

            void setTraverseID(int nTraverseID)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(TraverseClosure.this.m_saveState, "Undo set TraverseClosure member TraverseID = " + TraverseClosure.this.m_nTraverseID)
                    {
                        int m_undoTraverseID = TraverseClosure.this.m_nTraverseID;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                TraverseClosure.this.m_nTraverseID = m_undoTraverseID;
                                if(TraverseClosure.this.m_saveState != m_dataSaveState)
                                {
                                    TraverseClosure.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_nTraverseID = nTraverseID;
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
                strJson += "\"MiscZ\":" + m_dMiscZ + ",";
                strJson += "\"MiscY\":" + m_dMiscY + ",";
                strJson += "\"MiscX\":" + m_dMiscX + ",";
                strJson += "\"BearingMisclose\":" + m_dBearingMisclose + ",";
                strJson += "\"TraverseLength\":" + m_dTraverseLength + ",";
                strJson += "\"Adjusted\":" + m_bAdjusted + ",";
                strJson += "\"TraverseID\":" + m_nTraverseID;
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "TraverseClosure";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_MISCZ = "MiscZ";
    public static final String FIELD_MISCY = "MiscY";
    public static final String FIELD_MISCX = "MiscX";
    public static final String FIELD_BEARINGMISCLOSE = "BearingMisclose";
    public static final String FIELD_TRAVERSELENGTH = "TraverseLength";
    public static final String FIELD_ADJUSTED = "Adjusted";
    public static final String FIELD_TRAVERSEID = "TraverseID";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ITraverseClosure createNewTraverseClosure()
    {
        return new TraverseClosure();
    }

    public static ITraverseClosure createTraverseClosure
    (
        int nID,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        double dMiscZ,
        double dMiscY,
        double dMiscX,
        double dBearingMisclose,
        double dTraverseLength,
        boolean bAdjusted,
        int nTraverseID
    )
    {
        return new TraverseClosure(nID, dateCreated, dateUpdated, dMiscZ, dMiscY, dMiscX, dBearingMisclose, dTraverseLength, bAdjusted, nTraverseID);
    }

    // This method enables the adapter type to be registered to deserialise json as ITraverseClosure
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ITraverseClosure.class, new TraverseClosureAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ITraverseClosure serialised = gsonInstance.fromJson(strJson, ITraverseClosure.class);

    public ITraverseClosure deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        return gsonInstance.fromJson(json, TraverseClosureAdapter.TraverseClosure.class);
    }

    public static ITraverseClosure get(Connection connDb, int nIdGet) throws SQLException
    {
        ITraverseClosure typeReturn = null;
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
                typeReturn = createTraverseClosureFromQueryResults(connDb, results);
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
    public static ITraverseClosure getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return createTraverseClosureFromQueryResults(connDb, results);
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
    public static ITraverseClosure updateFromLast(Connection connDb, ITraverseClosure typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if(results.next())
            {
                return updateTraverseClosureFromQueryResults(connDb, results, typeUpdate);
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

    public static List<ITraverseClosure> getAll(Connection connDb) throws SQLException
    {
        List<ITraverseClosure> listReturn = new ArrayList<ITraverseClosure>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createTraverseClosureFromQueryResults(connDb, results));
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

    public static List<ITraverseClosure> getAllForTraverseParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ITraverseClosure> listReturn = new ArrayList<ITraverseClosure>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectForTraverseQuery());
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listReturn.add(createTraverseClosureFromQueryResults(connDb, results));
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
    public static ITraverseClosure add(Connection connDb, ITraverseClosure typeAdd) throws SQLException
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
            stmtSelect.setDouble(1, typeAdd.getMiscZ());
            stmtSelect.setDouble(2, typeAdd.getMiscY());
            stmtSelect.setDouble(3, typeAdd.getMiscX());
            stmtSelect.setDouble(4, typeAdd.getBearingMisclose());
            stmtSelect.setDouble(5, typeAdd.getTraverseLength());
            stmtSelect.setInt(6, SQLiteConverter.convertBooleanToInteger(typeAdd.getAdjusted()));
            stmtSelect.setInt(7, ((TraverseClosure) typeAdd).m_nTraverseID);

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
    public static ITraverseClosure update(Connection connDb, ITraverseClosure typeUpdate) throws SQLException
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
                stmtSelect.setDouble(1, typeUpdate.getMiscZ());
                stmtSelect.setDouble(2, typeUpdate.getMiscY());
                stmtSelect.setDouble(3, typeUpdate.getMiscX());
                stmtSelect.setDouble(4, typeUpdate.getBearingMisclose());
                stmtSelect.setDouble(5, typeUpdate.getTraverseLength());
                stmtSelect.setInt(6, SQLiteConverter.convertBooleanToInteger(typeUpdate.getAdjusted()));
                stmtSelect.setInt(7, ((TraverseClosure) typeUpdate).m_nTraverseID);
                stmtSelect.setInt(8, typeUpdate.getID());

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

    public static ITraverseClosure updateFromDatabase(Connection connDb, ITraverseClosure typeUpdate) throws SQLException
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
                return updateTraverseClosureFromQueryResults(connDb, results, typeUpdate);
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

    private static ITraverseClosure createTraverseClosureFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createTraverseClosure
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getDouble(FIELD_MISCZ),
                       results.getDouble(FIELD_MISCY),
                       results.getDouble(FIELD_MISCX),
                       results.getDouble(FIELD_BEARINGMISCLOSE),
                       results.getDouble(FIELD_TRAVERSELENGTH),
                       SQLiteConverter.convertIntegerToBoolean(results.getInt(FIELD_ADJUSTED)),
                       results.getInt(FIELD_TRAVERSEID)
                   );

    }
    private static ITraverseClosure updateTraverseClosureFromQueryResults(Connection connDb, ResultSet results, ITraverseClosure typeUpdate) throws SQLException
    {
       ((TraverseClosure)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((TraverseClosure)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((TraverseClosure)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((TraverseClosure)typeUpdate).m_dMiscZ = results.getDouble(FIELD_MISCZ);
       ((TraverseClosure)typeUpdate).m_dMiscY = results.getDouble(FIELD_MISCY);
       ((TraverseClosure)typeUpdate).m_dMiscX = results.getDouble(FIELD_MISCX);
       ((TraverseClosure)typeUpdate).m_dBearingMisclose = results.getDouble(FIELD_BEARINGMISCLOSE);
       ((TraverseClosure)typeUpdate).m_dTraverseLength = results.getDouble(FIELD_TRAVERSELENGTH);
       ((TraverseClosure)typeUpdate).m_bAdjusted = SQLiteConverter.convertIntegerToBoolean(results.getInt(FIELD_ADJUSTED));
       ((TraverseClosure)typeUpdate).m_nTraverseID = results.getInt(FIELD_TRAVERSEID);

       return typeUpdate;
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_MISCZ + ",  " +
            FIELD_MISCY + ",  " +
            FIELD_MISCX + ",  " +
            FIELD_BEARINGMISCLOSE + ",  " +
            FIELD_TRAVERSELENGTH + ",  " +
            FIELD_ADJUSTED + ",  " +
            FIELD_TRAVERSEID
            + " FROM " +
            TABLE_NAME;
        if(nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }
    private static String getSelectForTraverseQuery()
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_MISCZ + ",  " +
            FIELD_MISCY + ",  " +
            FIELD_MISCX + ",  " +
            FIELD_BEARINGMISCLOSE + ",  " +
            FIELD_TRAVERSELENGTH + ",  " +
            FIELD_ADJUSTED + ",  " +
            FIELD_TRAVERSEID
            + " FROM " +
            TABLE_NAME  +
            " WHERE " +
            FIELD_TRAVERSEID + " = ?";
        return strSelect;
    }
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_MISCZ + ",  " +
            FIELD_MISCY + ",  " +
            FIELD_MISCX + ",  " +
            FIELD_BEARINGMISCLOSE + ",  " +
            FIELD_TRAVERSELENGTH + ",  " +
            FIELD_ADJUSTED + ",  " +
            FIELD_TRAVERSEID
            + ") VALUES (?,  ?,  ?,  ?,  ?,  ?,  ?)";
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
            FIELD_MISCZ + ",  " +
            FIELD_MISCY + ",  " +
            FIELD_MISCX + ",  " +
            FIELD_BEARINGMISCLOSE + ",  " +
            FIELD_TRAVERSELENGTH + ",  " +
            FIELD_ADJUSTED + ",  " +
            FIELD_TRAVERSEID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_MISCZ + " = ?,  " +
            FIELD_MISCY + " = ?,  " +
            FIELD_MISCX + " = ?,  " +
            FIELD_BEARINGMISCLOSE + " = ?,  " +
            FIELD_TRAVERSELENGTH + " = ?,  " +
            FIELD_ADJUSTED + " = ?,  " +
            FIELD_TRAVERSEID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `TraverseClosure` " + 
        "( " + 
        "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`TraverseID`    INTEGER NOT NULL, " + 
        "`MiscZ` REAL, " + 
        "`MiscY` REAL, " + 
        "`MiscX` REAL, " + 
        "`BearingMisclose`   REAL, " + 
        "`TraverseLength`    REAL, " + 
        "`Adjusted`  BOOLEAN, " + 
        "FOREIGN KEY (TraverseID) REFERENCES Traverse(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateTraverseClosure after update on `TraverseClosure` " + 
            "for each row " + 
            "begin " + 
            "update TraverseClosure set updated = current_timestamp where ID == OLD.ID; " + 
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
