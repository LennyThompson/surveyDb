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

import com.lenny.surveyingDB.adapters.InstrumentManufacturerAdapter;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;


public class InstrumentManufacturersHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getInstrumentManufacturersRequest(httpExchange);
                break;
            case "POST":
                addInstrumentManufacturersRequest(httpExchange);
                break;
            case "PUT":
                updateInstrumentManufacturersRequest(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getInstrumentManufacturersRequest(HttpExchange httpExchange)
    {
        try
        {
            if(httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if(getRequestMap().size() == 0)
            {
                List<IInstrumentManufacturer> listInstrumentManufacturers = InstrumentManufacturerAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listInstrumentManufacturers.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "InstrumentManufacturer (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(getRequestMap().get("ID").getValue());
                IInstrumentManufacturer InstrumentManufacturer = InstrumentManufacturerAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) InstrumentManufacturer).toJson();
                System.out.println(getTimestamp() + "InstrumentManufacturer request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
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

    private void addInstrumentManufacturersRequest(HttpExchange httpExchange)
    {
        try
        {
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(IInstrumentManufacturer.class, new InstrumentManufacturerAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            IInstrumentManufacturer typeSerialised = gsonInstance.fromJson(strJson, IInstrumentManufacturer.class);
            typeSerialised = InstrumentManufacturerAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
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

    private void updateInstrumentManufacturersRequest(HttpExchange httpExchange)
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/InstrumentManufacturers";
        httpServer.createContext(strPath, new InstrumentManufacturersHttpHandler());
    }
}
