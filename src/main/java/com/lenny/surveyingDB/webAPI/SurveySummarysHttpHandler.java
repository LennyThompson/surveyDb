// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sat May 13 12:52:41 AEST 2017

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

import com.lenny.Utils.*;

import com.lenny.surveyingDB.adapters.SurveySummaryAdapter;
import com.lenny.surveyingDB.interfaces.ISurveySummary;
import com.lenny.surveyingDB.interfaces.ISurveySummary.*;


public class SurveySummarysHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch (httpExchange.getRequestMethod().toUpperCase())
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
            RequestMap requestMap = new RequestMap();
            if (httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                requestMap.buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            String strJsonResponse = "";

            if (requestMap.getRequestMap().size() == 0)
            {
                List<ISurveySummary> listSurveySummarys = SurveySummaryAdapter.getAll(ConnectionManager.getInstance().getConnection());
                strJsonResponse = "[" + listSurveySummarys.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveySummary (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            }
            else if (requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                ISurveySummary SurveySummary = SurveySummaryAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                strJsonResponse = ((ISerialiseState) SurveySummary).toJson();
                System.out.println(getTimestamp() + "SurveySummary request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            }
            if (!strJsonResponse.isEmpty())
            {
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
                httpExchange.getResponseBody().close();
                httpExchange.close();
            }
        }
        catch (SQLException exc)
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
