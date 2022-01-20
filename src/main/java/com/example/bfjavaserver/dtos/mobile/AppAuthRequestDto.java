package com.example.bfjavaserver.dtos.mobile;

import lombok.Data;

@Data
public class AppAuthRequestDto {
    public String login;
    public String password;
    public String deviceId;
}
