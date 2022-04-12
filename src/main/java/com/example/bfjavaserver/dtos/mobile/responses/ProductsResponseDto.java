package com.example.bfjavaserver.dtos.mobile.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ProductsResponseDto {
    public ArrayList<ProductResponseDto> products;
}

