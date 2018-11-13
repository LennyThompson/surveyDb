// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:54 AEST 2018

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
