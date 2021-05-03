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

    // TODO: Add interface to apply parameters to jdbc statements...

    public interface SqlParameterHandler<InType>
    {
        boolean prepareInsert(PreparedStatement stmt, InType type);
        boolean prepareInsertFor(PreparedStatement stmt, InType type, String strContext);
        boolean prepareUpdateUpdate(PreparedStatement stmt, InType type);
        boolean prepareDelete(PreparedStatement stmt, InType type);
        boolean prepareDeleteFor(PreparedStatement stmt, InType type);
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

        boolean createInDatabase(Connection connDb);

        <OutType> SqlResultHandler<OutType> resultsHandler();
    }
    String getProviderName();
    SqlScriptProvider getScriptProvider(String strTarget);
    boolean createDatabase(Connection connDb);
}