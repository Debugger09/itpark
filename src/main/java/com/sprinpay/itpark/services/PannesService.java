package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.services.dto.PanneDTO;

import java.util.List;
import java.util.Optional;

public interface PannesService {

    List<Pannes> findAll();

    Optional<Pannes> findById(Long id);

    Pannes save(PanneDTO panneDTO);

    void deleteById(Long id);

}
