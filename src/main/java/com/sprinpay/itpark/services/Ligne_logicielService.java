package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Ligne_logiciel;

import java.util.List;
import java.util.Optional;

public interface Ligne_logicielService {

    List<Ligne_logiciel> findAll();

    Optional<Ligne_logiciel> findById(Long id);

    Ligne_logiciel save(Ligne_logiciel ligne_logiciel);

    void deleteById(Long id);

}
