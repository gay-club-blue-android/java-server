package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.ClientRequestAuthDto;
import com.example.bfjavaserver.dtos.mobile.ClientSuccessAuthDto;
import com.example.bfjavaserver.models.Client;
import com.example.bfjavaserver.repositories.ClientsRepository;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class ClientsService {

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final ClientsRepository clientsRepository;

    public ClientsService(ModelMapper modelMapper, ClientsRepository clientsRepository) {
        this.modelMapper = modelMapper;
        this.clientsRepository = clientsRepository;
    }

    public ClientSuccessAuthDto authByEmailAndPassword(ClientRequestAuthDto clientRequestAuthDto) throws Exception {

        Client foundClient = clientsRepository.findByEmailAndPassword(clientRequestAuthDto.email, clientRequestAuthDto.password);

        ClientSuccessAuthDto clientSuccessAuthDto = modelMapper.map(foundClient, ClientSuccessAuthDto.class);

        String dataForHash = foundClient.email + foundClient.password + new Date();

        String apiKey = Hashing.sha256()
                .hashString(dataForHash, StandardCharsets.UTF_8)
                .toString();

        clientSuccessAuthDto.apiKey = apiKey;

        return clientSuccessAuthDto;
    }
}
