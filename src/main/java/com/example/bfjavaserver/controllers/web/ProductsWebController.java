package com.example.bfjavaserver.controllers.web;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.web.reponses.CreatingImageResponseDto;
import com.example.bfjavaserver.dtos.web.reponses.ProductWebResponseDto;
import com.example.bfjavaserver.dtos.web.requests.ProductRequestDto;
import com.example.bfjavaserver.services.web.ProductsWebService;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.lang.System.currentTimeMillis;

@RestController
@RequestMapping(path = "/web/products")
@AllArgsConstructor
public class ProductsWebController {

    private ProductsWebService productsWebService;

    @PostMapping(value = "/addNewProduct")
    public ProductWebResponseDto addNewProduct(@RequestBody ProductRequestDto productRequestDto) throws Exception {
        return productsWebService.addNewProduct(productRequestDto);
    }

    @PostMapping(value = "loadImage")
    public CreatingImageResponseDto loadImage(byte[] bytes) throws CustomException {
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
            BufferedImage image = ImageIO.read(stream);

            long timestamp = currentTimeMillis();
            String dataForHash = new String(bytes, StandardCharsets.UTF_8);

            String filename = Hashing.sha256().hashString(dataForHash, StandardCharsets.UTF_8).toString();
            filename += timestamp;

            File filepath = new File("images/farmers" + filename + ".jpg");

            ImageIO.write(image, "jpg", filepath);
            return new CreatingImageResponseDto(filepath.getName());
        } catch (IOException e) {
            throw CustomException.BadDataException("invalid byte array");
        }
    }

}