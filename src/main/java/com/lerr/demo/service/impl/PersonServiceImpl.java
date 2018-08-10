package com.lerr.demo.service.impl;

import com.lerr.demo.mapper.dao.gen.PersonMapper;
import com.lerr.demo.model.gen.Person;
import com.lerr.demo.model.gen.PersonExample;
import com.lerr.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public Person getPersonByName(String name) {
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Person> persons = personMapper.selectByExample(personExample);
        return persons.get(0);
    }
}
