package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/users";
    }

    @GetMapping("/user-form")
    public String showFormUser(@ModelAttribute("user") User user) {
        return "users/add-user";
    }

    @PostMapping("/users")
    public String saveUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/add-user";
        }
        System.out.println(user.toString());
        userService.save(user);

        return "redirect:/users";
    }

    /*
     * Supprimer un utilisateur
     */
    @GetMapping("/user-delete/{id}")
    public String deleteSave(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    /*
     * Modifier un utilisateur
     */

    @GetMapping("/user-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.showOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        System.out.println(user);

        model.addAttribute("user", user);
        return "users/update-user";
    }

    @PostMapping("/user-update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid User user) {
        user.setId(id);
        userService.save(user);
        return "redirect:/users";
    }

}
