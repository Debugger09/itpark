package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.LigneLogiciel;
import com.sprinpay.itpark.domain.Logiciels;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.repository.LigneLogicielRepository;
import com.sprinpay.itpark.repository.LogicielsRepository;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.services.LigneLogicielService;
import com.sprinpay.itpark.services.dto.LigneLogicielDTO;
import org.springframework.stereotype.Service;

@Service
public class LigneLogicielServiceImpl implements LigneLogicielService {
    private final LigneLogicielRepository logicielRepository;
    private final MaterielsRepository materielsRepository;
    private final LogicielsRepository logicielsRepository;

    public LigneLogicielServiceImpl(LigneLogicielRepository logicielRepository, MaterielsRepository materielsRepository, LogicielsRepository logicielsRepository) {
        this.logicielRepository = logicielRepository;
        this.materielsRepository = materielsRepository;
        this.logicielsRepository = logicielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        logicielRepository.deleteById(id);

    }

    @Override
    public List<LigneLogiciel> findAll() {
        return logicielRepository.findAll();
    }

    @Override
    public Optional<LigneLogiciel> findById(Long id) {
        return logicielRepository.findById(id);
    }

    @Override
    public LigneLogiciel save(LigneLogicielDTO ligneLogicielDTO) {
        System.out.println(ligneLogicielDTO);

        LigneLogiciel ligneLogiciel=new LigneLogiciel();

        Optional<Logiciels> logiciels=logicielsRepository.findById(ligneLogicielDTO.getLogicielId());
        logiciels.ifPresent(ligneLogiciel::setLogiciel);


        Optional<Materiels> materiels=materielsRepository.findById(ligneLogicielDTO.getMaterielId());
        materiels.ifPresent(ligneLogiciel::setMateriel);
        ligneLogiciel.setDateInstallation(ligneLogicielDTO.getDateInstallation());
        System.out.println(ligneLogiciel);
        return logicielRepository.save(ligneLogiciel);
    }

}
