// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 15:32:27 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyReference;


public interface ISurveyReference
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    String getName();
    String getDescription();
    OffsetDateTime getDate();
    String getReference();

    void setName(String strSet);
    void setDescription(String strSet);
    void setDate(OffsetDateTime dateSet);
    void setReference(String strSet);

}
