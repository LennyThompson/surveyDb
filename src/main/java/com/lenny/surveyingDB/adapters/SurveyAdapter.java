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
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.interfaces.IProjection;
import com.lenny.surveyingDB.adapters.ProjectionAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.adapters.SurveyImageAdapter;
import com.lenny.surveyingDB.adapters.TraverseAdapter;
import com.lenny.surveyingDB.adapters.InstrumentAdapter;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;


public class SurveyAdapter implements JsonDeserializer<ISurvey>
{

        // Class implements ISurvey but only accessible through the SurveyAdapter

        static class Survey extends UndoTarget implements ISurvey
        {
            @SerializedName("ID")
            private int m_nID;
            @SerializedName("created")
            private LocalDateTime m_dateCreated;
            @SerializedName("updated")
            private LocalDateTime m_dateUpdated;
            @SerializedName("Name")
            private String m_strName;
            @SerializedName("Description")
            private String m_strDescription;

            @SerializedName("ProjectionID")
            private IProjection m_typeProjection;

            @SerializedName("Measurements")
            private List<ISurveyMeasurement> m_listSurveyMeasurement;
            @SerializedName("Images")
            private List<ISurveyImage> m_listSurveyImage;
            @SerializedName("Traverses")
            private List<ITraverse> m_listTraverse;
            @SerializedName("Survey_Instrument")
            private List<IInstrument> m_listInstrument;
            @SerializedName("Survey_SurveyPoint")
            private List<ISurveyPoint> m_listSurveyPoint;

