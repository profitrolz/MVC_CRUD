package academy.kata.service;

import academy.kata.dao.Crud;
import academy.kata.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Crud<User> userCrud;

    public UserService(Crud<User> userCrud) {
        this.userCrud = userCrud;
    }

    public void create(User user) {
        userCrud.create(user);
    }

    public void update(User user) {
        userCrud.update(user);
    }

    public List<User> findAll() {
        return userCrud.findAll();
    }

    public void delete(User user) {
        userCrud.delete(user);
    }
}
