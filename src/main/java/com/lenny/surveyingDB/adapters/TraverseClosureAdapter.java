// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Fri Jul 09 17:31:10 AEST 2021

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
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import java.util.Date;


public class TraverseClosureAdapter implements JsonDeserializer<ITraverseClosure>
{
    private static final Logger LOGGER = LogManager.getLogger(TraverseClosureAdapter.class.getName());

    // Class implements ITraverseClosure but only accessible through the TraverseClosureAdapter

    public static class TraverseClosure extends UndoTarget implements ITraverseClosure
    {
        @SerializedName("ID")
        private int m_nID;
        @SerializedName("created")
        private OffsetDateTime m_dateCreated;
        @SerializedName("updated")
        private OffsetDateTime m_dateUpdated;
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


        // This constructor is specically for json serialisation, not to be used...
        TraverseClosure()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_dMiscZ = 0.0;
            m_dMiscY = 0.0;
            m_dMiscX = 0.0;
            m_dBearingMisclose = 0.0;
            m_dTraverseLength = 0.0;
            m_bAdjusted = false;

            m_nTraverseID = 0;

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }

        TraverseClosure
        (
            int nTraverseID
        )
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_dMiscZ = 0.0;
            m_dMiscY = 0.0;
            m_dMiscX = 0.0;
            m_dBearingMisclose = 0.0;
            m_dTraverseLength = 0.0;
            m_bAdjusted = false;

