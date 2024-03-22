package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Ligne_inventaire;

import java.util.List;
import java.util.Optional;

public interface Ligne_inventaireService {

    List<Ligne_inventaire> findAll();

    Optional<Ligne_inventaire> findById(Long id);

    Ligne_inventaire save(Ligne_inventaire ligne_inventaire);

    void deleteById(Long id);

}
