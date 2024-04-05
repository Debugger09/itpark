package com.sprinpay.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinpay.itpark.domain.Pannes;

import java.util.List;

public interface PannesRepository extends JpaRepository<Pannes, Long> {

    List<Pannes> findAllByDecisionFalse();
}
