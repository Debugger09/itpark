package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.TypeLogiciel;

import java.util.List;
import java.util.Optional;

public interface TypeLogicielService {

    List<TypeLogiciel> findAll();

    Optional<TypeLogiciel> findById(Long id);

    TypeLogiciel save(TypeLogiciel type_logiciel);

    void deleteById(Long id);

}
