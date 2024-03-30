package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.repository.TypeLogicielRepository;

import com.sprinpay.itpark.domain.TypeLogiciel;
import com.sprinpay.itpark.services.TypeLogicielService;
import org.springframework.stereotype.Service;

@Service
public class TypeLogicielServiceImpl implements TypeLogicielService {

    private final TypeLogicielRepository type_logicielsRepository;

    public TypeLogicielServiceImpl(TypeLogicielRepository type_logicielsRepository) {
        this.type_logicielsRepository = type_logicielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        type_logicielsRepository.deleteById(id);

    }

    @Override
    public List<TypeLogiciel> findAll() {
        return type_logicielsRepository.findAll();
    }

    @Override
    public Optional<TypeLogiciel> findById(Long id) {
        return type_logicielsRepository.findById(id);
    }

    @Override
    public TypeLogiciel save(TypeLogiciel type_logiciel) {
        return type_logicielsRepository.save(type_logiciel);
    }

}
