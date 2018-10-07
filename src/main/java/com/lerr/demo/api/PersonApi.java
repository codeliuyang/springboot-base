package com.lerr.demo.api;


import com.lerr.demo.dto.PersonDto;
import com.lerr.demo.service.PersonService;
import com.lerr.demo.vo.PersonVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * PersonApi 用户模块相关的API
 *
 * @author yangliu
 */
@Api(value = "/persons", tags = "用户模块")
@RestController
@RequestMapping("/persons")
public class PersonApi {

    @Autowired
    PersonService personService;

    @ApiOperation(value = "根据person信息查询person", notes = "用生成xml与mapper通过方法名映射，查询数据")
    @GetMapping("/gen")
    public PersonDto getPersonByName(@Valid @ApiParam(value = "请求人信息", required = true) PersonVo personVo) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(personService.getPersonByName(personVo.getName()),
                personDto);
        return personDto;
    }

    @ApiOperation(value = "根据person信息查询person", notes = "直接用注解的方式写sql，查询数据")
    @GetMapping("/custom")
    public PersonDto getCustomPersonByName(@Valid PersonVo personVo) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(personService.getCustomPersonByName(personVo.getName()),
                personDto);
        return personDto;
    }


}
