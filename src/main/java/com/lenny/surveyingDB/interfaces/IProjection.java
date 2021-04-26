// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Apr 26 15:32:27 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.IProjection;


public interface IProjection
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    String getName();
    OffsetDateTime getDate();
    String getDescription();

    void setID(int nSet);
    void setName(String strSet);
    void setDate(OffsetDateTime dateSet);
    void setDescription(String strSet);

}
