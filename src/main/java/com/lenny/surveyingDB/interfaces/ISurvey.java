// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Fri Feb 17 19:30:37 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.interfaces.IProjection;
import com.lenny.surveyingDB.adapters.ProjectionAdapter;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.InstrumentAdapter;
import com.lenny.surveyingDB.adapters.TraverseAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;


public interface ISurvey
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    String getDescription();

    IProjection getProjection();

    List<ISurveyPoint> getSurveyPoints();
    List<IInstrument> getInstruments();
    List<ITraverse> getTraverses();
    List<ISurveyMeasurement> getSurveyMeasurements();

    void setName(String strSet);
    void setDescription(String strSet);

    void setProjection(IProjection typeSet);

    void addSurveyPoint(ISurveyPoint listAdd);
    void addInstrument(IInstrument listAdd);
    void addTraverse(ITraverse listAdd);
    void addSurveyMeasurement(ISurveyMeasurement listAdd);

}
