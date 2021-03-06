package com.vladapps.fmanager.repository;


import com.vladapps.fmanager.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(long id);

    // null if not found
    User get(long id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

    default User getWithBuys(long id){
        throw new UnsupportedOperationException();
    }
}