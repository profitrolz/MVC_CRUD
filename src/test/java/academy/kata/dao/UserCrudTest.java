package academy.kata.dao;

import academy.kata.config.InMemoryDBTest;
import academy.kata.model.User;
import org.junit.jupiter.api.Test;

class UserCrudTest extends InMemoryDBTest {

    @Test
    public void saveUserWhenSaveUser_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();
        userDao.create(user);
    }

}
