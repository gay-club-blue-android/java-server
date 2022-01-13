package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.AppRequestAuthDto;
import com.example.bfjavaserver.dtos.mobile.AppSuccessAuthDto;
import com.example.bfjavaserver.models.App;
import com.example.bfjavaserver.models.AppApiKey;
import com.example.bfjavaserver.models.Client;
import com.example.bfjavaserver.repositories.AppsApiKeysRepository;
import com.example.bfjavaserver.repositories.AppsRepository;
import com.example.bfjavaserver.repositories.ClientsRepository;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Timestamp;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

@Service
public class AppsService {

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final AppsRepository appsRepository;

    @Autowired
    private final AppsApiKeysRepository appsApiKeysRepository;

    public AppsService(ModelMapper modelMapper, AppsRepository appsRepository, AppsApiKeysRepository appsApiKeysRepository) {
        this.modelMapper = modelMapper;
        this.appsRepository = appsRepository;
        this.appsApiKeysRepository = appsApiKeysRepository;
    }

    public AppSuccessAuthDto authByLoginAndPassword(AppRequestAuthDto appRequestAuthDto) throws Exception {

        App foundApp = appsRepository.findByLoginAndPassword(appRequestAuthDto.login, appRequestAuthDto.password);

        long timestamp = currentTimeMillis();
        String dataForHash = foundApp.login + foundApp.password + timestamp;//add device id to hash

        String apiKey = Hashing.sha256().hashString(dataForHash, StandardCharsets.UTF_8).toString();

        long finishTime = timestamp + 86400 * 1000;

        AppApiKey appApiKey = new AppApiKey(0, apiKey, finishTime, foundApp);
        appsApiKeysRepository.saveAndFlush(appApiKey);

        return new AppSuccessAuthDto(apiKey);
    }
}
