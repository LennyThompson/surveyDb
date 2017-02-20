// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Feb 19 13:52:25 AEST 2017

package com.lenny.surveyingDB.webAPI;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.lenny.Utils.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.InputStreamReader;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;

import com.lenny.Utils.HandlerBase;
import com.lenny.Utils.ConnectionManager;
import com.lenny.Utils.ISerialiseState;

import com.lenny.surveyingDB.adapters.SurveyPointTypeAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyPointType;


public class SurveyPointTypesHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getSurveyPointTypesRequest(httpExchange);
                break;
            case "POST":
                addSurveyPointTypesRequest(httpExchange);
                break;
            case "PUT":
                updateSurveyPointTypesRequest(httpExchange);
                break;
            case "OPTIONS":
                replySurveyPointTypesOptions(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getSurveyPointTypesRequest(HttpExchange httpExchange)
    {
        try
        {
            RequestMap requestMap = new RequestMap();
            if(httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                requestMap.buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if(requestMap.getRequestMap().size() == 0)
            {
                List<ISurveyPointType> listSurveyPointTypes = SurveyPointTypeAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listSurveyPointTypes.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveyPointType (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                ISurveyPointType SurveyPointType = SurveyPointTypeAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) SurveyPointType).toJson();
                System.out.println(getTimestamp() + "SurveyPointType request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyPointType request: GET SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyPointType request: GET IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void replySurveyPointTypesOptions(HttpExchange httpExchange)
    {
        try
        {
            updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, 0);
            httpExchange.close();
        }
        catch (IOException exc)
        {
        }
        finally
        {
        }
    }

    private void addSurveyPointTypesRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyPointType.class, new SurveyPointTypeAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyPointType typeSerialised = gsonInstance.fromJson(strJson, ISurveyPointType.class);
            typeSerialised = SurveyPointTypeAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyPointType
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyPointType request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyPointType request: POST SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyPointType request: POST IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void updateSurveyPointTypesRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyPointType.class, new SurveyPointTypeAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyPointType typeSerialised = gsonInstance.fromJson(strJson, ISurveyPointType.class);
            ((ISerialiseState) typeSerialised).setUpdated();
            typeSerialised = SurveyPointTypeAdapter.update(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyPointType
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyPointType request: PUT responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyPointType request: PUT SQL exception: " + exc.getMessage());
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveyPointTypes";
        httpServer.createContext(strPath, new SurveyPointTypesHttpHandler());

    }

}
