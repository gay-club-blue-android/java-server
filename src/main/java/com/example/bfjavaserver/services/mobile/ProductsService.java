package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.product.response.ProductGetAllResponseDto;
import com.example.bfjavaserver.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsService {
    private final ModelMapper modelMapper;
    private final ProductsRepository productsRepository;


    public List<ProductGetAllResponseDto> getAllByCategoryId(int id) {
        return productsRepository
                .findAllByProductCategoryId(id).stream()
                .map(product -> modelMapper.map(product, ProductGetAllResponseDto.class))
                .collect(Collectors.toList());
    }
}
