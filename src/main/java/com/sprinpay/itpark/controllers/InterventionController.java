package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.services.InterventionsService;
import com.sprinpay.itpark.services.PannesService;
import com.sprinpay.itpark.services.dto.InterventionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class InterventionController {
    private final InterventionsService interventionsService;
    private final PannesService pannesService;

    public InterventionController(InterventionsService interventionsService, PannesService pannesService) {
        this.interventionsService = interventionsService;
        this.pannesService = pannesService;
    }

    @GetMapping("/interventions")
    String list(Model model) {
        model.addAttribute("interventions", interventionsService.findAll());
        return "interventions/interventions";

    }

    @GetMapping("/intervention-form")
    public String showForm(@ModelAttribute("interventionDTO") InterventionDTO interventionDTO, Model model) {

        model.addAttribute("pannes", pannesService.findAll());

        return "interventions/add-intervention";
    }
}
