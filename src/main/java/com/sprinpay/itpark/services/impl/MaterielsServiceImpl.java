package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.services.MaterielsService;

public class MaterielsServiceImpl implements MaterielsService {
    private final MaterielsRepository materielsRepository;

    @Autowired
    public MaterielsServiceImpl(MaterielsRepository materielsRepository) {
        this.materielsRepository = materielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        materielsRepository.deleteById(id);

    }

    @Override
    public List<Materiels> findAll() {
        return materielsRepository.findAll();
    }

    @Override
    public Optional<Materiels> findById(Long id) {
        return materielsRepository.findById(id);
    }

    @Override
    public Materiels save(Materiels materiels) {
        return materielsRepository.save(materiels);
    }

}
