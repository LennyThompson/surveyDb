// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 15:32:27 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyImage;


public interface ISurveyImage
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    String getPath();
    String getDescription();

    void setPath(String strSet);
    void setDescription(String strSet);

}
