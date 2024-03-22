package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Pannes;

import java.util.List;
import java.util.Optional;

public interface PannesService {

    List<Pannes> findAll();

    Optional<Pannes> findById(Long id);

    Pannes save(Pannes panne);

    void deleteById(Long id);

}
