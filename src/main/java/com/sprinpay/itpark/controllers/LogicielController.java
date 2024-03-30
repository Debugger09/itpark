package com.sprinpay.itpark.controllers;
import com.sprinpay.itpark.domain.Logiciels;
import com.sprinpay.itpark.services.LogicielsService;
import com.sprinpay.itpark.services.TypeLogicielService;
import com.sprinpay.itpark.services.dto.LogicielDTO;
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
public class LogicielController {
    private final LogicielsService logicielsService;
    private  final TypeLogicielService typeLogicielService;

    public LogicielController(LogicielsService logicielsService, TypeLogicielService typeLogicielService) {
        this.logicielsService = logicielsService;
        this.typeLogicielService = typeLogicielService;
    }

    @GetMapping("/logiciels")
    public String showLogiciels(Model model) {
        List<Logiciels> logiciels = logicielsService.findAll();
        model.addAttribute("logiciels", logiciels);

        return "logiciels/logiciels";
    }

    @GetMapping("/logiciel-form")
    public String showFormLogiciel(@ModelAttribute("logicielDTO") LogicielDTO logicielDTO,Model model) {
        model.addAttribute("typeLogiciels",typeLogicielService.findAll());
        return "logiciels/add-logiciel";
    }

    @PostMapping("/logiciels")
    public String saveLogiciel(@Valid LogicielDTO logicielDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "logiciels/add-logiciel";
        }
        logicielsService.save(logicielDTO);
        return "redirect:/logiciels";
    }

    @GetMapping("/logiciel-delete/{id}")
    public String deleteLogiciel(@PathVariable Long id) {
        logicielsService.deleteById(id);
        return "redirect:/logiciels";
    }

    @GetMapping("/logiciel-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("typeLogiciels",typeLogicielService.findAll());
        Logiciels logiciels = logicielsService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid logiciel Id:" + id));

        model.addAttribute("logicielDTO", LogicielDTO.mapDTO(logiciels));
        return "logiciels/add-logiciel";
    }
}
