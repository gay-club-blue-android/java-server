package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.farmer.response.FarmerGetAllResponseDto;
import com.example.bfjavaserver.services.mobile.FarmersMobileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.util.List;

@RestController
@RequestMapping(path = "/mobile/farmers")
@AllArgsConstructor
@Tag(name="Контроллер фермеров", description = "позволяет получить список фермеров, аватар фермера")
public class FarmersMobileController {
    private FarmersMobileService farmersMobileService;

    /**
     * возвращает всех фермеров из базы данных
     * @return сущность, содержащая список сущностей фермера
     */
    @Operation(summary = "выдача списка фермеров", description = "возвращает всех фермеров из базы данных")
    @GetMapping(value = "/getAll")
    public List<FarmerGetAllResponseDto> getAll(){
        return farmersMobileService.getAll();
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
