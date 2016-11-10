// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Nov 10 08:33:28 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.adapters.SurveyAdapter;


public interface ISurveyImage
{
    int getID();
    Date getCreated();
    Date getUpdated();
    String getPath();
    String getDescription();

    ISurvey getSurvey();

    void setPath(String strSet);
    void setDescription(String strSet);

    void setSurvey(ISurvey typeSet);

}
