package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.LigneInventaire;
import com.sprinpay.itpark.repository.LigneInventaireRepository;
import com.sprinpay.itpark.services.LigneInventaireService;

public class LigneInventaireServiceImpl implements LigneInventaireService {
    private final LigneInventaireRepository ligneInventaireRepository;

    @Autowired
    public LigneInventaireServiceImpl(LigneInventaireRepository ligneInventaireRepository) {
        this.ligneInventaireRepository = ligneInventaireRepository;
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
    public LigneInventaire save(LigneInventaire ligne_inventaire) {
        return ligneInventaireRepository.save(ligne_inventaire);
    }

}
