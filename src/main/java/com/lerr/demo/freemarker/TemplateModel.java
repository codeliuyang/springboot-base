package com.lerr.demo.freemarker;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * -
 *
 * @auther: yangliu
 * create date: 09-06-2019
 */
@Data
@AllArgsConstructor
public class TemplateModel {

    private String comment;
    private String domainNameUpper;
    private String packageName;

}
