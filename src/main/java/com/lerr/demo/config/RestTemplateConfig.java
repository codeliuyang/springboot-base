package com.lerr.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置以及初始化
 * 在实际工程需要使用RestTeplate的时候，都是需要先进行配置进注入的BeanFactory中去的。
 *
 * 这样，其他需要引用的地方直接@Autowired即可
 *
 * @author yangliu
 */
@Configuration
public class RestTemplateConfig {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build();
    }

}
