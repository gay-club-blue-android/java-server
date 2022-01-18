package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.AppAuthRequestDto;
import com.example.bfjavaserver.dtos.mobile.AppAuthResponseDto;
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

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final AppsRepository appsRepository;

    @Autowired
    private final AppsApiKeysRepository appsApiKeysRepository;

    public AppAuthResponseDto authByLoginAndPassword(AppAuthRequestDto appAuthRequestDto) throws Exception {

        App foundApp = appsRepository.findByLoginAndPassword(appAuthRequestDto.login, appAuthRequestDto.password);

        long timestamp = currentTimeMillis();

        String dataForHash = foundApp.login + foundApp.password +appAuthRequestDto.deviceId + timestamp;//add device id to hash

        String apiKey = Hashing.sha256().hashString(dataForHash, StandardCharsets.UTF_8).toString();

        long finishTime = timestamp + 86400 * 1000;

        AppApiKey appApiKey = new AppApiKey(0, apiKey, finishTime, foundApp, appAuthRequestDto.deviceId);

        appsApiKeysRepository.saveAndFlush(appApiKey);

        return new AppAuthResponseDto(apiKey);
    }
}
