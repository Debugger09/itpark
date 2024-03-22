package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Interventions;
import com.sprinpay.itpark.repository.InterventionsRepository;
import com.sprinpay.itpark.services.InterventionsService;

public class InterventionsServiceImpl implements InterventionsService {
    private final InterventionsRepository interventionsRepository;

    @Autowired
    public InterventionsServiceImpl(InterventionsRepository interventionsRepository) {
        this.interventionsRepository = interventionsRepository;
    }

    @Override
    public void deleteById(Long id) {
        interventionsRepository.deleteById(id);

    }

    @Override
    public List<Interventions> findAll() {
        return interventionsRepository.findAll();
    }

    @Override
    public Optional<Interventions> findById(Long id) {
        return interventionsRepository.findById(id);
    }

    @Override
    public Interventions save(Interventions interventions) {
        return interventionsRepository.save(interventions);
    }

}
