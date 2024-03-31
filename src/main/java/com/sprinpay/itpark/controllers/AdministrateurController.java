package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Administrateurs;
import com.sprinpay.itpark.services.AdministrateursService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdministrateurController {
    private final AdministrateursService administrateursService;

    public AdministrateurController(AdministrateursService administrateursService) {
        this.administrateursService = administrateursService;
    }

    @GetMapping("/administrateurs")
    public String showAdministrateurs(Model model) {
        List<Administrateurs> administrateurs = administrateursService.findAll();
        model.addAttribute("administrateurs", administrateurs);
        return "administrateurs/administrateurs";
    }

    @GetMapping("/administrateur-form")
    public String showFormAdministrateur(@ModelAttribute("administrateur") Administrateurs administrateur) {
        return "administrateurs/add-administrateur";
    }

    @PostMapping("/administrateurs")
    public String saveAdministrateur(@Valid Administrateurs administrateur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "administrateurs/add-administrateur";
        }
        administrateursService.save(administrateur);
        return "redirect:/administrateurs";
    }

    @GetMapping("/administrateur-delete/{id}")
    public String deleteAdministrateur(@PathVariable Long id) {
        administrateursService.deleteById(id);
        return "redirect:/administrateurs";
    }

    @GetMapping("/administrateur-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Administrateurs administrateur = administrateursService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid administrateur Id:" + id));
        model.addAttribute("administrateur", administrateur);
        return "administrateurs/update-administrateur";
    }

    @PostMapping("/administrateur-update/{id}")
    public String updateAdministrateur(@PathVariable("id") Long id, @Valid Administrateurs administrateur) {
        administrateur.setId(id);
        administrateursService.save(administrateur);
        return "redirect:/administrateurs";
    }
}
