package com.sprinpay.itpark.services.impl;

import com.sprinpay.itpark.domain.Employes;
import com.sprinpay.itpark.domain.LigneMateriel;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.repository.EmployesRepository;
import com.sprinpay.itpark.repository.LigneMaterielRepository;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.services.LigneMaterielService;
import com.sprinpay.itpark.services.dto.LigneMaterielDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneMaterielServiceImpl implements LigneMaterielService {

    private final LigneMaterielRepository ligneMaterielRepository;
    private final MaterielsRepository materielsRepository;
    private final EmployesRepository employesRepository;

    public LigneMaterielServiceImpl(LigneMaterielRepository materielRepository, MaterielsRepository materielsRepository, EmployesRepository employesRepository) {
        this.ligneMaterielRepository = materielRepository;
        this.materielsRepository = materielsRepository;
        this.employesRepository = employesRepository;
    }

    @Override
    public List<LigneMateriel> findAll() {
        return ligneMaterielRepository.findAll();
    }

    @Override
    public Optional<LigneMateriel> findById(Long id) {
        return ligneMaterielRepository.findById(id);
    }

    @Override
    public LigneMateriel save(LigneMaterielDTO ligneMaterielDTO) {

        LigneMateriel ligneMateriel=new LigneMateriel();

        Optional<Employes> employes=employesRepository.findById(ligneMaterielDTO.getEmployeId());
        Optional<Materiels> materiels=materielsRepository.findById(ligneMaterielDTO.getMaterielId());
        employes.ifPresent(ligneMateriel::setEmploye);
        materiels.ifPresent(ligneMateriel::setMateriel);
        ligneMateriel.setDateAttribution(ligneMaterielDTO.getDateAttribution());




        return ligneMaterielRepository.save(ligneMateriel);
    }

    @Override
    public void deleteById(Long id) {
        ligneMaterielRepository.deleteById(id);
    }
}
