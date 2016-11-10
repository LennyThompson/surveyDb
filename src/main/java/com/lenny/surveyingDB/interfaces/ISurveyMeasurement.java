// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Nov 10 08:33:28 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ITraverse;


public interface ISurveyMeasurement
{
    int getID();
    Date getCreated();
    Date getUpdated();
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
