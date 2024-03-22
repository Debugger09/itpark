package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Logiciels;

import java.util.List;
import java.util.Optional;

public interface LogicielsService {

    List<Logiciels> findAll();

    Optional<Logiciels> findById(Long id);

    Logiciels save(Logiciels logiciel);

    void deleteById(Long id);

}
