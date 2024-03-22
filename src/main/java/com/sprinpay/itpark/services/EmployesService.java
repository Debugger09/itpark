package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.Employes;

import java.util.List;
import java.util.Optional;

public interface EmployesService {

    List<Employes> findAll();

    Optional<Employes> findById(Long id);

    Employes save(Employes employe);

    void deleteById(Long id);

}
