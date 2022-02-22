package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.ProductsCategoriesResponseDto;
import com.example.bfjavaserver.services.mobile.ProductsCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mobile/productsCategories", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class ProductsCategoriesController {

    @Autowired
    private final ProductsCategoriesService productsCategoriesService;

    @GetMapping(value = "/getAll")
    public ProductsCategoriesResponseDto getAll(){
        return productsCategoriesService.getAll();
    }
}
