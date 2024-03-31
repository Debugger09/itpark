package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.LigneLogiciel;
import com.sprinpay.itpark.services.dto.LigneLogicielDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LigneLogicielService {

    List<LigneLogiciel> findAll();

    Optional<LigneLogiciel> findById(Long id);

    LigneLogiciel save(LigneLogicielDTO ligneLogicielDTO);

    void deleteById(Long id);

}
