package com.sprinpay.itpark.services.impl;

import com.sprinpay.itpark.domain.LigneMateriel;
import com.sprinpay.itpark.repository.LigneMaterielRepository;
import com.sprinpay.itpark.services.LigneMaterielService;

import java.util.List;
import java.util.Optional;

public class LigneMaterielServiceImpl implements LigneMaterielService {

    private final LigneMaterielRepository materielRepository;

    public LigneMaterielServiceImpl(LigneMaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    @Override
    public List<LigneMateriel> findAll() {
        return materielRepository.findAll();
    }

    @Override
    public Optional<LigneMateriel> findById(Long id) {
        return materielRepository.findById(id);
    }

    @Override
    public LigneMateriel save(LigneMateriel ligneMateriel) {
        return materielRepository.save(ligneMateriel);
    }

    @Override
    public void deleteById(Long id) {
        materielRepository.deleteById(id);
    }
}
