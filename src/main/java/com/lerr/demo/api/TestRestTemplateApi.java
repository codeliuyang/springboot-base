package com.lerr.demo.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test/resttemplate")
@Slf4j
public class TestRestTemplateApi {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/send")
    public String send(){
        restTemplate.getForObject("http://localhost:8090/demo/test/resttemplate/resp", String.class);
        return "okay";
    }

    @GetMapping("/resp")
    public String resp(){
        log.info("yes");
        return "It works!";
    }

}
