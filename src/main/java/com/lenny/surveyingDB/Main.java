package com.lenny.surveyingDB;

import com.lenny.Utils.CmdLineParser;
import com.lenny.surveyingDB.webAPI.surveyDbServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class Main
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    private static String PORT_ARG = "PORT";
    public static void main(String[] args) throws IOException
    {
        CmdLineParser cmdLineParser = new CmdLineParser(args);
        if(cmdLineParser.getArg(PORT_ARG) == null)
        {
            LOGGER.error("Incorrect usage - use command line argument PORT=<port number> and try again.");
            return;
        }

        Thread runServer = null;
        if(cmdLineParser.getArg(PORT_ARG).asIntValue() != Integer.MIN_VALUE)
        {
            LOGGER.info("Starting surveyDbServer on port " + cmdLineParser.getArg(PORT_ARG).value());
            runServer = new Thread()
            {

                public void run()
                {
                    try
                    {
                        surveyDbServer server = surveyDbServer.createServer(cmdLineParser.getArg(PORT_ARG).asIntValue(), "");
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            };

            runServer.start();

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
}
