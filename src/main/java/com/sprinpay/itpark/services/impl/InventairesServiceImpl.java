package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Inventaires;
import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.repository.InventairesRepository;
import com.sprinpay.itpark.repository.UserRepository;
import com.sprinpay.itpark.services.InventairesService;
import org.springframework.stereotype.Service;

@Service
public class InventairesServiceImpl implements InventairesService {
    private final InventairesRepository inventairesRepository;
    private final UserRepository userRepository;

    public InventairesServiceImpl(InventairesRepository inventairesRepository, UserRepository userRepository) {
        this.inventairesRepository = inventairesRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void deleteInventaire(Long id) {
        inventairesRepository.deleteById(id);

    }

    @Override
    public List<Inventaires> findAll() {
        return inventairesRepository.findAll();
    }

    @Override
    public Optional<Inventaires> findInventaireById(Long id) {
        return inventairesRepository.findById(id);
    }

    @Override
    public Inventaires save(Inventaires inventaires) {
        Optional<User> user= userRepository.findById(inventaires.getTechnicienId());
        user.ifPresent(inventaires::setTechnicien);
        System.out.println(inventaires.toString());
        return inventairesRepository.save(inventaires);
    }

}
