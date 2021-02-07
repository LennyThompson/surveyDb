package com.lenny.Utils;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

public class SurveyConfig implements JsonSerializer<SurveyConfig>
{
    public class CertificateConfig
    {
        @SerializedName("Keystore")
        private String m_strKeystore;
        @SerializedName("Storepass")
        private String m_strStorePass;
        @SerializedName("Keypass")
        private String m_strKeyPass;
        @SerializedName("Alias")
        private String m_strAlias;

        public String keystore()
        {
            return m_strKeystore;
        }

        public String storepass()
        {
            return m_strStorePass;
        }

        public String keypass()
        {
            return m_strKeyPass;
        }

        public String alias()
        {
            return m_strAlias;
        }
    }

    @SerializedName("Port")
    private int m_nPortNo;
    @SerializedName("DatabaseLocation")
    private String m_strDbLocation;
    @SerializedName("DatabaseName")
    private String m_strDbName;
    @SerializedName("Certificate")
    private CertificateConfig m_certConfig;

    public int port()
    {
        return m_nPortNo;
    }

    public String databaseLocation()
    {
        return m_strDbName;
    }

    public String database()
    {
        return m_strDbName;
    }

    public CertificateConfig certificate()
    {
        return m_certConfig;
    }

    public static SurveyConfig fromJson(GsonBuilder gsonBuilder, String strJson)
    {
        Gson gsonInstance = gsonBuilder.create();
        return gsonInstance.fromJson(strJson, SurveyConfig.class);
    }

    @Override
    public JsonElement serialize(SurveyConfig surveyConfig, Type type, JsonSerializationContext jsonSerializationContext)
    {
        return null;
    }
}
