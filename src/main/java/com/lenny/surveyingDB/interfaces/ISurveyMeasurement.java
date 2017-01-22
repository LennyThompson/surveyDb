// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 22 21:26:42 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ITraverse;


public interface ISurveyMeasurement
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    double getHorizDistance();
    double getVertDistance();
    double getBearing();

    ISurveyPoint getPointFrom();
    ISurveyPoint getPointTo();

    void setHorizDistance(double dSet);
    void setVertDistance(double dSet);
    void setBearing(double dSet);

    void setPointFrom(ISurveyPoint typeSet);
    void setPointTo(ISurveyPoint typeSet);

}
