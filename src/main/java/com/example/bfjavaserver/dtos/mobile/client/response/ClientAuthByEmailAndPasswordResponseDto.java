package com.example.bfjavaserver.dtos.mobile.client.response;

import lombok.Data;

@Data
public class ClientAuthByEmailAndPasswordResponseDto {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
}
