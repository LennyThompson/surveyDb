// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on 

package com.lenny.surveyingDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public interface SqlProvider
{
    public interface SqlResultHandler<OutType>
    {
        OutType fromResults(Connection connDb, ResultSet results);
        OutType updateFromResults(OutType typUpdate, Connection connDb, ResultSet results);
        boolean insertNew(OutType typeInsert, PreparedStatement stmtNew);
        boolean updateExisting(OutType typeUpdate, PreparedStatement stmtUpdate);
    }

    public interface SqlScriptProvider
    {
        String target();
        String selectScript();
        String selectByPrimaryKeyScript();
        String selectFor(String strContext);
        String selectLastId();
        String selectLast();
        String selectForPath(Integer[] path);
        String insertScript();
        String insertFor(String strContext);
        String updateScript();
        String deleteScript();
        String deleteByPrimaryKeyScript();
        String deleteFor(String strContext);
        String createScript();
        String triggerScript();
        String staticInsertsScript();

        <OutType> SqlResultHandler<OutType> resultsHandler();
    }
    SqlScriptProvider getScriptProvider(String strTarget);
}