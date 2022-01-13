package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.AppRequestAuthDto;
import com.example.bfjavaserver.dtos.mobile.AppSuccessAuthDto;
import com.example.bfjavaserver.services.mobile.AppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mobile/clients", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AppsController {

    @Autowired
    private final AppsService appsService;

    public AppsController(AppsService appsService) {
        this.appsService = appsService;
    }

    @PostMapping(value = "/authByLoginAndPassword")
    public AppSuccessAuthDto authByLoginAndPassword(@RequestBody AppRequestAuthDto appRequestAuthDto) throws Exception {
        return appsService.authByLoginAndPassword(appRequestAuthDto);
    }
}
