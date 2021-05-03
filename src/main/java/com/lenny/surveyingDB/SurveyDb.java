package com.lenny.surveyingDB;

import com.lenny.surveyingDB.adapters.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SurveyDb
{
    public static void buildNewDatabase(String strDbName) throws SQLException
    {
        String strDbConnName = "jdbc:sqlite:" + strDbName;
        Connection connDb = DriverManager.getConnection(strDbConnName);

        SurveyPointTypeAdapter.createInDatabase(connDb);
        SurveyReferenceAdapter.createInDatabase(connDb);
        InstrumentManufacturerAdapter.createInDatabase(connDb);
        InstrumentAdapter.createInDatabase(connDb);
        ProjectionAdapter.createInDatabase(connDb);
        SurveyPointAdapter.createInDatabase(connDb);
        SurveyAdapter.createInDatabase(connDb);
        SurveyMeasurementAdapter.createInDatabase(connDb);
        SurveyImageAdapter.createInDatabase(connDb);
        TraverseAdapter.createInDatabase(connDb);
        SurveyAdjustmentAdapter.createInDatabase(connDb);
        TraverseClosureAdapter.createInDatabase(connDb);
        TraverseSummaryAdapter.createInDatabase(connDb);
        TraverseMeasurementSummaryAdapter.createInDatabase(connDb);
        SurveyPointSummaryAdapter.createInDatabase(connDb);
        SurveySummaryAdapter.createInDatabase(connDb);

    }

    public static void resetSqlProvider()
    {
        SurveyPointTypeAdapter.setSqlProvider(null);
        SurveyReferenceAdapter.setSqlProvider(null);
        InstrumentManufacturerAdapter.setSqlProvider(null);
        InstrumentAdapter.setSqlProvider(null);
        ProjectionAdapter.setSqlProvider(null);
        SurveyPointAdapter.setSqlProvider(null);
        SurveyAdapter.setSqlProvider(null);
        SurveyMeasurementAdapter.setSqlProvider(null);
        SurveyImageAdapter.setSqlProvider(null);
        TraverseAdapter.setSqlProvider(null);
        SurveyAdjustmentAdapter.setSqlProvider(null);
        TraverseClosureAdapter.setSqlProvider(null);
        TraverseSummaryAdapter.setSqlProvider(null);
        TraverseMeasurementSummaryAdapter.setSqlProvider(null);
        SurveyPointSummaryAdapter.setSqlProvider(null);
        SurveySummaryAdapter.setSqlProvider(null);
    }
}
