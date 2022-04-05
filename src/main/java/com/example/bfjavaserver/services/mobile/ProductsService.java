package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.ProductResponseDto;
import com.example.bfjavaserver.dtos.mobile.responses.ProductsResponseDto;
import com.example.bfjavaserver.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsService {
    private final ModelMapper modelMapper;
    private final ProductsRepository productsRepository;

    public ProductsResponseDto getAll() {
        ArrayList<ProductResponseDto> products = (ArrayList<ProductResponseDto>) productsRepository
                .findAll().stream().map(
                product -> modelMapper.map(product, ProductResponseDto.class)
        ).collect(Collectors.toList());

        return new ProductsResponseDto(products);
    }

    public ProductsResponseDto getAllByCategoryId(int id) {
        ArrayList<ProductResponseDto> products = (ArrayList<ProductResponseDto>)productsRepository
                .findAllByProductCategoryId(id).stream().map(
                product -> modelMapper.map(product, ProductResponseDto.class)
        ).collect(Collectors.toList());
        return new ProductsResponseDto(products);
    }
}
