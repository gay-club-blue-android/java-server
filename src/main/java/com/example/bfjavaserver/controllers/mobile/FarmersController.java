package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.FarmersResponseDto;
import com.example.bfjavaserver.services.mobile.FarmersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/mobile/farmers")
@AllArgsConstructor
@Tag(name="Контроллер фермеров", description = "позволяет получить список фермеров, аватар фермера")
public class FarmersController {
    private FarmersService farmersService;

    /**
     * возвращает всех фермеров из базы данных
     * @return сущность, содержащая список сущностей фермера
     */
    @Operation(summary = "выдача списка фермеров", description = "возвращает всех фермеров из базы данных")
    @GetMapping(value = "/getAll")
    public FarmersResponseDto getAll(){
        return farmersService.getAll();
    }

    /**
     * выдаёт изображение из папки images/farmers
     * @param pictureName название файла картинки
     * @return картинку в виде массива байт
     * @throws Exception возвращает ошибку, если иззображения не существует
     */
    @Operation(summary = "Выдача аввтар фермера", description = "выдаёт изображение из папки images/farmers")
    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getPictureByName(@PathVariable @Parameter(description = "название файла картинки") String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/farmers/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
