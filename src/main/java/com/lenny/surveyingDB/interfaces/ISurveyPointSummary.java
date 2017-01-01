// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 01 10:59:55 AEST 2017

package com.lenny.surveyingDB.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import com.lenny.Utils.ISerialiseState;
import com.lenny.surveyingDB.interfaces.ISurveyPointSummary;
import com.lenny.surveyingDB.interfaces.ISurveyPointSummary.*;


public interface ISurveyPointSummary extends ISerialiseState
{
    public interface ISurveyPointSummary_Pt
    {
        int getPtID();
        String getPtName();
        String getPtDesc();
        double getX();
        double getY();
        double getZ();
        IPt_PtType getPtType();
        IPt_Ref getRef();

        public interface IPt_PtType
        {
            String getPtTypeName();
            String getPtTypeAbbreviation();

        }
        public interface IPt_Ref
        {
            String getRefName();
            String getRefDescription();

        }

    }

    int getID();
    List<ISurveyPointSummary_Pt> getPts();

}
