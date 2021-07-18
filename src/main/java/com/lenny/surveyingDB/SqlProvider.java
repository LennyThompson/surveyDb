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
    }

    public interface SqlParameterHandler<InType>
    {
        boolean prepareInsert(PreparedStatement stmt, InType type);
        boolean prepareInsertFor(PreparedStatement stmt, InType type, String strContext);
        boolean prepareUpdate(PreparedStatement stmt, InType type);
        boolean prepareDelete(PreparedStatement stmt, InType type);
        boolean prepareDeleteFor(PreparedStatement stmt, InType type, String strContext);
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
        String selectHistory();
        String insertScript();
        String insertFor(String strContext);
        String updateScript();
        String deleteScript();
        String deleteByPrimaryKeyScript();
        String deleteFor(String strContext);
        String createScript();
        String removeScript();
        String triggerScript();
        String staticInsertsScript();

        boolean createInDatabase(Connection connDb);

        <OutType> SqlResultHandler<OutType> resultsHandler();
        <InType> SqlParameterHandler<InType> parametersHandler();
    }
    String getProviderName();
    SqlScriptProvider getScriptProvider(String strTarget);
    boolean removeDatabase(Connection connDb);
    boolean createDatabase(Connection connDb);
}