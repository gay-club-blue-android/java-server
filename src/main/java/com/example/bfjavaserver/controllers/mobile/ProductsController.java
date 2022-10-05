package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.product.response.ProductGetAllResponseDto;
import com.example.bfjavaserver.services.mobile.ProductsService;
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
@CrossOrigin
@RequestMapping(path = "/mobile/products")
@AllArgsConstructor
@Tag(name="Контроллер продуктов", description = "позволяет получить список продуктов, фото продукта")
public class ProductsController {
    private ProductsService productsService;
    /**
     * возвращает все продукты из базы данных
     * @return сущность, содержащая список сущностей продуктов
     */
    @Operation(summary = "Выдача всех продуктов", description = "возвращает все продукты из базы данных")
    @GetMapping(value = "/getAllByCategoryId/{id}")
    public List<ProductGetAllResponseDto> getAll(@PathVariable int id){
        return productsService.getAllByCategoryId(id);
    }
    /**
     * выдаёт изображение из папки images/products
     * @param pictureName название файла картинки
     * @return картинку в виде массива байт
     * @throws Exception возвращает ошибку, если иззображения не существуе
     */
    @Operation(summary = "Выдача картинки продукта", description = "выдаёт изображение из папки images/products")
    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    byte[] getPictureByName(@PathVariable @Parameter(description = "название файла картинки") String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/products/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
