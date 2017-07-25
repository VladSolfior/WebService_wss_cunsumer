package com.vladapps.fmanager.web.user;

import com.vladapps.fmanager.model.User;
import com.vladapps.fmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.vladapps.fmanager.util.ValidationUtil.checkIdConsistent;
import static com.vladapps.fmanager.util.ValidationUtil.checkNew;


public abstract class AbstractUserController {

    private final UserService service;

    private static final Logger log = LoggerFactory.getLogger(AbstractUserController.class);

    public AbstractUserController(UserService userService) {
        this.service = userService;
    }

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(long id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.save(user);
    }

    public void delete(long id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, long id) {
        log.info("update {}", user);
        checkIdConsistent(user, id);
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }
}
