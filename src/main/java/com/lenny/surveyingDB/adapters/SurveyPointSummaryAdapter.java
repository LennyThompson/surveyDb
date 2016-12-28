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
import com.lenny.surveyingDB.interfaces.ISurveyPointSummary;


public class SurveyPointSummaryAdapter
{
    // Class implements ISurveyPointSummary but only accessible through the SurveyPointSummaryAdapter

        static class SurveyPointSummary_Pt implements ISurveyPointSummary_Pt
        {
                static class Pt_PtType implements IPt_PtType
                {

                    @SerializedName("ptTypeName")
                     String m_strPtTypeName;
                    @SerializedName("ptTypeAbbreviation")
                     String m_strPtTypeAbbreviation;


                    public Pt_PtType
                    (
                        String strPtTypeName,
                        String strPtTypeAbbreviation
                    )
                    {
                        m_strPtTypeName = strPtTypeName;
                        m_strPtTypeAbbreviation = strPtTypeAbbreviation;
                    }

                    public String getPtTypeName()
                    {
                        return  m_strPtTypeName;
                    }
                    public String getPtTypeAbbreviation()
                    {
                        return  m_strPtTypeAbbreviation;
                    }

                    public String toJson()
                    {
                        String strJson = "{";
                        strJson += "\"ptTypeName\":" + "\"" + m_strPtTypeName + "\"" + ",";
                        strJson += "\"ptTypeAbbreviation\":" + "\"" + m_strPtTypeAbbreviation + "\"";
                        strJson += "}";
                        return strJson;
                    }
                }
                static class Pt_Ref implements IPt_Ref
                {

                    @SerializedName("refName")
                     String m_strRefName;
                    @SerializedName("refDescription")
                     String m_strRefDescription;


                    public Pt_Ref
                    (
                        String strRefName,
                        String strRefDescription
                    )
                    {
                        m_strRefName = strRefName;
                        m_strRefDescription = strRefDescription;
                    }

                    public String getRefName()
                    {
                        return  m_strRefName;
                    }
                    public String getRefDescription()
                    {
                        return  m_strRefDescription;
                    }

                    public String toJson()
                    {
                        String strJson = "{";
                        strJson += "\"refName\":" + "\"" + m_strRefName + "\"" + ",";
                        strJson += "\"refDescription\":" + "\"" + m_strRefDescription + "\"";
                        strJson += "}";
                        return strJson;
                    }
                }


            @SerializedName("ptID")
             int m_nPtID;
            @SerializedName("ptName")
             String m_strPtName;
            @SerializedName("ptDesc")
             String m_strPtDesc;
            @SerializedName("X")
             double m_dX;
            @SerializedName("Y")
             double m_dY;
            @SerializedName("Z")
             double m_dZ;
            @SerializedName("ptType")
             IPt_PtType m_typePtType;
            @SerializedName("ref")
             IPt_Ref m_typeRef;


            public SurveyPointSummary_Pt
            (
                int nPtID,
                String strPtName,
                String strPtDesc,
                double dX,
                double dY,
                double dZ,
                String strPtTypeName,
                String strPtTypeAbbreviation,
                String strRefName,
                String strRefDescription
            )
            {
                m_nPtID = nPtID;
                m_strPtName = strPtName;
                m_strPtDesc = strPtDesc;
                m_dX = dX;
                m_dY = dY;
                m_dZ = dZ;
                m_typePtType = new IPt_PtType
                                (
                                    String strPtTypeName,
                                    String strPtTypeAbbreviation
                                );


                m_typeRef = new IPt_Ref
                                (
                                    String strRefName,
                                    String strRefDescription
                                );

            }

