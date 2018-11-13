// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:54 AEST 2018

package com.lenny.surveyingDB.adapters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import com.google.gson.annotations.SerializedName;
import com.lenny.Utils.ISerialiseState;
import com.lenny.Utils.UndoTarget;
import com.lenny.Utils.DataSaveState;
import com.lenny.Utils.SQLiteConverter;
import com.lenny.surveyingDB.interfaces.ITraverseSummary;
import com.lenny.surveyingDB.interfaces.ITraverseSummary.*;


public class TraverseSummaryAdapter
{
    // Class implements ITraverseSummary but only accessible through the TraverseSummaryAdapter

        static class TraverseSummary_PtStart
                implements ITraverseSummary_PtStart
        {

            @SerializedName("ptStartID")
             int m_nPtStartID;
            @SerializedName("ptStartName")
             String m_strPtStartName;
            @SerializedName("ptStartX")
             double m_dPtStartX;
            @SerializedName("ptStartY")
             double m_dPtStartY;
            @SerializedName("ptStartZ")
             double m_dPtStartZ;


            TraverseSummary_PtStart()
            {
                m_nPtStartID = 0;
                m_strPtStartName = "";
                m_dPtStartX = 0.0;
                m_dPtStartY = 0.0;
                m_dPtStartZ = 0.0;
            }
            public TraverseSummary_PtStart
            (
                int nPtStartID,
                String strPtStartName,
                double dPtStartX,
                double dPtStartY,
                double dPtStartZ
            )
            {
                m_nPtStartID = nPtStartID;
                m_strPtStartName = strPtStartName;
                m_dPtStartX = dPtStartX;
                m_dPtStartY = dPtStartY;
                m_dPtStartZ = dPtStartZ;
            }

            public int getPtStartID()
            {
                return  m_nPtStartID;
            }
            public String getPtStartName()
            {
                return  m_strPtStartName;
            }
            public double getPtStartX()
            {
                return  m_dPtStartX;
            }
            public double getPtStartY()
            {
                return  m_dPtStartY;
            }
            public double getPtStartZ()
            {
                return  m_dPtStartZ;
            }

            @Override
            public String toJson()
            {
                String strJson = "{";
                strJson += "\"ptStartID\":" + m_nPtStartID + ",";
                strJson += "\"ptStartName\":" + "\"" + m_strPtStartName + "\"" + ",";
                strJson += "\"ptStartX\":" + m_dPtStartX + ",";
                strJson += "\"ptStartY\":" + m_dPtStartY + ",";
                strJson += "\"ptStartZ\":" + m_dPtStartZ;
                strJson += "}";
                return strJson;
            }
        }
        static class TraverseSummary_PtEnd
                implements ITraverseSummary_PtEnd
        {

            @SerializedName("ptEndID")
             int m_nPtEndID;
            @SerializedName("ptEndName")
             String m_strPtEndName;
            @SerializedName("ptEndX")
             double m_dPtEndX;
            @SerializedName("ptEndY")
             double m_dPtEndY;
            @SerializedName("ptEndZ")
             double m_dPtEndZ;


            TraverseSummary_PtEnd()
            {
                m_nPtEndID = 0;
                m_strPtEndName = "";
                m_dPtEndX = 0.0;
                m_dPtEndY = 0.0;
                m_dPtEndZ = 0.0;
            }
            public TraverseSummary_PtEnd
            (
                int nPtEndID,
                String strPtEndName,
                double dPtEndX,
                double dPtEndY,
                double dPtEndZ
            )
            {
                m_nPtEndID = nPtEndID;
                m_strPtEndName = strPtEndName;
                m_dPtEndX = dPtEndX;
                m_dPtEndY = dPtEndY;
                m_dPtEndZ = dPtEndZ;
            }

            public int getPtEndID()
            {
                return  m_nPtEndID;
            }
            public String getPtEndName()
            {
                return  m_strPtEndName;
            }
            public double getPtEndX()
            {
                return  m_dPtEndX;
            }
            public double getPtEndY()
            {
                return  m_dPtEndY;
            }
            public double getPtEndZ()
            {
                return  m_dPtEndZ;
            }

            @Override
            public String toJson()
            {
                String strJson = "{";
                strJson += "\"ptEndID\":" + m_nPtEndID + ",";
                strJson += "\"ptEndName\":" + "\"" + m_strPtEndName + "\"" + ",";
                strJson += "\"ptEndX\":" + m_dPtEndX + ",";
                strJson += "\"ptEndY\":" + m_dPtEndY + ",";
                strJson += "\"ptEndZ\":" + m_dPtEndZ;
                strJson += "}";
                return strJson;
            }
        }


