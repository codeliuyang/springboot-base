package com.lerr.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test/resttemplate")
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
        System.out.print("yes");
        return "It works!";
    }

}
