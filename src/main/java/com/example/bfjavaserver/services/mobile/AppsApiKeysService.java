package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.models.AppApiKey;
import com.example.bfjavaserver.repositories.AppsApiKeysRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppsApiKeysService {
    private final AppsApiKeysRepository appsApiKeysRepository;

    public AppApiKey getByKeyAndDeviceId(String key, String deviceId) {
        return appsApiKeysRepository.getByKeyAndDeviceId(key, deviceId);
    }
}