            Survey()
            {
                m_nID = 0;
                m_dateCreated = LocalDateTime.now();
                m_dateUpdated = LocalDateTime.now();
                m_strName = "";
                m_strDescription = "";

                m_typeProjection = ProjectionAdapter.createNewProjection();

                m_listSurveyMeasurement = new ArrayList<>();
                m_listSurveyImage = new ArrayList<>();
                m_listTraverse = new ArrayList<>();
                m_listInstrument = new ArrayList<>();
                m_listSurveyPoint = new ArrayList<>();

                m_saveState = DataSaveState.SAVE_STATE_NEW;
            }
            Survey(int nID, LocalDateTime dateCreated, LocalDateTime dateUpdated, String strName, String strDescription, IProjection typeProjection, List<ISurveyMeasurement> listSurveyMeasurement, List<ISurveyImage> listSurveyImage, List<ITraverse> listTraverse, List<IInstrument> listInstrument, List<ISurveyPoint> listSurveyPoint)
            {
                m_nID = nID;
                m_dateCreated = dateCreated;
                m_dateUpdated = dateUpdated;
                m_strName = strName;
                m_strDescription = strDescription;
                m_typeProjection = typeProjection;
                m_listSurveyMeasurement = listSurveyMeasurement;
                m_listSurveyImage = listSurveyImage;
                m_listTraverse = listTraverse;
                m_listInstrument = listInstrument;
                m_listSurveyPoint = listSurveyPoint;
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
            public String getDescription()
            {
                return  m_strDescription;
            }

            public IProjection getProjection()
            {
                return  m_typeProjection;
            }

            public List<ISurveyMeasurement> getSurveyMeasurements()
            {
                return  m_listSurveyMeasurement;
            }
            public List<ISurveyImage> getSurveyImages()
            {
                return  m_listSurveyImage;
            }
            public List<ITraverse> getTraverses()
            {
                return  m_listTraverse;
            }
            public List<IInstrument> getInstruments()
            {
                return  m_listInstrument;
            }
            public List<ISurveyPoint> getSurveyPoints()
            {
                return  m_listSurveyPoint;
            }

            public void setName(String strSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Name = " + Survey.this.m_strName)
                    {
                        String m_undoName = Survey.this.m_strName;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_strName = m_undoName;
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
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
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Description = " + Survey.this.m_strDescription)
                    {
                        String m_undoDescription = Survey.this.m_strDescription;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_strDescription = m_undoDescription;
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
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

            public void setProjection(IProjection typeSet)
            {
                addUndoProvider
                (
                    new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Projection = " + Survey.this.m_typeProjection)
                    {
                        IProjection m_undoProjection = Survey.this.m_typeProjection;
                        public boolean doUndo()
                        {
                            if(isPending())
                            {
                                Survey.this.m_typeProjection = m_undoProjection;
                                if(Survey.this.m_saveState != m_dataSaveState)
                                {
                                    Survey.this.m_saveState = m_dataSaveState;
                                }
                                m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                return true;
                            }
                            return false;
                        }
                    }
                );
                m_typeProjection = typeSet;
                setUpdated();
            }

            public void addSurveyMeasurement(ISurveyMeasurement typeAdd)
            {
                addUndoProvider
                    (
                        new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member SurveyMeasurement = " + Survey.this.m_listSurveyMeasurement)
                        {
                            ISurveyMeasurement m_undoSurveyMeasurement = typeAdd;
                            public boolean doUndo()
                            {
                                if(isPending())
                                {
                                    Survey.this.m_listSurveyMeasurement.remove(m_undoSurveyMeasurement);
                                    if(Survey.this.m_saveState != m_dataSaveState)
                                    {
                                        Survey.this.m_saveState = m_dataSaveState;
                                    }
                                    m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                    return true;
                                }
                                return false;
                            }
                        }
                    );

                m_listSurveyMeasurement.add(typeAdd);
                ((SurveyMeasurementAdapter.SurveyMeasurement) typeAdd).setSurveyID(getID());
                setUpdated();
            }
            public void addSurveyImage(ISurveyImage typeAdd)
            {
                addUndoProvider
                    (
                        new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member SurveyImage = " + Survey.this.m_listSurveyImage)
                        {
                            ISurveyImage m_undoSurveyImage = typeAdd;
                            public boolean doUndo()
                            {
                                if(isPending())
                                {
                                    Survey.this.m_listSurveyImage.remove(m_undoSurveyImage);
                                    if(Survey.this.m_saveState != m_dataSaveState)
                                    {
                                        Survey.this.m_saveState = m_dataSaveState;
                                    }
                                    m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                    return true;
                                }
                                return false;
                            }
                        }
                    );

                m_listSurveyImage.add(typeAdd);
                ((SurveyImageAdapter.SurveyImage) typeAdd).setSurveyID(getID());
                setUpdated();
            }
            public void addTraverse(ITraverse typeAdd)
            {
                addUndoProvider
                    (
                        new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Traverse = " + Survey.this.m_listTraverse)
                        {
                            ITraverse m_undoTraverse = typeAdd;
                            public boolean doUndo()
                            {
                                if(isPending())
                                {
                                    Survey.this.m_listTraverse.remove(m_undoTraverse);
                                    if(Survey.this.m_saveState != m_dataSaveState)
                                    {
                                        Survey.this.m_saveState = m_dataSaveState;
                                    }
                                    m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                    return true;
                                }
                                return false;
                            }
                        }
                    );

                m_listTraverse.add(typeAdd);
                ((TraverseAdapter.Traverse) typeAdd).setSurveyID(getID());
                setUpdated();
            }
            public void addInstrument(IInstrument typeAdd)
            {
                addUndoProvider
                    (
                        new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member Instrument = " + Survey.this.m_listInstrument)
                        {
                            IInstrument m_undoInstrument = typeAdd;
                            public boolean doUndo()
                            {
                                if(isPending())
                                {
                                    Survey.this.m_listInstrument.remove(m_undoInstrument);
                                    if(Survey.this.m_saveState != m_dataSaveState)
                                    {
                                        Survey.this.m_saveState = m_dataSaveState;
                                    }
                                    m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                    return true;
                                }
                                return false;
                            }
                        }
                    );

                m_listInstrument.add(typeAdd);
                setUpdated();
            }
            public void addSurveyPoint(ISurveyPoint typeAdd)
            {
                addUndoProvider
                    (
                        new UndoProviderImpl(Survey.this.m_saveState, "Undo set Survey member SurveyPoint = " + Survey.this.m_listSurveyPoint)
                        {
                            ISurveyPoint m_undoSurveyPoint = typeAdd;
                            public boolean doUndo()
                            {
                                if(isPending())
                                {
                                    Survey.this.m_listSurveyPoint.remove(m_undoSurveyPoint);
                                    if(Survey.this.m_saveState != m_dataSaveState)
                                    {
                                        Survey.this.m_saveState = m_dataSaveState;
                                    }
                                    m_pendingUndo = PendingUndoState.UNDO_COMPLETE;
                                    return true;
                                }
                                return false;
                            }
                        }
                    );

                m_listSurveyPoint.add(typeAdd);
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
                strJson += "\"ProjectionID\":" + ((ISerialiseState) m_typeProjection).toJson() + ",";
                strJson += "\"Measurements\":[" + m_listSurveyMeasurement.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
                strJson += "\"Images\":[" + m_listSurveyImage.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
                strJson += "\"Traverses\":[" + m_listTraverse.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
                strJson += "\"Survey_Instrument\":[" + m_listInstrument.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
                strJson += "\"Survey_SurveyPoint\":[" + m_listSurveyPoint.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]";
                strJson += "}";
                return strJson;
            }
        }

    public static final String TABLE_NAME = "Survey";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_PROJECTIONID = "ProjectionID";
    public static final String FIELD_DESCRIPTION = "Description";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurvey createNewSurvey()
    {
        return new Survey();
    }

    public static ISurvey createSurvey
    (
        int nID,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String strName,
        String strDescription,
        IProjection typeProjection,
        List<ISurveyMeasurement> listSurveyMeasurement,
        List<ISurveyImage> listSurveyImage,
        List<ITraverse> listTraverse,
        List<IInstrument> listInstrument,
        List<ISurveyPoint> listSurveyPoint
    )
    {
        return new Survey(nID, dateCreated, dateUpdated, strName, strDescription, typeProjection, listSurveyMeasurement, listSurveyImage, listTraverse, listInstrument, listSurveyPoint);
    }

    // This method enables the adapter type to be registered to deserialise json as ISurvey
    // Code to deserialise is along these lines
    //      GsonBuilder gsonBuild = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
    //      gsonBuild.registerTypeAdapter(ISurvey.class, new SurveyAdapter());
    //      Gson gsonInstance = gsonBuild.create();
    //      ISurvey serialised = gsonInstance.fromJson(strJson, ISurvey.class);

    public ISurvey deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
        gsonBuilder.registerTypeAdapter(IProjection.class, new ProjectionAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyImage.class, new SurveyImageAdapter());
        gsonBuilder.registerTypeAdapter(ITraverse.class, new TraverseAdapter());
        gsonBuilder.registerTypeAdapter(IInstrument.class, new InstrumentAdapter());
        gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());

        Gson gsonInstance = gsonBuilder.create();
        SurveyAdapter.Survey typeSurvey = gsonInstance.fromJson(json, SurveyAdapter.Survey.class);
        if (typeSurvey.m_nID > 0)
        {
            typeSurvey.setSaved();
        }
        return typeSurvey;
    }

