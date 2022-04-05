package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.requests.AppAuthRequestDto;
import com.example.bfjavaserver.dtos.mobile.responses.AppAuthResponseDto;
import com.example.bfjavaserver.services.mobile.AppsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/mobile/apps", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class AppsController {
    private final AppsService appsService;

    @PostMapping(value = "/authByLoginAndPassword")
    public AppAuthResponseDto authByLoginAndPassword(@RequestBody @Valid AppAuthRequestDto appAuthRequestDto) throws Exception {
        return appsService.authByLoginAndPassword(appAuthRequestDto);
    }

    @GetMapping(value = "/checkAuth")
    public String checkAuth(){
        return "ok";
    }
}
