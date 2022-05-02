package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.requests.ClientRequestDto;
import com.example.bfjavaserver.dtos.mobile.responses.ClientResponseDto;
import com.example.bfjavaserver.services.mobile.ClientsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/mobile/clients", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class ClientsController {
    private final ClientsService clientsService;

    /**
     * Проверяет сущетсвует ли клиент с переданными email и паролем и, если существует, возвращает его
     * @param clientRequestDto -сущность,содержащая email и пароль клиента
     * @return ClientResponseDto - сущность, содержащая id,имя, фамилию и email искомого клиента
     * @throws Exception - возвращает ошибку при передаче несущестыующей пары email и пароля
     */
    @PostMapping(value = "/authByEmailAndPassword")
    public ClientResponseDto authByEmailAndPassword(@RequestBody @Valid ClientRequestDto clientRequestDto) throws Exception {
        return clientsService.authByEmailAndPassword(clientRequestDto);
    }
}
