package com.lerr.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * person vo
 *
 * @Data Lombok的注解
 *
 *
 * @author yangliu
 */
@Data
public class PersonVo {

    @NotNull
    private String name;

}
