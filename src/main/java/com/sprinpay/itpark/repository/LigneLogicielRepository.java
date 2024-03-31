package com.sprinpay.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinpay.itpark.domain.LigneLogiciel;

import java.util.List;

public interface LigneLogicielRepository extends JpaRepository<LigneLogiciel, Long> {

    List<LigneLogiciel> findAllByMateriel_Id(Long materielId);

    LigneLogiciel findByLogiciel_Id(Long logicielId);

}
