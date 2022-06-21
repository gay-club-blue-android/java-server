package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.FaqsResponseDto;
import com.example.bfjavaserver.services.mobile.FaqsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/mobile/faqs")
@AllArgsConstructor
@Tag(name="Контроллер ЧЗВ", description = "выдаёт список всех ЧЗВ")
public class FaqsController {
    private final FaqsService faqsService;

    /**
     * возвращает все хранящиеся все вопросы и ответы на них
     * @return сущность, содержащая список всех сущностей FAQ
     */
    @Operation(summary = "список вопросов", description = "возвращает все хранящиеся все вопросы и ответы на них")
    @GetMapping(value = "/getAll")
    public FaqsResponseDto getAll(){
        return faqsService.getAll();
    }
}