package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.ProductsResponseDto;
import com.example.bfjavaserver.services.mobile.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mobile/products", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @GetMapping(value = "/getAll")
    public ProductsResponseDto getAll(){
        return productsService.getAll();
    }
    @GetMapping(value = "/getAllByCategoryId/{id}")
    public ProductsResponseDto getAll(@PathVariable int id){
        return productsService.getAllByCategoryId(id);
    }
}
