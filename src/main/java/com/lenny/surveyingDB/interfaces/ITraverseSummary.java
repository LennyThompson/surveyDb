// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 01 10:59:55 AEST 2017

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

    }
    public interface ITraverseSummary_PtEnd
    {
        int getPtEndID();
        String getPtEndName();
        double getPtEndX();
        double getPtEndY();
        double getPtEndZ();

    }

    int getID();
    int getSurveyID();
    String getName();
    LocalDateTime getUpdated();
    String getDescription();
    ITraverseSummary_PtStart getPtStart();
    ITraverseSummary_PtEnd getPtEnd();

}
