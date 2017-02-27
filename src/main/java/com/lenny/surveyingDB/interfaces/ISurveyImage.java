// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Feb 23 08:13:21 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.adapters.SurveyAdapter;


public interface ISurveyImage
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getPath();
    String getDescription();

    ISurvey getSurvey();

    void setPath(String strSet);
    void setDescription(String strSet);

    void setSurvey(ISurvey typeSet);

}
