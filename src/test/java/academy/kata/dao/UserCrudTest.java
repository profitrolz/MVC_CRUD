package academy.kata.dao;

import academy.kata.config.InMemoryDBTest;
import academy.kata.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.NoResultException;
import java.util.List;


class UserCrudTest extends InMemoryDBTest {

    @Test
    public void saveUser_WhenSaveUser_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();
        userDao.save(user);
    }

    @Test
    public void findAll_WhenFindAll_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();
        userDao.save(user);
        Assertions.assertEquals(userDao.findAll(), List.of(user));
    }

    @Test
    public void findById_WhenFindById_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();


        User user2 = User.builder()
                .firstName("Irina")
                .lastName("Sheik")
                .build();

        userDao.save(user);
        userDao.save(user2);
        Assertions.assertEquals(userDao.findById(2L), user2);
    }

    @Test
    public void updateUser_WhenUpdate_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();

        userDao.save(user);

        Assertions.assertEquals("Pupkin", userDao.findById(1L).getLastName());

        User user2 = User.builder()
                .id(1L)
                .firstName("Vasya")
                .lastName("Ivanov")
                .build();

        userDao.update(user2);

        Assertions.assertEquals("Ivanov", userDao.findById(1L).getLastName());
    }

    @Test
    public void removeUser_WhenRemove_GetOk() {
        User user = User.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .build();


        User user2 = User.builder()
                .firstName("Irina")
                .lastName("Sheik")
                .build();

        userDao.save(user);
        userDao.save(user2);

        Assertions.assertEquals(userDao.findById(2L), user2);

        userDao.delete(user2);
        Assertions.assertEquals(userDao.findById(1L), user);
        Assertions.assertThrows(NoResultException.class, () -> userDao.findById(2L));
    }


}
