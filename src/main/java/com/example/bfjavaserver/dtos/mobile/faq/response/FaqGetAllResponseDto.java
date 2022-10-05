package com.example.bfjavaserver.dtos.mobile.faq.response;

import lombok.Data;

@Data
public class FaqGetAllResponseDto {
    public int id;
    public String question;
    public String answer;
}
