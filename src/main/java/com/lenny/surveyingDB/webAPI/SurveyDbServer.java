package com.lenny.surveyingDB.webAPI;

import com.lenny.Utils.ISerialiseState;
import com.lenny.surveyingDB.adapters.*;
import com.lenny.surveyingDB.interfaces.ISurvey;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyDbServer
{
    private static int HTTP_404 = 404;
    private static String HTTP_ACCESS_DENIED = "Error 404: Access to %s denied";
    private static int HTTP_405 = 405;
    private static String HTTP_ILLEGAL_METHOD = "Error 405: Method %s not supported";
    private static int HTTP_200 = 200;

    private HttpServer m_httpServer;
    private int m_nPort;
    private File m_fileSurveyDb;

    private SurveyDbServer(int nPortNo) throws IOException
    {
        m_httpServer = HttpServer.create(new InetSocketAddress(nPortNo), 0);
        m_nPort = nPortNo;
    }

    public static SurveyDbServer createServer(int nPortNo)
    {
        SurveyDbServer surveyServer = null;
        if(nPortNo > 1023)
        {
            try
            {
                surveyServer = new SurveyDbServer(nPortNo);
            }
            catch(IOException exc)
            {

            }
        }
        return surveyServer;
    }

    public void initServer() throws SQLException
    {
        m_fileSurveyDb = new File("survey.db");
        if(!m_fileSurveyDb.exists())
        {
            buildNewDatabase("survey.db");
        }
        m_httpServer.createContext("/", new RootHandler());
        m_httpServer.createContext("/surveys", new SurveysHandler());
        m_httpServer.createContext("/curr_survey", new CurrentSurveyHandler());
        m_httpServer.setExecutor(null);
        m_httpServer.start();
    }

    private void buildNewDatabase(String s) throws SQLException
    {
        Connection connDb = DriverManager.getConnection("jdbc:sqlite:survey.db");

        SurveyPointTypeAdapter.createInDatabase(connDb);
        SurveyReferenceAdapter.createInDatabase(connDb);
        InstrumentManufacturerAdapter.createInDatabase(connDb);
        InstrumentAdapter.createInDatabase(connDb);
        ProjectionAdapter.createInDatabase(connDb);
        SurveyAdapter.createInDatabase(connDb);
        TraverseAdapter.createInDatabase(connDb);
        SurveyPointAdapter.createInDatabase(connDb);
        SurveyImageAdapter.createInDatabase(connDb);
        SurveyMeasurementAdapter.createInDatabase(connDb);

        connDb.close();
    }

    private class RootHandler implements HttpHandler
    {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException
        {

        }
    }

    private class SurveysHandler implements HttpHandler
    {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException
        {
            switch(httpExchange.getRequestMethod())
            {
                case "GET":
                    getSurveysRequest(httpExchange);
                    break;
                case "PUT":
                case "POST":
                case "DELETE":
                case "":
                default:
                    handleIncorrectRequest(httpExchange, HTTP_405, HTTP_ILLEGAL_METHOD, httpExchange.getRequestMethod());
                    break;
            }

        }

        private void handleIncorrectRequest(HttpExchange httpExchange, int nErrorNo, String strErrorResponse, String strErrorExtra) throws IOException
        {
            String strMsg = strErrorExtra.isEmpty() ? strErrorResponse : String.format(strErrorResponse, strErrorExtra);
            httpExchange.sendResponseHeaders(nErrorNo, strMsg.length());
            httpExchange.getResponseBody().write(strMsg.getBytes());
            httpExchange.getResponseBody().flush();
            httpExchange.close();
        }

        private void getSurveysRequest(HttpExchange httpExchange)
        {
            try
            {
                String strRequest = httpExchange.getRequestURI().getQuery();
                if(strRequest == null || strRequest.isEmpty())
                {
                    Connection connDb = null;
                    connDb = DriverManager.getConnection("jdbc:sqlite:survey.db");
                    List<ISurvey> listSurveys = SurveyAdapter.getAll(connDb);
                    String strJsonResponse = "[" + listSurveys.stream()
                            .map(survey -> ((ISerialiseState) survey).toJson())
                        .collect(Collectors.joining(",")) + "]";
                    httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                    httpExchange.getResponseBody().write(strJsonResponse.getBytes());
                    connDb.close();
                }
                else if(strRequest.matches("id=\\d+"))
                {
                    String[] listParts = strRequest.split("=");
                    Connection connDb = null;
                    connDb = DriverManager.getConnection("jdbc:sqlite:survey.db");
                    ISurvey survey = SurveyAdapter.get(connDb, Integer.parseInt(listParts[1]));
                    String strJsonResponse = ((ISerialiseState) survey).toJson();
                    httpExchange.sendResponseHeaders(HTTP_200, strJsonResponse.length());
                    httpExchange.getResponseBody().write(strJsonResponse.getBytes());
                    connDb.close();
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
    }

    private class CurrentSurveyHandler implements HttpHandler
    {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException
        {

        }
    }
}
