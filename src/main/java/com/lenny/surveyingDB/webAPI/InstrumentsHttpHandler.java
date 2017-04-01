// ****THIS IS A CODE GENERATED FILE DO NOT EDIT****
// Generated on Sun Mar 26 14:12:03 AEST 2017

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

import com.lenny.surveyingDB.adapters.InstrumentAdapter;
import com.lenny.surveyingDB.interfaces.IInstrument;
import com.lenny.surveyingDB.interfaces.IInstrumentManufacturer;
import com.lenny.surveyingDB.adapters.InstrumentManufacturerAdapter;
import com.lenny.surveyingDB.interfaces.ISurvey;


public class InstrumentsHttpHandler extends HandlerBase implements HttpHandler
{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException
    {
        switch(httpExchange.getRequestMethod().toUpperCase())
        {
            case "GET":
                getInstrumentsRequest(httpExchange);
                break;
            case "POST":
                addInstrumentsRequest(httpExchange);
                break;
            case "PUT":
                updateInstrumentsRequest(httpExchange);
                break;
            case "OPTIONS":
                replyInstrumentsOptions(httpExchange);
                break;
            case "DELETE":
            case "":
            default:
                handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                break;
        }

    }

    private void getInstrumentsRequest(HttpExchange httpExchange)
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
                List<IInstrument> listInstruments = InstrumentAdapter.getAll(ConnectionManager.getInstance().getConnection());
                String strJsonResponse = "[" + listInstruments.stream()
                        .map(item -> ((ISerialiseState) item).toJson())
                    .collect(Collectors.joining(",")) + "]";
                System.out.println(getTimestamp() + "Instrument (all) request: GET responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            else if(requestMap.getRequestMap().containsKey("ID"))
            {
                int nID = Integer.parseInt(requestMap.getRequestMap().get("ID").getValue());
                IInstrument Instrument = InstrumentAdapter.get(ConnectionManager.getInstance().getConnection(), nID);
                String strJsonResponse = ((ISerialiseState) Instrument).toJson();
                System.out.println(getTimestamp() + "Instrument request: GET (" + nID + ")  responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            }
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "Instrument request: GET SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "Instrument request: GET IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void replyInstrumentsOptions(HttpExchange httpExchange)
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

    private void addInstrumentsRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(IInstrument.class, new InstrumentAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            IInstrument typeSerialised = gsonInstance.fromJson(strJson, IInstrument.class);
            typeSerialised = InstrumentAdapter.add(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added Instrument
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "Instrument request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "Instrument request: POST SQL exception: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println(getTimestamp() + "Instrument request: POST IO exception: " + exc.getMessage());
        }
        finally
        {
        }
    }

    private void updateInstrumentsRequest(HttpExchange httpExchange)
    {
        try
        {
            // TODO: add request map...
            InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader readBuf = new BufferedReader(requestReader);
            String strJson = readBuf.readLine();
            GsonBuilder gsonBuild = new GsonBuilder()
                                        .registerTypeAdapter(IInstrument.class, new InstrumentAdapter())
                                        .setDateFormat("yyyy-MM-dd hh:mm:ss");
            Gson gsonInstance = gsonBuild.create();
            IInstrument typeSerialised = gsonInstance.fromJson(strJson, IInstrument.class);
            ((ISerialiseState) typeSerialised).setUpdated();
            typeSerialised = InstrumentAdapter.update(ConnectionManager.getInstance().getConnection(), typeSerialised);
            // Respond with the newly added Instrument
            String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
            System.out.println(getTimestamp() + "Instrument request: PUT responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
            super.updateHeaders(httpExchange);
            httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
            httpExchange.getResponseBody().write(strJsonResponse.getBytes());
            httpExchange.getResponseBody().close();
            httpExchange.close();
        }
        catch(SQLException exc)
        {
            System.out.println(getTimestamp() + "Instrument request: PUT SQL exception: " + exc.getMessage());
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
        String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/Instruments";
        httpServer.createContext(strPath, new InstrumentsHttpHandler());

        InstrumentForSurveyHttp.registerHandler(httpServer, strApiRoot);

    }

    // Class InstrumentForSurveyHttp provides http handler for
    // saving a Instrument for a parent Survey

    static class InstrumentForSurveyHttp
         extends HandlerBase implements HttpHandler
    {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException
        {
            switch(httpExchange.getRequestMethod().toUpperCase())
            {
                case "POST":
                    addInstrumentForSurveyRequest(httpExchange);
                    break;
                case "OPTIONS":
                    // With a POST request weneed to handle OPTIONS for some browsers

                    replyInstrumentForSurveyOptions(httpExchange);
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

        private void replyInstrumentForSurveyOptions(HttpExchange httpExchange)
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

        interface IInstrumentForSurvey
        {
            int getID();
            void setID(int nKey);

            IInstrument getInstrument();
            void setInstrument(IInstrument typeSerial);
        }

        class AddInstrumentForSurveyAdapter
            implements IInstrumentForSurvey
        {
            @SerializedName("ID")
            int m_nID;
            @SerializedName("Instrument")
            IInstrument m_typeInstrument;

            public int getID()
            {
                return m_nID;
            }
            public void setID(int nKey)
            {
                m_nID = nKey;
            }

            public IInstrument getInstrument()
            {
                return m_typeInstrument;
            }
            public void setInstrument(IInstrument typeSerial)
            {
                m_typeInstrument = typeSerial;
            }
        }

        class AddInstrumentForSurveySerialiser
            implements JsonDeserializer<IInstrumentForSurvey>
        {
            public IInstrumentForSurvey deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
             {
                 GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerialiser());
                 gsonBuilder.registerTypeAdapter(IInstrument.class, new InstrumentAdapter());
                 Gson gsonInstance = gsonBuilder.create();
                 return gsonInstance.fromJson(json, AddInstrumentForSurveyAdapter.class);
             }
        }

        private void addInstrumentForSurveyRequest(HttpExchange httpExchange)
        {
            try
            {
                InputStreamReader requestReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
                BufferedReader readBuf = new BufferedReader(requestReader);
                String strJson = readBuf.readLine();
                GsonBuilder gsonBuild = new GsonBuilder()
                                            .registerTypeAdapter(IInstrumentForSurvey.class, new AddInstrumentForSurveySerialiser())
                                            .setDateFormat("yyyy-MM-dd hh:mm:ss");
                Gson gsonInstance = gsonBuild.create();
                IInstrumentForSurvey addTypeSerialised = gsonInstance.fromJson(strJson, IInstrumentForSurvey.class);
                IInstrument typeSerialised = InstrumentAdapter.addForSurvey
                                (
                                    ConnectionManager.getInstance().getConnection(),
                                    addTypeSerialised.getInstrument(),
                                    addTypeSerialised.getID()
                                );
                // Respond with the newly added Instrument
                String strJsonResponse = ((ISerialiseState) typeSerialised).toJson();
                System.out.println(getTimestamp() + "Instrument request: POST responding with " + HTTP_200 + ", data length: " + strJsonResponse.length());
                super.updateHeaders(httpExchange);
                httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                httpExchange.getResponseBody().write(strJsonResponse.getBytes());
                httpExchange.getResponseBody().close();
                httpExchange.close();
            }
            catch(SQLException exc)
            {
                System.out.println(getTimestamp() + "Instrument request: POST SQL exception: " + exc.getMessage());
            }
            catch (IOException exc)
            {
                System.out.println(getTimestamp() + "Instrument request: POST IO exception: " + exc.getMessage());
            }
            finally
            {
            }
        }

        public static void registerHandler(HttpServer httpServer, String strApiRoot)
        {
            String strPath = (!strApiRoot.isEmpty() ? "/" + strApiRoot : "") + "/Instruments/addInstrumentToSurvey";
            httpServer.createContext(strPath, new InstrumentForSurveyHttp());
        }
    } 
}
