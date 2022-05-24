package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.models.AppApiKey;
import com.example.bfjavaserver.repositories.AppsApiKeysRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Обеспечивает "умный" доступ к таблице {@link AppApiKey}
 */
@Service
@AllArgsConstructor
public class AppsApiKeysService {
    private final AppsApiKeysRepository appsApiKeysRepository;

    /**
     * Ищет в базе данных {@link AppApiKey api-ключ} с переданным значением и id устройства
     * @param key значение искомого {@link AppApiKey api-ключ}а
     * @param deviceId id устройства, к которому привязан ключ
     * @return найденный {@link AppApiKey api-ключ}, иначе null
     */
    public AppApiKey getByKeyAndDeviceId(String key, String deviceId) {
        return appsApiKeysRepository.getByKeyAndDeviceId(key, deviceId);
    }
}
