package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.ProductsCategoriesResponseDto;
import com.example.bfjavaserver.models.ProductCategory;
import com.example.bfjavaserver.repositories.ProductsCategoriesRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ProductsCategoriesService {
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final ProductsCategoriesRepository productsCategoriesRepository;

    public ProductsCategoriesResponseDto getAll() {
        ArrayList<ProductCategory> productCategories = (ArrayList<ProductCategory>) productsCategoriesRepository.findAll();

        return new ProductsCategoriesResponseDto(productCategories);
    }
}
