package com.vladapps.fmanager.web;

import com.vladapps.fmanager.model.User;
import com.vladapps.fmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserRestController.REST_URL)
public class UserRestController {

    static final String REST_URL = "/api/users";

    private final UserRepository userDao;

    @Autowired
    public UserRestController(UserRepository userDao) {
        this.userDao = userDao;
    }

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";


    @GetMapping("/get-by-name")
    @ResponseBody
    public String getByEmail(String email) {
        String userId = "";
        try {
            User user = userDao.getByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }
}
