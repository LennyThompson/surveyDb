// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon May 08 10:06:02 AEST 2017

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
