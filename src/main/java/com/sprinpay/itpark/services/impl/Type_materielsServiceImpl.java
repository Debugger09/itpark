package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Type_materiels;
import com.sprinpay.itpark.repository.Type_materielsRepository;
import com.sprinpay.itpark.services.Type_materielsService;

public class Type_materielsServiceImpl implements Type_materielsService {
    private final Type_materielsRepository type_materielsRepository;

    @Autowired
    public Type_materielsServiceImpl(Type_materielsRepository type_materielsRepository) {
        this.type_materielsRepository = type_materielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        type_materielsRepository.deleteById(id);
    }

    @Override
    public List<Type_materiels> findAll() {
        return type_materielsRepository.findAll();
    }

    @Override
    public Optional<Type_materiels> findById(Long id) {
        return type_materielsRepository.findById(id);
    }

    @Override
    public Type_materiels save(Type_materiels type_materiel) {
        return type_materielsRepository.save(type_materiel);
    }

}
