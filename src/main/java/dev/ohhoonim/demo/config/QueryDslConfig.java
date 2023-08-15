package dev.ohhoonim.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class QueryDslConfig {

    @PersistenceContext(unitName = "primaryEntityManager")
    private EntityManager primaryJpaTransactionManager;
    @PersistenceContext(unitName = "secondaryEntityManager")
    private EntityManager secondaryJpaTransactionManager;

    @Bean
    public JPAQueryFactory primaryJpaQueryFactory() {
        return new JPAQueryFactory(primaryJpaTransactionManager);
    }

    @Bean
    public JPAQueryFactory secondaryJpaQueryFactory() {
        return new JPAQueryFactory(secondaryJpaTransactionManager);
    }
}
