package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Employes;
import com.sprinpay.itpark.services.EmployesService;
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

public class EmployeController {
    private final EmployesService employesService;

    public EmployeController(EmployesService employesService) {
        this.employesService = employesService;
    }

    @GetMapping("/employes")
    public String showEmploye(Model model) {
        List<Employes> employes = employesService.findAll();
        model.addAttribute("employes", employes);
        return "employes/employes";
    }

    @GetMapping("/employe-form")
    public String showFormEmploye(@ModelAttribute("employes") Employes employes) {
        return "employes/add-employe";
    }

    @PostMapping("/employes")
    public String saveEmployes(@Valid Employes employes, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "employes/add-employe";
        }
        System.out.println(employes.toString());
        employesService.save(employes);

        return "redirect:/employes";
    }

    @GetMapping("/employe-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Employes employes = employesService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        System.out.println(employes);

        model.addAttribute("employes", employes);
        return "employes/update-employe";
    }

    @PostMapping("/employe-update/{id}")
    public String updateEmploye(@PathVariable("id") Long id, @Valid Employes employes) {

        employes.setId(id);
        System.out.println(employes);
        employesService.save(employes);
        return "redirect:/employes";
    }

    @GetMapping("/employe-delete/{id}")
    public String deleteEmploye(@PathVariable Long id) {
        employesService.deleteById(id);
        return "redirect:/employes";
    }

}
