package com.lerr.demo.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * -
 *
 * @auther: yangliu
 * create date: 05-06-2019
 */
@Api(value = "fileApi", tags = "文件模块")
@RestController
@RequestMapping("/files")
@Slf4j
public class FileApi {

    @PostMapping("/save")
    public String saveFile(@RequestParam("file")MultipartFile multipartFile){
        log.info("file name = " + multipartFile.getOriginalFilename());
        try (InputStream inputStream = multipartFile.getInputStream()) {
            String orginalName = multipartFile.getOriginalFilename();
            String fileName = orginalName.split("\\.")[0];
            String suffix = orginalName.split("\\.")[1];
            File desFile = File.createTempFile(fileName, "." + suffix);
            log.info(desFile.getAbsolutePath());
            FileUtils.copyInputStreamToFile(inputStream, desFile);
        } catch (IOException ioe){
            log.error("error", ioe);
        }
        return "";
    }

}
