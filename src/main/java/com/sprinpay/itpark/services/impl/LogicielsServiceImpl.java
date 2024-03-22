package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Logiciels;
import com.sprinpay.itpark.repository.LogicielsRepository;
import com.sprinpay.itpark.services.LogicielsService;

public class LogicielsServiceImpl implements LogicielsService {
    private final LogicielsRepository logicielsRepository;

    @Autowired
    public LogicielsServiceImpl(LogicielsRepository logicielsRepository) {
        this.logicielsRepository = logicielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        logicielsRepository.deleteById(id);

    }

    @Override
    public List<Logiciels> findAll() {
        return logicielsRepository.findAll();
    }

    @Override
    public Optional<Logiciels> findById(Long id) {
        return logicielsRepository.findById(id);
    }

    @Override
    public Logiciels save(Logiciels logiciels) {
        return logicielsRepository.save(logiciels);
    }

}
