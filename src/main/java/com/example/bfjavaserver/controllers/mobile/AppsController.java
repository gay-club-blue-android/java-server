package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.requests.AppAuthRequestDto;
import com.example.bfjavaserver.dtos.mobile.responses.AppAuthResponseDto;
import com.example.bfjavaserver.services.mobile.AppsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin(allowedHeaders = "*")
@RequestMapping(path = "/mobile/apps")
@AllArgsConstructor
@Tag(name = "Контроллер приложений", description = "проводит авторизацию приложений (не пользователей)")
public class AppsController {
    private final AppsService appsService;

    /**
     * Проверяет сущетсвует ли приложение с переданными  логином и паролем и, если существует, удаляет все предыдущие
     * api-ключи этого приложения и создаёт новый
     *
     * @param appAuthRequestDto -сущность,содержащая логин, пароль и уникальный номер девайса
     * @return сущность, содаржащая новый api-ключ
     * @throws Exception - возвращает ошибку при передаче несущестыующей пары логина и пароля
     */
    @Operation(summary = "авторизация риложения", description = "Проверяет сущетсвует ли приложение с переданными  логином и паролем и, если существует, удаляет все предыдущие api-ключи этого приложения и создаёт новый")
    @PostMapping(value = "/authByLoginAndPassword")
    public AppAuthResponseDto authByLoginAndPassword(@RequestBody @Valid @Parameter(description = "сущность,содержащая логин, пароль и уникальный номер девайса") AppAuthRequestDto appAuthRequestDto) throws Exception {
        return appsService.authByLoginAndPassword(appAuthRequestDto);
    }
}
