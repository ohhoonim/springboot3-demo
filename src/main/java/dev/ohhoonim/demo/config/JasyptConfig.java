package dev.ohhoonim.demo.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
<<<<<<< HEAD

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        String key = "452948404D635166546A576E5A7234753778214125442A462D4A614E64526755";
=======
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        String key = "4B6250655368566D597133743677397A244326462948404D635166546A576E5A";
        
>>>>>>> security-init
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
