package com.lenny.surveyingDB.webAPI;

import com.lenny.Utils.ApiCertificate;
import com.lenny.surveyingDB.Main;
import com.sun.net.httpserver.*;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lenny.Utils.ConnectionManager;
import com.lenny.surveyingDB.webAPI.*;
import com.lenny.surveyingDB.adapters.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

public class surveyDbServer
{
    private static final Logger LOGGER = LogManager.getLogger(surveyDbServer.class.getName());
    // Todo: Turn this into a configuration item...

    private static int HTTP_404 = 404;
    private static String HTTP_ACCESS_DENIED = "Error 404: Access to %s denied";
    private static int HTTP_405 = 405;
    private static String HTTP_ILLEGAL_METHOD = "Error 405: Method %s not supported";
    private static int HTTP_200 = 200;

    private static String DEFAULT_FILE_NAME = "surveyDb.db";
    private HttpsServer m_httpServer;
    private int m_nPort;
    private File m_filesurveyDb;
    private String m_strDbName;

    private surveyDbServer(int nPortNo) throws IOException
    {
        m_nPort = nPortNo;
        m_strDbName = DEFAULT_FILE_NAME;
    }

    public static surveyDbServer createServer(int nPortNo, String strDbName, ApiCertificate certificate) throws SQLException
    {
        surveyDbServer server = null;
        if (nPortNo > 1023)
        {
            try
            {
                server = new surveyDbServer(nPortNo);
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
            catch (IOException exc)
            {

            }
        }
        if(server.initServer(certificate.getSSLContext()))
        {
            return server;
        }
        return null;
    }

    public boolean initServer(SSLContext sslContext) throws SQLException
    {
        m_filesurveyDb = new File(m_strDbName);
        if (!m_filesurveyDb.exists())
        {
            buildNewDatabase(m_strDbName);
        }
        else
        {
            ConnectionManager.getInstance().initConnection(m_strDbName);
        }

        try
        {
            m_httpServer = HttpsServer.create(new InetSocketAddress(m_nPort), 0);
            m_httpServer.setHttpsConfigurator(new HttpsConfigurator(sslContext)
            {
                public void configure(HttpsParameters params)
                {
                    try
                    {
                        // initialise the SSL context
                        SSLContext sslContext = getSSLContext();
                        SSLEngine engine = sslContext.createSSLEngine();
                        params.setNeedClientAuth(false);
                        params.setCipherSuites(engine.getEnabledCipherSuites());
                        params.setProtocols(engine.getEnabledProtocols());

                        params.setSSLParameters(sslContext.getDefaultSSLParameters());
                    }
                    catch (Exception exc)
                    {
                        LOGGER.error("Https parameters failure", exc);
                    }
                }
            });
        }
        catch(IOException exc)
        {
            LOGGER.error("IO exception",exc);
            return false;
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
        TraverseSummarysHttpHandler.registerHandler(m_httpServer, "api");
        TraverseMeasurementSummarysHttpHandler.registerHandler(m_httpServer, "api");
        SurveyPointSummarysHttpHandler.registerHandler(m_httpServer, "api");
        SurveySummarysHttpHandler.registerHandler(m_httpServer, "api");

        m_httpServer.setExecutor(null);
        m_httpServer.start();

        return true;
    }

    public static void buildNewDatabase(String strDbName) throws SQLException
    {
        String strDbConnName = "jdbc:sqlite:" + strDbName;
        Connection connDb = DriverManager.getConnection(strDbConnName);

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
        TraverseSummaryAdapter.createInDatabase(connDb);
        TraverseMeasurementSummaryAdapter.createInDatabase(connDb);
        SurveyPointSummaryAdapter.createInDatabase(connDb);
        SurveySummaryAdapter.createInDatabase(connDb);

    }

}
