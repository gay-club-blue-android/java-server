package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.faq.response.FaqGetAllResponseDto;
import com.example.bfjavaserver.repositories.FaqsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FaqsService {
    private final ModelMapper modelMapper;
    private final FaqsRepository faqsRepository;

    public List<FaqGetAllResponseDto> getAll() {
        return faqsRepository
                .findAll().stream()
                .map(faq -> modelMapper.map(faq, FaqGetAllResponseDto.class))
                .collect(Collectors.toList());

    }
}
