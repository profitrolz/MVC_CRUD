package academy.kata.config;

import academy.kata.dao.UserCrud;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public abstract class InMemoryDBTest {

    protected UserCrud userDao;

    @BeforeEach
    void initialize(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringTestConfig.class);
        userDao = context.getBean(UserCrud.class);
    }
}
