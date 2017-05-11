// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon May 08 10:06:02 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.TraverseClosureAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;


public interface ITraverse
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    String getDescription();

    ISurveyPoint getStartPoint();
    ISurveyPoint getEndPoint();

    List<ITraverseClosure> getTraverseClosures();
    List<ISurveyMeasurement> getSurveyMeasurements();

    void setName(String strSet);
    void setDescription(String strSet);

    void setStartPoint(ISurveyPoint typeSet);
    void setEndPoint(ISurveyPoint typeSet);

    void addTraverseClosure(ITraverseClosure listAdd);
    void addSurveyMeasurement(ISurveyMeasurement listAdd);

}
