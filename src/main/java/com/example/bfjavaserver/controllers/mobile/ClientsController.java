package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.ClientRequestAuthDto;
import com.example.bfjavaserver.dtos.mobile.ClientSuccessAuthDto;
import com.example.bfjavaserver.services.mobile.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mobile/clients", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientsController {

    @Autowired
    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @PostMapping(value = "/authByEmailAndPassword")
    public ClientSuccessAuthDto authByEmailAndPassword(@RequestBody ClientRequestAuthDto clientRequestAuthDto) throws Exception {
        return clientsService.authByEmailAndPassword(clientRequestAuthDto);
    }
}
