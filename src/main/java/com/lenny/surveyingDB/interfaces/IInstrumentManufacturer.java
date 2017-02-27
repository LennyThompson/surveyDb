// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Feb 23 08:13:21 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;


public interface IInstrumentManufacturer
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    String getDescription();

    void setName(String strSet);
    void setDescription(String strSet);

}
