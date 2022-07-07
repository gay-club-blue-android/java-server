package com.example.bfjavaserver.controllers.web;


import com.example.bfjavaserver.dtos.web.reponses.FarmerAuthResponseDto;
import com.example.bfjavaserver.dtos.web.requests.FarmerAuthRequestDto;
import com.example.bfjavaserver.services.web.FarmersWebService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/web/farmers")
@AllArgsConstructor
public class FarmersWebController {
    private final FarmersWebService farmersWebService;

    @PostMapping(value = "/authByEmailAndPassword")
    public FarmerAuthResponseDto authByEmailAndPassword(@RequestBody @Valid FarmerAuthRequestDto farmerAuthRequestDto) throws Exception {
        return farmersWebService.authByEmailAndPassword(farmerAuthRequestDto);
    }

    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    byte[] getPictureByName(@PathVariable String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/farmers/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
