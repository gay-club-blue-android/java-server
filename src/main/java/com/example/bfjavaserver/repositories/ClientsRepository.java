package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientsRepository extends JpaRepository<Client, Integer> {
    //@Query(value = "select * from clients where email=?1 and password=?2", nativeQuery = true)
    Client findByEmailAndPassword(String email, String password);
}

