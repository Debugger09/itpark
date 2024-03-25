package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.LigneMateriel;

import java.util.List;
import java.util.Optional;

public interface LigneMaterielService {

    List<LigneMateriel> findAll();

    Optional<LigneMateriel> findById(Long id);

    LigneMateriel save(LigneMateriel ligneMateriel);

    void deleteById(Long id);

}
