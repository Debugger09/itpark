package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Services;
import com.sprinpay.itpark.services.ServicesService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceController {

    private final ServicesService servicesService;

    public ServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/services")
    public String showServices(Model model) {

        List<Services> services = servicesService.findAll();
        model.addAttribute("services", services);
        return "services/services"; // Assurez-vous que le nom du fichier HTML correspond
    }

    @GetMapping("/services/{id}")
    public String showServiceDetails(@PathVariable Long id, Model model) {
        Services service = servicesService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid service Id:" + id));
        model.addAttribute("service", service);
        return "services/services"; // Assurez-vous que le nom du fichier HTML correspond
    }

    @GetMapping("/services/new")
    public String showAddServiceForm(@ModelAttribute("service") Services service) {
        return "services/add-service"; // Assurez-vous que le nom du fichier HTML correspond
    }

    @PostMapping("/services")
    public String saveService(@Valid @ModelAttribute("service") Services service, BindingResult result) {
        if (result.hasErrors()) {
            return "services/add-service"; // Assurez-vous que le nom du fichier HTML correspond
        }
        servicesService.save(service);
        return "redirect:/services";
    }

    @GetMapping("/services/edit/{id}")
    public String showUpdateServiceForm(@PathVariable Long id, Model model) {
        Services service = servicesService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid service Id:" + id));
        model.addAttribute("service", service);
        return "services/update-service"; // Assurez-vous que le nom du fichier HTML correspond
    }

    @PostMapping("/services/update/{id}")
    public String updateService(@PathVariable Long id, @Valid @ModelAttribute("service") Services service,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            service.setId(id); // Assurez-vous que l'ID est défini pour une redirection correcte
            return "services/update-service"; // Assurez-vous que le nom du fichier HTML correspond
        }
        servicesService.save(service);
        return "redirect:/services";
    }

    @GetMapping("/services/delete/{id}")
    public String deleteService(@PathVariable Long id) {
        servicesService.deleteById(id);
        return "redirect:/services";
    }

}
