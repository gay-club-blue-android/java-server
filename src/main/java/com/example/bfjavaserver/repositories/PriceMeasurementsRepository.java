package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.PriceMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceMeasurementsRepository extends JpaRepository<PriceMeasurement, Integer> {
}
