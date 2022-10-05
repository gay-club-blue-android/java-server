package com.example.bfjavaserver.dtos.mobile.faq.response;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FaqGetAllResponseDto {
    public int id;
    public String question;
    public String answer;
}
