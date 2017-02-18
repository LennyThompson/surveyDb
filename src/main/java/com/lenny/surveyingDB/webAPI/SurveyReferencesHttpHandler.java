// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Fri Feb 17 19:30:37 AEST 2017

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

import com.lenny.surveyingDB.adapters.SurveyReferenceAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyReference;


public class SurveyReferencesHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getSurveyReferencesRequest(httpExchange);
                break;
            case "POST":
                addSurveyReferencesRequest(httpExchange);
                break;
            case "PUT":
                updateSurveyReferencesRequest(httpExchange);
                break;
            case "OPTIONS":
                replySurveyReferencesOptions(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getSurveyReferencesRequest(HttpExchange httpExchange)
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
                List<ISurveyReference> listSurveyReferences = SurveyReferenceAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listSurveyReferences.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveyReference (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                ISurveyReference SurveyReference = SurveyReferenceAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) SurveyReference).toJson();
                System.out.println(getTimestamp() + "SurveyReference request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyReference request: GET SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyReference request: GET IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void replySurveyReferencesOptions(HttpExchange httpExchange)
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

    private void addSurveyReferencesRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyReference.class, new SurveyReferenceAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyReference typeSerialised = gsonInstance.fromJson(strJson, ISurveyReference.class);
            typeSerialised = SurveyReferenceAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyReference
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyReference request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyReference request: POST SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyReference request: POST IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void updateSurveyReferencesRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyReference.class, new SurveyReferenceAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyReference typeSerialised = gsonInstance.fromJson(strJson, ISurveyReference.class);
            ((ISerialiseState) typeSerialised).setUpdated();
            typeSerialised = SurveyReferenceAdapter.update(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyReference
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyReference request: PUT responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyReference request: PUT SQL exception: " + exc.getMessage());
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveyReferences";
        httpServer.createContext(strPath, new SurveyReferencesHttpHandler());

    }

}
