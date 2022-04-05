package com.example.bfjavaserver.controllers.mobile;

import com.example.bfjavaserver.dtos.mobile.responses.ProductsCategoriesResponseDto;
import com.example.bfjavaserver.services.mobile.ProductsCategoriesService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/mobile/productsCategories", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class ProductsCategoriesController {
    private final ProductsCategoriesService productsCategoriesService;

    @GetMapping(value = "/getAll")
    public ProductsCategoriesResponseDto getAll() {
        return productsCategoriesService.getAll();
    }

    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getPictureByName(@PathVariable String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/productscategories/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
