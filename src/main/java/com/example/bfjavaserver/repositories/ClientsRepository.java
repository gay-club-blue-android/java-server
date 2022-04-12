package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientsRepository extends JpaRepository<Client, Integer> {
    Client findByEmailAndPassword(String email, String password);
}

