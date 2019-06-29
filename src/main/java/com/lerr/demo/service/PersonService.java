package com.lerr.demo.service;

import com.github.pagehelper.PageInfo;
import com.lerr.demo.dto.PersonDTO;
import com.lerr.demo.model.gen.Person;

import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
public interface PersonService {

    Person getById(Long personDTO);

    Person getByQuery(PersonDTO query);

    List<Person> getPersons(PersonDTO query);

    PageInfo<Person> getPersonPage(PersonDTO query, int pageNumber, int pageSize);

    Long createPerson(PersonDTO personDTO);

    Long updatePerson(PersonDTO personDTO, Long personId);

    void removePerson(Long personId);

}
