// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 01 10:59:55 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.lenny.Utils.ISerialiseState;
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary;
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary.*;


public interface ITraverseMeasurementSummary extends ISerialiseState
{
    public interface ITraverseMeasurementSummary_SurvMeas
    {
        int getMeasID();
        double getHorizontal();
        double getVertical();
        double getBearing();
        ISurvMeas_PtFrom getPtFrom();
        ISurvMeas_PtTo getPtTo();

        public interface ISurvMeas_PtFrom
        {
            int getPtFromID();
            String getPtFromName();
            double getPtFromX();
            double getPtFromY();
            double getPtFromZ();

        }
        public interface ISurvMeas_PtTo
        {
            int getPtToID();
            String getPtToName();
            double getPtToX();
            double getPtToY();
            double getPtToZ();

        }

    }

    int getID();
    int getSurveyID();
    List<ITraverseMeasurementSummary_SurvMeas> getSurvMeass();

}
