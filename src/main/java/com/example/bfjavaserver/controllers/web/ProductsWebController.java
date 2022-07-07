package com.example.bfjavaserver.controllers.web;

import com.example.bfjavaserver.dtos.web.reponses.ProductWebResponseDto;
import com.example.bfjavaserver.dtos.web.requests.FarmerAuthRequestDto;
import com.example.bfjavaserver.dtos.web.requests.ProductRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/web/products")
@AllArgsConstructor
public class ProductsWebController {

    @PostMapping(value = "/addNewProduct")
    public ProductWebResponseDto addNewProduct(@RequestBody ProductRequestDto productRequestDto) throws Exception {

        int a = 5;
        //todo add service for save data to db

        return new ProductWebResponseDto();
    }

}
