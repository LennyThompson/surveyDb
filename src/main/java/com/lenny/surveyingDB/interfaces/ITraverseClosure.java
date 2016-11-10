// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Nov 10 08:33:28 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import java.util.Date;


public interface ITraverseClosure
{
    int getID();
    Date getCreated();
    Date getUpdated();
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
