package com.lerr.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * person vo
 */
@Data
public class PersonVo {

    @NotNull
    private String name;

}
