package com.sprinpay.itpark.controllers;
import com.sprinpay.itpark.domain.TypeLogiciel;
import com.sprinpay.itpark.services.TypeLogicielService;
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
public class TypeLogicielController {

    private final TypeLogicielService typeLogicielService;

    public TypeLogicielController(TypeLogicielService typeLogicielService) {
        this.typeLogicielService = typeLogicielService;
    }

    @GetMapping("/type-logiciels")
    public String showLogiciels(Model model) {
        List<TypeLogiciel> typeLogiciels = typeLogicielService.findAll();
        model.addAttribute("typeLogiciels", typeLogiciels);

        return "logiciels/type-logiciels";
    }



    @PostMapping("/type-logiciels")
    public String saveLogiciel(@Valid TypeLogiciel typeLogiciel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "logiciels/add-type-logiciel";
        }
        System.out.println(typeLogiciel.toString());
        typeLogicielService.save(typeLogiciel);
        return "redirect:/type-logiciels";
    }

    @GetMapping("/type-logiciel-delete/{id}")
    public String deleteLogiciel(@PathVariable Long id) {
        typeLogicielService.deleteById(id);
        return "redirect:/type-logiciels";
    }

    @GetMapping("/type-logiciel-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TypeLogiciel typeLogiciel = typeLogicielService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        System.out.println(typeLogiciel.toString());

        model.addAttribute("typeLogiciel", typeLogiciel);
        return "logiciels/update-type-logiciel";
    }

    @GetMapping("/type-logiciel-form")
    public String showFormLogiciel(@ModelAttribute("typeLogiciel") TypeLogiciel typeLogiciel) {
        return "logiciels/add-type-logiciel";
    }
}
