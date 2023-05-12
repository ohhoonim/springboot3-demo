package dev.ohhoonim.demo;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JasyptTest {
    
    @Test
    public void jasyptTest() {
        String value = "jdbc:mariadb://192.168.1.253:3306/testdb"; 
        String result = jasyptEncoding(value);
        log.debug("---{}---", result);

        
    }

    public String jasyptEncoding(String value) {
        String key = "4B6250655368566D597133743677397A244326462948404D635166546A576E5A";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
}
