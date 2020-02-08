package com.service;

import com.aop.annotation.DataSourceSelector;
import com.config.DynamicDataSourceEnum;
import com.dao.PersonMapper;
import com.domin.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PersonService
 * @Description: TODO 用户服务
 * @Author lxc
 * @Date 2020/2/8
 * @Version V1.0
 **/
@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public List<Person> listPerson() {
        List<Person> Persons = personMapper.selectAll();
        return Persons;
    }

    @DataSourceSelector(value = DynamicDataSourceEnum.MASTER)
    public int update() {
        Person Person = new Person();
        Person.setPersonId(Long.parseLong("1196978513958141952"));
        Person.setPersonName("修改后的名字2");
        return personMapper.updateByPrimaryKeySelective(Person);
    }

    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public Person find() {
        Person Person = new Person();
        Person.setPersonId(Long.parseLong("1196978513958141952"));
        return personMapper.selectByPrimaryKey(Person);
    }
}
