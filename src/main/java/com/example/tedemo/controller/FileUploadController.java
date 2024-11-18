package com.example.tedemo.controller;

import com.example.tedemo.pojo.result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public result<String> upload(MultipartFile file) throws IOException {
        String OriginalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString() + OriginalFilename.substring(OriginalFilename.lastIndexOf("."));
        System.out.println(filename);
        file.transferTo(new File("/www/wwwroot/imgs/" + filename));

        return result.success("http://119.29.91.37:8080/files/" + filename );

    }
}
