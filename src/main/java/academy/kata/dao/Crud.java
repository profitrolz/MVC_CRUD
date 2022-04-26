package academy.kata.dao;

import java.util.List;

public interface Crud <T> {
    void create (T t);

    void update(T t);

    List<T> findAll();

    void delete(T t);
}