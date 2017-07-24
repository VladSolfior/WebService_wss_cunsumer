package com.vladapps.fmanager.repository;

import com.vladapps.fmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {
    private static final Sort SORT_NAME_EMAIL = new Sort("name", "email");

    private final CrudUserRepository crudRepository;

    @Autowired
    public DataJpaUserRepositoryImpl(CrudUserRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public boolean delete(long id) {
        return crudRepository.delete((int) id) != 0;
    }

    @Override
    public User get(long id) {
        return crudRepository.findOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return crudRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

    @Override
    public User getWithBuys(long id) {
        return crudRepository.getWithBuys(id);
    }
}
