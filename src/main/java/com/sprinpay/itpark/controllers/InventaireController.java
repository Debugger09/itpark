package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Inventaires;
import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.domain.enums.ROLE;
import com.sprinpay.itpark.repository.UserRepository;
import com.sprinpay.itpark.services.InventairesService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InventaireController {

    private final InventairesService inventairesService;
    private final UserRepository userRepository;


    public InventaireController(InventairesService inventairesService, UserRepository userRepository) {
        this.inventairesService = inventairesService;
        this.userRepository = userRepository;
    }

    @GetMapping("/inventaires")
    String list(Model model) {
        model.addAttribute("inventaires", inventairesService.findAll());

        return "inventaires/inventaires";

    }




    @GetMapping("/inventaire-form")
    public String showForm(@ModelAttribute("inventaire") Inventaires inventaires, Model model) {
            List<User> userList=userRepository.findAllByRole(ROLE.TECHNICIEN);
            model.addAttribute("techniciens",userList);
        return "inventaires/add-inventaire";
    }

    @PostMapping("/inventaire")
    public String save(@Valid Inventaires inventaires, BindingResult result) {
        if (result.hasErrors()) {
            return "inventaires/add-inventaire";
        }
        inventairesService.save(inventaires);
        return "redirect:/inventaires";
    }
    @GetMapping("/inventaire-delete/{id}")
    public String deletePanne(@PathVariable Long id) {
        inventairesService.deleteInventaire(id);
        return "redirect:/inventaires";
    }


}
