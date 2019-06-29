package com.lerr.demo.api;

import com.github.pagehelper.PageInfo;
import com.lerr.demo.core.HttpResult;
import com.lerr.demo.dto.PersonDTO;
import com.lerr.demo.model.gen.Person;
import com.lerr.demo.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
@RestController
@RequestMapping("/persons")
@Api(value="用户模块API", tags = "用户模块模块")
public class PersonApi {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public HttpResult<Person> getPersons(@PathVariable Long id){
        return HttpResult.success(personService.getById(id));
    }

    @GetMapping("/list")
    public HttpResult<List<Person>> getPersons(PersonDTO query){
        return HttpResult.success(personService.getPersons(query));
    }

    @GetMapping("/page")
    public HttpResult<PageInfo<Person>> getPersonPage(PersonDTO query,
                                      @RequestParam Integer pageNumber,
                                      @RequestParam Integer pageSize){
        return HttpResult.success(personService.getPersonPage(query, pageNumber, pageSize));
    }

    @PostMapping("")
    public HttpResult<Long> createPerson(@RequestBody PersonDTO personDTO){
        return HttpResult.success(personService.createPerson(personDTO));
    }

    @PutMapping("")
    public HttpResult<Long> updatePerson(@RequestBody PersonDTO personDTO){
        return HttpResult.success(personService.updatePerson(personDTO, personDTO.getId()));
    }

    @DeleteMapping("/{id}")
    public HttpResult removePerson(@PathVariable Long id){
        personService.removePerson(id);
        return HttpResult.success(null, "success");
    }

}
