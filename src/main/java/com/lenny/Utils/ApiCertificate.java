package com.lenny.Utils;

import com.lenny.surveyingDB.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class ApiCertificate
{
    private static final Logger LOGGER = LogManager.getLogger(ApiCertificate.class.getName());

    ApiCertificate(SurveyConfig.CertificateConfig certConfig)
    {
        m_certConfig = certConfig;
    }

    public static ApiCertificate createCertificate(SurveyConfig.CertificateConfig certConfig, KeystoreProvider keystoreProvider)
    {
        LOGGER.info("Creating API certificate from file: " + certConfig.keystore());
        ApiCertificate apiCertificate = new ApiCertificate((certConfig));
        if(apiCertificate.init(keystoreProvider))
        {
            return apiCertificate;
        }
        return null;
    }

    public SSLContext getSSLContext()
    {
        return m_sslContext;
    }

    private boolean init(KeystoreProvider keystoreProvider)
    {
        m_sslContext = keystoreProvider.getSSLContext
            (
                m_certConfig.storepass().toCharArray(),
                m_certConfig.keypass().toCharArray(),
                m_certConfig.keystore(),
                m_certConfig.alias(),
                "JKS",
                "SunX509"
            );
        if(m_sslContext != null)
        {
            return true;
        }
        return false;
    }
    SSLContext m_sslContext;
    SurveyConfig.CertificateConfig m_certConfig;
}
