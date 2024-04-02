package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.services.MaterielsService;
import com.sprinpay.itpark.services.PannesService;

import com.sprinpay.itpark.services.dto.PanneDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class PanneController {
    private final PannesService pannesService;
    private final MaterielsService materielsService;

    public PanneController(PannesService pannesService, MaterielsService materielsService) {
        this.pannesService = pannesService;
        this.materielsService = materielsService;
    }

    @GetMapping("/pannes")
    String list(Model model) {
        model.addAttribute("pannes", pannesService.findAll());
        return "pannes/pannes";

    }

    @GetMapping("/panne-form")
    public String showForm(@ModelAttribute("panneDTO") PanneDTO panneDTO, Model model) {

        model.addAttribute("materiels", materielsService.findAll());

        return "pannes/add-panne";
    }

    @PostMapping("/pannes")
    public String save(@Valid PanneDTO panneDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "pannes/add-panne";
        }
        pannesService.save(panneDTO);
        return "redirect:/pannes";
    }

    @GetMapping("/panne-delete/{id}")
    public String deletePanne(@PathVariable Long id) {
        pannesService.deleteById(id);
        return "redirect:/pannes";
    }

    @GetMapping("/panne-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {

        Pannes pannes = pannesService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid materiel Id:" + id));
        model.addAttribute("materiels", materielsService.findAll());
        model.addAttribute("panneDTO", PanneDTO.mapDTO(pannes));
        return "pannes/add-panne";
    }
}
