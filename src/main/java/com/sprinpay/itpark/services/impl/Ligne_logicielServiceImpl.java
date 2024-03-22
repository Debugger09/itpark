package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Ligne_logiciel;
import com.sprinpay.itpark.repository.Ligne_logicielRepository;
import com.sprinpay.itpark.services.Ligne_logicielService;

public class Ligne_logicielServiceImpl implements Ligne_logicielService {
    private final Ligne_logicielRepository ligne_logicielRepository;

    @Autowired
    public Ligne_logicielServiceImpl(Ligne_logicielRepository ligne_logicielRepository) {
        this.ligne_logicielRepository = ligne_logicielRepository;
    }

    @Override
    public void deleteById(Long id) {
        ligne_logicielRepository.deleteById(id);

    }

    @Override
    public List<Ligne_logiciel> findAll() {
        return ligne_logicielRepository.findAll();
    }

    @Override
    public Optional<Ligne_logiciel> findById(Long id) {
        return ligne_logicielRepository.findById(id);
    }

    @Override
    public Ligne_logiciel save(Ligne_logiciel ligne_logiciel) {
        return ligne_logicielRepository.save(ligne_logiciel);
    }

}
