package com.example.consent.src.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.consent",
        entityManagerFactoryRef = "databaseEntityManager"
)
public class DatabaseConfig {

    @Primary
    @Bean(name = "databaseSource")
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/ctaskinfo");
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.username("youruser");
        dataSourceBuilder.password("mypass");
        return dataSourceBuilder.build();
    }

    @Primary
    @Bean(name = "databaseEntityManager")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("databaseSource") DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
                .packages("com.example.consent")
                .persistenceUnit("db1")
                .build();
    }

    @Primary
    @Bean(name = "databaseTransactionManager")
    public PlatformTransactionManager customerTransactionManager(
            @Qualifier("databaseEntityManager") EntityManagerFactory customerEntityManagerFactory
    ) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }
}
