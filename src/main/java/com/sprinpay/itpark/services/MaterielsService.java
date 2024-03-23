package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Materiel;

import java.util.List;
import java.util.Optional;

public interface MaterielsService {

    List<Materiel> findAll();

    Optional<Materiel> findById(Long id);

    Materiel save(Materiel materiel);

    void deleteById(Long id);

    // Ajoutez d'autres méthodes spécifiques aux matériels si nécessaire

}
