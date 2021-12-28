package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.AmountMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountMeasurementsRepository extends JpaRepository<AmountMeasurement, Integer> {
}
