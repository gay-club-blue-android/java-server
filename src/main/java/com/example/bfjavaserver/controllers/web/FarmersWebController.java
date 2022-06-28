package com.example.bfjavaserver.controllers.web;


import com.example.bfjavaserver.dtos.web.reponses.FarmerAuthResponseDto;
import com.example.bfjavaserver.dtos.web.requests.FarmerAuthRequestDto;
import com.example.bfjavaserver.services.web.FarmersWebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "/web/farmers")
@AllArgsConstructor
public class FarmersWebController {
    private final FarmersWebService farmersWebService;

    @PostMapping(value = "/authByEmailAndPassword")
    public FarmerAuthResponseDto authByEmailAndPassword(@RequestBody @Valid FarmerAuthRequestDto farmerAuthRequestDto) throws Exception {
        return farmersWebService.authByEmailAndPassword(farmerAuthRequestDto);
    }
}
