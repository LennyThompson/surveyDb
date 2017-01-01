// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 01 10:59:55 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;
import com.lenny.surveyingDB.adapters.InstrumentManufacturerAdapter;
import com.lenny.surveyingDB.interfaces.ISurvey;


public interface IInstrument
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    String getName();
    String getDescription();

    IInstrumentManufacturer getManufacturer();

    void setName(String strSet);
    void setDescription(String strSet);

    void setManufacturer(IInstrumentManufacturer typeSet);

}
