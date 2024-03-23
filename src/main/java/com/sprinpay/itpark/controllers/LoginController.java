package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.services.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String showLogin(){

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDTO") LoginDTO loginDTO){
        System.out.println(loginDTO.toString());
        return "redirect:/dashboard";
    }
}
