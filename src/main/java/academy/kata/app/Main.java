package academy.kata.app;

import academy.kata.config.AppConfig;
import academy.kata.model.User;
import academy.kata.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");

        User user = User.builder()
                .firstName("Alexey")
                .lastName("Mamaev")
                .build();

        userService.save(user);
    }
}
