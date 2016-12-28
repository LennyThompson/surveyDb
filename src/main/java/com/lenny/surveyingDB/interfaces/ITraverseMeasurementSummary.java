// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary;


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
