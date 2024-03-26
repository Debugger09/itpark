package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.TypeMateriel;
import com.sprinpay.itpark.repository.TypeMaterielRepository;

import com.sprinpay.itpark.services.TypeMaterielService;
import org.springframework.stereotype.Service;

@Service
public class TypeMaterielServiceImpl implements TypeMaterielService {
    private final TypeMaterielRepository typeMaterielRepository;

    public TypeMaterielServiceImpl(TypeMaterielRepository typeMaterielRepository) {
        this.typeMaterielRepository = typeMaterielRepository;
    }

    @Override
    public void deleteById(Long id) {
        typeMaterielRepository.deleteById(id);
    }

    @Override
    public List<TypeMateriel> findAll() {
        return typeMaterielRepository.findAll();
    }

    @Override
    public Optional<TypeMateriel> findById(Long id) {
        return typeMaterielRepository.findById(id);
    }

    @Override
    public TypeMateriel save(TypeMateriel type_materiel) {
        return typeMaterielRepository.save(type_materiel);
    }

}