    static class TraverseSummary implements ITraverseSummary
    {
        @SerializedName("ID")
         int m_nID;
        @SerializedName("SurveyID")
         int m_nSurveyID;
        @SerializedName("Name")
         String m_strName;
        @SerializedName("Updated")
         LocalDateTime m_dateUpdated;
        @SerializedName("Description")
         String m_strDescription;
        @SerializedName("ptStart")
         ITraverseSummary_PtStart m_typePtStart;
        @SerializedName("ptEnd")
         ITraverseSummary_PtEnd m_typePtEnd;


        TraverseSummary()
        {
            m_nID = 0;
            m_nSurveyID = 0;
            m_strName = "";
            m_dateUpdated = LocalDateTime.now();
            m_strDescription = "";

            m_typePtStart = new TraverseSummary_PtStart();


            m_typePtEnd = new TraverseSummary_PtEnd();

        }

        public TraverseSummary
        (
            int nID,
            int nSurveyID,
            String strName,
            LocalDateTime dateUpdated,
            String strDescription,
            int nPtStartID,
            String strPtStartName,
            double dPtStartX,
            double dPtStartY,
            double dPtStartZ,
            int nPtEndID,
            String strPtEndName,
            double dPtEndX,
            double dPtEndY,
            double dPtEndZ
        )
        {
            m_nID = nID;
            m_nSurveyID = nSurveyID;
            m_strName = strName;
            m_dateUpdated = dateUpdated;
            m_strDescription = strDescription;

            m_typePtStart = new TraverseSummary_PtStart
                            (
                                nPtStartID,
                                strPtStartName,
                                dPtStartX,
                                dPtStartY,
                                dPtStartZ
                            );


            m_typePtEnd = new TraverseSummary_PtEnd
                            (
                                nPtEndID,
                                strPtEndName,
                                dPtEndX,
                                dPtEndY,
                                dPtEndZ
                            );

        }

        TraverseSummary(TraverseSummary viewFrom)
        {
            m_nID = viewFrom.m_nID;
            m_nSurveyID = viewFrom.m_nSurveyID;
            m_strName = viewFrom.m_strName;
            m_dateUpdated = viewFrom.m_dateUpdated;
            m_strDescription = viewFrom.m_strDescription;
            m_typePtStart = viewFrom.m_typePtStart;
            m_typePtEnd = viewFrom.m_typePtEnd;

        }

        public int getID()
        {
            return  m_nID;
        }
        public int getSurveyID()
        {
            return  m_nSurveyID;
        }
        public String getName()
        {
            return  m_strName;
        }
        public LocalDateTime getUpdated()
        {
            return  m_dateUpdated;
        }
        public String getDescription()
        {
            return  m_strDescription;
        }
        public ITraverseSummary_PtStart getPtStart()
        {
            return  m_typePtStart;
        }
        public ITraverseSummary_PtEnd getPtEnd()
        {
            return  m_typePtEnd;
        }


        // Used by stream collector to aggregate like instances together

        public TraverseSummary add(ITraverseSummary newType)
        {
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
            strJson += "\"SurveyID\":" + m_nSurveyID + ",";
            strJson += "\"Name\":" + "\"" + m_strName + "\"" + ",";
            strJson += "\"Updated\":" + "\"" + SQLiteConverter.convertDateTimeToJSString(m_dateUpdated) + "\"" + ",";
            strJson += "\"Description\":" + "\"" + m_strDescription + "\"" + ",";
            strJson += "\"ptStart\":" + m_typePtStart.toJson() + ",";
            strJson += "\"ptEnd\":" + m_typePtEnd.toJson();
            strJson += "}";
            return strJson;
        }

    }

