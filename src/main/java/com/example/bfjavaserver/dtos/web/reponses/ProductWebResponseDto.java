package com.example.bfjavaserver.dtos.web.reponses;

import com.example.bfjavaserver.models.Farmer;
import com.example.bfjavaserver.models.ProductCategory;
import lombok.Data;

@Data
public class ProductWebResponseDto {
    public int id;
    public String name;
    public int price;
    public String priceMeasurementName;
    public int amount;
    public String amountMeasurementName;
    public String description;
    public double rating;
    public String photoPath;
    public int farmerId;
    public String farmerFirstName;
    public String farmerLastName;
    public int productCategoryId;
    public String productCategoryName;
}
