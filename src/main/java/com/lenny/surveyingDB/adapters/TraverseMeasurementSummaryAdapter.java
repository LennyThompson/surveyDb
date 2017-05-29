// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sat May 13 12:52:41 AEST 2017

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
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary;
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary.*;


public class TraverseMeasurementSummaryAdapter
{
    // Class implements ITraverseMeasurementSummary but only accessible through the TraverseMeasurementSummaryAdapter

        static class TraverseMeasurementSummary_SurvMeas
                implements ITraverseMeasurementSummary_SurvMeas
        {
                static class SurvMeas_PtFrom
                        implements ITraverseMeasurementSummary_SurvMeas.ISurvMeas_PtFrom
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


                    SurvMeas_PtFrom()
                    {
                        m_nPtFromID = 0;
                        m_strPtFromName = "";
                        m_dPtFromX = 0.0;
                        m_dPtFromY = 0.0;
                        m_dPtFromZ = 0.0;
                    }
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

                    @Override
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
                static class SurvMeas_PtTo
                        implements ITraverseMeasurementSummary_SurvMeas.ISurvMeas_PtTo
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


                    SurvMeas_PtTo()
                    {
                        m_nPtToID = 0;
                        m_strPtToName = "";
                        m_dPtToX = 0.0;
                        m_dPtToY = 0.0;
                        m_dPtToZ = 0.0;
                    }
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

                    @Override
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


            TraverseMeasurementSummary_SurvMeas()
            {
                m_nMeasID = 0;
                m_dHorizontal = 0.0;
                m_dVertical = 0.0;
                m_dBearing = 0.0;
                m_typePtFrom = new SurvMeas_PtFrom();


                m_typePtTo = new SurvMeas_PtTo();

            }
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
                m_typePtFrom = new SurvMeas_PtFrom
                                (
                                    nPtFromID,
                                    strPtFromName,
                                    dPtFromX,
                                    dPtFromY,
                                    dPtFromZ
                                );


                m_typePtTo = new SurvMeas_PtTo
                                (
                                    nPtToID,
                                    strPtToName,
                                    dPtToX,
                                    dPtToY,
                                    dPtToZ
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

            @Override
            public String toJson()
            {
                String strJson = "{";
                strJson += "\"measID\":" + m_nMeasID + ",";
                strJson += "\"Horizontal\":" + m_dHorizontal + ",";
                strJson += "\"Vertical\":" + m_dVertical + ",";
                strJson += "\"Bearing\":" + m_dBearing + ",";
                strJson += "\"ptFrom\":" + m_typePtFrom.toJson() + ",";
                strJson += "\"ptTo\":" + m_typePtTo.toJson();
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
        @SerializedName("Name")
         String m_strName;
        @SerializedName("survMeas")
         List<ITraverseMeasurementSummary_SurvMeas> m_listSurvMeass;


        TraverseMeasurementSummary()
        {
            m_nID = 0;
            m_nSurveyID = 0;
            m_strName = "";

            m_listSurvMeass = new ArrayList<>();

        }

        public TraverseMeasurementSummary
        (
            int nID,
            int nSurveyID,
            String strName,
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
            m_strName = strName;

            m_listSurvMeass = new ArrayList<>();
            if(nMeasID != 0)
            {
            m_listSurvMeass.add(
                        new TraverseMeasurementSummary_SurvMeas
                        (
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
                        )
                    );
            }

        }

        TraverseMeasurementSummary(TraverseMeasurementSummary viewFrom)
        {
            m_nID = viewFrom.m_nID;
            m_nSurveyID = viewFrom.m_nSurveyID;
            m_strName = viewFrom.m_strName;
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
        public String getName()
        {
            return  m_strName;
        }
        public List<ITraverseMeasurementSummary_SurvMeas> getSurvMeass()
        {
            return  m_listSurvMeass;
        }


        // Used by stream collector to aggregate like instances together

        public TraverseMeasurementSummary add(ITraverseMeasurementSummary newType)
        {
            if
            (
                newType.getSurvMeass().size() > 0
                &&
                !m_listSurvMeass.stream()
                    .anyMatch(member -> member.getMeasID() == newType.getSurvMeass().get(0).getMeasID())
            )
            {
                m_listSurvMeass.add(newType.getSurvMeass().get(0));
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
            strJson += "\"Name\":" + "\"" + m_strName + "\"" + ",";
            strJson += "\"survMeas\":[" + m_listSurvMeass.stream().map(item -> item.toJson()).collect(Collectors.joining(",")) + "]";
            strJson += "}";
            return strJson;
        }

    }

    public static final String VIEW_NAME = "TraverseMeasurementSummary";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_SURVEYID = "SurveyID";
    public static final String FIELD_NAME = "Name";
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
        String strName,
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
                strName,
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
            if (nIdGet > 0)
            {
                stmtSelect.setInt(1, nIdGet);
            }
            results = stmtSelect.executeQuery();
            List<ITraverseMeasurementSummary> listRawData = new ArrayList<>();
            while (results.next())
            {
                listRawData.add
                    (
                        createTraverseMeasurementSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getString(FIELD_NAME),
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
            if(!listRawData.isEmpty())
            {
                Map<Integer, ITraverseMeasurementSummary> mapData = listRawData.stream()
                        .collect(
                            Collectors.toMap(
                                view -> view.getID(),
                                view -> new TraverseMeasurementSummary((TraverseMeasurementSummary) view),
                                (viewInto, view) -> ((TraverseMeasurementSummary) viewInto).add(view)
                            )
                        );

                typeReturn = mapData.get(listRawData.get(0).getID());
            }
            else
            {
                typeReturn = new TraverseMeasurementSummary();
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

    public static List<ITraverseMeasurementSummary> getForPathQuery(Connection connDb, int nSurveyID, int nID) throws SQLException
    {
        List<ITraverseMeasurementSummary> listReturn = new ArrayList<ITraverseMeasurementSummary>();
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
            List<ITraverseMeasurementSummary> listRawData = new ArrayList<ITraverseMeasurementSummary>();
            while (results.next())
            {
                listRawData.add
                    (
                        createTraverseMeasurementSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getString(FIELD_NAME),
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

            if(!listRawData.isEmpty())
            {
                Map<Integer, ITraverseMeasurementSummary> mapData = listRawData.stream()
                        .collect(
                            Collectors.toMap(
                                view -> view.getID(),
                                view -> new TraverseMeasurementSummary((TraverseMeasurementSummary) view),
                                (viewInto, view) -> ((TraverseMeasurementSummary) viewInto).add(view)
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


    public static List<ITraverseMeasurementSummary> getAll(Connection connDb) throws SQLException
    {
        List<ITraverseMeasurementSummary> listReturn = new ArrayList<ITraverseMeasurementSummary>();
        PreparedStatement stmtSelect = null;
        ResultSet results = null;
        try
        {
            stmtSelect = connDb.prepareStatement(getSelectQuery(-1));
            results = stmtSelect.executeQuery();
            List<ITraverseMeasurementSummary> listRawData = new ArrayList<ITraverseMeasurementSummary>();
            while (results.next())
            {
                listRawData.add
                    (
                        createTraverseMeasurementSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_SURVEYID),
                            results.getString(FIELD_NAME),
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
            if(!listRawData.isEmpty())
            {
                Map<Integer, ITraverseMeasurementSummary> mapData = listRawData.stream()
                        .collect(
                            Collectors.toMap(
                                view -> view.getID(),
                                view -> new TraverseMeasurementSummary((TraverseMeasurementSummary) view),
                                (viewInto, view) -> ((TraverseMeasurementSummary) viewInto).add(view)
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
        if (nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }

    private static String CREATE_VIEW_SCRIPT =         "CREATE VIEW TraverseMeasurementSummary as " + 
        "select " + 
        "trav.ID as ID, " + 
        "trav.SurveyID as SurveyID, " + 
        "trav.Name as Name, " + 
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
        "left join TraverseMeasurement as link on link.TraverseID = trav.ID " + 
        "left join SurveyMeasurement as survMeas on survMeas.ID = link.MeasurementID " + 
        "left join SurveyPoint as ptFrom on survMeas.FromPtID = ptFrom.ID " + 
        "left join SurveyPoint as ptTo on survMeas.ToPtID = ptTo.ID;";
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

