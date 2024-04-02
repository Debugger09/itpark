package com.sprinpay.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinpay.itpark.domain.LigneMateriel;

public interface LigneMaterielRepository extends JpaRepository<LigneMateriel, Long> {

    LigneMateriel findByMateriel_IdAndDateAttributionTrue(Long materielId);

    Long countByDateAttributionTrue();

}
