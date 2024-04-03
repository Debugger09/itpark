package com.sprinpay.itpark.repository;

import com.sprinpay.itpark.domain.Inventaires;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinpay.itpark.domain.LigneInventaire;

import java.util.List;

public interface LigneInventaireRepository extends JpaRepository<LigneInventaire, Long> {

    List<LigneInventaire> findAllByInventaire_Id(Long inventaireId);
    LigneInventaire findByMateriel_IdAndInventaire_Id(Long materielId,Long inventaireId);

}
