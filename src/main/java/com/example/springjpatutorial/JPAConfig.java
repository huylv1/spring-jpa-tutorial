package com.example.springjpatutorial;

import com.example.springjpatutorial.entity.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@ConditionalOnProperty(
        value="app.main.data-source.primary",
        havingValue = "true",
        matchIfMissing = false)
@EnableTransactionManagement()
@EnableJpaRepositories(transactionManagerRef = "mainTransactionManager", basePackages = "com.example.springjpatutorial.dao")
public class JPAConfig {

    private final PersistenceUnitManager persistenceUnitManager;
    public JPAConfig(ObjectProvider<PersistenceUnitManager> persistenceUnitManager) {
        this.persistenceUnitManager = persistenceUnitManager.getIfAvailable();
    }

    @Bean
    @ConfigurationProperties(prefix="app.main.jpa")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.main.data-source")
    public DataSource mainDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            JpaProperties jpaProperties, DataSource dataSource) {
        EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(
                jpaProperties);
        return builder
                .dataSource(dataSource)
                .packages("com.example.springjpatutorial.entity")
                .persistenceUnit("mainDs")
                .build();
    }

    @Bean
    @Primary
    public JpaTransactionManager mainTransactionManager(
            EntityManagerFactory mainEntityManager) {
        return new JpaTransactionManager(mainEntityManager);
    }

    private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(
            JpaProperties jpaProperties) {
        return new EntityManagerFactoryBuilder(createJpaVendorAdapter(),
                jpaProperties.getProperties(), this.persistenceUnitManager);
    }


    private JpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }


}
