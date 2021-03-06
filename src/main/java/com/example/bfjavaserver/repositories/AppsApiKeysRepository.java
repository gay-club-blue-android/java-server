package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.AppApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppsApiKeysRepository extends JpaRepository<AppApiKey, Integer> {
    AppApiKey getByKeyAndDeviceId(String key, String deviceId);
    void deleteByDeviceId(String deviceId);
}
