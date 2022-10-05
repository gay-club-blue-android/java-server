package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.client.request.ClientAuthByEmailAndPasswordRequestDto;
import com.example.bfjavaserver.dtos.mobile.client.response.ClientAuthByEmailAndPasswordResponseDto;
import com.example.bfjavaserver.services.mobile.ClientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(path = "/mobile/clients")
@AllArgsConstructor
@Tag(name="Контроллер клиентов", description = "проводит авторизацию клиентов")
public class ClientsController {
    private final ClientsService clientsService;

    /**
     * Проверяет сущетсвует ли клиент с переданными email и паролем и, если существует, возвращает его
     * @param clientAuthByEmailAndPasswordRequestDto сущность,содержащая email и пароль клиента
     * @return ClientResponseDto сущность, содержащая id,имя, фамилию и email искомого клиента
     * @throws Exception возвращает ошибку при передаче несущестыующей пары email и пароля
     */
    @Operation(method = "POST",summary = "авторизация пользователя", description = "Проверяет сущетсвует ли клиент с переданными email и паролем и, если существует, возвращает его")
    @PostMapping(value = "/authByEmailAndPassword")
    public ClientAuthByEmailAndPasswordResponseDto authByEmailAndPassword(@RequestBody @Valid @Parameter(description = "сущность,содержащая email и пароль клиента") ClientAuthByEmailAndPasswordRequestDto clientAuthByEmailAndPasswordRequestDto) throws Exception {


        return clientsService.authByEmailAndPassword(clientAuthByEmailAndPasswordRequestDto);
    }
}
