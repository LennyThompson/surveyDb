// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;


public interface ISurveyAdjustment
{
    int getID();
    Date getCreated();
    Date getUpdated();
    double getDeltaX();
    double getDeltaY();
    double getDeltaZ();
    double getBearingAdj();

    ISurveyMeasurement getMeasurement();

    void setDeltaX(double dSet);
    void setDeltaY(double dSet);
    void setDeltaZ(double dSet);
    void setBearingAdj(double dSet);

    void setMeasurement(ISurveyMeasurement typeSet);

}
