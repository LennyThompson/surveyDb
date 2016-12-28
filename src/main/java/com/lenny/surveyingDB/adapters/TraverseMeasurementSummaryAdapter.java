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
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary;


public class TraverseMeasurementSummaryAdapter
{
    // Class implements ITraverseMeasurementSummary but only accessible through the TraverseMeasurementSummaryAdapter

        static class TraverseMeasurementSummary_SurvMeas implements ITraverseMeasurementSummary_SurvMeas
        {
                static class SurvMeas_PtFrom implements ISurvMeas_PtFrom
                {

                    @SerializedName("ptFromID")
                     int m_nPtFromID;
                    @SerializedName("ptFromName")
                     String m_strPtFromName;
                    @SerializedName("ptFromX")
                     double m_dPtFromX;
                    @SerializedName("ptFromY")
                     double m_dPtFromY;
                    @SerializedName("ptFromZ")
                     double m_dPtFromZ;


                    public SurvMeas_PtFrom
                    (
                        int nPtFromID,
                        String strPtFromName,
                        double dPtFromX,
                        double dPtFromY,
                        double dPtFromZ
                    )
                    {
                        m_nPtFromID = nPtFromID;
                        m_strPtFromName = strPtFromName;
                        m_dPtFromX = dPtFromX;
                        m_dPtFromY = dPtFromY;
                        m_dPtFromZ = dPtFromZ;
                    }

                    public int getPtFromID()
                    {
                        return  m_nPtFromID;
                    }
                    public String getPtFromName()
                    {
                        return  m_strPtFromName;
                    }
                    public double getPtFromX()
                    {
                        return  m_dPtFromX;
                    }
                    public double getPtFromY()
                    {
                        return  m_dPtFromY;
                    }
                    public double getPtFromZ()
                    {
                        return  m_dPtFromZ;
                    }

                    public String toJson()
                    {
                        String strJson = "{";
                        strJson += "\"ptFromID\":" + m_nPtFromID + ",";
                        strJson += "\"ptFromName\":" + "\"" + m_strPtFromName + "\"" + ",";
                        strJson += "\"ptFromX\":" + m_dPtFromX + ",";
                        strJson += "\"ptFromY\":" + m_dPtFromY + ",";
                        strJson += "\"ptFromZ\":" + m_dPtFromZ;
                        strJson += "}";
                        return strJson;
                    }
                }
                static class SurvMeas_PtTo implements ISurvMeas_PtTo
                {

                    @SerializedName("ptToID")
                     int m_nPtToID;
                    @SerializedName("ptToName")
                     String m_strPtToName;
                    @SerializedName("ptToX")
                     double m_dPtToX;
                    @SerializedName("ptToY")
                     double m_dPtToY;
                    @SerializedName("ptToZ")
                     double m_dPtToZ;


                    public SurvMeas_PtTo
                    (
                        int nPtToID,
                        String strPtToName,
                        double dPtToX,
                        double dPtToY,
                        double dPtToZ
                    )
                    {
                        m_nPtToID = nPtToID;
                        m_strPtToName = strPtToName;
                        m_dPtToX = dPtToX;
                        m_dPtToY = dPtToY;
                        m_dPtToZ = dPtToZ;
                    }

                    public int getPtToID()
                    {
                        return  m_nPtToID;
                    }
                    public String getPtToName()
                    {
                        return  m_strPtToName;
                    }
                    public double getPtToX()
                    {
                        return  m_dPtToX;
                    }
                    public double getPtToY()
                    {
                        return  m_dPtToY;
                    }
                    public double getPtToZ()
                    {
                        return  m_dPtToZ;
                    }

                    public String toJson()
                    {
                        String strJson = "{";
                        strJson += "\"ptToID\":" + m_nPtToID + ",";
                        strJson += "\"ptToName\":" + "\"" + m_strPtToName + "\"" + ",";
                        strJson += "\"ptToX\":" + m_dPtToX + ",";
                        strJson += "\"ptToY\":" + m_dPtToY + ",";
                        strJson += "\"ptToZ\":" + m_dPtToZ;
                        strJson += "}";
                        return strJson;
                    }
                }


