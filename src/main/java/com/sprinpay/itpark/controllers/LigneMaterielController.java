package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.LigneMateriel;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.repository.LigneMaterielRepository;
import com.sprinpay.itpark.services.EmployesService;
import com.sprinpay.itpark.services.LigneMaterielService;
import com.sprinpay.itpark.services.MaterielsService;
import com.sprinpay.itpark.services.ServicesService;
import com.sprinpay.itpark.services.dto.LigneMaterielDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class LigneMaterielController {
    private final LigneMaterielService ligneMaterielService;
    private final LigneMaterielRepository ligneMaterielRepository;
    private final EmployesService employesService;
    private final MaterielsService materielsService;

    private final ServicesService servicesService;

    public LigneMaterielController(LigneMaterielService ligneMaterielService,
            LigneMaterielRepository ligneMaterielRepository, EmployesService employesService,
            MaterielsService materielsService, ServicesService servicesService) {
        this.ligneMaterielService = ligneMaterielService;
        this.ligneMaterielRepository = ligneMaterielRepository;
        this.employesService = employesService;
        this.materielsService = materielsService;
        this.servicesService = servicesService;
    }

    @GetMapping("/attributions")
    public String listeAttribution(Model model) {

        List<LigneMateriel> ligneMateriels = ligneMaterielService.findAll();
        model.addAttribute("ligneMateriels", ligneMateriels);

        return "materiels/attribution";
    }

    @GetMapping("/attribut-materiel-form/{id}")
    public String showFormLigneMateriel(@PathVariable Long id,
            @ModelAttribute("ligneMaterielDTO") LigneMaterielDTO ligneMaterielDTO, Model model) {
        model.addAttribute("employes", employesService.findAll());
        model.addAttribute("services", servicesService.findAll());

        model.addAttribute("materiel", materielsService.findById(id));
        ligneMaterielDTO.setMaterielId(id);

        return "materiels/attribuer";
    }

    @GetMapping("/attribuer-materiels")
    public String showAttribuerMaterielsForm(Model model) {
        model.addAttribute("employes", employesService.findAll());
        model.addAttribute("services", servicesService.findAll());
        return "materiels/attribuer";
    }

    @PostMapping("/attribuer-materiels")
    public String saveLigneMateriel(@Valid LigneMaterielDTO ligneMaterielDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "materiels/attribuer";
        }

        Optional<Materiels> materiels = materielsService.findById(ligneMaterielDTO.getMaterielId());
        LigneMateriel ligneMateriel = ligneMaterielRepository
                .findByMateriel_IdAndDateAttributionTrue(ligneMaterielDTO.getMaterielId());
        System.out.println(ligneMateriel);
        if (ligneMateriel != null) {
            model.addAttribute("employes", employesService.findAll());
            model.addAttribute("services", servicesService.findAll());
            model.addAttribute("materiel", materiels);
            if (ligneMateriel.getAttribueA().equals("EMPLOYE")) {
                model.addAttribute("materielAttribut",
                        "Ce materiel est deja attribué a l'employé " + ligneMateriel.getEmploye().getNom());
            } else {
                model.addAttribute("materielAttribut",
                        "Ce materiel est deja attribué au service " + ligneMateriel.getServices().getLibelle());
            }

            return "materiels/attribuer";
        }

        ligneMaterielService.save(ligneMaterielDTO);
        return "redirect:/materiels";
    }

    @GetMapping("/restituer-materiel/{id}")
    public String restituerMateriel(@PathVariable Long id) {
        System.out.println("============"+id);
        Optional<LigneMateriel> ligneMateriel=ligneMaterielRepository.findById(id);
        if(ligneMateriel.isPresent()){
            ligneMateriel.get().setDateRestitution(new Date());
            ligneMaterielRepository.save(ligneMateriel.get());
        }

        return "redirect:/attributions";
    }

}
