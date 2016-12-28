// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.adapters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.lenny.Utils.ISerialiseState;
import com.lenny.Utils.UndoTarget;
import com.lenny.Utils.DataSaveState;
import com.lenny.Utils.SQLiteConverter;
import com.lenny.surveyingDB.interfaces.ISurveySummary;


public class SurveySummaryAdapter
{
    // Class implements ISurveySummary but only accessible through the SurveySummaryAdapter

        static class SurveySummary_Proj implements ISurveySummary_Proj
        {

            @SerializedName("projID")
             int m_nProjID;
            @SerializedName("projName")
             String m_strProjName;


            public SurveySummary_Proj
            (
                int nProjID,
                String strProjName
            )
            {
                m_nProjID = nProjID;
                m_strProjName = strProjName;
            }

            public int getProjID()
            {
                return  m_nProjID;
            }
            public String getProjName()
            {
                return  m_strProjName;
            }

            public String toJson()
            {
                String strJson = "{";
                strJson += "\"projID\":" + m_nProjID + ",";
                strJson += "\"projName\":" + "\"" + m_strProjName + "\"";
                strJson += "}";
                return strJson;
            }
        }
        static class SurveySummary_Trav implements ISurveySummary_Trav
        {

            @SerializedName("travID")
             int m_nTravID;
            @SerializedName("travName")
             String m_strTravName;
            @SerializedName("travUpdated")
             Date m_dateTravUpdated;
            @SerializedName("ptTravStart")
             String m_strPtTravStart;
            @SerializedName("ptTravEnd")
             String m_strPtTravEnd;


            public SurveySummary_Trav
            (
                int nTravID,
                String strTravName,
                Date dateTravUpdated,
                String strPtTravStart,
                String strPtTravEnd
            )
            {
                m_nTravID = nTravID;
                m_strTravName = strTravName;
                m_dateTravUpdated = dateTravUpdated;
                m_strPtTravStart = strPtTravStart;
                m_strPtTravEnd = strPtTravEnd;
            }

            public int getTravID()
            {
                return  m_nTravID;
            }
            public String getTravName()
            {
                return  m_strTravName;
            }
            public Date getTravUpdated()
            {
                return  m_dateTravUpdated;
            }
            public String getPtTravStart()
            {
                return  m_strPtTravStart;
            }
            public String getPtTravEnd()
            {
                return  m_strPtTravEnd;
            }

            public String toJson()
            {
                String strJson = "{";
                strJson += "\"travID\":" + m_nTravID + ",";
                strJson += "\"travName\":" + "\"" + m_strTravName + "\"" + ",";
                strJson += "\"travUpdated\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateTravUpdated) + "\"" + ",";
                strJson += "\"ptTravStart\":" + "\"" + m_strPtTravStart + "\"" + ",";
                strJson += "\"ptTravEnd\":" + "\"" + m_strPtTravEnd + "\"";
                strJson += "}";
                return strJson;
            }
        }
        static class SurveySummary_PtSurv implements ISurveySummary_PtSurv
        {

            @SerializedName("ptID")
             int m_nPtID;
            @SerializedName("ptName")
             String m_strPtName;
            @SerializedName("ptX")
             double m_dPtX;
            @SerializedName("ptY")
             double m_dPtY;
            @SerializedName("ptZ")
             double m_dPtZ;


            public SurveySummary_PtSurv
            (
                int nPtID,
                String strPtName,
                double dPtX,
                double dPtY,
                double dPtZ
            )
            {
                m_nPtID = nPtID;
                m_strPtName = strPtName;
                m_dPtX = dPtX;
                m_dPtY = dPtY;
                m_dPtZ = dPtZ;
            }

            public int getPtID()
            {
                return  m_nPtID;
            }
            public String getPtName()
            {
                return  m_strPtName;
            }
            public double getPtX()
            {
                return  m_dPtX;
            }
            public double getPtY()
            {
                return  m_dPtY;
            }
            public double getPtZ()
            {
                return  m_dPtZ;
            }

