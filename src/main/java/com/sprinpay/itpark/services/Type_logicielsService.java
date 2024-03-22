package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Type_logiciels;

import java.util.List;
import java.util.Optional;

public interface Type_logicielsService {

    List<Type_logiciels> findAll();

    Optional<Type_logiciels> findById(Long id);

    Type_logiciels save(Type_logiciels type_logiciel);

    void deleteById(Long id);

}
