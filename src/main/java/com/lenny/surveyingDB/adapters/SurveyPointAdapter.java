// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Fri Jul 09 17:31:11 AEST 2021

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
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.interfaces.ISurveyPointType;
import com.lenny.surveyingDB.interfaces.ISurveyReference;
import com.lenny.surveyingDB.adapters.SurveyPointTypeAdapter;
import com.lenny.surveyingDB.adapters.SurveyReferenceAdapter;
import com.lenny.surveyingDB.adapters.SurveyImageAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ISurvey;


public class SurveyPointAdapter implements JsonDeserializer<ISurveyPoint>
{
    private static final Logger LOGGER = LogManager.getLogger(SurveyPointAdapter.class.getName());

    // Class implements ISurveyPoint but only accessible through the SurveyPointAdapter

    public static class SurveyPoint extends UndoTarget implements ISurveyPoint
    {
        @SerializedName("ID")
        private int m_nID;
        @SerializedName("created")
        private OffsetDateTime m_dateCreated;
        @SerializedName("updated")
        private OffsetDateTime m_dateUpdated;
        @SerializedName("X")
        private double m_dX;
        @SerializedName("Y")
        private double m_dY;
        @SerializedName("Z")
        private double m_dZ;
        @SerializedName("Name")
        private String m_strName;
        @SerializedName("Description")
        private String m_strDescription;

        @SerializedName("PointTypeID")
        private ISurveyPointType m_typePointType;
        @SerializedName("RefID")
        private ISurveyReference m_typeReference;

        @SerializedName("Images")
        private List<ISurveyImage> m_listSurveyImage;

