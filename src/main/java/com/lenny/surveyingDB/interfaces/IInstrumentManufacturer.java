// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Nov 10 08:33:28 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;


public interface IInstrumentManufacturer
{
    int getID();
    Date getCreated();
    Date getUpdated();
    String getName();
    String getDescription();

    void setName(String strSet);
    void setDescription(String strSet);

}
