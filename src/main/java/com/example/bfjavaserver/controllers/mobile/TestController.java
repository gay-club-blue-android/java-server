package com.example.bfjavaserver.controllers.mobile;


import com.example.bfjavaserver.dtos.mobile.AppAuthRequestDto;
import com.example.bfjavaserver.dtos.mobile.AppAuthResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TestController {

    @GetMapping(value = "/first")
    public String first(@RequestBody AppAuthRequestDto appAuthRequestDto) throws Exception {
        return "first test";
    }
}
