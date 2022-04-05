package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.FaqResponseDto;
import com.example.bfjavaserver.models.Faq;
import com.example.bfjavaserver.repositories.FaqsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class FaqsService {
    private final FaqsRepository faqsRepository;

    public FaqResponseDto getAll() {
        ArrayList<Faq> faqs = (ArrayList<Faq>) faqsRepository.findAll();
        return new FaqResponseDto(faqs);
    }
}
