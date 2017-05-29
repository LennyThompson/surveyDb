// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sat May 13 12:52:41 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyReference;


public interface ISurveyReference
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    String getDescription();
    LocalDateTime getDate();
    String getReference();

    void setName(String strSet);
    void setDescription(String strSet);
    void setDate(LocalDateTime dateSet);
    void setReference(String strSet);

}
