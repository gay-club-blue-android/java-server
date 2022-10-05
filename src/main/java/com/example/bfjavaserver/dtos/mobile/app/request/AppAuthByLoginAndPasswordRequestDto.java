package com.example.bfjavaserver.dtos.mobile.app.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AppAuthByLoginAndPasswordRequestDto {

    @NotEmpty (message = "login must be full")
    public String login;
    @NotEmpty
    public String password;
    @NotEmpty
    public String deviceId;
}
