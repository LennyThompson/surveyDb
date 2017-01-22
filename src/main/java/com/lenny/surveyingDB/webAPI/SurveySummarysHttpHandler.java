// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 22 21:26:42 AEST 2017

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

import com.lenny.surveyingDB.adapters.SurveySummaryAdapter;
import com.lenny.surveyingDB.interfaces.ISurveySummary;
import com.lenny.surveyingDB.interfaces.ISurveySummary.*;


public class SurveySummarysHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getSurveySummarysRequest(httpExchange);
                break;
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getSurveySummarysRequest(HttpExchange httpExchange)
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
                List<ISurveySummary> listSurveySummarys = SurveySummaryAdapter.getAll(ConnectionManager.getInstance().getConnection());
                strJsonResponse = "[" + listSurveySummarys.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveySummary (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            }
            else if(getRequestMap().containsKey("TravID"))
            {
                int nTravID = getRequestMap().containsKey("TravID") ? Integer.parseInt(getRequestMap().get("TravID").getValue()) : -1;

                List<ISurveySummary> listSurveySummarys = SurveySummaryAdapter.getForPathQuery(ConnectionManager.getInstance().getConnection(), nTravID);
                strJsonResponse = "[" + listSurveySummarys.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveySummary (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            }
            else if(getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(getRequestMap().get("ID").getValue());
                ISurveySummary SurveySummary = SurveySummaryAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                strJsonResponse = ((ISerialiseState) SurveySummary).toJson();
                System.out.println(getTimestamp() + "SurveySummary request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveySummarys";
        httpServer.createContext(strPath, new SurveySummarysHttpHandler());
    }
}