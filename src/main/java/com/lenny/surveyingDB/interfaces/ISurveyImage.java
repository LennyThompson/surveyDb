// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:54 AEST 2018

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyImage;


public interface ISurveyImage
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getPath();
    String getDescription();

    void setPath(String strSet);
    void setDescription(String strSet);

}
