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

import com.lenny.surveyingDB.adapters.SurveyImageAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.lenny.surveyingDB.adapters.SurveyAdapter;


public class SurveyImagesHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getSurveyImagesRequest(httpExchange);
                break;
            case "POST":
                addSurveyImagesRequest(httpExchange);
                break;
            case "PUT":
                updateSurveyImagesRequest(httpExchange);
                break;
            case "OPTIONS":
                replySurveyImagesOptions(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getSurveyImagesRequest(HttpExchange httpExchange)
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
                List<ISurveyImage> listSurveyImages = SurveyImageAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listSurveyImages.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveyImage (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                ISurveyImage SurveyImage = SurveyImageAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) SurveyImage).toJson();
                System.out.println(getTimestamp() + "SurveyImage request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyImage request: GET SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyImage request: GET IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void replySurveyImagesOptions(HttpExchange httpExchange)
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

    private void addSurveyImagesRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyImage.class, new SurveyImageAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyImage typeSerialised = gsonInstance.fromJson(strJson, ISurveyImage.class);
            typeSerialised = SurveyImageAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyImage
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyImage request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyImage request: POST SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyImage request: POST IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void updateSurveyImagesRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyImage.class, new SurveyImageAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyImage typeSerialised = gsonInstance.fromJson(strJson, ISurveyImage.class);
            ((ISerialiseState) typeSerialised).setUpdated();
            typeSerialised = SurveyImageAdapter.update(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyImage
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyImage request: PUT responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyImage request: PUT SQL exception: " + exc.getMessage());
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveyImages";
        httpServer.createContext(strPath, new SurveyImagesHttpHandler());

    }

}
