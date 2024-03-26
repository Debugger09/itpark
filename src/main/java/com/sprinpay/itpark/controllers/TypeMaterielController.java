package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.TypeMateriel;
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
public class TypeMaterielController {

    private final TypeMaterielService typeMaterielService;

    public TypeMaterielController(TypeMaterielService typeMaterielService) {
        this.typeMaterielService = typeMaterielService;
    }

    @GetMapping("/type-materiels")
    public String showMateriels(Model model) {
        List<TypeMateriel> typeMateriels = typeMaterielService.findAll();
        model.addAttribute("typemateriels", typeMateriels);

        return "materiels/type-materiels";
    }

    @GetMapping("/type-materiel-form")
    public String showFormMateriel(@ModelAttribute("typeMateriel") TypeMateriel typeMateriel) {
        return "materiels/add-type-materiel";
    }

    @PostMapping("/type-materiels")
    public String saveMateriel(@Valid TypeMateriel materiels, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "materiels/add-type-materiel";
        }
        typeMaterielService.save(materiels);
        return "redirect:/type-materiels";
    }
}