    public static ISurvey get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurvey typeReturn = null;
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
                typeReturn = createSurveyFromQueryResults(connDb, results);
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
    public static ISurvey getLast(Connection connDb) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return createSurveyFromQueryResults(connDb, results);
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
    public static ISurvey updateFromLast(Connection connDb, ISurvey typeUpdate) throws SQLException
    {
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectLastQuery());
            results = stmtSelect.executeQuery();
            if (results.next())
            {
                return updateSurveyFromQueryResults(connDb, results, typeUpdate);
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

    public static List<ISurvey> getAll(Connection connDb) throws SQLException
    {
        List<ISurvey> listReturn = new ArrayList<ISurvey>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while (results.next())
            {
                listReturn.add(createSurveyFromQueryResults(connDb, results));
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

    public static ISurvey add(Connection connDb, ISurvey typeAdd) throws SQLException
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
        if (((UndoTarget) typeAdd.getProjection()).isNew())
        {
            typeAdd.setProjection(ProjectionAdapter.add(connDb, typeAdd.getProjection()));
        }
        else if (((UndoTarget) typeAdd.getProjection()).isUpdated())
        {
            typeAdd.setProjection(ProjectionAdapter.update(connDb, typeAdd.getProjection()));
        }

        try
        {
            stmtSelect = connDb.prepareStatement(getInsertQuery());
            stmtSelect.setString(1, typeAdd.getName());
            stmtSelect.setString(2, typeAdd.getDescription());
            stmtSelect.setInt(3, typeAdd.getProjection().getID());

            stmtSelect.executeUpdate();

            ((Survey) typeAdd).m_nID = getLastId(connDb);

            ((Survey) typeAdd).m_listSurveyMeasurement = typeAdd.getSurveyMeasurements().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return SurveyMeasurementAdapter.add(connDb, item);
                        }
                        catch (SQLException exc)
                        {
                        // TODO: set up error handling
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listSurveyImage = typeAdd.getSurveyImages().stream()
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
                        // TODO: set up error handling
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listTraverse = typeAdd.getTraverses().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return TraverseAdapter.add(connDb, item);
                        }
                        catch (SQLException exc)
                        {
                        // TODO: set up error handling
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listInstrument = typeAdd.getInstruments().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return InstrumentAdapter.addForSurvey(connDb, item, typeAdd);
                        }
                        catch (SQLException exc)
                        {
                        // TODO: set up error handling
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());
            ((Survey) typeAdd).m_listSurveyPoint = typeAdd.getSurveyPoints().stream()
                .map
                (
                    item ->
                    {
                        try
                        {
                            return SurveyPointAdapter.addForSurvey(connDb, item, typeAdd);
                        }
                        catch (SQLException exc)
                        {
                        // TODO: set up error handling
                            throw new RuntimeException(exc);
                        }
                    }
                )
                .collect(Collectors.toList());

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
    public static ISurvey update(Connection connDb, ISurvey typeUpdate) throws SQLException
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
                stmtSelect.setString(2, typeUpdate.getDescription());
                stmtSelect.setInt(3, typeUpdate.getProjection().getID());
                stmtSelect.setInt(4, typeUpdate.getID());

                ((Survey) typeUpdate).m_listSurveyMeasurement = typeUpdate.getSurveyMeasurements().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return SurveyMeasurementAdapter.update(connDb, item);
                            }
                            catch (SQLException exc)
                            {
                            // TODO: set up error handling
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listSurveyImage = typeUpdate.getSurveyImages().stream()
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
                            // TODO: set up error handling
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listTraverse = typeUpdate.getTraverses().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return TraverseAdapter.update(connDb, item);
                            }
                            catch (SQLException exc)
                            {
                            // TODO: set up error handling
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listInstrument = typeUpdate.getInstruments().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return InstrumentAdapter.updateForSurvey(connDb, item, typeUpdate);
                            }
                            catch (SQLException exc)
                            {
                            // TODO: set up error handling
                                throw new RuntimeException(exc);
                            }
                        }
                    )
                    .collect(Collectors.toList());
                ((Survey) typeUpdate).m_listSurveyPoint = typeUpdate.getSurveyPoints().stream()
                    .map
                    (
                        item ->
                        {
                            try
                            {
                                return SurveyPointAdapter.updateForSurvey(connDb, item, typeUpdate);
                            }
                            catch (SQLException exc)
                            {
                            // TODO: set up error handling
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

    public static ISurvey updateFromDatabase(Connection connDb, ISurvey typeUpdate) throws SQLException
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
                return updateSurveyFromQueryResults(connDb, results, typeUpdate);
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





    static boolean addSurveyForInstrument(Connection connDb, int nID, IInstrument typeUpdate) throws SQLException
    {
        return InstrumentAdapter.addForSurvey(connDb, typeUpdate, nID) != null;
    }


    static boolean addSurveyForSurveyPoint(Connection connDb, int nID, ISurveyPoint typeUpdate) throws SQLException
    {
        return SurveyPointAdapter.addForSurvey(connDb, typeUpdate, nID) != null;
    }



    private static ISurvey createSurveyFromQueryResults(Connection connDb, ResultSet results) throws SQLException
    {
        return createSurvey
                   (
                       results.getInt(FIELD_ID),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                       SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                       results.getString(FIELD_NAME),
                       results.getString(FIELD_DESCRIPTION),
                       ProjectionAdapter.get(connDb, results.getInt(FIELD_PROJECTIONID)),
                       SurveyMeasurementAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                       SurveyImageAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                       TraverseAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                       InstrumentAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID)),
                       SurveyPointAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID))
                   );

    }
    private static ISurvey updateSurveyFromQueryResults(Connection connDb, ResultSet results, ISurvey typeUpdate) throws SQLException
    {
       ((Survey)typeUpdate).m_nID = results.getInt(FIELD_ID);
       ((Survey)typeUpdate).m_dateCreated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED));
       ((Survey)typeUpdate).m_dateUpdated = SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED));
       ((Survey)typeUpdate).m_strName = results.getString(FIELD_NAME);
       ((Survey)typeUpdate).m_strDescription = results.getString(FIELD_DESCRIPTION);
       ((Survey)typeUpdate).m_typeProjection = ProjectionAdapter.get(connDb, results.getInt(FIELD_PROJECTIONID));
       ((Survey)typeUpdate).m_listSurveyMeasurement = SurveyMeasurementAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID));
       ((Survey)typeUpdate).m_listSurveyImage = SurveyImageAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID));
       ((Survey)typeUpdate).m_listTraverse = TraverseAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID));
       ((Survey)typeUpdate).m_listInstrument = InstrumentAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID));
       ((Survey)typeUpdate).m_listSurveyPoint = SurveyPointAdapter.getAllForSurveyParent(connDb, results.getInt(FIELD_ID));

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
            FIELD_PROJECTIONID
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
            FIELD_DESCRIPTION + ",  " +
            FIELD_PROJECTIONID
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
            FIELD_PROJECTIONID
            + " FROM " +
            TABLE_NAME;
        return strSelectLast;
    }
    private static String getUpdateQuery()
    {
        String strUpdate = "UPDATE " + TABLE_NAME + " SET " +
            FIELD_NAME + " = ?,  " +
            FIELD_DESCRIPTION + " = ?,  " +
            FIELD_PROJECTIONID + " = ?"
        + " WHERE " + PRIMARY_KEY + " = ?";
        return strUpdate;
    }
    private static String CREATE_TABLE_SCRIPT =         "CREATE TABLE `Survey` " + 
        "( " + 
        "`ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + 
        "`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " + 
        "`Name`  TEXT NOT NULL, " + 
        "`ProjectionID` INTEGER NOT NULL, " + 
        "`Description`   TEXT, " + 
        "FOREIGN KEY (ProjectionID) REFERENCES Projection(ID) " + 
        ");";
    public static String getCreateTableScript()
    {
        return CREATE_TABLE_SCRIPT;
    }

    private static String[] TABLE_EXTRA_SCRIPTS = new String[] {
            "create trigger Survey after update on `Survey` " + 
            "for each row " + 
            "begin " + 
            "update Survey set updated = current_timestamp where ID == OLD.ID; " + 
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
