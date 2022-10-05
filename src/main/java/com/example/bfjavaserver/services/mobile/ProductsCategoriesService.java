package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.productCategory.response.ProductCategoryGetAllResponseDto;
import com.example.bfjavaserver.repositories.ProductsCategoriesRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsCategoriesService {
    private final ModelMapper modelMapper;
    private final ProductsCategoriesRepository productsCategoriesRepository;

    public List<ProductCategoryGetAllResponseDto> getAll() {
        return productsCategoriesRepository
                .findAll().stream()
                .map(productCategory -> modelMapper.map(productCategory, ProductCategoryGetAllResponseDto.class))
                .collect(Collectors.toList());
    }
}
