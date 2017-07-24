package com.vladapps.fmanager.web;

import com.vladapps.fmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by vlad on 24-Jul-17.
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userDao;


    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}
