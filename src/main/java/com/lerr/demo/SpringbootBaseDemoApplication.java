package com.lerr.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 主启动类
 *
 * @author yangliu
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lerr.demo.mapper")
public class SpringbootBaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBaseDemoApplication.class, args);
    }

}