            m_nTraverseID = nTraverseID;
            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        TraverseClosure(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, double dMiscZ, double dMiscY, double dMiscX, double dBearingMisclose, double dTraverseLength, boolean bAdjusted, int nTraverseID)
        {
            super();
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
        public OffsetDateTime getCreated()
        {
            return  m_dateCreated;
        }
        public OffsetDateTime getUpdated()
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

        public int getTraverseID()
        {
            return m_nTraverseID;
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

    public static ITraverseClosure createNewTraverseClosure
    (
        int nTraverseID
    )
    {
        return new TraverseClosure
        (
            nTraverseID
        );
    }
    public static ITraverseClosure createTraverseClosure
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
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

    public static ITraverseClosure updateTraverseClosure
    (
        ITraverseClosure typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        double dMiscZ,
        double dMiscY,
        double dMiscX,
        double dBearingMisclose,
        double dTraverseLength,
        boolean bAdjusted,
        int nTraverseID
    )
    {
        TraverseClosure updating = (TraverseClosure) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_dMiscZ = dMiscZ;;
        updating.m_dMiscY = dMiscY;;
        updating.m_dMiscX = dMiscX;;
        updating.m_dBearingMisclose = dBearingMisclose;;
        updating.m_dTraverseLength = dTraverseLength;;
        updating.m_bAdjusted = bAdjusted;;
        updating.m_nTraverseID = nTraverseID;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ITraverseClosure
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ITraverseClosure.class, new TraverseClosureAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ITraverseClosure serialised = gsonInstance.fromJson(strJson, ITraverseClosure.class);

    public ITraverseClosure deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        Gson gsonInstance = gsonBuilder.create();
        TraverseClosureAdapter.TraverseClosure typeTraverseClosure = gsonInstance.fromJson(json, TraverseClosureAdapter.TraverseClosure.class);
        if (typeTraverseClosure.m_nID > 0)
        {
            typeTraverseClosure.setSaved();
        }
        return typeTraverseClosure;
    }

    public static ITraverseClosure get(Connection connDb, int nIdGet) throws SQLException
    {
        ITraverseClosure typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting TraverseClosure id = " + nIdGet + " from db");
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
                typeReturn = createTraverseClosureFromQueryResults(connDb, results);
                LOGGER.debug("TraverseClosure data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No TraverseClosure data for id = " + nIdGet + " from db");
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
    public static ITraverseClosure getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last TraverseClosure from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createTraverseClosureFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last TraverseClosure data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last TraverseClosure  from db", exc);
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
    public static ITraverseClosure updateFromLast(Connection connDb, ITraverseClosure typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating TraverseClosure id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateTraverseClosureFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find TraverseClosure id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of TraverseClosure id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting TraverseClosure id from db");
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
                LOGGER.debug("No last TraverseClosure in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last TraverseClosure id from db failed", exc);
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

    public static List<ITraverseClosure> getAll(Connection connDb) throws SQLException
    {
        List<ITraverseClosure> listReturn = new ArrayList<ITraverseClosure>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all TraverseClosure data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createTraverseClosureFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " TraverseClosure data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all TraverseClosure from db failed", exc);
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

    public static List<ITraverseClosure> getAllForTraverseParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ITraverseClosure> listReturn = new ArrayList<ITraverseClosure>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("Traverse"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createTraverseClosureFromQueryResults(connDb, results));
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
    public static ITraverseClosure add(Connection connDb, ITraverseClosure typeAdd) throws SQLException
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
        LOGGER.info("Adding TraverseClosure data to db");
        LOGGER.debug("Adding TraverseClosure data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.parametersHandler().prepareInsert(stmtSelect, typeAdd);
            stmtSelect.executeUpdate();

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added TraverseClosure data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding TraverseClosure to db failed", exc);
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
    public static ITraverseClosure update(Connection connDb, ITraverseClosure typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating TraverseClosure data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating TraverseClosure, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating TraverseClosure data - " + ((ISerialiseState) typeUpdate).toJson());
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
                LOGGER.error("Adding TraverseClosure to db failed", exc);
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

    public static ITraverseClosure updateFromDatabase(Connection connDb, ITraverseClosure typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database TraverseClosure, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateTraverseClosureFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database TraverseClosure, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for TraverseClosure, id = " + typeUpdate.getID() + " from db failed", exc);
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
    public static boolean remove(Connection connDb, ITraverseClosure typeRemove) throws SQLException
    {
        LOGGER.info("Removing TraverseClosure data in db");
        LOGGER.debug("Removing TraverseClosure data - " + ((ISerialiseState) typeRemove).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.deleteByPrimaryKeyScript());
            SQL_PROVIDER.parametersHandler().prepareDelete(stmtSelect, typeRemove);
            if(stmtSelect.executeUpdate() == 1)
            {
                LOGGER.info("Removed TraverseClosure data from db");
                LOGGER.debug("Removed " + ((ISerialiseState) typeRemove).toJson());
                return true;
            }
            else
            {
                LOGGER.info("Could not remove TraverseClosure data from db");
                return false;
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Removing TraverseClosure from db failed", exc);
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


    private static ITraverseClosure createTraverseClosureFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ITraverseClosure) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ITraverseClosure updateTraverseClosureFromQueryResults(Connection connDb, ResultSet results, ITraverseClosure typeUpdate) throws SQLException
    {
        return (ITraverseClosure) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
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
        if (nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }
    private static String getSelectForTraverseQuery()
    {
        return "SELECT " +
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
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
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
            return "traverseclosure";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
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
        }
        @Override
        public String selectByPrimaryKeyScript()
        {
            return "SELECT " +
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
            TABLE_NAME + " WHERE " + PRIMARY_KEY + " = ?";
        }
        public String selectFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                case "traverse":
                    return "SELECT " +
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
                             FIELD_MISCZ + ",  " +
                             FIELD_MISCY + ",  " +
                             FIELD_MISCX + ",  " +
                             FIELD_BEARINGMISCLOSE + ",  " +
                             FIELD_TRAVERSELENGTH + ",  " +
                             FIELD_ADJUSTED + ",  " +
                             FIELD_TRAVERSEID
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
                        FIELD_MISCZ + ",  " +
                        FIELD_MISCY + ",  " +
                        FIELD_MISCX + ",  " +
                        FIELD_BEARINGMISCLOSE + ",  " +
                        FIELD_TRAVERSELENGTH + ",  " +
                        FIELD_ADJUSTED + ",  " +
                        FIELD_TRAVERSEID
                        + ") VALUES (?,  ?,  ?,  ?,  ?,  ?,  ?)";
        }
        @Override
        public String insertFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
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
                               FIELD_MISCZ + " = ?,  " +
                               FIELD_MISCY + " = ?,  " +
                               FIELD_MISCX + " = ?,  " +
                               FIELD_BEARINGMISCLOSE + " = ?,  " +
                               FIELD_TRAVERSELENGTH + " = ?,  " +
                               FIELD_ADJUSTED + " = ?,  " +
                               FIELD_TRAVERSEID + " = ?"
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
                LOGGER.debug("Creating TraverseClosure in database");
                Statement stmtExecute = connDb.createStatement();
                stmtExecute.execute(createScript());
                LOGGER.debug("TraverseClosure create script - " + createScript());

                for(String strStatement : TABLE_EXTRA_SCRIPTS)
                {
                    stmtExecute.execute(strStatement);
                }
                LOGGER.debug("TraverseClosure extra script - " + triggerScript());

                if(!SQL_PROVIDER.staticInsertsScript().isEmpty())
                {
                    String[] listStatements = staticInsertsScript().split(";");
                    for(String strStatement : listStatements)
                    {
                        stmtExecute.execute(strStatement);
                    }
                    LOGGER.debug("TraverseClosure extra script - " + staticInsertsScript());
                }
                return true;
            }
            catch(SQLException exc)
            {
                LOGGER.error("Error executing scripts", exc);
            }
            return false;
        }

        private SqlProvider.SqlResultHandler<ITraverseClosure> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ITraverseClosure> resultsHandler()
        {
            if(m_resultsHandler == null)
            {
                m_resultsHandler = new SqlProvider.SqlResultHandler<ITraverseClosure>()
                   {
                        @Override
                        public ITraverseClosure fromResults(Connection connDb, ResultSet results)
                        {
                            try
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
                            catch(SQLException exc)
                            {
                                LOGGER.error("Error parsing result set", exc);
                            }
                            return null;
                        }
                        @Override
                        public ITraverseClosure updateFromResults(ITraverseClosure typeUpdate, Connection connDb, ResultSet results)
                        {
                            try
                            {
                                return updateTraverseClosure
                                (
                                    typeUpdate,
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
        private SqlProvider.SqlParameterHandler<ITraverseClosure> m_parametersHandler;
        @Override
        public SqlProvider.SqlParameterHandler<ITraverseClosure> parametersHandler()
        {
            if(m_parametersHandler == null)
            {
                m_parametersHandler = new SqlProvider.SqlParameterHandler<ITraverseClosure>()
                {
                    @Override
                    public boolean prepareInsert(PreparedStatement stmtSelect, ITraverseClosure typeInsert)
                    {
                        try
                        {
                            stmtSelect.setDouble(1, typeInsert.getMiscZ());
                            stmtSelect.setDouble(2, typeInsert.getMiscY());
                            stmtSelect.setDouble(3, typeInsert.getMiscX());
                            stmtSelect.setDouble(4, typeInsert.getBearingMisclose());
                            stmtSelect.setDouble(5, typeInsert.getTraverseLength());
                            stmtSelect.setInt(6, SQLiteConverter.convertBooleanToInteger(typeInsert.getAdjusted()));
                            stmtSelect.setInt(7, ((TraverseClosureAdapter.TraverseClosure) typeInsert).getTraverseID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;
                    }
                    @Override
                    public boolean prepareInsertFor(PreparedStatement stmt, ITraverseClosure type, String strContext)
                    {
                        return false;
                    }
                    @Override
                    public boolean prepareUpdate(PreparedStatement stmtSelect, ITraverseClosure typeUpdate)
                    {
                        try
                        {
                            stmtSelect.setDouble(1, typeUpdate.getMiscZ());
                            stmtSelect.setDouble(2, typeUpdate.getMiscY());
                            stmtSelect.setDouble(3, typeUpdate.getMiscX());
                            stmtSelect.setDouble(4, typeUpdate.getBearingMisclose());
                            stmtSelect.setDouble(5, typeUpdate.getTraverseLength());
                            stmtSelect.setInt(6, SQLiteConverter.convertBooleanToInteger(typeUpdate.getAdjusted()));
                            stmtSelect.setInt(7, ((TraverseClosureAdapter.TraverseClosure) typeUpdate).getTraverseID());
                            stmtSelect.setInt(8, typeUpdate.getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;

                    }
                    @Override
                    public boolean prepareDelete(PreparedStatement stmtSelect, ITraverseClosure typeDelete)
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
                    public boolean prepareDeleteFor(PreparedStatement stmt, ITraverseClosure type, String strContext)
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
