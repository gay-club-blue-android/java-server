package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.mobile.requests.ClientRequestDto;
import com.example.bfjavaserver.dtos.mobile.responses.ClientResponseDto;
import com.example.bfjavaserver.models.App;
import com.example.bfjavaserver.models.AppApiKey;
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
     * @param clientRequestDto Сущность, содержашая email и пароль искомого клиента
     * @return Сущность, содержащая id (из базы данных), имя, фамилию и email клиента
     * @throws Exception Если клиент не был найден
     */
    public ClientResponseDto authByEmailAndPassword(ClientRequestDto clientRequestDto) throws Exception{

        Client foundClient = clientsRepository.findByEmailAndPassword(clientRequestDto.email, clientRequestDto.password);

        if (foundClient == null) {
            throw CustomException.AuthException("Client credentials not found");
        }

        ClientResponseDto clientResponseDto = modelMapper.map(foundClient, ClientResponseDto.class);

        return clientResponseDto;
    }
}
