// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Jan 10 14:55:28 AEST 2021

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

// log4j types
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.lenny.surveyingDB.adapters.ProjectionAdapter;
import com.lenny.surveyingDB.interfaces.IProjection;


public class ProjectionsHttpHandler extends HandlerBase implements HttpHandler
{
    private static final Logger LOGGER = LogManager.getLogger(ProjectionAdapter.class.getName());

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch (httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getProjectionsRequest(httpExchange);
                break;
            case "POST":
                addProjectionsRequest(httpExchange);
                break;
            case "PUT":
                updateProjectionsRequest(httpExchange);
                break;
            case "OPTIONS":
                replyProjectionsOptions(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getProjectionsRequest(HttpExchange httpExchange)
    {
        LOGGER.debug("Projection GET request", httpExchange);
        try
        {
            RequestMap requestMap = new RequestMap();
            if (httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                requestMap.buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if (requestMap.getRequestMap().size() == 0)
            {
                List<IProjection> listProjections = ProjectionAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listProjections.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "Projection (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if (requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                IProjection Projection = ProjectionAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) Projection).toJson();
                System.out.println(getTimestamp() + "Projection request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch (SQLException exc)
        {
            LOGGER.error("Projection request: GET SQL exception", exc);
        }
        catch (IOException exc)
        {
            LOGGER.error("Projection request: GET IO exception", exc);
        }
        finally
        {
        }
    }

    private void replyProjectionsOptions(HttpExchange httpExchange)
    {
        LOGGER.debug("Projection OPTIONS request", httpExchange);
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

    private void addProjectionsRequest(HttpExchange httpExchange)
    {
        LOGGER.debug("Projection PUT request", httpExchange);
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(IProjection.class, new ProjectionAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            IProjection typeSerialised = gsonInstance.fromJson(strJson, IProjection.class);
            typeSerialised = ProjectionAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added Projection
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "Projection request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch (SQLException exc)
        {
            LOGGER.error("Projection request: POST SQL exception", exc);
        }
        catch (IOException exc)
        {
            LOGGER.error("Projection request: POST IO exception", exc);
        }
        finally
        {
        }
    }

    private void updateProjectionsRequest(HttpExchange httpExchange)
    {
        LOGGER.debug("Projection update request", httpExchange);
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(IProjection.class, new ProjectionAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            IProjection typeSerialised = gsonInstance.fromJson(strJson, IProjection.class);
            ((ISerialiseState) typeSerialised).setUpdated();
            typeSerialised = ProjectionAdapter.update(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added Projection
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "Projection request: PUT responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch (SQLException exc)
        {
            LOGGER.error("Projection request: PUT SQL exception", exc);
        }
        catch (IOException exc)
        {
            LOGGER.error("Projection request: PUT IO exception", exc);
        }
        finally
        {
        }
    }

    public static void registerHandler(HttpServer httpServer, String strApiRoot)
    {
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/Projections";
        httpServer.createContext(strPath, new ProjectionsHttpHandler());

    }

}
