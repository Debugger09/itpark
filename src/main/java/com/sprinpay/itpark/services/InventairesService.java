package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Inventaires;

import java.util.List;
import java.util.Optional;

public interface InventairesService {

    List<Inventaires> findAll();

    Optional<Inventaires> findInventaireById(Long id);

    Inventaires save(Inventaires inventaire);

    void deleteInventaire(Long id);

}
