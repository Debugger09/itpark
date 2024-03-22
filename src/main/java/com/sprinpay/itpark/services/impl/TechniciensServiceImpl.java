package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Techniciens;
import com.sprinpay.itpark.repository.TechniciensRepository;
import com.sprinpay.itpark.services.TechniciensService;

public class TechniciensServiceImpl implements TechniciensService {
    private final TechniciensRepository techniciensRepository;

    @Autowired
    public TechniciensServiceImpl(TechniciensRepository techniciensRepository) {
        this.techniciensRepository = techniciensRepository;
    }

    @Override
    public void deleteById(Long id) {
        techniciensRepository.deleteById(id);

    }

    @Override
    public List<Techniciens> findAll() {
        return techniciensRepository.findAll();
    }

    @Override
    public Optional<Techniciens> findById(Long id) {
        return techniciensRepository.findById(id);
    }

    @Override
    public Techniciens save(Techniciens technicien) {
        return techniciensRepository.save(technicien);
    }

}
