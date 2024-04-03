package com.sprinpay.itpark.controllers;


import com.sprinpay.itpark.domain.*;
import com.sprinpay.itpark.repository.InventairesRepository;
import com.sprinpay.itpark.repository.LigneInventaireRepository;
import com.sprinpay.itpark.services.InventairesService;
import com.sprinpay.itpark.services.LigneInventaireService;
import com.sprinpay.itpark.services.MaterielsService;
import com.sprinpay.itpark.services.dto.LigneInventaireDTO;
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
public class LigneInventaireController {


    private final MaterielsService materielsService;

    private final InventairesService inventairesService;
    private final LigneInventaireService ligneInventaireService;
    private final LigneInventaireRepository ligneInventaireRepository;
    private final InventairesRepository inventairesRepository;

    public LigneInventaireController(MaterielsService materielsService, InventairesService inventairesService, LigneInventaireService ligneInventaireService, LigneInventaireRepository ligneInventaireRepository, InventairesRepository inventairesRepository) {
        this.materielsService = materielsService;
        this.inventairesService = inventairesService;
        this.ligneInventaireService = ligneInventaireService;
        this.ligneInventaireRepository = ligneInventaireRepository;
        this.inventairesRepository = inventairesRepository;
    }


    @GetMapping("/effectue-inventaire/{id}")
    public String showFormLigneInventaire(@PathVariable Long id, @ModelAttribute("ligneInventaireDTO") LigneInventaireDTO ligneInventaireDTO, Model model){
        ligneInventaireDTO.setInventaireId(id);
        Optional<Inventaires> inventaires= inventairesService.findInventaireById(id);
        inventaires.ifPresent(value -> model.addAttribute("inventaire", value));
        model.addAttribute("materiels",materielsService.findAll());
        model.addAttribute("materielByInventaires",ligneInventaireRepository.findAllByInventaire_Id(id));

        return "inventaires/add-inventaire-materiel";
    }
    @GetMapping("/fermer-inventaire/{id}")
    public String showFormLigneInventaire(@PathVariable Long id){
        Optional<Inventaires> inventaires= inventairesService.findInventaireById(id);
          inventaires.ifPresent(inventaires1 -> inventaires1.setCloseInventaire(true));
        inventaires.ifPresent(inventairesRepository::save);


        return "redirect:/inventaires";
    }




    @PostMapping("/add-ligne-inventaire-materiel")
    public String saveLigneInventaireMateriel(@Valid LigneInventaireDTO ligneInventaireDTO, BindingResult result, Model model) {

        LigneInventaire ligneInventaire= ligneInventaireRepository.findByMateriel_IdAndInventaire_Id(ligneInventaireDTO.getMaterielId(),ligneInventaireDTO.getInventaireId());
        if(ligneInventaire!=null){

            Optional<Inventaires> inventaires= inventairesService.findInventaireById(ligneInventaireDTO.getInventaireId());

            inventaires.ifPresent(value -> model.addAttribute("inventaire", value));



            model.addAttribute("materiels",materielsService.findAll());
            model.addAttribute("materielByInventaires",ligneInventaireRepository.findAllByInventaire_Id(ligneInventaireDTO.getInventaireId()));
            model.addAttribute("error","Ce materiel existe déjà" );
            return "inventaires/add-inventaire-materiel";
        }

        if (result.hasErrors()) {
            return "inventaires/add-inventaire-materiel";
        }

           ligneInventaireService.save(ligneInventaireDTO);

          return "redirect:/effectue-inventaire/"+ligneInventaireDTO.getInventaireId();
    }


    @GetMapping("/ligne-inventaire-delete/{id}")
    public String deleteMaterielLigne(@PathVariable Long id, Model model) {
        Optional<LigneInventaire> ligneInventaire=ligneInventaireService.findById(id);
        if(ligneInventaire.isPresent()){
            ligneInventaireService.deleteById(id);

            model.addAttribute("inventaire", ligneInventaire.get().getInventaire());
            model.addAttribute("materiels",materielsService.findAll());
            model.addAttribute("materielByInventaires",ligneInventaireRepository.findAllByInventaire_Id(ligneInventaire.get().getInventaire().getId()));
            return "redirect:/effectue-inventaire/"+ligneInventaire.get().getInventaire().getId();
        }
       return null;
    }

}
