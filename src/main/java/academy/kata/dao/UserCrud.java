package academy.kata.dao;

import academy.kata.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserCrud implements Crud<User> {

    private final EntityManager entityManager;

    @Autowired
    public UserCrud(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> findAll() {
        return null; //entityManager.createQuery("from users").getResultList();
    }

    @Override
    public void delete(User user) {

    }
}
