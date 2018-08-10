package com.lerr.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PersonDto {

    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

}
