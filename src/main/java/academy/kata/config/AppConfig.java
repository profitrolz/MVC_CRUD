package academy.kata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = {"academy.kata.service", "academy.kata.dao"})
public class AppConfig {

    private Environment env;


    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public EntityManagerFactory getEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("academy.kata.mySql");
    }

    @Bean
    public EntityManager getEntityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

}
