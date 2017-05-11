// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon May 08 10:06:02 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.lenny.Utils.ISerialiseState;
import com.lenny.surveyingDB.interfaces.ITraverseSummary;
import com.lenny.surveyingDB.interfaces.ITraverseSummary.*;


public interface ITraverseSummary extends ISerialiseState
{
    public interface ITraverseSummary_PtStart
    {
        int getPtStartID();
        String getPtStartName();
        double getPtStartX();
        double getPtStartY();
        double getPtStartZ();

        String toJson();
    }
    public interface ITraverseSummary_PtEnd
    {
        int getPtEndID();
        String getPtEndName();
        double getPtEndX();
        double getPtEndY();
        double getPtEndZ();

        String toJson();
    }

    int getID();
    int getSurveyID();
    String getName();
    LocalDateTime getUpdated();
    String getDescription();
    ITraverseSummary_PtStart getPtStart();
    ITraverseSummary_PtEnd getPtEnd();

}
