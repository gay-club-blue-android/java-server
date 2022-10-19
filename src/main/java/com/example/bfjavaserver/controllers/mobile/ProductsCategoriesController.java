package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.productCategory.response.ProductCategoryGetAllResponseDto;
import com.example.bfjavaserver.services.mobile.ProductsCategoriesService;
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
@RequestMapping(path = "/mobile/productsCategories")
@AllArgsConstructor
@Tag(name="Контроллер категорий продуктов", description = "позволяет получить список категорий продуктов, картинку категории")
public class ProductsCategoriesController {
    private final ProductsCategoriesService productsCategoriesService;

    /**
     * возвращает все категории из базы данных
     * @return сущность, содержащая список сущностей категории продукта
     */
    @Operation(summary = "Выдача списка категорий продуктов", description = "возвращает все категории из базы данных")
    @GetMapping(value = "/getAll")
    public List<ProductCategoryGetAllResponseDto> getAll() {

        List<ProductCategoryGetAllResponseDto> result = productsCategoriesService.getAll();

        System.out.println(String.format("REQUEST ProductsCategoriesController getAll INPUT:none OUTPUT:%s \n\n", result.toString()));

        return result;
    }
    /**
     * выдаёт изображение из папки images/productscategories
     * @param pictureName название файла картинки
     * @return картинку в виде массива байт
     * @throws Exception возвращает ошибку, если иззображения не существуе
     */
    @Operation(summary = "Выдача картинки категории", description = "выдаёт изображение из папки images/productscategories")
    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    byte[] getPictureByName(@PathVariable @Parameter(description = "название файла картинки") String pictureName) throws Exception {

        System.out.println(String.format("REQUEST ProductsCategoriesController getPictureByName INPUT:%s\n\n",pictureName));

        FileInputStream inputStream = new FileInputStream("images/productscategories/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
