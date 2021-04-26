// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 15:32:27 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
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
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
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
