// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Feb 19 13:52:25 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.interfaces.ISurveyPointType;
import com.lenny.surveyingDB.interfaces.ISurveyReference;
import com.lenny.surveyingDB.adapters.SurveyPointTypeAdapter;
import com.lenny.surveyingDB.adapters.SurveyReferenceAdapter;
import com.lenny.surveyingDB.adapters.SurveyImageAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ISurvey;


public interface ISurveyPoint
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    double getX();
    double getY();
    double getZ();
    String getName();
    String getDescription();

    ISurveyPointType getPointType();
    ISurveyReference getReference();

    List<ISurveyImage> getSurveyImages();

    void setX(double dSet);
    void setY(double dSet);
    void setZ(double dSet);
    void setName(String strSet);
    void setDescription(String strSet);

    void setPointType(ISurveyPointType typeSet);
    void setReference(ISurveyReference typeSet);

    void addSurveyImage(ISurveyImage listAdd);

}
