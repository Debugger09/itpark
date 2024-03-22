package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Materiels;

import java.util.List;
import java.util.Optional;

public interface MaterielsService {

    List<Materiels> findAll();

    Optional<Materiels> findById(Long id);

    Materiels save(Materiels materiel);

    void deleteById(Long id);

    // Ajoutez d'autres méthodes spécifiques aux matériels si nécessaire

}
