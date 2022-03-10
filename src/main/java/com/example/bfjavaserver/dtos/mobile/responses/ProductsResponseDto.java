package com.example.bfjavaserver.dtos.mobile.responses;

import com.example.bfjavaserver.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ProductsResponseDto {
    public ArrayList<ProductResponseDto> products;
}

