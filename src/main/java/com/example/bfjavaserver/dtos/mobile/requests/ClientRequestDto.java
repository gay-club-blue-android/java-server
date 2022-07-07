package com.example.bfjavaserver.dtos.mobile.requests;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class ClientRequestDto {
    @NotEmpty
    public String email;

    @NotEmpty
    public String password;
}