            public String toJson()
            {
                String strJson = "{";
                strJson += "\"ptID\":" + m_nPtID + ",";
                strJson += "\"ptName\":" + "\"" + m_strPtName + "\"" + ",";
                strJson += "\"ptX\":" + m_dPtX + ",";
                strJson += "\"ptY\":" + m_dPtY + ",";
                strJson += "\"ptZ\":" + m_dPtZ;
                strJson += "}";
                return strJson;
            }
        }


    static class SurveySummary implements ISurveySummary
    {
        @SerializedName("ID")
         int m_nID;
        @SerializedName("Name")
         String m_strName;
        @SerializedName("created")
         Date m_dateCreated;
        @SerializedName("updated")
         Date m_dateUpdated;
        @SerializedName("Description")
         String m_strDescription;
        @SerializedName("proj")
         ISurveySummary_Proj m_typeProj;
        @SerializedName("trav")
         List<ISurveySummary_Trav> m_listTravs;
        @SerializedName("ptSurv")
         List<ISurveySummary_PtSurv> m_listPtSurvs;


        public SurveySummary
        (
            int nID,
            String strName,
            Date dateCreated,
            Date dateUpdated,
            String strDescription,
            int nProjID,
            String strProjName,
            int nTravID,
            String strTravName,
            Date dateTravUpdated,
            String strPtTravStart,
            String strPtTravEnd,
            int nPtID,
            String strPtName,
            double dPtX,
            double dPtY,
            double dPtZ
        )
        {
            m_nID = nID;
            m_strName = strName;
            m_dateCreated = dateCreated;
            m_dateUpdated = dateUpdated;
            m_strDescription = strDescription;

            m_typeProj = new ISurveySummary_Proj
                            (
                                int nProjID,
                                String strProjName
                            );


            m_listTravs = new ArrayList<>();
            m_listTravs.add(
                        new 
                        (
                            int nTravID,
                            String strTravName,
                            Date dateTravUpdated,
                            String strPtTravStart,
                            String strPtTravEnd
                        )
                    );


            m_listPtSurvs = new ArrayList<>();
            m_listPtSurvs.add(
                        new 
                        (
                            int nPtID,
                            String strPtName,
                            double dPtX,
                            double dPtY,
                            double dPtZ
                        )
                    );

        }

        SurveySummary(SurveySummary viewFrom)
        {
            m_nID = viewFrom.m_nID;
            m_strName = viewFrom.m_strName;
            m_dateCreated = viewFrom.m_dateCreated;
            m_dateUpdated = viewFrom.m_dateUpdated;
            m_strDescription = viewFrom.m_strDescription;
            m_typeProj = viewFrom.m_typeProj;
            m_listTravs = viewFrom.m_listTravs;
            m_listPtSurvs = viewFrom.m_listPtSurvs;

        }

        public int getID()
        {
            return  m_nID;
        }
        public String getName()
        {
            return  m_strName;
        }
        public Date getCreated()
        {
            return  m_dateCreated;
        }
        public Date getUpdated()
        {
            return  m_dateUpdated;
        }
        public String getDescription()
        {
            return  m_strDescription;
        }
        public ISurveySummary_Proj getProj()
        {
            return  m_typeProj;
        }
        public List<ISurveySummary_Trav> getTravs()
        {
            return  m_listTravs;
        }
        public List<ISurveySummary_PtSurv> getPtSurvs()
        {
            return  m_listPtSurvs;
        }


        // Used by stream collector to aggregate like instances together

        public SurveySummary add(SurveySummary newType)
        {
            if
            (
                newType.m_listTravs.size() > 0
                &&
                !m_listTravs.stream()
                    .filter(member -> member.m_nTravID == newType.m_listTravs.get(0).m_nTravID)
                    .isPresent()
            )
            {
                m_listTravs.add(newType.m_listTravs.get(0));
            }
            if
            (
                newType.m_listPtSurvs.size() > 0
                &&
                !m_listPtSurvs.stream()
                    .filter(member -> member.m_nPtID == newType.m_listPtSurvs.get(0).m_nPtID)
                    .isPresent()
            )
            {
                m_listPtSurvs.add(newType.m_listPtSurvs.get(0));
            }
            return this;
        }

