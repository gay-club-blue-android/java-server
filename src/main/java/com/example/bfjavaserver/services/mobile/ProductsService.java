package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.ProductsResponseDto;
import com.example.bfjavaserver.models.Product;
import com.example.bfjavaserver.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ProductsService {
    @Autowired
    private final ProductsRepository productsRepository;
    public ProductsResponseDto getAll() {
        ArrayList<Product> products = (ArrayList<Product>) productsRepository.findAll();
        return new ProductsResponseDto(products);
    }
}
