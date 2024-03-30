package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Logiciels;
import com.sprinpay.itpark.services.dto.LogicielDTO;

import java.util.List;
import java.util.Optional;

public interface LogicielsService {

    List<Logiciels> findAll();

    Optional<Logiciels> findById(Long id);

    Logiciels save(LogicielDTO logicielDTO);

    void deleteById(Long id);

}
