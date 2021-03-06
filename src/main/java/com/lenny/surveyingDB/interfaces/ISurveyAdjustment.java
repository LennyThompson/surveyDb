// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 10 14:31:05 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;


public interface ISurveyAdjustment
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
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
