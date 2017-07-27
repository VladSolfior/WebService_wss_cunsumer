package com.vladapps.fmanager.web.user;

import com.vladapps.fmanager.AuthorizedUser;
import com.vladapps.fmanager.model.User;
import com.vladapps.fmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractUserController {
    static final String REST_URL = "/rest/profile";

    @Autowired
    public ProfileRestController(UserService service) {
        super(service);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        return super.get(AuthorizedUser.getId());
    }

    @DeleteMapping
    public void delete() {
        super.delete(AuthorizedUser.getId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        super.update(user, AuthorizedUser.getId());
    }
}