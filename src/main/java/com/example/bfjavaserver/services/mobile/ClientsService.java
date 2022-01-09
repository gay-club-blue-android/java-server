package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.ClientRequestAuthDto;
import com.example.bfjavaserver.dtos.mobile.ClientSuccessAuthDto;
import com.example.bfjavaserver.models.Client;
import com.example.bfjavaserver.repositories.ClientsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        clientSuccessAuthDto.apiKey = "jskdbfjkshdbfjksbd";//create hash from email + password + timestamp

        return clientSuccessAuthDto;
    }
}
