package dev.ohhoonim.demo.config.datasource;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"dev.ohhoonim.demo.repository.primary"},
            entityManagerFactoryRef = "primaryEntityManagerFactory",
            transactionManagerRef = "primaryJpaTransactionManager")
public class PrimaryDatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.primary")
    public HikariConfig primaryHikariConfig() {
        return new HikariConfig();
    }

    @Primary
    @Bean(name = "primaryDatasource")
    public DataSource primaryDatasource() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(primaryHikariConfig()));
    }

    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDatasource") DataSource primaryDatasource) {
        return builder.dataSource(primaryDatasource).packages("dev.ohhoonim.demo.model.primary")
                .persistenceUnit("hikari").properties(jpaProperties()).build();
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
	    props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName()); 
        props.put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName()); 
        return props;
    }

    @Primary
    @Bean(name = "primaryJpaTransactionManager")
    public PlatformTransactionManager primaryJpaTransactionManager(
        @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {
        return new JpaTransactionManager(primaryEntityManagerFactory);
    }

   /*
   https://github.com/spring-projects/spring-data-commons/issues/2232
   ChainedTransactionManager는 deprecate 되었습니다.
   */ 
}
