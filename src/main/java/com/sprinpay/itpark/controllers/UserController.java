package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public String showUsers(Model model){
        List<User> users=userService.findAll();
        model.addAttribute("users",users);
        return "users";
    }
}
