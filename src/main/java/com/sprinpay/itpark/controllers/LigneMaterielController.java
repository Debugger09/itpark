package com.sprinpay.itpark.controllers;

import com.sprinpay.itpark.domain.Employes;
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

import java.util.List;
import java.util.Optional;

@Controller
public class LigneMaterielController {
    private final LigneMaterielService ligneMaterielService;
    private final LigneMaterielRepository ligneMaterielRepository;
    private final EmployesService employesService;
    private final MaterielsService materielsService;

    private final ServicesService servicesService;
    public LigneMaterielController(LigneMaterielService ligneMaterielService, LigneMaterielRepository ligneMaterielRepository, EmployesService employesService,
                                   MaterielsService materielsService, ServicesService servicesService) {
        this.ligneMaterielService = ligneMaterielService;
        this.ligneMaterielRepository = ligneMaterielRepository;
        this.employesService = employesService;
        this.materielsService = materielsService;
        this.servicesService = servicesService;
    }

        @GetMapping("/attributions")
        public String listeAttribution(Model model){

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

    @PostMapping("/attribuer-materiels")
    public String saveLigneMateriel(@Valid LigneMaterielDTO ligneMaterielDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "materiels/attribuer";
        }


        Optional<Materiels> materiels=materielsService.findById(ligneMaterielDTO.getMaterielId());
        LigneMateriel ligneMateriel=ligneMaterielRepository.findByMateriel_IdAndDateAttributionTrue(ligneMaterielDTO.getMaterielId());
        System.out.println(ligneMateriel);
        if(ligneMateriel!=null){
            model.addAttribute("employes", employesService.findAll());
            model.addAttribute("services", servicesService.findAll());
            model.addAttribute("materiel", materiels);
            if(ligneMateriel.getAttribueA().equals("EMPLOYE")){
                model.addAttribute("materielAttribut","Ce materiel est deja attribué a l'employé "+ligneMateriel.getEmploye().getNom());
            }else{
                model.addAttribute("materielAttribut","Ce materiel est deja attribué au service "+ligneMateriel.getServices().getLibelle());
            }

            return "materiels/attribuer";
        }

        if(ligneMaterielDTO.getAttribueA().equals("EMPLOYE")){
            Optional<Employes> employes= employesService.findById(ligneMaterielDTO.getEmployeId());
            if(employes.isPresent() && materiels.isPresent()){
                model.addAttribute("employes", employesService.findAll());
                model.addAttribute("services", servicesService.findAll());
                model.addAttribute("materiel", materiels);

                if(!employes.get().getAccordSortie()){
                    model.addAttribute("noAccord","L'employé n'a pas l'accord de rentrer avec le materiel");
                    return "materiels/attribuer";
                }
                if(!materiels.get().getMobilite()){
                    model.addAttribute("noMobilite","Ce materiel ne peut pas sortir de l'entreprise");
                    return "materiels/attribuer";
                }
            }else {
                model.addAttribute("error","Une erreur c'est produite !!");
                return "materiels/attribuer";
            }
        }



        ligneMaterielService.save(ligneMaterielDTO);
        return "redirect:/materiels";
    }

}
