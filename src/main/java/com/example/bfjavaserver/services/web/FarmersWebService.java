package com.example.bfjavaserver.services.web;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.web.reponses.FarmerAuthResponseDto;
import com.example.bfjavaserver.dtos.web.requests.FarmerAuthRequestDto;
import com.example.bfjavaserver.models.Farmer;
import com.example.bfjavaserver.repositories.FarmersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FarmersWebService {
    private final ModelMapper modelMapper;
    private final FarmersRepository farmersRepository;

    public FarmerAuthResponseDto authByEmailAndPassword(FarmerAuthRequestDto farmerAuthRequestDto) throws Exception {

        Farmer foundFarmer = farmersRepository.findByEmailAndPassword(farmerAuthRequestDto.email, farmerAuthRequestDto.password);

        if (foundFarmer == null) {
            throw CustomException.AuthException("Farmer credentials not found");
        }

        FarmerAuthResponseDto farmerAuthResponseDto = modelMapper.map(foundFarmer, FarmerAuthResponseDto.class);

        return farmerAuthResponseDto;
    }
}
