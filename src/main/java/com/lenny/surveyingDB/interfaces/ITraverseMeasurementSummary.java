// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:54 AEST 2018

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

            String toJson();
        }
        public interface ISurvMeas_PtTo
        {
            int getPtToID();
            String getPtToName();
            double getPtToX();
            double getPtToY();
            double getPtToZ();

            String toJson();
        }

        String toJson();
    }

    int getID();
    int getSurveyID();
    String getName();
    List<ITraverseMeasurementSummary_SurvMeas> getSurvMeass();

}
