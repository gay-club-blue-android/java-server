package com.example.bfjavaserver.controllers.mobile;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

@RestController
@RequestMapping(path = "/mobile/test", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class TestFileController {

    @GetMapping(value = "/createFile")
    public void createFile() throws Exception {
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write("hello world");
        fileWriter.close();
    }

    @GetMapping(value = "/getTxtFile")
    public @ResponseBody
    byte[] getTxtFile() throws Exception {
        FileInputStream inputStream = new FileInputStream("test.txt");
        return IOUtils.toByteArray(inputStream);
    }

    @GetMapping(value = "/getPictureFile", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getPictureFile() throws Exception {
        FileInputStream inputStream = new FileInputStream("picture.jpg");
        return IOUtils.toByteArray(inputStream);
    }
}
