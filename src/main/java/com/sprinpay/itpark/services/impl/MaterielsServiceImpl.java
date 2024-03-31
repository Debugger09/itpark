package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.TypeMateriel;
import com.sprinpay.itpark.repository.TypeMaterielRepository;
import com.sprinpay.itpark.services.dto.MaterielDTO;
import org.springframework.stereotype.Service;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.services.MaterielsService;

@Service
public class MaterielsServiceImpl implements MaterielsService {
    private final MaterielsRepository materielsRepository;
    private final TypeMaterielRepository typeMaterielRepository;

    public MaterielsServiceImpl(MaterielsRepository materielsRepository,
            TypeMaterielRepository typeMaterielRepository) {
        this.materielsRepository = materielsRepository;
        this.typeMaterielRepository = typeMaterielRepository;
    }

    @Override
    public void deleteById(Long id) {
        materielsRepository.deleteById(id);

    }

    @Override
    public List<Materiels> findAll() {
        return materielsRepository.findAll();
    }

    @Override
    public Optional<Materiels> findById(Long id) {
        return materielsRepository.findById(id);
    }

    @Override
    public Materiels save(MaterielDTO materielDTO) {
        System.out.println(materielDTO.toString());
        Materiels materiels = new Materiels();
        TypeMateriel typeMateriel = typeMaterielRepository.findById(materielDTO.getTypeMaterielId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + materielDTO.getTypeMaterielId()));
        materiels.setTypeMateriel(typeMateriel);
        materiels.setFabricant(materielDTO.getFabricant());
        materiels.setLibelle(materielDTO.getLibelle());
        materiels.setModele(materielDTO.getModele());
        materiels.setNumeroSerie(materielDTO.getNumeroSerie());
        materiels.setEtatAchat(materielDTO.getEtatAchat());
        if (materielDTO.getId() != null) {
            materiels.setId(materielDTO.getId());
        }
        return materielsRepository.save(materiels);
    }

}
