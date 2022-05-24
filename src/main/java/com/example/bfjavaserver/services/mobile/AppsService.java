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
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

import static java.lang.System.currentTimeMillis;

/**
 * Обеспечивает "умный" доступ к таблице {@link App}
 */
@Service
@AllArgsConstructor
public class AppsService {
    private final AppsRepository appsRepository;
    private final AppsApiKeysRepository appsApiKeysRepository;

    /**
     * Совершает попытку на авторизацию приложения (не пользователя).
     * Если приложение с таким логином и паролем есть в базе данных, то удаляет все api-ключи,
     * связанные с этим id устройтсва, создаёт новый и возвращает сущность, содержащую его значение, иначе возвращает ошибку
     * @param appAuthRequestDto сущность, содержашая email, пароль и id устройтсва авторизируемого приложения
     * @return Сущность содержащую значение нового api-ключа
     * @throws Exception Приложение не было найдено
     */
    @Transactional
    public AppAuthResponseDto authByLoginAndPassword(AppAuthRequestDto appAuthRequestDto) throws Exception {

        App foundApp = appsRepository.findByLoginAndPassword(appAuthRequestDto.login, appAuthRequestDto.password);

        if (foundApp == null) {
            throw CustomException.AuthException("App credentials not found");
        }

        //delete all old keys for this device
        appsApiKeysRepository.deleteByDeviceId(appAuthRequestDto.deviceId);

        long timestamp = currentTimeMillis();

        String dataForHash = foundApp.login + foundApp.password + appAuthRequestDto.deviceId + timestamp;

        String apiKey = Hashing.sha256().hashString(dataForHash, StandardCharsets.UTF_8).toString();

        int millisecondsInDay = 86400 * 1000;
        int days = 7;

        long finishTime = timestamp + days * millisecondsInDay;

        AppApiKey appApiKey = new AppApiKey(0, apiKey, finishTime, foundApp.id, appAuthRequestDto.deviceId);

        appsApiKeysRepository.saveAndFlush(appApiKey);

        return new AppAuthResponseDto(apiKey);
    }
}
