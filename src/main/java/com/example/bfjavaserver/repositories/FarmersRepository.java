package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmersRepository extends JpaRepository<Farmer, Integer> {
}