    public static final String VIEW_NAME = "TraverseSummary";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_SURVEYID = "SurveyID";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_UPDATED = "Updated";
    public static final String FIELD_DESCRIPTION = "Description";
    public static final String FIELD_PTSTARTID = "ptStartID";
    public static final String FIELD_PTSTARTNAME = "ptStartName";
    public static final String FIELD_PTSTARTX = "ptStartX";
    public static final String FIELD_PTSTARTY = "ptStartY";
    public static final String FIELD_PTSTARTZ = "ptStartZ";
    public static final String FIELD_PTENDID = "ptEndID";
    public static final String FIELD_PTENDNAME = "ptEndName";
    public static final String FIELD_PTENDX = "ptEndX";
    public static final String FIELD_PTENDY = "ptEndY";
    public static final String FIELD_PTENDZ = "ptEndZ";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ITraverseSummary createTraverseSummary
    (
        int nID,
        int nSurveyID,
        String strName,
        LocalDateTime dateUpdated,
        String strDescription,
        int nPtStartID,
        String strPtStartName,
        double dPtStartX,
        double dPtStartY,
        double dPtStartZ,
        int nPtEndID,
        String strPtEndName,
        double dPtEndX,
        double dPtEndY,
        double dPtEndZ
    )
    {
        return new TraverseSummary
            (
                nID,
                nSurveyID,
                strName,
                dateUpdated,
                strDescription,
                nPtStartID,
                strPtStartName,
                dPtStartX,
                dPtStartY,
                dPtStartZ,
                nPtEndID,
                strPtEndName,
                dPtEndX,
                dPtEndY,
                dPtEndZ
            );
    }

    public static ITraverseSummary get(Connection connDb, int nIdGet) throws SQLException
    {
        ITraverseSummary typeReturn = null;
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
            List<ITraverseSummary> listRawData = new ArrayList<>();
            while (results.next())
            {
                listRawData.add
                    (
                        createTraverseSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getString(FIELD_NAME),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                            results.getString(FIELD_DESCRIPTION),
                            results.getInt(FIELD_PTSTARTID),
                            results.getString(FIELD_PTSTARTNAME),
                            results.getDouble(FIELD_PTSTARTX),
                            results.getDouble(FIELD_PTSTARTY),
                            results.getDouble(FIELD_PTSTARTZ),
                            results.getInt(FIELD_PTENDID),
                            results.getString(FIELD_PTENDNAME),
                            results.getDouble(FIELD_PTENDX),
                            results.getDouble(FIELD_PTENDY),
                            results.getDouble(FIELD_PTENDZ)
                        )
                    );
            }
            if(!listRawData.isEmpty())
            {
                Map<Integer, ITraverseSummary> mapData = listRawData.stream()
                        .collect(
                            Collectors.toMap(
                                view -> view.getID(),
                                view -> new TraverseSummary((TraverseSummary) view),
                                (viewInto, view) -> ((TraverseSummary) viewInto).add(view)
                            )
                        );

                typeReturn = mapData.get(listRawData.get(0).getID());
            }
            else
            {
                typeReturn = new TraverseSummary();
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

    public static List<ITraverseSummary> getForPathQuery(Connection connDb, int nSurveyID, int nID) throws SQLException
    {
        List<ITraverseSummary> listReturn = new ArrayList<ITraverseSummary>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectByPathKeyQuery(nSurveyID, nID));
            int nIndex = 1;
            if (nSurveyID > 0)
            {
                stmtSelect.setInt(nIndex++, nSurveyID);
            }
            if (nID > 0)
            {
                stmtSelect.setInt(nIndex++, nID);
            }

            results = stmtSelect.executeQuery();
            List<ITraverseSummary> listRawData = new ArrayList<ITraverseSummary>();
            while (results.next())
            {
                listRawData.add
                    (
                        createTraverseSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getString(FIELD_NAME),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                            results.getString(FIELD_DESCRIPTION),
                            results.getInt(FIELD_PTSTARTID),
                            results.getString(FIELD_PTSTARTNAME),
                            results.getDouble(FIELD_PTSTARTX),
                            results.getDouble(FIELD_PTSTARTY),
                            results.getDouble(FIELD_PTSTARTZ),
                            results.getInt(FIELD_PTENDID),
                            results.getString(FIELD_PTENDNAME),
                            results.getDouble(FIELD_PTENDX),
                            results.getDouble(FIELD_PTENDY),
                            results.getDouble(FIELD_PTENDZ)
                        )
                    );
            }

