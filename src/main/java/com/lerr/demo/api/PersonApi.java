package com.lerr.demo.api;


import com.lerr.demo.model.gen.Person;
import com.lerr.demo.service.PersonService;
import com.lerr.demo.vo.PersonVo;
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

    @GetMapping("")
    public Person getPersonByName(@Valid PersonVo personVo){
        return personService.getPersonByName(personVo.getName());
    }


}
