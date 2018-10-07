package com.lerr.demo.config;

import com.lerr.demo.interceptor.CustomClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    //another method to instantiate RestTemplate
//    @Bean
//    public RestTemplate restTemplate(){
//        return restTemplateBuilder.build();
//    }

    /**
     * 实例化restTemplate，因为在CustomClientHttpRequestInterceptor中有读取过response的IO，因此实例化比较复杂
     *
     * @return restTemplate
     */
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new CustomClientHttpRequestInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }


}
