package com.sprinpay.itpark.controllers;


import com.sprinpay.itpark.domain.LigneLogiciel;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.repository.LigneLogicielRepository;
import com.sprinpay.itpark.services.LigneLogicielService;
import com.sprinpay.itpark.services.LogicielsService;
import com.sprinpay.itpark.services.MaterielsService;
import com.sprinpay.itpark.services.dto.LigneLogicielDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LigneLogicielController {

    private final LogicielsService logicielsService;
    private final MaterielsService materielsService;
    private final LigneLogicielRepository ligneLogicielRepository;
    private final LigneLogicielService ligneLogicielService;

    public LigneLogicielController(LogicielsService logicielsService, MaterielsService materielsService, LigneLogicielRepository logicielRepository, LigneLogicielService ligneLogicielService) {
        this.logicielsService = logicielsService;
        this.materielsService = materielsService;
        this.ligneLogicielRepository = logicielRepository;
        this.ligneLogicielService = ligneLogicielService;
    }

    @GetMapping("/install-logiciel/{id}")
    public String showFormLigneMateriel(@PathVariable Long id, @ModelAttribute("ligneLogicielDTO") LigneLogicielDTO ligneLogicielDTO, Model model){
        ligneLogicielDTO.setMaterielId(id);
        Optional<Materiels> materiels= materielsService.findById(id);
        materiels.ifPresent(value -> model.addAttribute("materiel", value));
        model.addAttribute("logiciels",logicielsService.findAll());
        model.addAttribute("logicielByMateriel",ligneLogicielRepository.findAllByMateriel_Id(id));



        return "logiciels/install-logiciel";
    }

    @PostMapping("/install-logiciel")
    public String saveLigneMateriel(@Valid LigneLogicielDTO ligneLogicielDTO, BindingResult result, Model model) {

        LigneLogiciel ligneLogiciel= ligneLogicielRepository.findByLogiciel_Id(ligneLogicielDTO.getLogicielId());
        if(ligneLogiciel!=null){

            Optional<Materiels> materiels= materielsService.findById(ligneLogicielDTO.getLogicielId());
            materiels.ifPresent(value -> model.addAttribute("materiel", value));
            model.addAttribute("logiciels",logicielsService.findAll());
            model.addAttribute("logicielByMateriel",ligneLogicielRepository.findAllByMateriel_Id(ligneLogicielDTO.getMaterielId()));
            model.addAttribute("error","Ce logiciel est déjà installé dans cette machine");
            return "logiciels/install-logiciel";
        }

        if (result.hasErrors()) {
            return "logiciels/install-logiciel";
        }

           ligneLogicielService.save(ligneLogicielDTO);

          return "redirect:/install-logiciel/"+ligneLogicielDTO.getMaterielId();
    }


    @GetMapping("/ligne-logiciel-delete/{id}")
    public String deleteLogicielLigne(@PathVariable Long id, Model model) {
        Optional<LigneLogiciel> ligneLogiciel=ligneLogicielRepository.findById(id);
        if(ligneLogiciel.isPresent()){
            ligneLogicielService.deleteById(id);

            model.addAttribute("materiel", ligneLogiciel.get().getMateriel());
            model.addAttribute("logiciels",logicielsService.findAll());
            model.addAttribute("logicielByMateriel",ligneLogicielRepository.findAllByMateriel_Id(ligneLogiciel.get().getMateriel().getId()));
            return "redirect:/install-logiciel/"+ligneLogiciel.get().getMateriel().getId();
        }


       return null;



    }

}
