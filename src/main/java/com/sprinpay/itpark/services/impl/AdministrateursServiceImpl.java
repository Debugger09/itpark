package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprinpay.itpark.domain.Administrateurs;
import com.sprinpay.itpark.repository.AdministrateursRepository;
import com.sprinpay.itpark.services.AdministrateursService;

@Service
public class AdministrateursServiceImpl implements AdministrateursService {
    private final AdministrateursRepository administrateursRepository;

    public AdministrateursServiceImpl(AdministrateursRepository administrateursRepository) {
        this.administrateursRepository = administrateursRepository;
    }

    @Override
    public void deleteById(Long id) {
        administrateursRepository.deleteById(id);
    }

    @Override
    public List<Administrateurs> findAll() {
        return administrateursRepository.findAll();
    }

    @Override
    public Optional<Administrateurs> findById(Long id) {
        return administrateursRepository.findById(id);
    }

    @Override
    public Administrateurs save(Administrateurs administrateur) {
        return administrateursRepository.save(administrateur);
    }
}
