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

import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ITraverse;


public class SurveyMeasurementsHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getSurveyMeasurementsRequest(httpExchange);
                break;
            case "POST":
                addSurveyMeasurementsRequest(httpExchange);
                break;
            case "PUT":
                updateSurveyMeasurementsRequest(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getSurveyMeasurementsRequest(HttpExchange httpExchange)
    {
        try
        {
            if(httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if(getRequestMap().size() == 0)
            {
                List<ISurveyMeasurement> listSurveyMeasurements = SurveyMeasurementAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listSurveyMeasurements.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(getRequestMap().containsKey("ID"))
            {
                ISurveyMeasurement SurveyMeasurement = SurveyMeasurementAdapter.get(ConnectionManager.getInstance().getConnection(), Integer.parseInt(getRequestMap().get("ID").getValue()));
                String strJsonResponse = ((ISerialiseState) SurveyMeasurement).toJson();
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

    private void addSurveyMeasurementsRequest(HttpExchange httpExchange)
    {
        try
        {
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyMeasurement typeSerialised = gsonInstance.fromJson(strJson, ISurveyMeasurement.class);
            typeSerialised = SurveyMeasurementAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
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

    private void updateSurveyMeasurementsRequest(HttpExchange httpExchange)
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveyMeasurements";
        httpServer.createContext(strPath, new SurveyMeasurementsHttpHandler());
    }
}
