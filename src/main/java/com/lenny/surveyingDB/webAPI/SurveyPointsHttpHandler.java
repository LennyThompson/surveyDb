// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Mon Nov 12 20:29:54 AEST 2018

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

import com.lenny.surveyingDB.adapters.SurveyPointAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyPoint;
import com.lenny.surveyingDB.interfaces.ISurveyPointType;
import com.lenny.surveyingDB.interfaces.ISurveyReference;
import com.lenny.surveyingDB.adapters.SurveyPointTypeAdapter;
import com.lenny.surveyingDB.adapters.SurveyReferenceAdapter;
import com.lenny.surveyingDB.adapters.SurveyImageAdapter;
import com.lenny.surveyingDB.interfaces.ISurveyImage;
import com.lenny.surveyingDB.interfaces.ISurvey;


public class SurveyPointsHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch (httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getSurveyPointsRequest(httpExchange);
                break;
            case "POST":
                addSurveyPointsRequest(httpExchange);
                break;
            case "PUT":
                updateSurveyPointsRequest(httpExchange);
                break;
            case "OPTIONS":
                replySurveyPointsOptions(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getSurveyPointsRequest(HttpExchange httpExchange)
    {
        try
        {
            RequestMap requestMap = new RequestMap();
            if (httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                requestMap.buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if (requestMap.getRequestMap().size() == 0)
            {
                List<ISurveyPoint> listSurveyPoints = SurveyPointAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listSurveyPoints.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveyPoint (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if (requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                ISurveyPoint SurveyPoint = SurveyPointAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) SurveyPoint).toJson();
                System.out.println(getTimestamp() + "SurveyPoint request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch (SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyPoint request: GET SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyPoint request: GET IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void replySurveyPointsOptions(HttpExchange httpExchange)
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

    private void addSurveyPointsRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyPoint typeSerialised = gsonInstance.fromJson(strJson, ISurveyPoint.class);
            typeSerialised = SurveyPointAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyPoint
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyPoint request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch (SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyPoint request: POST SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyPoint request: POST IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void updateSurveyPointsRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyPoint typeSerialised = gsonInstance.fromJson(strJson, ISurveyPoint.class);
            ((ISerialiseState) typeSerialised).setUpdated();
            typeSerialised = SurveyPointAdapter.update(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyPoint
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyPoint request: PUT responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch (SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyPoint request: PUT SQL exception: " + exc.getMessage());
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveyPoints";
        httpServer.createContext(strPath, new SurveyPointsHttpHandler());

        SurveyPointForSurveyHttp.registerHandler(httpServer, strApiRoot);

    }

    // Class SurveyPointForSurveyHttp provides http handler for
    // saving a SurveyPoint for a parent Survey

    static class SurveyPointForSurveyHttp
         extends HandlerBase implements HttpHandler
    {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException
        {
            switch (httpExchange.getRequestMethod().toUpperCase())
            {
                case "POST":
                    addSurveyPointForSurveyRequest(httpExchange);
                    break;
                case "OPTIONS":
                    // With a POST request weneed to handle OPTIONS for some browsers

                    replySurveyPointForSurveyOptions(httpExchange);
                    break;
                case "PUT":
                case "DELETE":
                    // TODO - add delete api for indirect children
                case "GET":
                case "":
                default:
                    handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                    break;
            }

        }

        private void replySurveyPointForSurveyOptions(HttpExchange httpExchange)
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

        interface ISurveyPointForSurvey
        {
            int getID();
            void setID(int nKey);

            ISurveyPoint getSurveyPoint();
            void setSurveyPoint(ISurveyPoint typeSerial);
        }

        class AddSurveyPointForSurveyAdapter
            implements ISurveyPointForSurvey
        {
            @SerializedName("ID")
            int m_nID;
            @SerializedName("SurveyPoint")
            ISurveyPoint m_typeSurveyPoint;

            public int getID()
            {
                return m_nID;
            }
            public void setID(int nKey)
            {
                m_nID = nKey;
            }

            public ISurveyPoint getSurveyPoint()
            {
                return m_typeSurveyPoint;
            }
            public void setSurveyPoint(ISurveyPoint typeSerial)
            {
                m_typeSurveyPoint = typeSerial;
            }
        }

        class AddSurveyPointForSurveySerialiser
            implements JsonDeserializer<ISurveyPointForSurvey>
        {
            public ISurveyPointForSurvey deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
             {
                 GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
                 gsonBuilder.registerTypeAdapter(ISurveyPoint.class, new SurveyPointAdapter());
                 Gson gsonInstance = gsonBuilder.create();
                 return gsonInstance.fromJson(json, AddSurveyPointForSurveyAdapter.class);
             }
        }

        private void addSurveyPointForSurveyRequest(HttpExchange httpExchange)
        {
            try
            {
                InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
                BufferedReader readBuf = new BufferedReader(requestReader);
                String strJson = readBuf.readLine();
                GsonBuilder gsonBuild = new GsonBuilder()
                                            .registerTypeAdapter(ISurveyPointForSurvey.class, new AddSurveyPointForSurveySerialiser())
                                            .setDateFormat("yyyy-MM-dd hh:mm:ss");
                Gson gsonInstance = gsonBuild.create();
                ISurveyPointForSurvey addTypeSerialised = gsonInstance.fromJson(strJson, ISurveyPointForSurvey.class);
                ISurveyPoint typeSerialised = SurveyPointAdapter.addForSurvey
                                (
                                    ConnectionManager.getInstance().getConnection(),
                                    addTypeSerialised.getSurveyPoint(),
                                    addTypeSerialised.getID()
                                );
                // Respond with the newly added SurveyPoint
                String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
                System.out.println(getTimestamp() + "SurveyPoint request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
                httpExchange.getResponseBody().close();
                httpExchange.close();
            }
            catch (SQLException exc)
            {
                System.out.println(getTimestamp() + "SurveyPoint request: POST SQL exception: " + exc.getMessage());
            }
            catch (IOException exc)
            {
                System.out.println(getTimestamp() + "SurveyPoint request: POST IO exception: " + exc.getMessage());
            }
            finally
            {
            }
        }

        public static void registerHandler(HttpServer httpServer, String strApiRoot)
        {
            String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveyPoints/addSurveyPointToSurvey";
            httpServer.createContext(strPath, new SurveyPointForSurveyHttp());
        }
    } 
}
