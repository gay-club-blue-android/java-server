package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.mobile.ProductsCategoriesResponseDto;
import com.example.bfjavaserver.services.mobile.AppsApiKeysService;
import com.example.bfjavaserver.services.mobile.ProductsCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mobile/productsCategories", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class ProductsCategoriesController {

    @Autowired
    private final ProductsCategoriesService productsCategoriesService;

    @Autowired
    private final AppsApiKeysService appsApiKeysService;

    @GetMapping(value = "/getAll")
    public ProductsCategoriesResponseDto getAll(@RequestHeader("API_KEY") String apiKey, @RequestHeader("DEVICE_ID") String deviceId) throws Exception {

        boolean exist = appsApiKeysService.existsByKeyAndDeviceId(apiKey, deviceId);
        if (exist == false) {
            throw CustomException.LogicException("key error");
        }

        return productsCategoriesService.getAll();
    }
}
