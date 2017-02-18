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
            case "OPTIONS":
                replySurveyMeasurementsOptions(httpExchange);
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
            RequestMap requestMap = new RequestMap();
            if(httpExchange.getRequestURI().getQuery() != null && !httpExchange.getRequestURI().getQuery().isEmpty())
            {
                requestMap.buildRequestMap(httpExchange.getRequestURI().getQuery());
            }

            if(requestMap.getRequestMap().size() == 0)
            {
                List<ISurveyMeasurement> listSurveyMeasurements = SurveyMeasurementAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listSurveyMeasurements.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "SurveyMeasurement (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                ISurveyMeasurement SurveyMeasurement = SurveyMeasurementAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) SurveyMeasurement).toJson();
                System.out.println(getTimestamp() + "SurveyMeasurement request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyMeasurement request: GET SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyMeasurement request: GET IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void replySurveyMeasurementsOptions(HttpExchange httpExchange)
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

    private void addSurveyMeasurementsRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyMeasurement typeSerialised = gsonInstance.fromJson(strJson, ISurveyMeasurement.class);
            typeSerialised = SurveyMeasurementAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyMeasurement
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyMeasurement request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyMeasurement request: POST SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "SurveyMeasurement request: POST IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void updateSurveyMeasurementsRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            ISurveyMeasurement typeSerialised = gsonInstance.fromJson(strJson, ISurveyMeasurement.class);
            ((ISerialiseState) typeSerialised).setUpdated();
            typeSerialised = SurveyMeasurementAdapter.update(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added SurveyMeasurement
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "SurveyMeasurement request: PUT responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "SurveyMeasurement request: PUT SQL exception: " + exc.getMessage());
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

        SurveyMeasurementForTraverseHttp.registerHandler(httpServer, strApiRoot);

    }

    // Class SurveyMeasurementForTraverseHttp provides http handler for
    // saving a SurveyMeasurement for a parent Traverse

    static class SurveyMeasurementForTraverseHttp
         extends HandlerBase implements HttpHandler
    {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException
        {
            switch(httpExchange.getRequestMethod().toUpperCase())
            {
                case "POST":
                    addSurveyMeasurementForTraverseRequest(httpExchange);
                    break;
                case "OPTIONS":
                    // With a POST request weneed to handle OPTIONS for some browsers

                    replySurveyMeasurementForTraverseOptions(httpExchange);
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

        private void replySurveyMeasurementForTraverseOptions(HttpExchange httpExchange)
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

        interface ISurveyMeasurementForTraverse
        {
            int getID();
            void setID(int nKey);

            ISurveyMeasurement getSurveyMeasurement();
            void setSurveyMeasurement(ISurveyMeasurement typeSerial);
        }

        class AddSurveyMeasurementForTraverseAdapter
            implements ISurveyMeasurementForTraverse
        {
            @SerializedName("ID")
            int m_nID;
            @SerializedName("SurveyMeasurement")
            ISurveyMeasurement m_typeSurveyMeasurement;

            public int getID()
            {
                return m_nID;
            }
            public void setID(int nKey)
            {
                m_nID = nKey;
            }

            public ISurveyMeasurement getSurveyMeasurement()
            {
                return m_typeSurveyMeasurement;
            }
            public void setSurveyMeasurement(ISurveyMeasurement typeSerial)
            {
                m_typeSurveyMeasurement = typeSerial;
            }
        }

        class AddSurveyMeasurementForTraverseSerialiser
            implements JsonDeserializer<ISurveyMeasurementForTraverse>
        {
            public ISurveyMeasurementForTraverse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
             {
                 GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
                 gsonBuilder.registerTypeAdapter(ISurveyMeasurement.class, new SurveyMeasurementAdapter());
                 Gson gsonInstance = gsonBuilder.create();
                 return gsonInstance.fromJson(json, AddSurveyMeasurementForTraverseAdapter.class);
             }
        }

        private void addSurveyMeasurementForTraverseRequest(HttpExchange httpExchange)
        {
            try
            {
                InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
                BufferedReader readBuf = new BufferedReader(requestReader);
                String strJson = readBuf.readLine();
                GsonBuilder gsonBuild = new GsonBuilder()
                                            .registerTypeAdapter(ISurveyMeasurementForTraverse.class, new AddSurveyMeasurementForTraverseSerialiser())
                                            .setDateFormat("yyyy-MM-dd hh:mm:ss");
                Gson gsonInstance = gsonBuild.create();
                ISurveyMeasurementForTraverse addTypeSerialised = gsonInstance.fromJson(strJson, ISurveyMeasurementForTraverse.class);
                ISurveyMeasurement typeSerialised = SurveyMeasurementAdapter.addForTraverse
                                (
                                    ConnectionManager.getInstance().getConnection(),
                                    addTypeSerialised.getSurveyMeasurement(),
                                    addTypeSerialised.getID()
                                );
                // Respond with the newly added SurveyMeasurement
                String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
                System.out.println(getTimestamp() + "SurveyMeasurement request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
                httpExchange.getResponseBody().close();
                httpExchange.close();
            }
            catch(SQLException exc)
            {
                System.out.println(getTimestamp() + "SurveyMeasurement request: POST SQL exception: " + exc.getMessage());
            }
            catch (IOException exc)
            {
                System.out.println(getTimestamp() + "SurveyMeasurement request: POST IO exception: " + exc.getMessage());
            }
            finally
            {
            }
        }

        public static void registerHandler(HttpServer httpServer, String strApiRoot)
        {
            String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/SurveyMeasurements/addSurveyMeasurementToTraverse";
            httpServer.createContext(strPath, new SurveyMeasurementForTraverseHttp());
        }
    } 
}
