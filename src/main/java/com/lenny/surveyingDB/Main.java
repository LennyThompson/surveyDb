package com.lenny.surveyingDB;

import com.lenny.Utils.CmdLineParser;
import com.lenny.surveyingDB.webAPI.surveyDbServer;

import java.io.IOException;
import java.sql.SQLException;

public class Main
{
    private static String PORT_ARG = "PORT";
    public static void main(String[] args) throws IOException
    {
        CmdLineParser cmdLineParser = new CmdLineParser(args);
        if(cmdLineParser.getArg(PORT_ARG) == null)
        {
            System.out.print("Incorrect usage - use command line argument PORT=<port number> and try again.");
            return;
        }

        Thread runServer = null;
        if(cmdLineParser.getArg(PORT_ARG).asIntValue() != Integer.MIN_VALUE)
        {
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
            System.out.print("Incorrect usage - the command line argument PORT=<port number> port number must be an integer.");
        }
        // Terminate on any command line input.

        System.out.println("Enter any character to terminate.");
        System.in.read();
    }
}