            public int getPtID()
            {
                return  m_nPtID;
            }
            public String getPtName()
            {
                return  m_strPtName;
            }
            public String getPtDesc()
            {
                return  m_strPtDesc;
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
            public IPt_PtType getPtType()
            {
                return  m_typePtType;
            }
            public IPt_Ref getRef()
            {
                return  m_typeRef;
            }

            public String toJson()
            {
                String strJson = "{";
                strJson += "\"ptID\":" + m_nPtID + ",";
                strJson += "\"ptName\":" + "\"" + m_strPtName + "\"" + ",";
                strJson += "\"ptDesc\":" + "\"" + m_strPtDesc + "\"" + ",";
                strJson += "\"X\":" + m_dX + ",";
                strJson += "\"Y\":" + m_dY + ",";
                strJson += "\"Z\":" + m_dZ + ",";
                strJson += "\"ptType\":" + ((ISerialiseState) m_typePtType).toJson() + ",";
                strJson += "\"ref\":" + ((ISerialiseState) m_typeRef).toJson();
                strJson += "}";
                return strJson;
            }
        }


    static class SurveyPointSummary implements ISurveyPointSummary
    {
        @SerializedName("ID")
         int m_nID;
        @SerializedName("pt")
         List<ISurveyPointSummary_Pt> m_listPts;


        public SurveyPointSummary
        (
            int nID,
            int nPtID,
            String strPtName,
            String strPtDesc,
            double dX,
            double dY,
            double dZ,
            String strPtTypeName,
            String strPtTypeAbbreviation,
            String strRefName,
            String strRefDescription
        )
        {
            m_nID = nID;

            m_listPts = new ArrayList<>();
            m_listPts.add(
                        new 
                        (
                            int nPtID,
                            String strPtName,
                            String strPtDesc,
                            double dX,
                            double dY,
                            double dZ,
                            String strPtTypeName,
                            String strPtTypeAbbreviation,
                            String strRefName,
                            String strRefDescription
                        )
                    );

        }

        SurveyPointSummary(SurveyPointSummary viewFrom)
        {
            m_nID = viewFrom.m_nID;
            m_listPts = viewFrom.m_listPts;

        }

        public int getID()
        {
            return  m_nID;
        }
        public List<ISurveyPointSummary_Pt> getPts()
        {
            return  m_listPts;
        }


        // Used by stream collector to aggregate like instances together

        public SurveyPointSummary add(SurveyPointSummary newType)
        {
            if
            (
                newType.m_listPts.size() > 0
                &&
                !m_listPts.stream()
                    .filter(member -> member.m_nPtID == newType.m_listPts.get(0).m_nPtID)
                    .isPresent()
            )
            {
                m_listPts.add(newType.m_listPts.get(0));
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
            strJson += "\"pt\":[" + m_listPts.stream().map(item -> ((ISerialiseState) item).toJson()).collect(Collectors.joining(",")) + "]";
            strJson += "}";
            return strJson;
        }

    }

    public static final String VIEW_NAME = "SurveyPointSummary";
    public static final String FIELD_ID = "ID";
    public static final String FIELD_PTID = "ptID";
    public static final String FIELD_PTNAME = "ptName";
    public static final String FIELD_PTDESC = "ptDesc";
    public static final String FIELD_X = "X";
    public static final String FIELD_Y = "Y";
    public static final String FIELD_Z = "Z";
    public static final String FIELD_PTTYPENAME = "ptTypeName";
    public static final String FIELD_PTTYPEABBREVIATION = "ptTypeAbbreviation";
    public static final String FIELD_REFNAME = "refName";
    public static final String FIELD_REFDESCRIPTION = "refDescription";

    public static final String PRIMARY_KEY = FIELD_ID;

    public static ISurveyPointSummary createSurveyPointSummary
    (
        int nID,
        int nPtID,
        String strPtName,
        String strPtDesc,
        double dX,
        double dY,
        double dZ,
        String strPtTypeName,
        String strPtTypeAbbreviation,
        String strRefName,
        String strRefDescription
    )
    {
        return new SurveyPointSummary
            (
                nID,
                nPtID,
                strPtName,
                strPtDesc,
                dX,
                dY,
                dZ,
                strPtTypeName,
                strPtTypeAbbreviation,
                strRefName,
                strRefDescription
            );
    }

