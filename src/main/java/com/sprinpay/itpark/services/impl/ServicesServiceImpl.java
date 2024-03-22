package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprinpay.itpark.domain.Services;
import com.sprinpay.itpark.repository.ServicesRepository;
import com.sprinpay.itpark.services.ServicesService;

public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepository servicesRepository;

    @Autowired
    public ServicesServiceImpl(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    public void deleteById(Long id) {
        servicesRepository.deleteById(id);

    }

    @Override
    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    @Override
    public Optional<Services> findById(Long id) {
        return servicesRepository.findById(id);
    }

    @Override
    public Services save(Services service) {
        return servicesRepository.save(service);
    }

}
