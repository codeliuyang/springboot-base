package com.lerr.demo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
${ims}

@Data
@Builder
@ApiModel(value = "${tableComment}")
public class ${domainNameUpper}DTO {

${propertiesInfo}
}