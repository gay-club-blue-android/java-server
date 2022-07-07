package com.example.bfjavaserver.controllers.web;


import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.web.reponses.CreatingImageResponseDto;
import com.example.bfjavaserver.dtos.web.reponses.FarmerAuthResponseDto;
import com.example.bfjavaserver.dtos.web.requests.FarmerAuthRequestDto;
import com.example.bfjavaserver.services.web.FarmersWebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "/web/farmers")
@AllArgsConstructor
public class FarmersWebController {
    private final FarmersWebService farmersWebService;

    @PostMapping(value = "/authByEmailAndPassword")
    public FarmerAuthResponseDto authByEmailAndPassword(@RequestBody @Valid FarmerAuthRequestDto farmerAuthRequestDto) throws Exception {
        return farmersWebService.authByEmailAndPassword(farmerAuthRequestDto);
    }

    @PostMapping(value = "loadImage")
    public CreatingImageResponseDto loadImage(byte[] bytes) throws CustomException {
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
            BufferedImage image = ImageIO.read(stream);
            String filename=new String(bytes, StandardCharsets.UTF_8);
            File filepath=new File( "images/farmers"+filename+".jpg");
            while (filepath.exists()){
                filename+="_1";
                filepath=new File( "images/farmers"+filename+".jpg");
            }
            ImageIO.write(image,"jpg",filepath);
            return new CreatingImageResponseDto( filepath.getName());
        } catch (IOException e) {
            throw CustomException.BadDataException("invalid byte array");
        }


    }
}
