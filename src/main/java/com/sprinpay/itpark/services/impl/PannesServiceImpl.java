package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.repository.PannesRepository;
import com.sprinpay.itpark.services.PannesService;

public class PannesServiceImpl implements PannesService {
    private final PannesRepository pannesRepository;

    public PannesServiceImpl(PannesRepository pannesRepository) {
        this.pannesRepository = pannesRepository;
    }

    @Override
    public void deleteById(Long id) {
        pannesRepository.deleteById(id);

    }

    @Override
    public List<Pannes> findAll() {
        return pannesRepository.findAll();
    }

    @Override
    public Optional<Pannes> findById(Long id) {
        return pannesRepository.findById(id);
    }

    @Override
    public Pannes save(Pannes panne) {
        return pannesRepository.save(panne);
    }

}
