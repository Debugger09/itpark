package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Ligne_inventaire;
import com.sprinpay.itpark.repository.Ligne_inventaireRepository;
import com.sprinpay.itpark.services.Ligne_inventaireService;

public class Ligne_inventaireServiceImpl implements Ligne_inventaireService {
    private final Ligne_inventaireRepository ligne_inventaireRepository;

    @Autowired
    public Ligne_inventaireServiceImpl(Ligne_inventaireRepository ligne_inventaireRepository) {
        this.ligne_inventaireRepository = ligne_inventaireRepository;
    }

    @Override
    public void deleteById(Long id) {
        ligne_inventaireRepository.deleteById(id);

    }

    @Override
    public List<Ligne_inventaire> findAll() {
        return ligne_inventaireRepository.findAll();

    }

    @Override
    public Optional<Ligne_inventaire> findById(Long id) {
        return ligne_inventaireRepository.findById(id);

    }

    @Override
    public Ligne_inventaire save(Ligne_inventaire ligne_inventaire) {
        return ligne_inventaireRepository.save(ligne_inventaire);
    }

}
