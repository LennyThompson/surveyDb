// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sat Jan 14 18:36:32 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.IProjection;


public interface IProjection
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    LocalDateTime getDate();
    String getDescription();

    void setID(int nSet);
    void setName(String strSet);
    void setDate(LocalDateTime dateSet);
    void setDescription(String strSet);

}
