package com.example.bfjavaserver.services.web;

import com.example.bfjavaserver.dtos.web.reponses.ProductWebResponseDto;
import com.example.bfjavaserver.dtos.web.requests.ProductRequestDto;
import com.example.bfjavaserver.models.Product;
import com.example.bfjavaserver.repositories.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductsWebService {
    private final ModelMapper modelMapper;
    private final ProductsRepository productsRepository;
    private final ProductsCategoriesRepository productsCategoriesRepository;
    private final PriceMeasurementsRepository priceMeasurementsRepository;
    private final AmountMeasurementsRepository amountMeasurementsRepository;
    private final FarmersRepository farmersRepository;

    public ProductWebResponseDto addNewProduct(ProductRequestDto productRequestDto) {
        Product inputProduct = modelMapper.map(productRequestDto, Product.class);

        inputProduct.productCategory = productsCategoriesRepository.getById(inputProduct.productCategory.id);
        inputProduct.priceMeasurement = priceMeasurementsRepository.getById(inputProduct.priceMeasurement.id);
        inputProduct.amountMeasurement = amountMeasurementsRepository.getById(inputProduct.amountMeasurement.id);

        inputProduct.farmer = farmersRepository.getById(inputProduct.farmer.id);
        Product newProduct = productsRepository.saveAndFlush(inputProduct);

        ProductWebResponseDto outputProduct = modelMapper.map(newProduct, ProductWebResponseDto.class);
        return outputProduct;
    }
}
