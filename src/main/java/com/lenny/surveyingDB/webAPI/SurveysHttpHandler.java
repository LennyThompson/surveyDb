// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Thu Nov 17 12:07:19 AEST 2016

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

import com.lenny.surveyingDB.adapters.SurveyAdapter;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.interfaces.IProjection;
import com.lenny.surveyingDB.adapters.ProjectionAdapter;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.InstrumentAdapter;
import com.lenny.surveyingDB.adapters.TraverseAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;


public class SurveysHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getSurveysRequest(httpExchange);
                break;
            case "POST":
                addSurveysRequest(httpExchange);
                break;
            case "PUT":
                updateSurveysRequest(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getSurveysRequest(HttpExchange httpExchange)
    {
        System.out.println("Surveys request: GET");
        try
        {
            if(httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if(getRequestMap().size() == 0)
            {
                List<ISurvey> listSurveys = SurveyAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listSurveys.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                super.updateHeaders(httpExchange);
                System.out.println("Surveys request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(getRequestMap().containsKey("ID"))
            {
                ISurvey Survey = SurveyAdapter.get(ConnectionManager.getInstance().getConnection(), Integer.parseInt(getRequestMap().get("ID").getValue()));
                String strJsonResponse = ((ISerialiseState) Survey).toJson();
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
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

    private void addSurveysRequest(HttpExchange httpExchange)
    {
        try
        {
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurvey.class, new SurveyAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurvey typeSerialised = gsonInstance.fromJson(strJson, ISurvey.class);
            typeSerialised = SurveyAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            String strJsonResponse = "{\"ID\":" + typeSerialised.getID() + "}";
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
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

    private void updateSurveysRequest(HttpExchange httpExchange)
    {
        try
        {
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            String strJsonResponse = "";//"{\"" + ID + "\":" + typeSerialised.getID() + "}";
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/Surveys";
        httpServer.createContext(strPath, new SurveysHttpHandler());
    }
}
