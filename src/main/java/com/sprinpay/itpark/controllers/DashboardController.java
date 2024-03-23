package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.repository.EmployesRepository;
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

    public DashboardController(EmployesRepository employesRepository, MaterielsRepository materielsRepository, LogicielsRepository logicielsRepository) {
        this.employesRepository = employesRepository;
        this.materielsRepository = materielsRepository;
        this.logicielsRepository = logicielsRepository;
    }

    @GetMapping("/dashboard")
    String show(Model model){

        model.addAttribute("employe",employesRepository.count());
        model.addAttribute("materiel",materielsRepository.count());
        model.addAttribute("logiciel",logicielsRepository.count());

        return "dashboard";
    }
}
