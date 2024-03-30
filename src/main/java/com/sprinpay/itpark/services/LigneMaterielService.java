package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.LigneMateriel;
import com.sprinpay.itpark.services.dto.LigneMaterielDTO;

import java.util.List;
import java.util.Optional;

public interface LigneMaterielService {

    List<LigneMateriel> findAll();

    Optional<LigneMateriel> findById(Long id);

    LigneMateriel save(LigneMaterielDTO ligneMaterielDTO);

    void deleteById(Long id);

}
