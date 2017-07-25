package com.vladapps.fmanager.web;

import com.vladapps.fmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class UserController {

    private UserService userService;
    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }



}
