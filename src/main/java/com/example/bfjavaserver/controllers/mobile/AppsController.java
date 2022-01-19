package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.AppAuthRequestDto;
import com.example.bfjavaserver.dtos.mobile.AppAuthResponseDto;
import com.example.bfjavaserver.services.mobile.AppsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mobile/apps", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class AppsController {

    @Autowired
    private final AppsService appsService;

    @PostMapping(value = "/authByLoginAndPassword")
    public AppAuthResponseDto authByLoginAndPassword(@RequestBody AppAuthRequestDto appAuthRequestDto) throws Exception {
        return appsService.authByLoginAndPassword(appAuthRequestDto);
    }
}
