// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun May 02 10:25:13 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import java.util.List;
import com.lenny.Utils.ISerialiseState;
import com.lenny.surveyingDB.interfaces.ISurveySummary;
import com.lenny.surveyingDB.interfaces.ISurveySummary.*;


public interface ISurveySummary extends ISerialiseState
{
    public interface ISurveySummary_Proj
    {
        int getProjID();
        String getProjName();

        String toJson();
    }
    public interface ISurveySummary_Trav
    {
        int getTravID();
        String getTravName();
        OffsetDateTime getTravUpdated();
        String getPtTravStart();
        String getPtTravEnd();

        String toJson();
    }
    public interface ISurveySummary_PtSurv
    {
        int getPtID();
        String getPtName();
        double getPtX();
        double getPtY();
        double getPtZ();

        String toJson();
    }

    int getID();
    String getName();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    String getDescription();
    ISurveySummary_Proj getProj();
    List<ISurveySummary_Trav> getTravs();
    List<ISurveySummary_PtSurv> getPtSurvs();

}
