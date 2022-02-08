package com.example.bfjavaserver.dtos.mobile;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class AppAuthRequestDto {

    @NotBlank(message = "Необходимо указать имя")
    public String login;
    @NotEmpty
    public String password;
    @NotEmpty
    public String deviceId;
}
