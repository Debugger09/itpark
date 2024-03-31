package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Techniciens;
import com.sprinpay.itpark.services.TechniciensService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TechnicienController {

    private final TechniciensService techniciensService;

    public TechnicienController(TechniciensService techniciensService) {
        this.techniciensService = techniciensService;
    }

    @GetMapping("/techniciens")
    public String showTechniciens(Model model) {
        List<Techniciens> techniciensList = techniciensService.findAll();
        model.addAttribute("techniciens", techniciensList);
        return "techniciens/techniciens";
    }

    @GetMapping("/technicien-form")
    public String showFormTechnicien(@ModelAttribute("technicien") Techniciens technicien) {
        return "techniciens/add-technicien";
    }

    @PostMapping("/techniciens")
    public String saveTechnicien(@Valid Techniciens technicien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "techniciens/add-technicien";
        }
        techniciensService.save(technicien);
        return "redirect:/techniciens";
    }

    @GetMapping("/technicien-delete/{id}")
    public String deleteTechnicien(@PathVariable Long id) {
        techniciensService.deleteById(id);
        return "redirect:/techniciens";
    }

    @GetMapping("/technicien-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Techniciens technicien = techniciensService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid technicien Id:" + id));
        model.addAttribute("technicien", technicien);
        return "techniciens/update-technicien";
    }

    @PostMapping("/technicien-update/{id}")
    public String updateTechnicien(@PathVariable("id") Long id, @Valid Techniciens technicien) {
        technicien.setId(id);
        techniciensService.save(technicien);
        return "redirect:/techniciens";
    }
}
