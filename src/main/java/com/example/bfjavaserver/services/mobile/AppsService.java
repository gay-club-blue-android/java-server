package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.mobile.requests.AppAuthRequestDto;
import com.example.bfjavaserver.dtos.mobile.responses.AppAuthResponseDto;
import com.example.bfjavaserver.models.App;
import com.example.bfjavaserver.models.AppApiKey;
import com.example.bfjavaserver.repositories.AppsApiKeysRepository;
import com.example.bfjavaserver.repositories.AppsRepository;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static java.lang.System.currentTimeMillis;

@Service
@AllArgsConstructor
public class AppsService {
    private final AppsRepository appsRepository;
    private final AppsApiKeysRepository appsApiKeysRepository;
    
    public AppAuthResponseDto authByLoginAndPassword(AppAuthRequestDto appAuthRequestDto) throws Exception {

        App foundApp = appsRepository.findByLoginAndPassword(appAuthRequestDto.login, appAuthRequestDto.password);

        if (foundApp == null) {
            throw CustomException.AuthException("App credentials not found");
        }

        long timestamp = currentTimeMillis();

        String dataForHash = foundApp.login + foundApp.password + appAuthRequestDto.deviceId + timestamp;

        String apiKey = Hashing.sha256().hashString(dataForHash, StandardCharsets.UTF_8).toString();

        int millisecondsInDay = 86400 * 1000;
        int days = 7;

        long finishTime = timestamp + days * millisecondsInDay;

        AppApiKey appApiKey = new AppApiKey(0, apiKey, finishTime, foundApp, appAuthRequestDto.deviceId);

        appsApiKeysRepository.saveAndFlush(appApiKey);

        return new AppAuthResponseDto(apiKey);
    }
}
