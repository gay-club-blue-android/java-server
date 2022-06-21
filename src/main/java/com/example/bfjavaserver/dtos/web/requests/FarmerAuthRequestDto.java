package com.example.bfjavaserver.dtos.web.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FarmerAuthRequestDto {
    @NotEmpty
    public String email;

    @NotEmpty
    public String password;
}