            @SerializedName("measID")
             int m_nMeasID;
            @SerializedName("Horizontal")
             double m_dHorizontal;
            @SerializedName("Vertical")
             double m_dVertical;
            @SerializedName("Bearing")
             double m_dBearing;
            @SerializedName("ptFrom")
             ISurvMeas_PtFrom m_typePtFrom;
            @SerializedName("ptTo")
             ISurvMeas_PtTo m_typePtTo;


            public TraverseMeasurementSummary_SurvMeas
            (
                int nMeasID,
                double dHorizontal,
                double dVertical,
                double dBearing,
                int nPtFromID,
                String strPtFromName,
                double dPtFromX,
                double dPtFromY,
                double dPtFromZ,
                int nPtToID,
                String strPtToName,
                double dPtToX,
                double dPtToY,
                double dPtToZ
            )
            {
                m_nMeasID = nMeasID;
                m_dHorizontal = dHorizontal;
                m_dVertical = dVertical;
                m_dBearing = dBearing;
                m_typePtFrom = new ISurvMeas_PtFrom
                                (
                                    int nPtFromID,
                                    String strPtFromName,
                                    double dPtFromX,
                                    double dPtFromY,
                                    double dPtFromZ
                                );


                m_typePtTo = new ISurvMeas_PtTo
                                (
                                    int nPtToID,
                                    String strPtToName,
                                    double dPtToX,
                                    double dPtToY,
                                    double dPtToZ
                                );

            }

            public int getMeasID()
            {
                return  m_nMeasID;
            }
            public double getHorizontal()
            {
                return  m_dHorizontal;
            }
            public double getVertical()
            {
                return  m_dVertical;
            }
            public double getBearing()
            {
                return  m_dBearing;
            }
            public ISurvMeas_PtFrom getPtFrom()
            {
                return  m_typePtFrom;
            }
            public ISurvMeas_PtTo getPtTo()
            {
                return  m_typePtTo;
            }

            public String toJson()
            {
                String strJson = "{";
                strJson += "\"measID\":" + m_nMeasID + ",";
                strJson += "\"Horizontal\":" + m_dHorizontal + ",";
                strJson += "\"Vertical\":" + m_dVertical + ",";
                strJson += "\"Bearing\":" + m_dBearing + ",";
                strJson += "\"ptFrom\":" + ((ISerialiseState) m_typePtFrom).toJson() + ",";
                strJson += "\"ptTo\":" + ((ISerialiseState) m_typePtTo).toJson();
                strJson += "}";
                return strJson;
            }
        }


    static class TraverseMeasurementSummary implements ITraverseMeasurementSummary
    {
        @SerializedName("ID")
         int m_nID;
        @SerializedName("SurveyID")
         int m_nSurveyID;
        @SerializedName("survMeas")
         List<ITraverseMeasurementSummary_SurvMeas> m_listSurvMeass;


        public TraverseMeasurementSummary
        (
            int nID,
            int nSurveyID,
            int nMeasID,
            double dHorizontal,
            double dVertical,
            double dBearing,
            int nPtFromID,
            String strPtFromName,
            double dPtFromX,
            double dPtFromY,
            double dPtFromZ,
            int nPtToID,
            String strPtToName,
            double dPtToX,
            double dPtToY,
            double dPtToZ
        )
        {
            m_nID = nID;
            m_nSurveyID = nSurveyID;

            m_listSurvMeass = new ArrayList<>();
            m_listSurvMeass.add(
                        new 
                        (
                            int nMeasID,
                            double dHorizontal,
                            double dVertical,
                            double dBearing,
                            int nPtFromID,
                            String strPtFromName,
                            double dPtFromX,
                            double dPtFromY,
                            double dPtFromZ,
                            int nPtToID,
                            String strPtToName,
                            double dPtToX,
                            double dPtToY,
                            double dPtToZ
                        )
                    );

        }

