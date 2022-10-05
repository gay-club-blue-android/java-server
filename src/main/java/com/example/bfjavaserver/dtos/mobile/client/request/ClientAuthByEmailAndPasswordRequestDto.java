package com.example.bfjavaserver.dtos.mobile.client.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ClientAuthByEmailAndPasswordRequestDto {
    @NotEmpty
    public String email;

    @NotEmpty
    public String password;
}
