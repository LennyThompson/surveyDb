// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon May 08 10:06:02 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyPointType;


public interface ISurveyPointType
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    String getAbbreviation();
    boolean getUserDefined();

    void setName(String strSet);
    void setAbbreviation(String strSet);
    void setUserDefined(boolean bSet);

}
