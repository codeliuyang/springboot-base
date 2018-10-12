package com.lerr.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 *
 * @author yangliu
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lerr.demo.mapper")
@Slf4j
public class SpringbootBaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBaseDemoApplication.class, args);
        log.info("project is running, see api doc at http://localhost:8090/demo/swagger-ui.html");
    }

}
