package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.mobile.FaqResponseDto;
import com.example.bfjavaserver.models.Faq;
import com.example.bfjavaserver.repositories.FaqsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class FaqsService {
    @Autowired
    private final FaqsRepository faqsRepository;

    public FaqResponseDto getAll() throws Exception {
        try {
            ArrayList<Faq> faqs = (ArrayList<Faq>) faqsRepository.findAll();
            return new FaqResponseDto(faqs);
        } catch (Exception e) {
            throw CustomException.FatalException("db connection error");
        }
    }
}
