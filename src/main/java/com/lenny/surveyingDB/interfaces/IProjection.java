// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 10 14:31:05 AEST 2021

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
