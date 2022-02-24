package com.example.bfjavaserver.controllers.mobile;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import org.apache.commons.io.IOUtils;

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

    @GetMapping(value = "/getFile")
    public @ResponseBody
    byte[] getImage() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("test.txt");
        return IOUtils.toByteArray(inputStream);
    }
}
