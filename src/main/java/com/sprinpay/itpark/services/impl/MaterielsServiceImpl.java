package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Materiel;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.services.MaterielsService;

public class MaterielsServiceImpl implements MaterielsService {
    private final MaterielsRepository materielsRepository;

    public MaterielsServiceImpl(MaterielsRepository materielsRepository) {
        this.materielsRepository = materielsRepository;
    }

    @Override
    public void deleteById(Long id) {
        materielsRepository.deleteById(id);

    }

    @Override
    public List<Materiel> findAll() {
        return materielsRepository.findAll();
    }

    @Override
    public Optional<Materiel> findById(Long id) {
        return materielsRepository.findById(id);
    }

    @Override
    public Materiel save(Materiel materiels) {
        return materielsRepository.save(materiels);
    }

}