            if(!listRawData.isEmpty())
            {
                Map<Integer, ITraverseSummary> mapData = listRawData.stream()
                        .collect(
                            Collectors.toMap(
                                view -> view.getID(),
                                view -> new TraverseSummary((TraverseSummary) view),
                                (viewInto, view) -> ((TraverseSummary) viewInto).add(view)
                            )
                        );

                listReturn = mapData.values().stream()
                        .collect(Collectors.toList());
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

    private static String getSelectByPathKeyQuery(int nSurveyID, int nID)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_NAME + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_PTSTARTID + ",  " +
            FIELD_PTSTARTNAME + ",  " +
            FIELD_PTSTARTX + ",  " +
            FIELD_PTSTARTY + ",  " +
            FIELD_PTSTARTZ + ",  " +
            FIELD_PTENDID + ",  " +
            FIELD_PTENDNAME + ",  " +
            FIELD_PTENDX + ",  " +
            FIELD_PTENDY + ",  " +
            FIELD_PTENDZ
            + " FROM " +
            VIEW_NAME;
        String strWhere = "";
        if (nSurveyID > 0)
        {
            if (strWhere.isEmpty())
            {
                strWhere = " WHERE ";
            }
            else
            {
                strWhere += " AND ";
            }
            strWhere += FIELD_SURVEYID + " = ?";
        }
        if (nID > 0)
        {
            if (strWhere.isEmpty())
            {
                strWhere = " WHERE ";
            }
            else
            {
                strWhere += " AND ";
            }
            strWhere += FIELD_ID + " = ?";
        }

        if (!strWhere.isEmpty())
        {
            strSelect += strWhere;
        }
        return strSelect;
    }


    public static List<ITraverseSummary> getAll(Connection connDb) throws SQLException
    {
        List<ITraverseSummary> listReturn = new ArrayList<ITraverseSummary>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            List<ITraverseSummary> listRawData = new ArrayList<ITraverseSummary>();
            while (results.next())
            {
                listRawData.add
                    (
                        createTraverseSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getString(FIELD_NAME),
                            SQLiteConverter.convertStringToDateTime(results.getString(FIELD_UPDATED)),
                            results.getString(FIELD_DESCRIPTION),
                            results.getInt(FIELD_PTSTARTID),
                            results.getString(FIELD_PTSTARTNAME),
                            results.getDouble(FIELD_PTSTARTX),
                            results.getDouble(FIELD_PTSTARTY),
                            results.getDouble(FIELD_PTSTARTZ),
                            results.getInt(FIELD_PTENDID),
                            results.getString(FIELD_PTENDNAME),
                            results.getDouble(FIELD_PTENDX),
                            results.getDouble(FIELD_PTENDY),
                            results.getDouble(FIELD_PTENDZ)
                        )
                    );
            }
            if(!listRawData.isEmpty())
            {
                Map<Integer, ITraverseSummary> mapData = listRawData.stream()
                        .collect(
                            Collectors.toMap(
                                view -> view.getID(),
                                view -> new TraverseSummary((TraverseSummary) view),
                                (viewInto, view) -> ((TraverseSummary) viewInto).add(view)
                            )
                        );

                listReturn = mapData.values().stream()
                        .collect(Collectors.toList());
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

    private static String getSelectQuery(int nIdFor)
    {
        String strSelect = "SELECT " +
            FIELD_ID + ",  " +
            FIELD_SURVEYID + ",  " +
            FIELD_NAME + ",  " +
            FIELD_UPDATED + ",  " +
            FIELD_DESCRIPTION + ",  " +
            FIELD_PTSTARTID + ",  " +
            FIELD_PTSTARTNAME + ",  " +
            FIELD_PTSTARTX + ",  " +
            FIELD_PTSTARTY + ",  " +
            FIELD_PTSTARTZ + ",  " +
            FIELD_PTENDID + ",  " +
            FIELD_PTENDNAME + ",  " +
            FIELD_PTENDX + ",  " +
            FIELD_PTENDY + ",  " +
            FIELD_PTENDZ
            + " FROM " +
            VIEW_NAME;
        if (nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }

    private static String CREATE_VIEW_SCRIPT =         "CREATE VIEW TraverseSummary as " + 
        "select " + 
        "trav.ID as ID, " + 
        "trav.SurveyID as SurveyID, " + 
        "trav.Name as Name, " + 
        "trav.updated as Updated, " + 
        "trav.Description as Description, " + 
        "ptStart.ID as ptStartID, " + 
        "ptStart.Name as ptStartName, " + 
        "ptStart.X as ptStartX, " + 
        "ptStart.Y as ptStartY, " + 
        "ptStart.Z as ptStartZ, " + 
        "ptEnd.ID as ptEndID, " + 
        "ptEnd.Name as ptEndName, " + 
        "ptEnd.X as ptEndX, " + 
        "ptEnd.Y as ptEndY, " + 
        "ptEnd.Z as ptEndZ " + 
        "from " + 
        "Traverse trav " + 
        "inner join SurveyPoint as ptStart on trav.StartPointID = ptStart.ID " + 
        "inner join SurveyPoint as ptEnd on trav.EndPointID = ptEnd.ID;";
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
        for (String strScript : VIEW_EXTRA_SCRIPTS)
        {
            stmtExecute.execute(strScript);
        }
    }
}

