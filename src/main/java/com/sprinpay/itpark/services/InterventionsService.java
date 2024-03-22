package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Interventions;

import java.util.List;
import java.util.Optional;

public interface InterventionsService {

    List<Interventions> findAll();

    Optional<Interventions> findById(Long id);

    Interventions save(Interventions intervention);

    void deleteById(Long id);

}
