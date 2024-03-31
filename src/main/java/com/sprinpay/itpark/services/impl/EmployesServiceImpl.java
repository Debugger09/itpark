package com.sprinpay.itpark.services.impl;

import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.Employes;
import com.sprinpay.itpark.domain.Services;
import com.sprinpay.itpark.repository.EmployesRepository;
import com.sprinpay.itpark.repository.ServicesRepository;
import com.sprinpay.itpark.services.EmployesService;
import org.springframework.stereotype.Service;

@Service
public class EmployesServiceImpl implements EmployesService {
    private final EmployesRepository employesRepository;
    private final ServicesRepository servicesRepository;

    public EmployesServiceImpl(EmployesRepository employesRepository, ServicesRepository servicesRepository) {
        this.employesRepository = employesRepository;
        this.servicesRepository = servicesRepository;
    }

    @Override
    public void deleteById(Long id) {
        employesRepository.deleteById(id);

    }

    @Override
    public List<Employes> findAll() {
        return employesRepository.findAll();
    }

    @Override
    public Optional<Employes> findById(Long id) {
       Optional<Employes> employes=  employesRepository.findById(id);
        employes.ifPresent(value ->{
            if(value.getService()!=null){
                value.setServiceId(value.getService().getId());
            }
        });
        return employes;
    }

    @Override
    public Employes save(Employes employes) {
        Optional<Services> service=servicesRepository.findById(employes.getServiceId());
         service.ifPresent(employes::setService);
        if(employes.getId()!=null){
            employes.setId(employes.getId());
        }
        return employesRepository.save(employes);
    }
}