    public static ISurveyPointSummary get(Connection connDb, int nIdGet) throws SQLException
    {
        ISurveyPointSummary typeReturn = null;
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
            List<SurveyPointSummary> listRawData = new ArrayList<>();
            while(results.next())
            {
                listRawData.add
                    (
                        createSurveyPointSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_PTID),
                            results.getString(FIELD_PTNAME),
                            results.getString(FIELD_PTDESC),
                            results.getDouble(FIELD_X),
                            results.getDouble(FIELD_Y),
                            results.getDouble(FIELD_Z),
                            results.getString(FIELD_PTTYPENAME),
                            results.getString(FIELD_PTTYPEABBREVIATION),
                            results.getString(FIELD_REFNAME),
                            results.getString(FIELD_REFDESCRIPTION)
                        )
                    );
            }
            Map<Integer, SurveyPointSummary> mapData = listRawData.stream()
                    .collect(
                        Collectors.toMap(
                            view -> view.m_,
                            view -> new SurveyPointSummary(view),
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

    public static List<ISurveyPointSummary> getAll(Connection connDb) throws SQLException
    {
        List<ISurveyPointSummary> listReturn = new ArrayList<ISurveyPointSummary>();
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
                        createSurveyPointSummary
                        (
                            results.getInt(FIELD_ID),
                            results.getInt(FIELD_PTID),
                            results.getString(FIELD_PTNAME),
                            results.getString(FIELD_PTDESC),
                            results.getDouble(FIELD_X),
                            results.getDouble(FIELD_Y),
                            results.getDouble(FIELD_Z),
                            results.getString(FIELD_PTTYPENAME),
                            results.getString(FIELD_PTTYPEABBREVIATION),
                            results.getString(FIELD_REFNAME),
                            results.getString(FIELD_REFDESCRIPTION)
                        )
                    );
            }
            Map<Integer, SurveyPointSummary> mapData = listRawData.stream()
                    .collect(
                        Collectors.toMap(
                            view -> view.m_,
                            view -> new SurveyPointSummary(view),
                            (viewInto, view) -> viewInto.add(view)
                        )
                    );
            listReturn = mapData.values().stream()
                    .map(value -> (ISurveyPointSummary) value)
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
            FIELD_PTID + ",  " +
            FIELD_PTNAME + ",  " +
            FIELD_PTDESC + ",  " +
            FIELD_X + ",  " +
            FIELD_Y + ",  " +
            FIELD_Z + ",  " +
            FIELD_PTTYPENAME + ",  " +
            FIELD_PTTYPEABBREVIATION + ",  " +
            FIELD_REFNAME + ",  " +
            FIELD_REFDESCRIPTION
            + " FROM " +
            VIEW_NAME;
        if(nIdFor > 0)
        {
            strSelect += " WHERE " + PRIMARY_KEY + " = ?";
        }
        return strSelect;
    }

    private static String CREATE_VIEW_SCRIPT =         "CREATE VIEW SurveyPointSummary as " + 
        "select " + 
        "surv.ID as ID, " + 
        "pt.ID as ptID, " + 
        "pt.Name as ptName, " + 
        "pt.Description as ptDesc, " + 
        "pt.X as X, " + 
        "pt.Y as Y, " + 
        "pt.Z as Z, " + 
        "ptType.Name as ptTypeName, " + 
        "ptType.Abbreviation as ptTypeAbbreviation, " + 
        "ref.Name as refName, " + 
        "ref.Description as refDescription " + 
        "from " + 
        "Survey surv " + 
        "inner join SurveyPointLink as link on link.SurveyID = surv.ID " + 
        "inner join SurveyPoint as pt on pt.ID = link.SurveyPointID " + 
        "inner join SurveyPointType as ptType on ptType.ID = pt.PointTypeID " + 
        "inner join SurveyReference as ref on ref.ID = pt.RefID;";
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

