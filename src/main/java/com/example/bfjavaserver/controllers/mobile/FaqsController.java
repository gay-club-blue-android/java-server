package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.AppAuthRequestDto;
import com.example.bfjavaserver.dtos.mobile.AppAuthResponseDto;
import com.example.bfjavaserver.dtos.mobile.FaqResponseDto;
import com.example.bfjavaserver.dtos.mobile.ProductsCategoriesResponseDto;
import com.example.bfjavaserver.services.mobile.AppsApiKeysService;
import com.example.bfjavaserver.services.mobile.FaqsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mobile/faqs", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class FaqsController {

    @Autowired
    private final FaqsService faqsService;

    @Autowired
    private final AppsApiKeysService appsApiKeysService;

    @GetMapping(value = "/getAll")
    public FaqResponseDto getAll(@RequestHeader("API_KEY") String apiKey, @RequestHeader("DEVICE_ID") String deviceId) throws Exception {

        boolean exist = appsApiKeysService.existsByKeyAndDeviceId(apiKey, deviceId);
        if(exist == false){
            throw new Exception("key error");
        }

        return faqsService.getAll();
    }
}