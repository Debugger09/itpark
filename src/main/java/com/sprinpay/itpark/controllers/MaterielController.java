package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Materiels;

import com.sprinpay.itpark.services.MaterielsService;
import com.sprinpay.itpark.services.TypeMaterielService;
import com.sprinpay.itpark.services.dto.MaterielDTO;
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
public class MaterielController {
    private final MaterielsService materielsService;
    private final TypeMaterielService typeMaterielService;

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
    public String showFormMateriel(@ModelAttribute("materielDTO") MaterielDTO materielDTO, Model model) {
        model.addAttribute("typesMateriels", typeMaterielService.findAll());
        return "materiels/add-materiel";
    }

    @PostMapping("/materiels")
    public String saveMateriel(@Valid MaterielDTO materielDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "materiels/add-materiel";
        }
        materielsService.save(materielDTO);
        return "redirect:/materiels";
    }

    @GetMapping("/materiel-delete/{id}")
    public String deleteMateriel(@PathVariable Long id) {
        materielsService.deleteById(id);
        return "redirect:/materiels";
    }

    @GetMapping("/materiel-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("typesMateriels", typeMaterielService.findAll());
        Materiels materiels = materielsService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid materiel Id:" + id));

        model.addAttribute("materielDTO", MaterielDTO.mapDTO(materiels));
        return "materiels/add-materiel";
    }

}
