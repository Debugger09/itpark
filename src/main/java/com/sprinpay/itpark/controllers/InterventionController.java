package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.domain.enums.ROLE;
import com.sprinpay.itpark.repository.UserRepository;
import com.sprinpay.itpark.services.InterventionsService;
import com.sprinpay.itpark.services.PannesService;
import com.sprinpay.itpark.services.dto.InterventionDTO;
import com.sprinpay.itpark.services.dto.LigneInventaireDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InterventionController {
    private final InterventionsService interventionsService;
    private final PannesService pannesService;
    private final UserRepository userRepository;


    public InterventionController(InterventionsService interventionsService, PannesService pannesService, UserRepository userRepository) {
        this.interventionsService = interventionsService;
        this.pannesService = pannesService;
        this.userRepository = userRepository;
    }

    @GetMapping("/interventions")
    String list(Model model) {
        model.addAttribute("interventions", interventionsService.findAll());
        return "interventions/interventions";
    }
    @PostMapping("/interventions")
    String save(@Valid InterventionDTO interventionDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "interventions/add-intervention";
        }
        interventionsService.save(interventionDTO);

        return "redirect:/pannes";
    }



    @GetMapping("/intervention-form/{id}")
    public String showForm(@PathVariable Long id, @ModelAttribute("interventionDTO") InterventionDTO interventionDTO, Model model) {
        interventionDTO.setPanneId(id);

        Pannes pannes=pannesService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid panne Id:" + id));

        model.addAttribute("panne",pannes);
        model.addAttribute("techniciens",userRepository.findAllByRole(ROLE.TECHNICIEN));

        return "interventions/add-intervention";
    }
}
