package com.example.bfjavaserver.controllers.web;

import com.example.bfjavaserver.dtos.web.reponses.ProductWebResponseDto;
import com.example.bfjavaserver.dtos.web.requests.ProductRequestDto;
import com.example.bfjavaserver.services.web.ProductsWebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/web/products")
@AllArgsConstructor
public class ProductsWebController {
    private ProductsWebService productsWebService;
    @PostMapping(value = "/addNewProduct")
    public ProductWebResponseDto addNewProduct(@RequestBody ProductRequestDto productRequestDto) throws Exception {
        return productsWebService.addNewProduct(productRequestDto);
    }
}