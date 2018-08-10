package com.lerr.demo.api;


import com.lerr.demo.dto.PersonDto;
import com.lerr.demo.service.PersonService;
import com.lerr.demo.vo.PersonVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/persons")
public class PersonApi {

    @Autowired
    PersonService personService;

    @GetMapping("/gen")
    public PersonDto getPersonByName(@Valid PersonVo personVo){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(personService.getPersonByName(personVo.getName()),
                personDto);
        return personDto;
    }

    @GetMapping("/custom")
    public PersonDto getCustomPersonByName(@Valid PersonVo personVo){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(personService.getCustomPersonByName(personVo.getName()),
                personDto);
        return personDto;
    }


}
