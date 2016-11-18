package com.lenny.Utils;


import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
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
    protected Map<String, QueryParam> m_mapRequestParams;

    protected HandlerBase()
    {
        m_mapRequestParams = new HashMap<>();
    }

    public static final class QueryParam
    {
        String m_strValue;
        String m_strParam;

        QueryParam(String strParam, String strValue)
        {
            m_strValue = strValue;
            m_strParam = strParam;
        }

        public String getValue()
        {
            return m_strValue;
        }
        public String getParam()
        {
            return m_strParam;
        }
    }

    static QueryParam createFromQuery(String strQuery)
    {
        String[] listParts = strQuery.split("=");

        if(listParts.length == 2)
        {
            return new QueryParam(listParts[0], listParts[1]);
        }
        return null;
    }

    protected Map<String, QueryParam> getRequestMap()
    {
        return m_mapRequestParams;
    }

    protected boolean buildRequestMap(String strRequestQuery)
    {
        m_mapRequestParams = Arrays.stream(strRequestQuery.split("&"))
            .map(query -> createFromQuery(query))
            .filter(queryParam -> queryParam != null)
            .collect(Collectors.toMap(queryParam -> queryParam.getParam(), queryParam -> queryParam));
        return m_mapRequestParams.size() > 0;
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
//        httpExchange.getResponseHeaders().add(ACCESS_CONTROL_ALLOW_HEADERS, "x-prototype-version,x-requested-with");
        httpExchange.getResponseHeaders().add(ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,PUT");
        httpExchange.getResponseHeaders().add(CONTENT_TYPE, APPLICATION_JSON);
    }

}
