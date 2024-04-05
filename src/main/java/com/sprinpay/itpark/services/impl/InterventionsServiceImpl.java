package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Interventions;
import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.repository.InterventionsRepository;
import com.sprinpay.itpark.repository.PannesRepository;
import com.sprinpay.itpark.repository.UserRepository;
import com.sprinpay.itpark.services.InterventionsService;
import com.sprinpay.itpark.services.dto.InterventionDTO;
import org.springframework.stereotype.Service;

@Service
public class InterventionsServiceImpl implements InterventionsService {
    private final InterventionsRepository interventionsRepository;
    private final UserRepository userRepository;
    private final PannesRepository pannesRepository;

    public InterventionsServiceImpl(InterventionsRepository interventionsRepository, UserRepository userRepository, PannesRepository pannesRepository) {
        this.interventionsRepository = interventionsRepository;
        this.userRepository = userRepository;
        this.pannesRepository = pannesRepository;
    }

    @Override
    public void deleteById(Long id) {
        interventionsRepository.deleteById(id);

    }

    @Override
    public List<Interventions> findAll() {
        return interventionsRepository.findAll();
    }

    @Override
    public Optional<Interventions> findById(Long id) {
        return interventionsRepository.findById(id);
    }

    @Override
    public Interventions save(InterventionDTO interventionDTO) {
        System.out.println(interventionDTO.toString());
        Pannes pannes =pannesRepository.findById(interventionDTO.getPanneId()).orElseThrow();
        User user=userRepository.findById(interventionDTO.getTechnicienId()).orElseThrow();
        Interventions interventions=new Interventions();
        interventions.setDateIntervention(interventionDTO.getDateIntervention());
        interventions.setDecision(interventionDTO.isDecision());
        interventions.setActionRequise(interventionDTO.getActionRequise());
        interventions.setPanne(pannes);
        interventions.setTechnicien(user);
        Interventions interventions1= interventionsRepository.save(interventions);

        pannes.setDecision(interventionDTO.isDecision());

        if(!interventionDTO.isDecision()){
           pannes.setReparable(false);
        }
        pannesRepository.save(pannes);



        return interventions1;
    }

}
