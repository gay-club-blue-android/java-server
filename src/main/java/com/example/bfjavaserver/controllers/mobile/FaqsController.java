package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.FaqsResponseDto;
import com.example.bfjavaserver.services.mobile.FaqsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mobile/faqs", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class FaqsController {
    private final FaqsService faqsService;

    @GetMapping(value = "/getAll")
    public FaqsResponseDto getAll(){
        return faqsService.getAll();
    }
}