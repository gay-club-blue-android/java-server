package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.ProductsResponseDto;
import com.example.bfjavaserver.services.mobile.ProductsService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/mobile/products", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class ProductsController {
    private ProductsService productsService;
    /**
     * возвращает все продукты из базы данных
     * @return сущность, содержащая список сущностей продуктов
     */
    @GetMapping(value = "/getAllByCategoryId/{id}")
    public ProductsResponseDto getAll(@PathVariable int id){
        return productsService.getAllByCategoryId(id);
    }
    /**
     * выдаёт изображение из папки images/products
     * @param pictureName название файла картинки
     * @return картинку в виде массива байт
     * @throws Exception возвращает ошибку, если иззображения не существуе
     */
    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getPictureByName(@PathVariable String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/products/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
