package com.sprinpay.itpark.services.impl;

import com.sprinpay.itpark.domain.Employes;
import com.sprinpay.itpark.domain.LigneMateriel;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.Services;
import com.sprinpay.itpark.repository.EmployesRepository;
import com.sprinpay.itpark.repository.LigneMaterielRepository;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.repository.ServicesRepository;
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
    private final ServicesRepository servicesRepository;

    public LigneMaterielServiceImpl(LigneMaterielRepository materielRepository, MaterielsRepository materielsRepository, EmployesRepository employesRepository, ServicesRepository servicesRepository) {
        this.ligneMaterielRepository = materielRepository;
        this.materielsRepository = materielsRepository;
        this.employesRepository = employesRepository;
        this.servicesRepository = servicesRepository;
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
        System.out.println(ligneMaterielDTO.toString());

        LigneMateriel ligneMateriel=new LigneMateriel();


        Optional<Materiels> materiels=materielsRepository.findById(ligneMaterielDTO.getMaterielId());
        materiels.ifPresent(ligneMateriel::setMateriel);

        if(ligneMaterielDTO.getAttribueA().equals("EMPLOYE")){
            Optional<Employes> employes=employesRepository.findById(ligneMaterielDTO.getEmployeId());
            employes.ifPresent(ligneMateriel::setEmploye);
        }

        if(ligneMaterielDTO.getAttribueA().equals("SERVICE")){
            Optional<Services> services=servicesRepository.findById(ligneMaterielDTO.getServiceId());
            services.ifPresent(ligneMateriel::setServices);
        }
        ligneMateriel.setDateAttribution(ligneMaterielDTO.getDateAttribution());
        ligneMateriel.setAttribueA(ligneMaterielDTO.getAttribueA());




        return ligneMaterielRepository.save(ligneMateriel);
    }

    @Override
    public void deleteById(Long id) {
        ligneMaterielRepository.deleteById(id);
    }
}
