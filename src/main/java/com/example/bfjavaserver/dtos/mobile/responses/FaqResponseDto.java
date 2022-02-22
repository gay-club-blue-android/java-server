package com.example.bfjavaserver.dtos.mobile.responses;

import com.example.bfjavaserver.models.Faq;
import com.example.bfjavaserver.models.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class FaqResponseDto {
    ArrayList<Faq> faqs;
}
