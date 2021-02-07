package com.lenny.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class StandardSSLProvider implements KeystoreProvider
{
    private static final Logger LOGGER = LogManager.getLogger(ApiCertificate.class.getName());
    private static final String PROTOCOL = "TLSv1.3";

    public StandardSSLProvider()
    {

    }

    @Override
    public SSLContext getSSLContext
        (
            char[] storePass,
            char[] keyPass,
            String strKeystore,
            String strAlias,
            String strKeystoreAlgorithm,
            String strKeyManagerAlgorithm
        )
    {
        try
        {
            FileInputStream keystoreStream = new FileInputStream(strKeystore);
            KeyStore keystore = null;
            try
            {
                keystore = KeyStore.getInstance(strKeystoreAlgorithm);
                keystore.load(keystoreStream, storePass);
                Certificate certificate = keystore.getCertificate(strAlias);
                LOGGER.debug(certificate);
            }
            catch(KeyStoreException exc)
            {
                LOGGER.error("keystore exception", exc);
                return null;
            }
            catch (NoSuchAlgorithmException exc)
            {
                LOGGER.error("keystore no such algorithm (" + strKeystoreAlgorithm + ")", exc);
                return null;
            }
            catch(CertificateException exc)
            {
                LOGGER.error("Certificate exception", exc);
                return null;
            }

            if(keystore != null)
            {
                try
                {
                    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(strKeyManagerAlgorithm);
                    keyManagerFactory.init(keystore, keyPass);

                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(strKeyManagerAlgorithm);
                    trustManagerFactory.init(keystore);

                    SSLContext sslContext = SSLContext.getInstance(PROTOCOL);
                    sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

                    return sslContext;
                }
                catch(NoSuchAlgorithmException exc)
                {
                    LOGGER.error("key manager no such algorithm (" + strKeyManagerAlgorithm + ")", exc);
                    return null;
                }
                catch(KeyStoreException exc)
                {
                    LOGGER.error("key manager keystore exception", exc);
                    return null;
                }
                catch(UnrecoverableKeyException exc)
                {
                    LOGGER.error("key manager cannot recover key", exc);
                    return null;
                }
                catch(KeyManagementException exc)
                {
                    LOGGER.error("key management exception", exc);
                    return null;
                }
            }
        }
        catch(IOException exc)
        {
            LOGGER.error("Io exception", exc);
        }

        return null;
    }
}
