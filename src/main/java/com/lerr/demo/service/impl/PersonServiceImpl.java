package com.lerr.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lerr.demo.core.AuditCore;
import com.lerr.demo.dto.PersonDTO;
import com.lerr.demo.mapper.gen.PersonMapper;
import com.lerr.demo.model.gen.Person;
import com.lerr.demo.model.gen.PersonCriteria;
import com.lerr.demo.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person getById(Long personId) {
        return personMapper.selectByPrimaryKey(personId);
    }

    @Override
    public Person getByQuery(PersonDTO personDTO) {
        PersonCriteria personCriteria = new PersonCriteria();
        PersonCriteria.Criteria criteria = personCriteria.createCriteria();
        // criteria.andDelFlagEqualTo(0);
        List<Person> persons = this.getPersons(personDTO);
        if(CollectionUtils.isEmpty(persons)){
            return null;
        } else {
            return persons.get(0);
        }
    }

    @Override
    public List<Person> getPersons(PersonDTO query) {
        PersonCriteria personCriteria = new PersonCriteria();
        PersonCriteria.Criteria criteria = personCriteria.createCriteria();
        // criteria.andDelFlagEqualTo(0);
        List<Person> persons = personMapper.selectByExample(personCriteria);
        return persons;
    }

    @Override
    public PageInfo<Person> getPersonPage(PersonDTO query, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Person> persons = this.getPersons(query);
        return new PageInfo<>(persons);
    }

    @Override
    public Long createPerson(PersonDTO personDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        AuditCore.setAuditPropsForCreated(person);
        personMapper.insert(person);
        return person.getId();
    }

    @Override
    public Long updatePerson(PersonDTO personDTO, Long personId) {
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        person.setId(personId);
        AuditCore.setAuditPropsForUpdated(person);
        personMapper.updateByPrimaryKeySelective(person);
        return person.getId();
    }

    @Override
    public void removePerson(Long personId) {
        Person person = personMapper.selectByPrimaryKey(personId);
        // person.setDelFlag(1);
        AuditCore.setAuditPropsForUpdated(person);
        personMapper.updateByPrimaryKeySelective(person);
    }
}
