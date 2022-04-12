package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.mobile.requests.ClientRequestDto;
import com.example.bfjavaserver.dtos.mobile.responses.ClientResponseDto;
import com.example.bfjavaserver.models.App;
import com.example.bfjavaserver.models.Client;
import com.example.bfjavaserver.repositories.ClientsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientsService {
    private final ModelMapper modelMapper;
    private final ClientsRepository clientsRepository;

    public ClientResponseDto authByEmailAndPassword(ClientRequestDto clientRequestDto) throws Exception{

        Client foundClient = clientsRepository.findByEmailAndPassword(clientRequestDto.email, clientRequestDto.password);

        if (foundClient == null) {
            throw CustomException.AuthException("Client credentials not found");
        }

        ClientResponseDto clientResponseDto = modelMapper.map(foundClient, ClientResponseDto.class);

        return clientResponseDto;
    }
}
