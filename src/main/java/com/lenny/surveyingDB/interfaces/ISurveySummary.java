// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ISurveySummary;


public interface ISurveySummary extends ISerialiseState
{
    public interface ISurveySummary_Proj
    {
        int getProjID();
        String getProjName();

    }
    public interface ISurveySummary_Trav
    {
        int getTravID();
        String getTravName();
        Date getTravUpdated();
        String getPtTravStart();
        String getPtTravEnd();

    }
    public interface ISurveySummary_PtSurv
    {
        int getPtID();
        String getPtName();
        double getPtX();
        double getPtY();
        double getPtZ();

    }

    int getID();
    String getName();
    Date getCreated();
    Date getUpdated();
    String getDescription();
    ISurveySummary_Proj getProj();
    List<ISurveySummary_Trav> getTravs();
    List<ISurveySummary_PtSurv> getPtSurvs();

}
