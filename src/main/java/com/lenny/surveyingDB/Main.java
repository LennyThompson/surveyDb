package com.lenny.surveyingDB;

import com.google.gson.GsonBuilder;
import com.lenny.Utils.ApiCertificate;
import com.lenny.Utils.CmdLineParser;
import com.lenny.Utils.StandardSSLProvider;
import com.lenny.Utils.SurveyConfig;
import com.lenny.surveyingDB.webAPI.surveyDbServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

public class Main
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    private static String CONFIG_ARG = "CONFIG";
    public static void main(String[] args) throws IOException
    {
        CmdLineParser cmdLineParser = new CmdLineParser(args);
        if(cmdLineParser.getArg(CONFIG_ARG) == null)
        {
            LOGGER.error("Incorrect usage - use command line argument CONFIG=<config file> and try again.");
            return;
        }

        SurveyConfig config = initConfig(cmdLineParser.getArg(CONFIG_ARG));
        Thread runServer = null;
        if(config != null && config.port() != Integer.MIN_VALUE)
        {
            ApiCertificate apiCertificate = ApiCertificate.createCertificate(config.certificate(), new StandardSSLProvider());
            if(apiCertificate != null)
            {

                LOGGER.info("Starting surveyDbServer on port " + config.port());
                runServer = new Thread()
                {

                    public void run()
                    {
                        try
                        {
                            surveyDbServer server = surveyDbServer.createServer(config.port(), config.database(), apiCertificate);
                        }
                        catch (SQLException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };

                runServer.start();
            }

        }
        else
        {
            LOGGER.error("Incorrect usage - the command line argument PORT=<port number> port number must be an integer.");
        }
        // Terminate on any command line input.

        LOGGER.info("Enter any character to terminate.");
        System.in.read();
        LOGGER.info("SurveyDb terminating.");
    }

    private static SurveyConfig initConfig(CmdLineParser.CmdLineArg argConfig)
    {
        SurveyConfig surveyConfig = null;
        if
        (
            argConfig != null
            &&
            Files.exists(Paths.get(argConfig.value()))
        )
        {
            try
            {
                String strJson = new String(Files.readAllBytes(Paths.get(argConfig.value())));

                GsonBuilder gsonBuild = new GsonBuilder();
                surveyConfig = SurveyConfig.fromJson(gsonBuild, strJson);
            }
            catch (IOException exc)
            {
                LOGGER.error("Failed to parse config " + argConfig.value(), exc);
            }
        }

        return surveyConfig;
    }
}
