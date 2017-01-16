// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sat Jan 14 18:36:32 AEST 2017

package com.lenny.surveyingDB.webAPI;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lenny.Utils.HandlerBase;
import com.lenny.Utils.ConnectionManager;
import com.lenny.Utils.ISerialiseState;

import com.lenny.surveyingDB.adapters.TraverseMeasurementSummaryAdapter;
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary;
import com.lenny.surveyingDB.interfaces.ITraverseMeasurementSummary.*;


public class TraverseMeasurementSummarysHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getTraverseMeasurementSummarysRequest(httpExchange);
                break;
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getTraverseMeasurementSummarysRequest(HttpExchange httpExchange)
    {
        try
        {
            if(httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            String strJsonResponse = "";

            if(getRequestMap().size() == 0)
            {
                List<ITraverseMeasurementSummary> listTraverseMeasurementSummarys = TraverseMeasurementSummaryAdapter.getAll(ConnectionManager.getInstance().getConnection());
                strJsonResponse = "[" + listTraverseMeasurementSummarys.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "TraverseMeasurementSummary (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            }
            else if(getRequestMap().containsKey("ID") || getRequestMap().containsKey("SurveyID"))
            {
                int nID = getRequestMap().containsKey("ID") ? Integer.parseInt(getRequestMap().get("ID").getValue()) : -1;
                int nSurveyID = getRequestMap().containsKey("SurveyID") ? Integer.parseInt(getRequestMap().get("SurveyID").getValue()) : -1;

                List<ITraverseMeasurementSummary> listTraverseMeasurementSummarys = TraverseMeasurementSummaryAdapter.getForPathQuery(ConnectionManager.getInstance().getConnection(), nID, nSurveyID);
                strJsonResponse = "[" + listTraverseMeasurementSummarys.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "TraverseMeasurementSummary (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            }
            else if(getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(getRequestMap().get("ID").getValue());
                ITraverseMeasurementSummary TraverseMeasurementSummary = TraverseMeasurementSummaryAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                strJsonResponse = ((ISerialiseState) TraverseMeasurementSummary).toJson();
                System.out.println(getTimestamp() + "TraverseMeasurementSummary request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            }
            if(!strJsonResponse.isEmpty())
            {
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
                httpExchange.getResponseBody().close();
                httpExchange.close();
            }
        }
        catch(SQLException exc)
        {
        }
        catch (IOException exc)
        {
        }
        finally
        {
        }
    }

    public static void registerHandler(HttpServer httpServer, String strApiRoot)
    {
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/TraverseMeasurementSummarys";
        httpServer.createContext(strPath, new TraverseMeasurementSummarysHttpHandler());
    }
}
