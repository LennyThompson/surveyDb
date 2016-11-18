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

import com.lenny.surveyingDB.adapters.TraverseAdapter;
import com.lenny.surveyingDB.interfaces.ITraverse;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.adapters.TraverseClosureAdapter;
import com.lenny.surveyingDB.adapters.SurveyMeasurementAdapter;
import com.lenny.surveyingDB.interfaces.ITraverseClosure;
import com.lenny.surveyingDB.interfaces.ISurveyMeasurement;


public class TraversesHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getTraversesRequest(httpExchange);
                break;
            case "POST":
                addTraversesRequest(httpExchange);
                break;
            case "PUT":
                updateTraversesRequest(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getTraversesRequest(HttpExchange httpExchange)
    {
        try
        {
            if(httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if(getRequestMap().size() == 0)
            {
                List<ITraverse> listTraverses = TraverseAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listTraverses.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(getRequestMap().containsKey("ID"))
            {
                ITraverse Traverse = TraverseAdapter.get(ConnectionManager.getInstance().getConnection(), Integer.parseInt(getRequestMap().get("ID").getValue()));
                String strJsonResponse = ((ISerialiseState) Traverse).toJson();
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

    private void addTraversesRequest(HttpExchange httpExchange)
    {
        try
        {
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ITraverse.class, new TraverseAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ITraverse typeSerialised = gsonInstance.fromJson(strJson, ITraverse.class);
            typeSerialised = TraverseAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
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

    private void updateTraversesRequest(HttpExchange httpExchange)
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/Traverses";
        httpServer.createContext(strPath, new TraversesHttpHandler());
    }
}