        TraverseMeasurementSummary(TraverseMeasurementSummary viewFrom)
        {
            m_nID = viewFrom.m_nID;
            m_nSurveyID = viewFrom.m_nSurveyID;
            m_listSurvMeass = viewFrom.m_listSurvMeass;

        }

        public int getID()
        {
            return  m_nID;
        }
        public int getSurveyID()
        {
            return  m_nSurveyID;
        }
        public List<ITraverseMeasurementSummary_SurvMeas> getSurvMeass()
        {
            return  m_listSurvMeass;
        }


        // Used by stream collector to aggregate like instances together

        public TraverseMeasurementSummary add(TraverseMeasurementSummary newType)
        {
            if
            (
                newType.m_listSurvMeass.size() > 0
                &&
                !m_listSurvMeass.stream()
                    .filter(member -> member.m_nMeasID == newType.m_listSurvMeass.get(0).m_nMeasID)
                    .isPresent()
            )
            {
                m_listSurvMeass.add(newType.m_listSurvMeass.get(0));
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
            strJson += "\"SurveyID\":" + m_nSurveyID + ",";
            strJson += "\"survMeas\":[" + m_listSurvMeass.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]";
            strJson += "}";
            return strJson;
        }

    }

    public static final String VIEW_NAME = "TraverseMeasurementSummary";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_SURVEYID = "SurveyID";
    public static final String FIELD_MEASID = "measID";
    public static final String FIELD_HORIZONTAL = "Horizontal";
    public static final String FIELD_VERTICAL = "Vertical";
    public static final String FIELD_BEARING = "Bearing";
    public static final String FIELD_PTFROMID = "ptFromID";
    public static final String FIELD_PTFROMNAME = "ptFromName";
    public static final String FIELD_PTFROMX = "ptFromX";
    public static final String FIELD_PTFROMY = "ptFromY";
    public static final String FIELD_PTFROMZ = "ptFromZ";
    public static final String FIELD_PTTOID = "ptToID";
    public static final String FIELD_PTTONAME = "ptToName";
    public static final String FIELD_PTTOX = "ptToX";
    public static final String FIELD_PTTOY = "ptToY";
    public static final String FIELD_PTTOZ = "ptToZ";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ITraverseMeasurementSummary createTraverseMeasurementSummary
    (
        int nID,
        int nSurveyID,
        int nMeasID,
        double dHorizontal,
        double dVertical,
        double dBearing,
        int nPtFromID,
        String strPtFromName,
        double dPtFromX,
        double dPtFromY,
        double dPtFromZ,
        int nPtToID,
        String strPtToName,
        double dPtToX,
        double dPtToY,
        double dPtToZ
    )
    {
        return new TraverseMeasurementSummary
            (
                nID,
                nSurveyID,
                nMeasID,
                dHorizontal,
                dVertical,
                dBearing,
                nPtFromID,
                strPtFromName,
                dPtFromX,
                dPtFromY,
                dPtFromZ,
                nPtToID,
                strPtToName,
                dPtToX,
                dPtToY,
                dPtToZ
            );
    }