        @Override public boolean isSaved() { return true; }
        @Override public boolean isNew() { return false; }
        @Override public boolean isUpdated() { return false; }
        @Override public void setSaved() {}
        @Override public void setUpdated() {}

        @Override
        public String toJson()
        {
            String strJson = "{";
            strJson += "\"ID\":" + m_nID + ",";
            strJson += "\"Name\":" + "\"" + m_strName + "\"" + ",";
            strJson += "\"created\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateCreated) + "\"" + ",";
            strJson += "\"updated\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateUpdated) + "\"" + ",";
            strJson += "\"Description\":" + "\"" + m_strDescription + "\"" + ",";
            strJson += "\"proj\":" + ((ISerialiseState) m_typeProj).toJson() + ",";
            strJson += "\"trav\":[" + m_listTravs.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]" + ",";
            strJson += "\"ptSurv\":[" + m_listPtSurvs.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]";
            strJson += "}";
            return strJson;
        }

    }

    public static final String VIEW_NAME = "SurveySummary";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_UPDATED = "updated";
    public static final String FIELD_DESCRIPTION = "Description";
    public static final String FIELD_PROJID = "projID";
    public static final String FIELD_PROJNAME = "projName";
    public static final String FIELD_TRAVID = "travID";
    public static final String FIELD_TRAVNAME = "travName";
    public static final String FIELD_TRAVUPDATED = "travUpdated";
    public static final String FIELD_PTTRAVSTART = "ptTravStart";
    public static final String FIELD_PTTRAVEND = "ptTravEnd";
    public static final String FIELD_PTID = "ptID";
    public static final String FIELD_PTNAME = "ptName";
    public static final String FIELD_PTX = "ptX";
    public static final String FIELD_PTY = "ptY";
    public static final String FIELD_PTZ = "ptZ";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveySummary createSurveySummary
    (
        int nID,
        String strName,
        Date dateCreated,
        Date dateUpdated,
        String strDescription,
        int nProjID,
        String strProjName,
        int nTravID,
        String strTravName,
        Date dateTravUpdated,
        String strPtTravStart,
        String strPtTravEnd,
        int nPtID,
        String strPtName,
        double dPtX,
        double dPtY,
        double dPtZ
    )
    {
        return new SurveySummary
            (
                nID,
                strName,
                dateCreated,
                dateUpdated,
                strDescription,
                nProjID,
                strProjName,
                nTravID,
                strTravName,
                dateTravUpdated,
                strPtTravStart,
                strPtTravEnd,
                nPtID,
                strPtName,
                dPtX,
                dPtY,
                dPtZ
            );
    }

    public static ISurveySummary get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveySummary typeReturn = null;
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
            List<SurveySummary> listRawData = new ArrayList<>();
            while(results.next())
            {
                listRawData.add
                    (
                        createSurveySummary
                        (
                            results.getInt(FIELD_ID),
                            results.getString(FIELD_NAME),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                            results.getString(FIELD_DESCRIPTION),
                            results.getInt(FIELD_PROJID),
                            results.getString(FIELD_PROJNAME),
                            results.getInt(FIELD_TRAVID),
                            results.getString(FIELD_TRAVNAME),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_TRAVUPDATED)),
                            results.getString(FIELD_PTTRAVSTART),
                            results.getString(FIELD_PTTRAVEND),
                            results.getInt(FIELD_PTID),
                            results.getString(FIELD_PTNAME),
                            results.getDouble(FIELD_PTX),
                            results.getDouble(FIELD_PTY),
                            results.getDouble(FIELD_PTZ)
                        )
                    );
            }
            Map<Integer, SurveySummary> mapData = listRawData.stream()
                    .collect(
                        Collectors.toMap(
                            view -> view.m_,
                            view -> new SurveySummary(view),
                            (viewInto, view) -> viewInto.add(view)
                        )
                    );

            typeReturn = mapData.values().get(0);
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

    public static List<ISurveySummary> getAll(Connection connDb) throws SQLException
    {
        List<ISurveySummary> listReturn = new ArrayList<ISurveySummary>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            while(results.next())
            {
                listRawData.add
                    (
                        createSurveySummary
                        (
                            results.getInt(FIELD_ID),
                            results.getString(FIELD_NAME),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_CREATED)),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                            results.getString(FIELD_DESCRIPTION),
                            results.getInt(FIELD_PROJID),
                            results.getString(FIELD_PROJNAME),
                            results.getInt(FIELD_TRAVID),
                            results.getString(FIELD_TRAVNAME),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_TRAVUPDATED)),
                            results.getString(FIELD_PTTRAVSTART),
                            results.getString(FIELD_PTTRAVEND),
                            results.getInt(FIELD_PTID),
                            results.getString(FIELD_PTNAME),
                            results.getDouble(FIELD_PTX),
                            results.getDouble(FIELD_PTY),
                            results.getDouble(FIELD_PTZ)
                        )
                    );
            }
            Map<Integer, SurveySummary> mapData = listRawData.stream()
                    .collect(
                        Collectors.toMap(
                            view -> view.m_,
                            view -> new SurveySummary(view),
                            (viewInto, view) -> viewInto.add(view)
                        )
                    );
            listReturn = mapData.values().stream()
                    .map(value -> (ISurveySummary) value)
                    .collect(Collectors.toList());
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

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_NAME + ",  " +
            FIELD_CREATED + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_PROJID + ",  " +
            FIELD_PROJNAME + ",  " +
            FIELD_TRAVID + ",  " +
            FIELD_TRAVNAME + ",  " +
            FIELD_TRAVUPDATED + ",  " +
            FIELD_PTTRAVSTART + ",  " +
            FIELD_PTTRAVEND + ",  " +
            FIELD_PTID + ",  " +
            FIELD_PTNAME + ",  " +
            FIELD_PTX + ",  " +
            FIELD_PTY + ",  " +
            FIELD_PTZ
            + " FROM " +
            VIEW_NAME;
        if(nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }

    private static String CREATE_VIEW_SCRIPT =         "CREATE VIEW SurveySummary as " + 
        "SELECT " + 
        "surv.ID as ID, " + 
        "surv.Name as Name, " + 
        "surv.created as created, " + 
        "surv.updated as updated, " + 
        "surv.Description as Description, " + 
        "proj.ID as projID, " + 
        "proj.Name as projName, " + 
        "trav.ID as travID, " + 
        "trav.Name as travName, " + 
        "trav.Updated as travUpdated, " + 
        "trav.ptStartName as ptTravStart, " + 
        "trav.ptEndName as ptTravEnd, " + 
        "ptSurv.ptID as ptID, " + 
        "ptSurv.ptName as ptName, " + 
        "ptSurv.X as ptX, " + 
        "ptSurv.Y as ptY, " + 
        "ptSurv.Z as ptZ " + 
        "from " + 
        "Survey surv " + 
        "inner join Projection as proj on proj.ID = surv.ProjectionID " + 
        "inner join TraverseSummary as trav on trav.SurveyID = surv.ID " + 
        "inner join SurveyPointSummary as ptSurv on ptSurv.ID = surv.ID;";
    public static String getCreateViewScript()
    {
        return CREATE_VIEW_SCRIPT;
    }

    private static String[] VIEW_EXTRA_SCRIPTS = new String[] {
    };

    public static String[] getExtraViewScripts()
    {
        return VIEW_EXTRA_SCRIPTS;
    }

    public static void createInDatabase(Connection connDb) throws SQLException
    {
        Statement stmtExecute = connDb.createStatement();
        stmtExecute.execute(CREATE_VIEW_SCRIPT);
        for(String strScript : VIEW_EXTRA_SCRIPTS)
        {
            stmtExecute.execute(strScript);
        }
    }
}
