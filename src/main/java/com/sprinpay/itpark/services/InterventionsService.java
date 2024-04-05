package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Interventions;
import com.sprinpay.itpark.services.dto.InterventionDTO;

import java.util.List;
import java.util.Optional;

public interface InterventionsService {

    List<Interventions> findAll();

    Optional<Interventions> findById(Long id);

    Interventions save(InterventionDTO interventionDTO);

    void deleteById(Long id);

}
