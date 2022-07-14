package com.example.bfjavaserver.controllers.web;

import com.example.bfjavaserver.controllers.shared.CustomException;
import com.example.bfjavaserver.dtos.web.reponses.CreatingImageResponseDto;
import com.example.bfjavaserver.dtos.web.reponses.ProductWebResponseDto;
import com.example.bfjavaserver.dtos.web.requests.ProductRequestDto;
import com.example.bfjavaserver.services.web.ProductsWebService;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

    @PostMapping(value = "/loadImage")
    public String /*CreatingImageResponseDto*/ loadImage(MultipartHttpServletRequest multipartRequest) throws CustomException {
        try {
            //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Set set = multipartRequest.getFileMap().entrySet();
            Iterator i = set.iterator();
            Map.Entry me = (Map.Entry) i.next();
            String fileName = (String) me.getKey();
            MultipartFile multipartFile = (MultipartFile) me.getValue();

            long timestamp = currentTimeMillis();
            String dataForHash = multipartFile.getOriginalFilename();

            String filename = Hashing.sha256().hashString(dataForHash, StandardCharsets.UTF_8).toString();
            filename += timestamp;

            File filepath = new File("images/products/" + filename + ".jpg");

            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();

            //return new CreatingImageResponseDto(filename + ".jpg");
            return filename + ".jpg";
        } catch (IOException e) {
            throw CustomException.BadDataException("invalid byte array");
        }
    }


}