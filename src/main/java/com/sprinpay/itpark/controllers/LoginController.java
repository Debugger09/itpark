package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.repository.UserRepository;
import com.sprinpay.itpark.services.dto.LoginDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String showLogin(@ModelAttribute("loginDTO") LoginDTO loginDTO){

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "login";
        }

        User user=userRepository.findByLoginAndPassword(loginDTO.getUserName(), loginDTO.getPassword());

        if(user!=null){
            return "redirect:/dashboard";
        }else {
            model.addAttribute("error","nom d'utilisateur ou mot de passe incorrete ");
            return "login";
        }


    }
}
