package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.FarmerResponseDto;
import com.example.bfjavaserver.dtos.mobile.responses.FarmersResponseDto;
import com.example.bfjavaserver.repositories.FarmersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FarmersService {
    private final ModelMapper modelMapper;
    private final FarmersRepository farmersRepository;

    public FarmersResponseDto getAll() {
        ArrayList<FarmerResponseDto> faqs = (ArrayList<FarmerResponseDto>) farmersRepository
                .findAll().stream().map(
                        product -> modelMapper.map(product, FarmerResponseDto.class)
                ).collect(Collectors.toList());
        return new FarmersResponseDto(faqs);
    }
}
