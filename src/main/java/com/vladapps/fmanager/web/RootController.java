package com.vladapps.fmanager.web;

import com.vladapps.fmanager.AuthorizedUser;
import com.vladapps.fmanager.service.BuyService;
import com.vladapps.fmanager.service.UserService;
import com.vladapps.fmanager.util.TransactionsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {

    private UserService userService;

    private BuyService buyService;
    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @Autowired
    public RootController(UserService userService, BuyService buyService) {
        this.userService = userService;
        this.buyService = buyService;
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

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/buys")
    public String buys(Model model) {
        model.addAttribute("buys",
                TransactionsUtil.getWithExceeded(buyService.getAll(AuthorizedUser.getId()), AuthorizedUser.getSpendPerDay()));
        return "users";
    }





}
