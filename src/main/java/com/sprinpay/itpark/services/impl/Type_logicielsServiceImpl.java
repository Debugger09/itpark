package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Type_logiciels;
import com.sprinpay.itpark.repository.Type_logicielsRepository;
import com.sprinpay.itpark.services.Type_logicielsService;

public class Type_logicielsServiceImpl implements Type_logicielsService {

    private final Type_logicielsRepository type_logicielsRepository;

    @Autowired
    public Type_logicielsServiceImpl(Type_logicielsRepository type_logicielsRepository) {
        this.type_logicielsRepository = type_logicielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        type_logicielsRepository.deleteById(id);

    }

    @Override
    public List<Type_logiciels> findAll() {
        return type_logicielsRepository.findAll();
    }

    @Override
    public Optional<Type_logiciels> findById(Long id) {
        return type_logicielsRepository.findById(id);
    }

    @Override
    public Type_logiciels save(Type_logiciels type_logiciel) {
        return type_logicielsRepository.save(type_logiciel);
    }

}