        SurveyPoint()
        {
            super();
            m_nID = 0;
            m_dateCreated = OffsetDateTime.now();
            m_dateUpdated = OffsetDateTime.now();
            m_dX = 0.0;
            m_dY = 0.0;
            m_dZ = 0.0;
            m_strName = "";
            m_strDescription = "";

            m_typePointType = SurveyPointTypeAdapter.createNewSurveyPointType();
            m_typeReference = SurveyReferenceAdapter.createNewSurveyReference();

            m_listSurveyImage = new ArrayList<>();

            m_saveState = DataSaveState.SAVE_STATE_NEW;
        }
        SurveyPoint(int nID, OffsetDateTime dateCreated, OffsetDateTime dateUpdated, double dX, double dY, double dZ, String strName, String strDescription, ISurveyPointType typePointType, ISurveyReference typeReference, List<ISurveyImage> listSurveyImage)
        {
            super();
            m_nID = nID;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_dX = dX;
            m_dY = dY;
            m_dZ = dZ;
            m_strName = strName;
            m_strDescription = strDescription;
            m_typePointType = typePointType;
            m_typeReference = typeReference;
            m_listSurveyImage = listSurveyImage;
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
        public double getX()
        {
            return  m_dX;
        }
        public double getY()
        {
            return  m_dY;
        }
        public double getZ()
        {
            return  m_dZ;
        }
        public String getName()
        {
            return  m_strName;
        }
        public String getDescription()
        {
            return  m_strDescription;
        }

        public ISurveyPointType getPointType()
        {
            return  m_typePointType;
        }
        public ISurveyReference getReference()
        {
            return  m_typeReference;
        }

        public List<ISurveyImage> getSurveyImages()
        {
            return  m_listSurveyImage;
        }

        public void setX(double dSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member X = " + SurveyPoint.this.m_dX)
                {
                    double m_undoX = SurveyPoint.this.m_dX;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPoint.this.m_dX = m_undoX;
                            if(SurveyPoint.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPoint.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dX = dSet;
            setUpdated();
        }
        public void setY(double dSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member Y = " + SurveyPoint.this.m_dY)
                {
                    double m_undoY = SurveyPoint.this.m_dY;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPoint.this.m_dY = m_undoY;
                            if(SurveyPoint.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPoint.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dY = dSet;
            setUpdated();
        }
        public void setZ(double dSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member Z = " + SurveyPoint.this.m_dZ)
                {
                    double m_undoZ = SurveyPoint.this.m_dZ;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPoint.this.m_dZ = m_undoZ;
                            if(SurveyPoint.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPoint.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_dZ = dSet;
            setUpdated();
        }
        public void setName(String strSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member Name = " + SurveyPoint.this.m_strName)
                {
                    String m_undoName = SurveyPoint.this.m_strName;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPoint.this.m_strName = m_undoName;
                            if(SurveyPoint.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPoint.this.m_saveState = m_dataSaveState;
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
                new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member Description = " + SurveyPoint.this.m_strDescription)
                {
                    String m_undoDescription = SurveyPoint.this.m_strDescription;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPoint.this.m_strDescription = m_undoDescription;
                            if(SurveyPoint.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPoint.this.m_saveState = m_dataSaveState;
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

        public void setPointType(ISurveyPointType typeSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member PointType = " + SurveyPoint.this.m_typePointType)
                {
                    ISurveyPointType m_undoPointType = SurveyPoint.this.m_typePointType;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPoint.this.m_typePointType = m_undoPointType;
                            if(SurveyPoint.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPoint.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_typePointType = typeSet;
            setUpdated();
        }
        public void setReference(ISurveyReference typeSet)
        {
            addUndoProvider
            (
                new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member Reference = " + SurveyPoint.this.m_typeReference)
                {
                    ISurveyReference m_undoReference = SurveyPoint.this.m_typeReference;
                    public boolean doUndo()
                    {
                        if(isPending())
                        {
                            SurveyPoint.this.m_typeReference = m_undoReference;
                            if(SurveyPoint.this.m_saveState != m_dataSaveState)
                            {
                                SurveyPoint.this.m_saveState = m_dataSaveState;
                            }
                            m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                            return true;
                        }
                        return false;
                    }
                }
            );
            m_typeReference = typeSet;
            setUpdated();
        }

        public void addSurveyImage(ISurveyImage typeAdd)
        {
            addUndoProvider
                (
                    new UndoProviderImpl(SurveyPoint.this.m_saveState, "Undo set SurveyPoint member SurveyImage = " + SurveyPoint.this.m_listSurveyImage)
                    {
                        ISurveyImage m_undoSurveyImage = typeAdd;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                SurveyPoint.this.m_listSurveyImage.remove(m_undoSurveyImage);
                                if(SurveyPoint.this.m_saveState != m_dataSaveState)
                                {
                                    SurveyPoint.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );

            m_listSurveyImage.add(typeAdd);
            ((SurveyImageAdapter.SurveyImage) typeAdd).setPointAtID(getID());
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
            strJson += "\"X\":" + m_dX + ",";
            strJson += "\"Y\":" + m_dY + ",";
            strJson += "\"Z\":" + m_dZ + ",";
            strJson += "\"Name\":" + "\"" + m_strName + "\"" + ",";
            strJson += "\"Description\":" + "\"" + m_strDescription + "\"" + ",";
            strJson += "\"PointTypeID\":" + ((ISerialiseState) m_typePointType).toJson() + ",";
            strJson += "\"RefID\":" + ((ISerialiseState) m_typeReference).toJson() + ",";
            strJson += "\"Images\":[" + m_listSurveyImage.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]";
            strJson += "}";
            return strJson;
        }
    }
    public static final String TABLE_NAME = "SurveyPoint";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_X = "X";
    public static final String FIELD_Y = "Y";
    public static final String FIELD_Z = "Z";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_DESCRIPTION = "Description";
    public static final String FIELD_POINTTYPEID = "PointTypeID";
    public static final String FIELD_REFID = "RefID";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyPoint createNewSurveyPoint()
    {
        return new SurveyPoint();
    }

    public static ISurveyPoint createSurveyPoint
    (
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        double dX,
        double dY,
        double dZ,
        String strName,
        String strDescription,
        ISurveyPointType typePointType,
        ISurveyReference typeReference,
        List<ISurveyImage> listSurveyImage
    )
    {
        return new SurveyPoint(nID, dateCreated, dateUpdated, dX, dY, dZ, strName, strDescription, typePointType, typeReference, listSurveyImage);
    }

    public static ISurveyPoint updateSurveyPoint
    (
        ISurveyPoint typeUpdate,
        int nID,
        OffsetDateTime dateCreated,
        OffsetDateTime dateUpdated,
        double dX,
        double dY,
        double dZ,
        String strName,
        String strDescription,
        ISurveyPointType typePointType,
        ISurveyReference typeReference,
        List<ISurveyImage> listSurveyImage
    )
    {
        SurveyPoint updating = (SurveyPoint) typeUpdate;
        updating.m_nID = nID;;
        updating.m_dateCreated = dateCreated;;
        updating.m_dateUpdated = dateUpdated;;
        updating.m_dX = dX;;
        updating.m_dY = dY;;
        updating.m_dZ = dZ;;
        updating.m_strName = strName;;
        updating.m_strDescription = strDescription;;
        updating.m_typePointType = typePointType;;
        updating.m_typeReference = typeReference;;
        updating.m_listSurveyImage = listSurveyImage;;
        return updating;
    }

    // This method enables the adapter type to be registered to deserialise json as ISurveyPoint
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurveyPoint serialised = gsonInstance.fromJson(strJson, ISurveyPoint.class);

    public ISurveyPoint deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(ISurveyPointType.class, new SurveyPointTypeAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyReference.class, new SurveyReferenceAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyImage.class, new SurveyImageAdapter());

        Gson gsonInstance = gsonBuilder.create();
        SurveyPointAdapter.SurveyPoint typeSurveyPoint = gsonInstance.fromJson(json, SurveyPointAdapter.SurveyPoint.class);
        if (typeSurveyPoint.m_nID > 0)
        {
            typeSurveyPoint.setSaved();
        }
        return typeSurveyPoint;
    }

    public static ISurveyPoint get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyPoint typeReturn = null;
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting SurveyPoint id = " + nIdGet + " from db");
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
                typeReturn = createSurveyPointFromQueryResults(connDb, results);
                LOGGER.debug("SurveyPoint data for id = " + nIdGet + " - " + ((ISerialiseState) typeReturn).toJson());
            }
            else
            {
                LOGGER.debug("No SurveyPoint data for id = " + nIdGet + " from db");
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
    public static ISurveyPoint getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting last SurveyPoint from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyPointFromQueryResults(connDb, results);
            }
            else
            {
                LOGGER.debug("No last SurveyPoint data from db");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Error reading last SurveyPoint  from db", exc);
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
    public static ISurveyPoint updateFromLast(Connection connDb, ISurveyPoint typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating SurveyPoint id = " + typeUpdate.getID() + " in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectLast());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyPointFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Cannot find SurveyPoint id = " + typeUpdate.getID() + " in db for update");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Update of SurveyPoint id = " + typeUpdate.getID() + " to db failed", exc);
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
        LOGGER.info("Getting SurveyPoint id from db");
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
                LOGGER.debug("No last SurveyPoint in db failed");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting last SurveyPoint id from db failed", exc);
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

    public static List<ISurveyPoint> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyPoint> listReturn = new ArrayList<ISurveyPoint>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Getting all SurveyPoint data from db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectScript());
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyPointFromQueryResults(connDb, results));
            }
            LOGGER.info("Found " + listReturn.size() + " SurveyPoint data from db");
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Getting all SurveyPoint from db failed", exc);
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

    public static List<ISurveyPoint> getAllForSurveyParent(Connection connDb, int nParentId) throws SQLException
    {
        List<ISurveyPoint> listReturn = new ArrayList<ISurveyPoint>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectFor("Survey"));
            stmtSelect.setInt(1, nParentId);
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyPointFromQueryResults(connDb, results));
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
    public static ISurveyPoint addForSurvey(Connection connDb, ISurveyPoint typeAdd, ISurvey typeParent) throws SQLException
    {
        return SurveyPointAdapter.addForSurvey(connDb, typeAdd, typeParent.getID());
    }

    public static ISurveyPoint addForSurvey(Connection connDb, ISurveyPoint typeAdd, int nID) throws SQLException
    {
        ISurveyPoint typeReturn = typeAdd;
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
    public static ISurveyPoint add(Connection connDb, ISurveyPoint typeAdd) throws SQLException
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
        LOGGER.info("Adding SurveyPoint data to db");
        LOGGER.debug("Adding SurveyPoint data - " + ((ISerialiseState) typeAdd).toJson());
        PreparedStatement stmtSelect = null;
        if (((UndoTarget) typeAdd.getPointType()).isNew())
        {
            typeAdd.setPointType(SurveyPointTypeAdapter.add(connDb, typeAdd.getPointType()));
        }
        else if (((UndoTarget) typeAdd.getPointType()).isUpdated())
        {
            typeAdd.setPointType(SurveyPointTypeAdapter.update(connDb, typeAdd.getPointType()));
        }
        if (((UndoTarget) typeAdd.getReference()).isNew())
        {
            typeAdd.setReference(SurveyReferenceAdapter.add(connDb, typeAdd.getReference()));
        }
        else if (((UndoTarget) typeAdd.getReference()).isUpdated())
        {
            typeAdd.setReference(SurveyReferenceAdapter.update(connDb, typeAdd.getReference()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.insertScript());
            SQL_PROVIDER.parametersHandler().prepareInsert(stmtSelect, typeAdd);
            stmtSelect.executeUpdate();

            ((SurveyPoint) typeAdd).m_nID = getLastId(connDb);

            ((SurveyPoint) typeAdd).m_listSurveyImage = typeAdd.getSurveyImages().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return SurveyImageAdapter.add(connDb, item);
                        }
                        catch (SQLException exc)
                        {
                            LOGGER.error("Error updating external references", exc);
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());

            // This will cancel any pending undo items
            ((ISerialiseState) typeAdd).setSaved();
            LOGGER.info("Added SurveyPoint data to db");
            return updateFromLast(connDb, typeAdd);
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Adding SurveyPoint to db failed", exc);
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
    public static ISurveyPoint updateForSurvey(Connection connDb, ISurveyPoint typeUpdate, ISurvey typeParent) throws SQLException
    {
        // A new object has to be added first, and any new links created
        addForSurvey(connDb, typeUpdate, typeParent);
        return update(connDb, typeUpdate);
    } 
    public static ISurveyPoint update(Connection connDb, ISurveyPoint typeUpdate) throws SQLException
    {
        LOGGER.debug("Updating SurveyPoint data in db");
        if (((ISerialiseState) typeUpdate).isNew())
        {
            // A new object has to be added first
            return add(connDb, typeUpdate);
        }
        else if (((ISerialiseState) typeUpdate).isUpdated())
        {
            LOGGER.info("Updating SurveyPoint, id = " + typeUpdate.getID() + " data in db");
            LOGGER.debug("Updating SurveyPoint data - " + ((ISerialiseState) typeUpdate).toJson());
            PreparedStatement stmtSelect = null;
            try
            {
                stmtSelect = connDb.prepareStatement(SQL_PROVIDER.updateScript());
                SQL_PROVIDER.parametersHandler().prepareUpdate(stmtSelect, typeUpdate);
                ((SurveyPoint) typeUpdate).m_listSurveyImage = typeUpdate.getSurveyImages().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return SurveyImageAdapter.update(connDb, item);
                            }
                            catch (SQLException exc)
                            {
                                LOGGER.error("Error updating external references", exc);
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());

                stmtSelect.executeUpdate();
                // This will cancel any pending undo items
                ((ISerialiseState) typeUpdate).setSaved();
                return updateFromDatabase(connDb, typeUpdate);
            }
            catch (SQLException exc)
            {
                // TODO: set up error handling
                LOGGER.error("Adding SurveyPoint to db failed", exc);
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

    public static ISurveyPoint updateFromDatabase(Connection connDb, ISurveyPoint typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        LOGGER.info("Updating from database SurveyPoint, id = " + typeUpdate.getID() + " data in db");
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.selectByPrimaryKeyScript());
            stmtSelect.setInt(1, typeUpdate.getID());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyPointFromQueryResults(connDb, results, typeUpdate);
            }
            else
            {
                LOGGER.debug("Updating from database SurveyPoint, id = " + typeUpdate.getID() + " returned no data");
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Updating from database for SurveyPoint, id = " + typeUpdate.getID() + " from db failed", exc);
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
    public static boolean remove(Connection connDb, ISurveyPoint typeRemove) throws SQLException
    {
        LOGGER.info("Removing SurveyPoint data in db");
        LOGGER.debug("Removing SurveyPoint data - " + ((ISerialiseState) typeRemove).toJson());
        PreparedStatement stmtSelect = null;
        try
        {
            stmtSelect = connDb.prepareStatement(SQL_PROVIDER.deleteByPrimaryKeyScript());
            SQL_PROVIDER.parametersHandler().prepareDelete(stmtSelect, typeRemove);
            if(stmtSelect.executeUpdate() == 1)
            {
                LOGGER.info("Removed SurveyPoint data from db");
                LOGGER.debug("Removed " + ((ISerialiseState) typeRemove).toJson());
                return true;
            }
            else
            {
                LOGGER.info("Could not remove SurveyPoint data from db");
                return false;
            }
        }
        catch (SQLException exc)
        {
            // TODO: set up error handling
            LOGGER.error("Removing SurveyPoint from db failed", exc);
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




    private static ISurveyPoint createSurveyPointFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return (ISurveyPoint) SQL_PROVIDER.resultsHandler().fromResults(connDb, results);
    }
    private static ISurveyPoint updateSurveyPointFromQueryResults(Connection connDb, ResultSet results, ISurveyPoint typeUpdate) throws SQLException
    {
        return (ISurveyPoint) SQL_PROVIDER.resultsHandler().updateFromResults(typeUpdate, connDb, results);
    }

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_X + ",  " +
            FIELD_Y + ",  " +
            FIELD_Z + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_POINTTYPEID + ",  " +
            FIELD_REFID
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
                FIELD_X + ",  " +
                FIELD_Y + ",  " +
                FIELD_Z + ",  " +
                FIELD_NAME + ",  " +
                FIELD_DESCRIPTION + ",  " +
                FIELD_POINTTYPEID + ",  " +
                FIELD_REFID
                + " FROM " +
                TABLE_NAME  +
                " INNER JOIN " +
                "SurveyPointLink tableSurveyPointLink ON tableSurveyPointLink.SurveyPointID = " + FIELD_ID +
                " WHERE tableSurveyPointLink.SurveyID = ?";
    } 
    private static String getSurveyInsertLinkQuery()
    {
        return "INSERT OR IGNORE INTO SurveyPointLink(" +
                "SurveyID" + ",  " +
                "SurveyPointID"
                + ") VALUES (?,  ?)";
    } 
    private static String getSurveyDeleteLinkQuery()
    {
            return "DELETE FROM SurveyPointLink WHERE " +
                "SurveyID = ? && " +
                "SurveyPointID = ?";
    } 
    private static String getInsertQuery()
    {
        String strInsert = "INSERT INTO " + TABLE_NAME + "(" +
            FIELD_X + ",  " +
            FIELD_Y + ",  " +
            FIELD_Z + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_POINTTYPEID + ",  " +
            FIELD_REFID
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
            FIELD_X + ",  " +
            FIELD_Y + ",  " +
            FIELD_Z + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_POINTTYPEID + ",  " +
            FIELD_REFID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_X + " = ?,  " +
            FIELD_Y + " = ?,  " +
            FIELD_Z + " = ?,  " +
            FIELD_NAME + " = ?,  " +
            FIELD_DESCRIPTION + " = ?,  " +
            FIELD_POINTTYPEID + " = ?,  " +
            FIELD_REFID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `SurveyPoint` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`X` REAL NOT NULL, " + 
        "`Y` REAL NOT NULL, " + 
        "`Z` REAL NOT NULL, " + 
        "`Name`  TEXT, " + 
        "`Description`   TEXT, " + 
        "`PointTypeID` INTEGER NOT NULL, " + 
        "`RefID` INTEGER, " + 
        "FOREIGN KEY (PointTypeID) REFERENCES SurveyPointType(ID), " + 
        "FOREIGN KEY (RefID) REFERENCES SurveyReference(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger UpdateSurveyPoint after update on `SurveyPoint` " + 
            "for each row " + 
            "begin " + 
            "update SurveyPoint set updated = current_timestamp where ID == OLD.ID; " + 
            "end;",
            "CREATE TABLE `SurveyPointLink` " + 
            "( " + 
            "`SurveyID`  INTEGER NOT NULL, " + 
            "`SurveyPointID` INTEGER NOT NULL, " + 
            "FOREIGN KEY (SurveyPointID) REFERENCES SurveyPoint(ID), " + 
            "FOREIGN KEY (SurveyID) REFERENCES Survey(ID), " + 
            "UNIQUE(SurveyPointID, SurveyID) " + 
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
            return "surveypoint";
        }
        @Override
        public String selectScript()
        {
            return "SELECT " +
                       FIELD_ID + ",  " +
                       FIELD_CREATED + ",  " +
                       FIELD_UPDATED + ",  " +
                       FIELD_X + ",  " +
                       FIELD_Y + ",  " +
                       FIELD_Z + ",  " +
                       FIELD_NAME + ",  " +
                       FIELD_DESCRIPTION + ",  " +
                       FIELD_POINTTYPEID + ",  " +
                       FIELD_REFID
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
            FIELD_X + ",  " +
            FIELD_Y + ",  " +
            FIELD_Z + ",  " +
            FIELD_NAME + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_POINTTYPEID + ",  " +
            FIELD_REFID
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
                            FIELD_X + ",  " +
                            FIELD_Y + ",  " +
                            FIELD_Z + ",  " +
                            FIELD_NAME + ",  " +
                            FIELD_DESCRIPTION + ",  " +
                            FIELD_POINTTYPEID + ",  " +
                            FIELD_REFID
                            + " FROM " +
                            TABLE_NAME  +
                            " INNER JOIN " +
                            "SurveyPointLink tableSurveyPointLink ON tableSurveyPointLink.SurveyPointID = " + FIELD_ID +
                            " WHERE tableSurveyPointLink.SurveyID = ?"; 
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
                             FIELD_X + ",  " +
                             FIELD_Y + ",  " +
                             FIELD_Z + ",  " +
                             FIELD_NAME + ",  " +
                             FIELD_DESCRIPTION + ",  " +
                             FIELD_POINTTYPEID + ",  " +
                             FIELD_REFID
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
                        FIELD_X + ",  " +
                        FIELD_Y + ",  " +
                        FIELD_Z + ",  " +
                        FIELD_NAME + ",  " +
                        FIELD_DESCRIPTION + ",  " +
                        FIELD_POINTTYPEID + ",  " +
                        FIELD_REFID
                        + ") VALUES (?,  ?,  ?,  ?,  ?,  ?,  ?)";
        }
        @Override
        public String insertFor(String strContext)
        {
            switch(strContext.toLowerCase())
            {
                case "survey":
                    return "INSERT OR IGNORE INTO SurveyPointLink(" +
                            "SurveyID" + ",  " +
                            "SurveyPointID"
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
                               FIELD_X + " = ?,  " +
                               FIELD_Y + " = ?,  " +
                               FIELD_Z + " = ?,  " +
                               FIELD_NAME + " = ?,  " +
                               FIELD_DESCRIPTION + " = ?,  " +
                               FIELD_POINTTYPEID + " = ?,  " +
                               FIELD_REFID + " = ?"
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
                        return "DELETE FROM SurveyPointLink WHERE " +
                            "SurveyID = ? && " +
                            "SurveyPointID = ?"; 
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
                LOGGER.debug("Creating SurveyPoint in database");
                Statement stmtExecute = connDb.createStatement();
                stmtExecute.execute(createScript());
                LOGGER.debug("SurveyPoint create script - " + createScript());

                for(String strStatement : TABLE_EXTRA_SCRIPTS)
                {
                    stmtExecute.execute(strStatement);
                }
                LOGGER.debug("SurveyPoint extra script - " + triggerScript());

                if(!SQL_PROVIDER.staticInsertsScript().isEmpty())
                {
                    String[] listStatements = staticInsertsScript().split(";");
                    for(String strStatement : listStatements)
                    {
                        stmtExecute.execute(strStatement);
                    }
                    LOGGER.debug("SurveyPoint extra script - " + staticInsertsScript());
                }
                return true;
            }
            catch(SQLException exc)
            {
                LOGGER.error("Error executing scripts", exc);
            }
            return false;
        }

        private SqlProvider.SqlResultHandler<ISurveyPoint> m_resultsHandler;
        @Override
        public SqlProvider.SqlResultHandler<ISurveyPoint> resultsHandler()
        {
            if(m_resultsHandler == null)
            {
                m_resultsHandler = new SqlProvider.SqlResultHandler<ISurveyPoint>()
                   {
                        @Override
                        public ISurveyPoint fromResults(Connection connDb, ResultSet results)
                        {
                            try
                            {
                                return createSurveyPoint
                                (
                                    results.getInt(FIELD_ID),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                    results.getDouble(FIELD_X),
                                    results.getDouble(FIELD_Y),
                                    results.getDouble(FIELD_Z),
                                    results.getString(FIELD_NAME),
                                    results.getString(FIELD_DESCRIPTION),
                                    SurveyPointTypeAdapter.get(connDb, results.getInt(FIELD_POINTTYPEID)),
                                    SurveyReferenceAdapter.get(connDb, results.getInt(FIELD_REFID)),
                                    SurveyImageAdapter.getAllForSurveyPointParent(connDb, results.getInt(FIELD_ID))
                                );
                            }
                            catch(SQLException exc)
                            {
                                LOGGER.error("Error parsing result set", exc);
                            }
                            return null;
                        }
                        @Override
                        public ISurveyPoint updateFromResults(ISurveyPoint typeUpdate, Connection connDb, ResultSet results)
                        {
                            try
                            {
                                return updateSurveyPoint
                                (
                                    typeUpdate,
                                    results.getInt(FIELD_ID),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                                    SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                                    results.getDouble(FIELD_X),
                                    results.getDouble(FIELD_Y),
                                    results.getDouble(FIELD_Z),
                                    results.getString(FIELD_NAME),
                                    results.getString(FIELD_DESCRIPTION),
                                    SurveyPointTypeAdapter.get(connDb, results.getInt(FIELD_POINTTYPEID)),
                                    SurveyReferenceAdapter.get(connDb, results.getInt(FIELD_REFID)),
                                    SurveyImageAdapter.getAllForSurveyPointParent(connDb, results.getInt(FIELD_ID))
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
        private SqlProvider.SqlParameterHandler<ISurveyPoint> m_parametersHandler;
        @Override
        public SqlProvider.SqlParameterHandler<ISurveyPoint> parametersHandler()
        {
            if(m_parametersHandler == null)
            {
                m_parametersHandler = new SqlProvider.SqlParameterHandler<ISurveyPoint>()
                {
                    @Override
                    public boolean prepareInsert(PreparedStatement stmtSelect, ISurveyPoint typeInsert)
                    {
                        try
                        {
                            stmtSelect.setDouble(1, typeInsert.getX());
                            stmtSelect.setDouble(2, typeInsert.getY());
                            stmtSelect.setDouble(3, typeInsert.getZ());
                            stmtSelect.setString(4, typeInsert.getName());
                            stmtSelect.setString(5, typeInsert.getDescription());
                            stmtSelect.setInt(6, typeInsert.getPointType().getID());
                            stmtSelect.setInt(7, typeInsert.getReference().getID());

                            return true;
                        }
                        catch(SQLException exc)
                        {
                            LOGGER.error("Error setting data to prepared statement", exc);
                        }
                        return false;
                    }
                    @Override
                    public boolean prepareInsertFor(PreparedStatement stmt, ISurveyPoint type, String strContext)
                    {
                        return false;
                    }
                    @Override
                    public boolean prepareUpdate(PreparedStatement stmtSelect, ISurveyPoint typeUpdate)
                    {
                        try
                        {
                            stmtSelect.setDouble(1, typeUpdate.getX());
                            stmtSelect.setDouble(2, typeUpdate.getY());
                            stmtSelect.setDouble(3, typeUpdate.getZ());
                            stmtSelect.setString(4, typeUpdate.getName());
                            stmtSelect.setString(5, typeUpdate.getDescription());
                            stmtSelect.setInt(6, typeUpdate.getPointType().getID());
                            stmtSelect.setInt(7, typeUpdate.getReference().getID());
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
                    public boolean prepareDelete(PreparedStatement stmtSelect, ISurveyPoint typeDelete)
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
                    public boolean prepareDeleteFor(PreparedStatement stmt, ISurveyPoint type, String strContext)
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
