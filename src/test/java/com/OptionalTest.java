package com;

import com.domin.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description: TODO
 * @Author lxc
 * @Date 2020/7/20 16:53
 * @Version V1.0
 **/
public class OptionalTest {

    @Test
    public void testOptional(){
        Person person = new Person();
        person.setPersonId(123l);
        person.setPersonName("mike");
       Optional.ofNullable(person).ifPresentOrElse(s->{
           String name =s.getPersonName();
           System.out.println(name);
           },()->{
            System.out.println("用户为空!");
        });

        String personName =Optional.of(person).filter(p->p.getPersonId()>=100).map(Person::getPersonName).orElse("");
        System.out.println(personName);
    }
}