    public static ITraverseMeasurementSummary get(Connection connDb, int nIdGet) throws SQLException
    {
        ITraverseMeasurementSummary typeReturn = null;
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
            List<TraverseMeasurementSummary> listRawData = new ArrayList<>();
            while(results.next())
            {
                listRawData.add
                    (
                        createTraverseMeasurementSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getInt(FIELD_MEASID),
                            results.getDouble(FIELD_HORIZONTAL),
                            results.getDouble(FIELD_VERTICAL),
                            results.getDouble(FIELD_BEARING),
                            results.getInt(FIELD_PTFROMID),
                            results.getString(FIELD_PTFROMNAME),
                            results.getDouble(FIELD_PTFROMX),
                            results.getDouble(FIELD_PTFROMY),
                            results.getDouble(FIELD_PTFROMZ),
                            results.getInt(FIELD_PTTOID),
                            results.getString(FIELD_PTTONAME),
                            results.getDouble(FIELD_PTTOX),
                            results.getDouble(FIELD_PTTOY),
                            results.getDouble(FIELD_PTTOZ)
                        )
                    );
            }
            Map<Integer, TraverseMeasurementSummary> mapData = listRawData.stream()
                    .collect(
                        Collectors.toMap(
                            view -> view.m_,
                            view -> new TraverseMeasurementSummary(view),
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

    public static List<ITraverseMeasurementSummary> getAll(Connection connDb) throws SQLException
    {
        List<ITraverseMeasurementSummary> listReturn = new ArrayList<ITraverseMeasurementSummary>();
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
                        createTraverseMeasurementSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getInt(FIELD_MEASID),
                            results.getDouble(FIELD_HORIZONTAL),
                            results.getDouble(FIELD_VERTICAL),
                            results.getDouble(FIELD_BEARING),
                            results.getInt(FIELD_PTFROMID),
                            results.getString(FIELD_PTFROMNAME),
                            results.getDouble(FIELD_PTFROMX),
                            results.getDouble(FIELD_PTFROMY),
                            results.getDouble(FIELD_PTFROMZ),
                            results.getInt(FIELD_PTTOID),
                            results.getString(FIELD_PTTONAME),
                            results.getDouble(FIELD_PTTOX),
                            results.getDouble(FIELD_PTTOY),
                            results.getDouble(FIELD_PTTOZ)
                        )
                    );
            }
            Map<Integer, TraverseMeasurementSummary> mapData = listRawData.stream()
                    .collect(
                        Collectors.toMap(
                            view -> view.m_,
                            view -> new TraverseMeasurementSummary(view),
                            (viewInto, view) -> viewInto.add(view)
                        )
                    );
            listReturn = mapData.values().stream()
                    .map(value -> (ITraverseMeasurementSummary) value)
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
            FIELD_SURVEYID + ",  " +
            FIELD_MEASID + ",  " +
            FIELD_HORIZONTAL + ",  " +
            FIELD_VERTICAL + ",  " +
            FIELD_BEARING + ",  " +
            FIELD_PTFROMID + ",  " +
            FIELD_PTFROMNAME + ",  " +
            FIELD_PTFROMX + ",  " +
            FIELD_PTFROMY + ",  " +
            FIELD_PTFROMZ + ",  " +
            FIELD_PTTOID + ",  " +
            FIELD_PTTONAME + ",  " +
            FIELD_PTTOX + ",  " +
            FIELD_PTTOY + ",  " +
            FIELD_PTTOZ
            + " FROM " +
            VIEW_NAME;
        if(nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }

    private static String CREATE_VIEW_SCRIPT =         "CREATE VIEW TraverseMeasurementSummary as " + 
        "select " + 
        "trav.ID as ID, " + 
        "trav.SurveyID as SurveyID, " + 
        "survMeas.ID as measID, " + 
        "survMeas.HorizDistance as Horizontal, " + 
        "survMeas.VertDistance as Vertical, " + 
        "survMeas.Bearing as Bearing, " + 
        "ptFrom.ID as ptFromID, " + 
        "ptFrom.Name as ptFromName, " + 
        "ptFrom.X as ptFromX, " + 
        "ptFrom.Y as ptFromY, " + 
        "ptFrom.Z as ptFromZ, " + 
        "ptTo.ID as ptToID, " + 
        "ptTo.Name as ptToName, " + 
        "ptTo.X as ptToX, " + 
        "ptTo.Y as ptToY, " + 
        "ptTo.Z as ptToZ " + 
        "from " + 
        "Traverse trav " + 
        "inner join TraverseMeasurement as link on link.TraverseID = trav.ID " + 
        "inner join SurveyMeasurement as survMeas on survMeas.ID = link.MeasurementID " + 
        "inner join SurveyPoint as ptFrom on survMeas.FromPtID = ptFrom.ID " + 
        "inner join SurveyPoint as ptTo on survMeas.ToPtID = ptTo.ID;";
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
