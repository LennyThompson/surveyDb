package com.lenny.Utils;


import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HandlerBase
{
    public static int HTTP_404 = 404;
    public static String HTTP_ACCESS_DENIED = "Error 404: Access to %s denied";
    public static int HTTP_405 = 405;
    public static String HTTP_ILLEGAL_METHOD = "Error 405: Method %s not supported";
    public static int HTTP_200 = 200;

    public static String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static String CONTENT_TYPE = "Content-Type";
    public static String APPLICATION_JSON = "application/json";

    protected HandlerBase()
    {

    }


    protected void handleIncorrectRequest(HttpExchange httpExchange, int nErrorNo, String strErrorResponse, String strErrorExtra) throws IOException
    {
        String strMsg = strErrorExtra.isEmpty() ? strErrorResponse : String.format(strErrorResponse, strErrorExtra);
        httpExchange.sendResponseHeaders(nErrorNo, strMsg.length());
        httpExchange.getResponseBody().write(strMsg.getBytes());
        httpExchange.getResponseBody().flush();
        httpExchange.close();
    }

    protected void updateHeaders(HttpExchange httpExchange)
    {
        httpExchange.getResponseHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        httpExchange.getResponseHeaders().add(ACCESS_CONTROL_ALLOW_HEADERS, "Origin, Content-Type, X-Auth-Token");
        httpExchange.getResponseHeaders().add(ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,PUT,OPTIONS");
        httpExchange.getResponseHeaders().add(CONTENT_TYPE, APPLICATION_JSON);
    }

    protected String getTimestamp()
    {
        return SQLiteConverter.convertDateTimeToString(LocalDateTime.now());
    }

}
