package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Employes;
import com.sprinpay.itpark.repository.EmployesRepository;
import com.sprinpay.itpark.services.EmployesService;
import org.springframework.stereotype.Service;

@Service
public class EmployesServiceImpl implements EmployesService {
    private final EmployesRepository employesRepository;

    public EmployesServiceImpl(EmployesRepository employesRepository) {
        this.employesRepository = employesRepository;
    }

    @Override
    public void deleteById(Long id) {
        employesRepository.deleteById(id);

    }

    @Override
    public List<Employes> findAll() {
        return employesRepository.findAll();
    }

    @Override
    public Optional<Employes> findById(Long id) {
        return employesRepository.findById(id);
    }

    @Override
    public Employes save(Employes employes) {
        return employesRepository.save(employes);
    }
}
