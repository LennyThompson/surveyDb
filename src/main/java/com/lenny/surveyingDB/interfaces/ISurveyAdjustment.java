// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 15:32:27 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;


public interface ISurveyAdjustment
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
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
