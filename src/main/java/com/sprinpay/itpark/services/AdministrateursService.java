package com.sprinpay.itpark.services;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Administrateurs;

public interface AdministrateursService {
    List<Administrateurs> findAll();

    Optional<Administrateurs> findById(Long id);

    Administrateurs save(Administrateurs administrateur);

    void deleteById(Long id);

}
