package com.lerr.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class PersonDTO implements Serializable {

    @ApiModelProperty(value = "", example = "0")
    private Long id;

    @ApiModelProperty(value = "", example = "")
    private String name;

    @ApiModelProperty(value = "", example = "")
    private Date birth;

}