package com;

import com.domin.Person;
import com.service.ITestService;
import com.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @ClassName PersonServiceTest
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/8
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired public PersonService personService;
    @Autowired public ITestService testService;

    @Test
    public void listPerson(){
        List<Person> personList = personService.listPerson();

        for(Person person : personList){
            System.out.println(person.getPersonId());
            System.out.println(person.getPersonName());
            System.out.println(person.getAddress());
        }
    }

    @Test
    public void updatePerson(){
        personService.update();
        Person person = personService.find();
        System.out.println(person.getPersonName());
    }

    @Test
    public void testAnnotationThings(){
       testService.saveTest(3);
    }
}
