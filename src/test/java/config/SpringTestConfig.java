package config;

import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(value = "academy.kata.dao")
public class SpringTestConfig {

    @Autowired
    private final Environment environment;

    public SpringTestConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource getDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUser(environment.getProperty("user"));
        dataSource.setPassword(environment.getProperty("password"));
        dataSource.setURL(environment.getProperty("url"));
        return dataSource;
    }

    @Bean("LocalContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean getEm(DataSource dataSource) {

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));


        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaProperties(properties);
        emf.setPackagesToScan("academy.kata.model");
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emf.afterPropertiesSet();

        return emf;
    }

    @Bean
    public EntityManagerFactory getEntityManagerFactory(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        return localContainerEntityManagerFactoryBean.getObject();
    }

    @Bean
    public EntityManager getEntityManager(@Autowired @Qualifier("LocalContainerEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
}
