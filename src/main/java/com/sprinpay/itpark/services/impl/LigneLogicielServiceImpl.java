package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.LigneLogiciel;
import com.sprinpay.itpark.repository.LigneLogicielRepository;
import com.sprinpay.itpark.services.LigneLogicielService;

public class LigneLogicielServiceImpl implements LigneLogicielService {
    private final LigneLogicielRepository logicielRepository;

    public LigneLogicielServiceImpl(LigneLogicielRepository logicielRepository) {
        this.logicielRepository = logicielRepository;
    }

    @Override
    public void deleteById(Long id) {
        logicielRepository.deleteById(id);

    }

    @Override
    public List<LigneLogiciel> findAll() {
        return logicielRepository.findAll();
    }

    @Override
    public Optional<LigneLogiciel> findById(Long id) {
        return logicielRepository.findById(id);
    }

    @Override
    public LigneLogiciel save(LigneLogiciel ligne_logiciel) {
        return logicielRepository.save(ligne_logiciel);
    }

}
