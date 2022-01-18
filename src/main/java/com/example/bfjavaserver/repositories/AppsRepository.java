package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.App;
import com.example.bfjavaserver.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppsRepository extends JpaRepository<App, Integer> {
    App findByLoginAndPassword(String login, String password, String device_id);
}
