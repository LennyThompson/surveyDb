// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Wed Dec 28 15:10:11 AEST 2016

package com.lenny.surveyingDB.interfaces;

import java.util.Date;
import com.lenny.surveyingDB.interfaces.ISurveyPointSummary;


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
