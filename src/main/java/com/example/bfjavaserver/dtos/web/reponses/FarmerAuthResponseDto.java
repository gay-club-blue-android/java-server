package com.example.bfjavaserver.dtos.web.reponses;

import lombok.Data;

@Data
public class FarmerAuthResponseDto {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String description;
}
