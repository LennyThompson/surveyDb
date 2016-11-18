package com.lenny.surveyingDB.webAPI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lenny.Utils.ConnectionManager;
import com.lenny.surveyingDB.webAPI.*;
import com.lenny.surveyingDB.adapters.*;

public class SurveyDbServer
{
    // Todo: Turn this into a configuration item...

    private static int HTTP_404 = 404;
    private static String HTTP_ACCESS_DENIED = "Error 404: Access to %s denied";
    private static int HTTP_405 = 405;
    private static String HTTP_ILLEGAL_METHOD = "Error 405: Method %s not supported";
    private static int HTTP_200 = 200;

    private static String DEFAULT_FILE_NAME = "SurveyDb.db";
    private HttpServer m_httpServer;
    private int m_nPort;
    private File m_fileSurveyDb;
    private String m_strDbName;

    private SurveyDbServer(int nPortNo) throws IOException
    {
        m_httpServer = HttpServer.create(new InetSocketAddress(nPortNo), 0);
        m_nPort = nPortNo;
        m_strDbName = DEFAULT_FILE_NAME;
    }

    public static SurveyDbServer createServer(int nPortNo, String strDbName) throws SQLException
    {
        SurveyDbServer server = null;
        if(nPortNo > 1023)
        {
            try
            {
                server = new SurveyDbServer(nPortNo);
                if
                (
                    strDbName != null
                    &&
                    !strDbName.isEmpty()
                )
                {
                    server.m_strDbName = strDbName;
                }
            }
            catch(IOException exc)
            {

            }
        }
        server.initServer();
        return server;
    }

    public void initServer() throws SQLException
    {
        m_fileSurveyDb = new File(m_strDbName);
        if(!m_fileSurveyDb.exists())
        {
            buildNewDatabase(m_strDbName);
        }
        else
        {
            ConnectionManager.getInstance().initConnection(m_strDbName);
        }
        m_httpServer.createContext("/api", new SurveysHttpHandler());
        SurveyPointTypesHttpHandler.registerHandler(m_httpServer, "api");
        SurveyReferencesHttpHandler.registerHandler(m_httpServer, "api");
        InstrumentManufacturersHttpHandler.registerHandler(m_httpServer, "api");
        InstrumentsHttpHandler.registerHandler(m_httpServer, "api");
        ProjectionsHttpHandler.registerHandler(m_httpServer, "api");
        SurveyPointsHttpHandler.registerHandler(m_httpServer, "api");
        SurveysHttpHandler.registerHandler(m_httpServer, "api");
        SurveyMeasurementsHttpHandler.registerHandler(m_httpServer, "api");
        SurveyImagesHttpHandler.registerHandler(m_httpServer, "api");
        TraversesHttpHandler.registerHandler(m_httpServer, "api");
        SurveyAdjustmentsHttpHandler.registerHandler(m_httpServer, "api");
        TraverseClosuresHttpHandler.registerHandler(m_httpServer, "api");

        m_httpServer.setExecutor(null);
        m_httpServer.start();
    }

    private void buildNewDatabase(String strDbName) throws SQLException
    {
        Connection connDb = ConnectionManager.getInstance().initConnection(strDbName);

        SurveyPointTypeAdapter.createInDatabase(connDb);
        SurveyReferenceAdapter.createInDatabase(connDb);
        InstrumentManufacturerAdapter.createInDatabase(connDb);
        InstrumentAdapter.createInDatabase(connDb);
        ProjectionAdapter.createInDatabase(connDb);
        SurveyPointAdapter.createInDatabase(connDb);
        SurveyAdapter.createInDatabase(connDb);
        SurveyMeasurementAdapter.createInDatabase(connDb);
        SurveyImageAdapter.createInDatabase(connDb);
        TraverseAdapter.createInDatabase(connDb);
        SurveyAdjustmentAdapter.createInDatabase(connDb);
        TraverseClosureAdapter.createInDatabase(connDb);

    }

}
