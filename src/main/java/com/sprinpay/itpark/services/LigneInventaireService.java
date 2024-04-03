package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.LigneInventaire;
import com.sprinpay.itpark.services.dto.LigneInventaireDTO;

import java.util.List;
import java.util.Optional;

public interface LigneInventaireService {

    List<LigneInventaire> findAll();

    Optional<LigneInventaire> findById(Long id);

    LigneInventaire save(LigneInventaireDTO ligneInventaireDTO);

    void deleteById(Long id);

}
