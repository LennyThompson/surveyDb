package com.lenny.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
    private static ConnectionManager INSTANCE;
    private String m_strDbName;
    public static ConnectionManager getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new ConnectionManager();
        }
        return INSTANCE;
    }

    public Connection initConnection(String strDbName) throws SQLException
    {
        m_strDbName = "jdbc:sqlite:" + strDbName;
        return getConnection();
    }

    public Connection getConnection() throws SQLException
    {
        Connection connDb = DriverManager.getConnection(m_strDbName);
        return connDb;
    }
}
