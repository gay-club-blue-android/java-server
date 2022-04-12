package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.FaqsResponseDto;
import com.example.bfjavaserver.models.Faq;
import com.example.bfjavaserver.repositories.FaqsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class FaqsService {
    private final FaqsRepository faqsRepository;

    public FaqsResponseDto getAll() {
        ArrayList<Faq> faqs = (ArrayList<Faq>) faqsRepository.findAll();
        return new FaqsResponseDto(faqs);
    }
}
