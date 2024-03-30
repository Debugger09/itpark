package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Logiciels;
import com.sprinpay.itpark.domain.TypeLogiciel;
import com.sprinpay.itpark.domain.TypeMateriel;
import com.sprinpay.itpark.repository.LogicielsRepository;
import com.sprinpay.itpark.repository.TypeLogicielRepository;
import com.sprinpay.itpark.services.LogicielsService;
import com.sprinpay.itpark.services.dto.LogicielDTO;
import org.springframework.stereotype.Service;

@Service
public class LogicielsServiceImpl implements LogicielsService {
    private final LogicielsRepository logicielsRepository;
    private final TypeLogicielRepository typeLogicielRepository;

    public LogicielsServiceImpl(LogicielsRepository logicielsRepository, TypeLogicielRepository typeLogicielRepository) {
        this.logicielsRepository = logicielsRepository;
        this.typeLogicielRepository = typeLogicielRepository;
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
    public Logiciels save(LogicielDTO logicielDTO) {
        TypeLogiciel typeLogiciel = typeLogicielRepository.findById(logicielDTO.getTypeLogicielId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + logicielDTO.getTypeLogicielId()));
            Logiciels logiciels=LogicielDTO.mapEntity(logicielDTO);
            logiciels.setTypeLogiciel(typeLogiciel);
        System.out.println(logiciels);
        return logicielsRepository.save(logiciels);
    }

}
