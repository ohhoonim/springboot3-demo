package dev.ohhoonim.demo;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JasyptApplicaitonTest {

    @Autowired
    StringEncryptor jasyptStringEncryptor;

    @Test
    void jasypt() {
        String value = ""; 
        String result = jasyptEncoding(value);
        log.debug("---{}---", result);

        log.debug(stringEncryptor().decrypt(result)); 
    }

    public String jasyptEncoding(String value) {
        String key = "452948404D635166546A576E5A7234753778214125442A462D4A614E64526755";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }


    private StringEncryptor stringEncryptor() {
        String key = "452948404D635166546A576E5A7234753778214125442A462D4A614E64526755";
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key); // encrypt key

        config.setAlgorithm("PBEWITHMD5ANDDES");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
