package com.lenny.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestMap
{
    protected Map<String, QueryParam> m_mapRequestParams;
    public RequestMap()
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

    public Map<String, QueryParam> getRequestMap()
    {
        return m_mapRequestParams;
    }

    public boolean buildRequestMap(String strRequestQuery)
    {
        m_mapRequestParams = Arrays.stream(strRequestQuery.split("&"))
            .map(query -> createFromQuery(query))
            .filter(queryParam -> queryParam != null)
            .collect(Collectors.toMap(queryParam -> queryParam.getParam(), queryParam -> queryParam));
        return m_mapRequestParams.size() > 0;
    }

}
