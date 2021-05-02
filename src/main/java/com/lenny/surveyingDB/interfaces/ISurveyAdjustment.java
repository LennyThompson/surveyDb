// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun May 02 10:25:13 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;


public interface ISurveyAdjustment
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    double getDeltaX();
    double getDeltaY();
    double getDeltaZ();
    double getBearingAdj();

    void setDeltaX(double dSet);
    void setDeltaY(double dSet);
    void setDeltaZ(double dSet);
    void setBearingAdj(double dSet);

}
