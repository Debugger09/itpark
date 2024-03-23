package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.LigneLogiciel;

import java.util.List;
import java.util.Optional;

public interface LigneLogicielService {

    List<LigneLogiciel> findAll();

    Optional<LigneLogiciel> findById(Long id);

    LigneLogiciel save(LigneLogiciel ligne_logiciel);

    void deleteById(Long id);

}
