package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.services.dto.MaterielDTO;

import java.util.List;
import java.util.Optional;

public interface MaterielsService {

    List<Materiels> findAll();

    Optional<Materiels> findById(Long id);

    Materiels save(MaterielDTO materielDTO);

    void deleteById(Long id);

    // Ajoutez d'autres méthodes spécifiques aux matériels si nécessaire

}
