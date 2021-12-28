package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, Integer> {
}

