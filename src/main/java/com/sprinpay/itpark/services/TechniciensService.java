package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Techniciens;

import java.util.List;
import java.util.Optional;

public interface TechniciensService {

    List<Techniciens> findAll();

    Optional<Techniciens> findById(Long id);

    Techniciens save(Techniciens technicien);

    void deleteById(Long id);

}
