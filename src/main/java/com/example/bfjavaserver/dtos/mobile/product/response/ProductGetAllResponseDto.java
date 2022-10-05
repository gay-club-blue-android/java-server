package com.example.bfjavaserver.dtos.mobile.product.response;

import com.example.bfjavaserver.dtos.mobile.farmer.response.FarmerGetAllResponseDto;
import lombok.Data;

@Data
public class ProductGetAllResponseDto {
	public int id;
	public String name;
	public int price;
	public String priceMeasurementName;
	public int amount;
	public String amountMeasurementName;
	public String description;
	public double rating;
	public String photoPath;
	public FarmerGetAllResponseDto farmer;
	public int productCategoryId;
}
