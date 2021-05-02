// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun May 02 10:25:13 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.interfaces.ISurveyAdjustment;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.SurveyAdjustmentAdapter;
import com.lenny.surveyingDB.interfaces.ITraverse;


public interface ISurveyMeasurement
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    double getHorizDistance();
    double getVertDistance();
    double getBearing();

    ISurveyPoint getPointFrom();
    ISurveyPoint getPointTo();
    ISurveyAdjustment getAdjustment();

    void setHorizDistance(double dSet);
    void setVertDistance(double dSet);
    void setBearing(double dSet);

    void setPointFrom(ISurveyPoint typeSet);
    void setPointTo(ISurveyPoint typeSet);
    void setAdjustment(ISurveyAdjustment typeSet);

}
