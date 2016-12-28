// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ISurveyReference;


public interface ISurveyReference
{
    int getID();
    Date getCreated();
    Date getUpdated();
    String getName();
    String getDescription();
    Date getDate();
    String getReference();

    void setName(String strSet);
    void setDescription(String strSet);
    void setDate(Date dateSet);
    void setReference(String strSet);

}
