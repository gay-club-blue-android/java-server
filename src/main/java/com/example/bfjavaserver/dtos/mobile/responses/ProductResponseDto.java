package com.example.bfjavaserver.dtos.mobile.responses;

import com.example.bfjavaserver.models.ProductCategory;
import lombok.Data;

@Data
public class ProductResponseDto {
	public int id;
	public String name;
	public int price;
	public String priceMeasurementName;
	public int amount;
	public String amountMeasurementName;
	public String description;
	public double rating;
	public String photoPath;
	public FarmerResponseDto farmer;
	public int productCategoryId;
}
