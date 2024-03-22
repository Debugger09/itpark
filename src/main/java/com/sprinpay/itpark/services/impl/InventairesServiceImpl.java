package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Inventaires;
import com.sprinpay.itpark.repository.InventairesRepository;
import com.sprinpay.itpark.services.InventairesService;

public class InventairesServiceImpl implements InventairesService {
    private final InventairesRepository inventairesRepository;

    @Autowired
    public InventairesServiceImpl(InventairesRepository inventairesRepository) {
        this.inventairesRepository = inventairesRepository;
    }

    @Override
    public void deleteInventaire(Long id) {
        inventairesRepository.deleteById(id);

    }

    @Override
    public List<Inventaires> findAll() {
        return inventairesRepository.findAll();
    }

    @Override
    public Optional<Inventaires> findInventaireById(Long id) {
        return inventairesRepository.findById(id);
    }

    @Override
    public Inventaires save(Inventaires inventaires) {
        return inventairesRepository.save(inventaires);
    }

}
