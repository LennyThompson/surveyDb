// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 10 14:31:05 AEST 2021

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import java.util.Date;


public interface ITraverseClosure
{
    int getID();
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
    double getMiscZ();
    double getMiscY();
    double getMiscX();
    double getBearingMisclose();
    double getTraverseLength();
    boolean getAdjusted();

    void setMiscZ(double dSet);
    void setMiscY(double dSet);
    void setMiscX(double dSet);
    void setBearingMisclose(double dSet);
    void setTraverseLength(double dSet);
    void setAdjusted(boolean bSet);

}
