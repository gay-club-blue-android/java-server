package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.mobile.client.request.ClientAuthByEmailAndPasswordRequestDto;
import com.example.bfjavaserver.dtos.mobile.client.response.ClientAuthByEmailAndPasswordResponseDto;
import com.example.bfjavaserver.models.Client;
import com.example.bfjavaserver.repositories.ClientsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
/**
 * Обеспечивает "умный" доступ к таблице {@link Client}
 */
@Service
@AllArgsConstructor
public class ClientsService {
    private final ModelMapper modelMapper;
    private final ClientsRepository clientsRepository;

    /**
     * Осуществляет попытку авторизации клиента (покупателя)
     * Если клиент с переданными email и паролем существует, то возвращает информацию о нём, иначе возвращает ошибку
     * @param clientAuthByEmailAndPasswordRequestDto Сущность, содержашая email и пароль искомого клиента
     * @return Сущность, содержащая id (из базы данных), имя, фамилию и email клиента
     * @throws Exception Если клиент не был найден
     */
    public ClientAuthByEmailAndPasswordResponseDto authByEmailAndPassword(ClientAuthByEmailAndPasswordRequestDto clientAuthByEmailAndPasswordRequestDto) throws Exception{

        Client foundClient = clientsRepository.findByEmailAndPassword(clientAuthByEmailAndPasswordRequestDto.email, clientAuthByEmailAndPasswordRequestDto.password);

        if (foundClient == null) {
            throw CustomException.AuthException("Client credentials not found");
        }

        ClientAuthByEmailAndPasswordResponseDto clientAuthByEmailAndPasswordResponseDto = modelMapper.map(foundClient, ClientAuthByEmailAndPasswordResponseDto.class);

        return clientAuthByEmailAndPasswordResponseDto;
    }
}
