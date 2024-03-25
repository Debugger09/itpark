package com.sprinpay.itpark.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.services.MaterielsService;

@Controller
public class MaterielController {
    private final MaterielsService materielsService;

    public MaterielController(MaterielsService materielsService) {
        this.materielsService = materielsService;
    }

    @GetMapping("/materiels")
    public String showEmploye(Model model) {
        List<Materiels> materiels = materielsService.findAll();
        model.addAttribute("materiels", materiels);
        return "materiels/materiels";
    }
}