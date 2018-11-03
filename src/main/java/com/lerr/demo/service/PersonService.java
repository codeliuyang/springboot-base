package com.lerr.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lerr.demo.mapper.dao.custom.PersonCustomMapper;
import com.lerr.demo.mapper.dao.gen.PersonMapper;
import com.lerr.demo.model.gen.Person;
import com.lerr.demo.model.gen.PersonExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Person相关的service
 *
 * @author yangliu
 */
@Service
public class PersonService{

    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonCustomMapper personCustomMapper;

    /**
     * 根据姓名查找Person，使用的是xml的方法
     *
     * @param name
     * @return
     */
    public Person getPersonByName(String name) {
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Person> persons = personMapper.selectByExample(personExample);
        return persons.get(0);
    }

    /**
     * 根据姓名查找Person，使用的是基于注解的方法
     *
     * @param name
     * @return
     */
    public Person getCustomPersonByName(String name) {
        return personCustomMapper.selectPersonByName(name);
    }

    /**
     * 分页获取Person数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Person> getPersonsInPage(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Person> persons = personMapper.selectByExample(null);
        return new PageInfo<>(persons);
    }



}
