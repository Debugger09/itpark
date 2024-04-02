package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.repository.PannesRepository;
import com.sprinpay.itpark.services.PannesService;
import com.sprinpay.itpark.services.dto.PanneDTO;
import org.springframework.stereotype.Service;


@Service
public class PannesServiceImpl implements PannesService {
    private final PannesRepository pannesRepository;
    private final MaterielsRepository materielsRepository;
    public PannesServiceImpl(PannesRepository pannesRepository, MaterielsRepository materielsRepository) {
        this.pannesRepository = pannesRepository;
        this.materielsRepository = materielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        pannesRepository.deleteById(id);

    }

    @Override
    public List<Pannes> findAll() {
        return pannesRepository.findAll();
    }

    @Override
    public Optional<Pannes> findById(Long id) {
        return pannesRepository.findById(id);
    }

    @Override
    public Pannes save(PanneDTO panneDTO) {

        Optional<Materiels> materiels=materielsRepository.findById(panneDTO.getMaterielId());
        Pannes panne=new Pannes();
        materiels.ifPresent(panne::setMateriel);
        panne.setDiagnostic(panneDTO.getDiagnostic());
        panne.setDateDiagnostic(panneDTO.getDateDiagnostic());

        if(panneDTO.getId()!=null){
            panne.setId(panneDTO.getId());
        }


        return pannesRepository.save(panne);
    }

}
