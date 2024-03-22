package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Services;

import java.util.List;
import java.util.Optional;

public interface ServicesService {

    List<Services> findAll();

    Optional<Services> findById(Long id);

    Services save(Services service);

    void deleteById(Long id);

}
