package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.TypeMateriel;
import com.sprinpay.itpark.services.MaterielsService;
import com.sprinpay.itpark.services.TypeMaterielService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MaterielController {
    private final MaterielsService materielsService;
    private  final TypeMaterielService typeMaterielService;

    public MaterielController(MaterielsService materielsService, TypeMaterielService typeMaterielService) {
        this.materielsService = materielsService;
        this.typeMaterielService = typeMaterielService;
    }

    @GetMapping("/materiels")
    public String showMateriels(Model model) {
        List<Materiels> materiels = materielsService.findAll();
        model.addAttribute("materiels", materiels);

        return "materiels/materiels";
    }

    @GetMapping("/materiel-form")
    public String showFormMateriel(@ModelAttribute("materiels") Materiels materiels,Model model) {
        model.addAttribute("typesMateriels",typeMaterielService.findAll());
        return "materiels/add-materiel";
    }

    @PostMapping("/materiels")
    public String saveMateriel(@Valid Materiels materiels, BindingResult result) {
        System.out.println(materiels.toString());
        if (result.hasErrors()) {
            return "materiels/add-materiel";
        }
        materielsService.save(materiels);
        return "redirect:/materiels";
    }
}
