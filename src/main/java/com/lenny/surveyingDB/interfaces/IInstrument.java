// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun May 02 10:25:13 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.OffsetDateTime;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;
import com.lenny.surveyingDB.adapters.InstrumentManufacturerAdapter;
import com.lenny.surveyingDB.interfaces.ISurvey;


public interface IInstrument
{
    int getID();
    OffsetDateTime getCreated();
    OffsetDateTime getUpdated();
    String getName();
    String getDescription();

    IInstrumentManufacturer getManufacturer();

    void setName(String strSet);
    void setDescription(String strSet);

    void setManufacturer(IInstrumentManufacturer typeSet);

}
