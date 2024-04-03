package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EmployesRepository employesRepository;
    private final MaterielsRepository materielsRepository;
    private  final LogicielsRepository logicielsRepository;

    private final LigneMaterielRepository ligneMaterielRepository;
    private final PannesRepository pannesRepository;
    private final InventairesRepository inventairesRepository;

    public DashboardController(EmployesRepository employesRepository, MaterielsRepository materielsRepository, LogicielsRepository logicielsRepository, LigneMaterielRepository ligneMaterielRepository, PannesRepository pannesRepository, InventairesRepository inventairesRepository) {
        this.employesRepository = employesRepository;
        this.materielsRepository = materielsRepository;
        this.logicielsRepository = logicielsRepository;
        this.ligneMaterielRepository = ligneMaterielRepository;
        this.pannesRepository = pannesRepository;
        this.inventairesRepository = inventairesRepository;
    }

    @GetMapping("/dashboard")
    String show(Model model){

        model.addAttribute("employe",employesRepository.count());
        model.addAttribute("materiel",materielsRepository.count());
        model.addAttribute("logiciel",logicielsRepository.count());
        model.addAttribute("attribue",ligneMaterielRepository.countByDateAttributionTrue());
        model.addAttribute("pannes",pannesRepository.count());
        model.addAttribute("inventaires",inventairesRepository.count());

        return "dashboard";
    }
}
