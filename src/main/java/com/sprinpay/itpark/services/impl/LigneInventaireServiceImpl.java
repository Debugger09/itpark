package com.sprinpay.itpark.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Inventaires;
import com.sprinpay.itpark.domain.LigneInventaire;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.repository.InventairesRepository;
import com.sprinpay.itpark.repository.LigneInventaireRepository;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.repository.PannesRepository;
import com.sprinpay.itpark.services.LigneInventaireService;
import com.sprinpay.itpark.services.dto.LigneInventaireDTO;
import org.springframework.stereotype.Service;

@Service
public class LigneInventaireServiceImpl implements LigneInventaireService {
    private final LigneInventaireRepository ligneInventaireRepository;
    private final MaterielsRepository materielsRepository;
    private final InventairesRepository inventairesRepository;
    private final PannesRepository pannesRepository;

    public LigneInventaireServiceImpl(LigneInventaireRepository ligneInventaireRepository, MaterielsRepository materielsRepository, InventairesRepository inventairesRepository, PannesRepository pannesRepository) {
        this.ligneInventaireRepository = ligneInventaireRepository;
        this.materielsRepository = materielsRepository;
        this.inventairesRepository = inventairesRepository;
        this.pannesRepository = pannesRepository;
    }

    @Override
    public void deleteById(Long id) {
        ligneInventaireRepository.deleteById(id);

    }

    @Override
    public List<LigneInventaire> findAll() {
        return ligneInventaireRepository.findAll();

    }

    @Override
    public Optional<LigneInventaire> findById(Long id) {
        return ligneInventaireRepository.findById(id);

    }

    @Override
    public LigneInventaire save(LigneInventaireDTO ligneInventaireDTO) {
        System.out.println(ligneInventaireDTO);

        LigneInventaire ligneInventaire=new LigneInventaire();

        Optional<Materiels> materiels=materielsRepository.findById(ligneInventaireDTO.getMaterielId());
        materiels.ifPresent(ligneInventaire::setMateriel);

        ligneInventaire.setEtat(ligneInventaireDTO.getEtat());
        ligneInventaire.setObservation(ligneInventaireDTO.getObservation());

        Optional<Inventaires> inventaires=inventairesRepository.findById(ligneInventaireDTO.getInventaireId());
        inventaires.ifPresent(ligneInventaire::setInventaire);
        LigneInventaire ligneInventaire1= ligneInventaireRepository.save(ligneInventaire);

        Pannes pannes=new Pannes();
        pannes.setInventaireId(ligneInventaire1.getInventaire().getId());
        pannes.setDateDiagnostic(new Date());
        pannes.setDiagnostic("Lors de l'inventaire");
        pannesRepository.save(pannes);

        System.out.println(ligneInventaire);

        return ligneInventaire1;
    }

}
