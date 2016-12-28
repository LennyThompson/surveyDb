// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
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
    Date getCreated();
    Date getUpdated();
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
