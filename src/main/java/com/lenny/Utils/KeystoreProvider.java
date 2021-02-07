package com.lenny.Utils;

import javax.net.ssl.SSLContext;

public interface KeystoreProvider
{
    SSLContext getSSLContext
        (
            char[] storePass,
            char[] keyPass,
            String strKeystore,
            String strAlias,
            String strKeystoreAlgorithm,
            String strKeyManagerAlgorithm
        );
}
