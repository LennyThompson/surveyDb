// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 15:32:27 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.ISurveyPointType;


public interface ISurveyPointType
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    String getName();
    String getAbbreviation();
    boolean getUserDefined();

    void setName(String strSet);
    void setAbbreviation(String strSet);
    void setUserDefined(boolean bSet);

}
