package com.lerr.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ${domainNameUpper}DTO {

    @ApiModelProperty(value = "", example = "0")
    private Long id;

    @ApiModelProperty(value = "", example = "")
    private String name;

    @ApiModelProperty(value = "", example = "")
    private Date birth;

}