// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ITraverseSummary;


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
    Date getUpdated();
    String getDescription();
    ITraverseSummary_PtStart getPtStart();
    ITraverseSummary_PtEnd getPtEnd();

}
