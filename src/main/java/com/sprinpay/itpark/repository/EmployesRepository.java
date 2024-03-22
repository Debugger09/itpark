package com.sprinpay.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinpay.itpark.domain.Employes;

public interface EmployesRepository extends JpaRepository<Employes, Long> {

}