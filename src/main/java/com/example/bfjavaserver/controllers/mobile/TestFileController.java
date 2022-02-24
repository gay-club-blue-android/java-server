package com.example.bfjavaserver.controllers.mobile;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;

@RestController
@RequestMapping(path = "/mobile/test", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class TestFileController {

    @GetMapping(value = "/createFile")
    public void createFile() throws Exception{
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write("hello world");
        fileWriter.close();

    }
}
