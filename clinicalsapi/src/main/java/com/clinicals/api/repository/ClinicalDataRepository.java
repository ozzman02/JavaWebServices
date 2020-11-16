package com.clinicals.api.repository;

import com.clinicals.api.model.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {
}
