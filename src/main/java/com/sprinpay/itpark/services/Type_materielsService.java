package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Type_materiels;

import java.util.List;
import java.util.Optional;

public interface Type_materielsService {

    List<Type_materiels> findAll();

    Optional<Type_materiels> findById(Long id);

    Type_materiels save(Type_materiels type_materiel);

    void deleteById(Long id);

    
}
