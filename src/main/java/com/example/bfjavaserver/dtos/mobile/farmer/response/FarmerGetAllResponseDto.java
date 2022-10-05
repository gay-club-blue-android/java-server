package com.example.bfjavaserver.dtos.mobile.farmer.response;

import com.example.bfjavaserver.models.FarmerDeliveryType;

import javax.persistence.*;
import lombok.Data;

@Data
public class FarmerGetAllResponseDto {
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNumber;
	public String photoPath;
	public String description;
	public String farmerDeliveryTypeName;
	public String pickupAddress;
	public String latLng;
}
