package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.repository.EmployesRepository;
import com.sprinpay.itpark.repository.LigneMaterielRepository;
import com.sprinpay.itpark.repository.LogicielsRepository;
import com.sprinpay.itpark.repository.MaterielsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EmployesRepository employesRepository;
    private final MaterielsRepository materielsRepository;
    private  final LogicielsRepository logicielsRepository;

    private final LigneMaterielRepository ligneMaterielRepository;

    public DashboardController(EmployesRepository employesRepository, MaterielsRepository materielsRepository, LogicielsRepository logicielsRepository, LigneMaterielRepository ligneMaterielRepository) {
        this.employesRepository = employesRepository;
        this.materielsRepository = materielsRepository;
        this.logicielsRepository = logicielsRepository;
        this.ligneMaterielRepository = ligneMaterielRepository;
    }

    @GetMapping("/dashboard")
    String show(Model model){

        model.addAttribute("employe",employesRepository.count());
        model.addAttribute("materiel",materielsRepository.count());
        model.addAttribute("logiciel",logicielsRepository.count());
        model.addAttribute("attribue",ligneMaterielRepository.countByDateAttributionTrue());

        return "dashboard";
    }
}
