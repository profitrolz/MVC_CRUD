package academy.kata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(value = "academy.kata.dao")
public class SpringTestConfig {

    private Environment env;


    public SpringTestConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public EntityManagerFactory getEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("academy.kata.h2");
    }

    @Bean
    public EntityManager getEntityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
}
