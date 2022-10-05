package com.example.bfjavaserver.dtos.web.requests;

import lombok.Data;

@Data
public class ProductRequestDto {
    public String name;
    public int price;
    public int priceMeasurementId;
    public int amount;
    public int amountMeasurementId;
    public String description;
    public double rating;
    public String photoPath;
    public int farmerId;
    public int productCategoryId;
}
