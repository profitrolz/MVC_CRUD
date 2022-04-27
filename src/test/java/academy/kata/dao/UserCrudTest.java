package academy.kata.dao;

import academy.kata.config.InMemoryDBTest;
import academy.kata.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class UserCrudTest extends InMemoryDBTest {

    @Test
    public void saveUser_WhenSaveUser_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();
        userDao.create(user);
    }

    @Test
    public void findAll_WhenFindAll_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();
        userDao.create(user);
        Assertions.assertEquals(userDao.findAll(), List.of(user));
    }


}
