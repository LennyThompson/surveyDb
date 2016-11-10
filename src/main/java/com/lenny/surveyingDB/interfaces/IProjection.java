// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Nov 10 08:33:28 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.IProjection;


public interface IProjection
{
    int getID();
    Date getCreated();
    Date getUpdated();
    String getName();
    Date getDate();
    String getDescription();

    void setID(int nSet);
    void setName(String strSet);
    void setDate(Date dateSet);
    void setDescription(String strSet);

}
