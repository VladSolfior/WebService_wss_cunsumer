package com.vladapps.fmanager.service;


import com.vladapps.fmanager.model.User;
import com.vladapps.fmanager.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(long id) throws NotFoundException;

    User get(long id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);
    
    void evictCache();

    User getWithBuys(long id);
}