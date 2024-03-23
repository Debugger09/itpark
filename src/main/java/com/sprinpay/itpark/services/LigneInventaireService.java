package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.LigneInventaire;

import java.util.List;
import java.util.Optional;

public interface LigneInventaireService {

    List<LigneInventaire> findAll();

    Optional<LigneInventaire> findById(Long id);

    LigneInventaire save(LigneInventaire ligne_inventaire);

    void deleteById(Long id);

}
