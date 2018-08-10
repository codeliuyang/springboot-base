package com.lerr.demo.mapper.dao.custom;

import com.lerr.demo.model.gen.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonCustomMapper {

    @Select("select id, name, birth from person where name = #{name}")
    Person selectPersonByName(String name);

}
