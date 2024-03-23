package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.TypeMateriel;

import java.util.List;
import java.util.Optional;

public interface TypeMaterielService {

    List<TypeMateriel> findAll();

    Optional<TypeMateriel> findById(Long id);

    TypeMateriel save(TypeMateriel type_materiel);

    void deleteById(Long id);

    
}
