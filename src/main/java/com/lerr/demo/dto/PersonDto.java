package com.lerr.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PersonDto {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "客户姓名")
    private String name;
    @ApiModelProperty(value = "生日，返回的时候用yyyy-MM-dd格式")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

}
