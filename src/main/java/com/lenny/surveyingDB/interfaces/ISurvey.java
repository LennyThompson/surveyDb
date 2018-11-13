// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:54 AEST 2018

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.interfaces.IProjection;
import com.lenny.surveyingDB.adapters.ProjectionAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.adapters.SurveyImageAdapter;
import com.lenny.surveyingDB.adapters.TraverseAdapter;
import com.lenny.surveyingDB.adapters.InstrumentAdapter;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;


public interface ISurvey
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    String getDescription();

    IProjection getProjection();

    List<ISurveyMeasurement> getSurveyMeasurements();
    List<ISurveyImage> getSurveyImages();
    List<ITraverse> getTraverses();
    List<IInstrument> getInstruments();
    List<ISurveyPoint> getSurveyPoints();

    void setName(String strSet);
    void setDescription(String strSet);

    void setProjection(IProjection typeSet);

    void addSurveyMeasurement(ISurveyMeasurement listAdd);
    void addSurveyImage(ISurveyImage listAdd);
    void addTraverse(ITraverse listAdd);
    void addInstrument(IInstrument listAdd);
    void addSurveyPoint(ISurveyPoint listAdd);

}
