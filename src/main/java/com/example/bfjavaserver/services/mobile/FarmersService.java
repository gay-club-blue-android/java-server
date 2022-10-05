package com.example.bfjavaserver.services.mobile;

import com.example.bfjavaserver.dtos.mobile.farmer.response.FarmerGetAllResponseDto;
import com.example.bfjavaserver.repositories.FarmersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FarmersService {
    private final ModelMapper modelMapper;
    private final FarmersRepository farmersRepository;

    public List<FarmerGetAllResponseDto> getAll() {
        return farmersRepository
                .findAll().stream()
                .map(farmer -> modelMapper.map(farmer, FarmerGetAllResponseDto.class))
                .collect(Collectors.toList());
    }
}
