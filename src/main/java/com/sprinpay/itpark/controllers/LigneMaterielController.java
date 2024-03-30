package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.services.EmployesService;
import com.sprinpay.itpark.services.LigneMaterielService;
import com.sprinpay.itpark.services.MaterielsService;
import com.sprinpay.itpark.services.dto.LigneMaterielDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LigneMaterielController {
    private final LigneMaterielService ligneMaterielService;
    private final EmployesService employesService;
    private final MaterielsService materielsService;

    public LigneMaterielController(LigneMaterielService ligneMaterielService, EmployesService employesService,
            MaterielsService materielsService) {
        this.ligneMaterielService = ligneMaterielService;
        this.employesService = employesService;
        this.materielsService = materielsService;
    }

    @GetMapping("/attribut-materiel-form/{id}")
    public String showFormLigneMateriel(@PathVariable Long id,
            @ModelAttribute("ligneMaterielDTO") LigneMaterielDTO ligneMaterielDTO, Model model) {
        model.addAttribute("employes", employesService.findAll());
        model.addAttribute("materiel", materielsService.findById(id));
        ligneMaterielDTO.setMaterielId(id);

        return "materiels/attribuer";
    }

    @PostMapping("/attribuer-materiels")
    public String saveLigneMateriel(@Valid LigneMaterielDTO ligneMaterielDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "materiels/attribuer";
        }
        System.out.println(ligneMaterielDTO.toString());

        ligneMaterielService.save(ligneMaterielDTO);
        return "redirect:/materiels";
    }

}
