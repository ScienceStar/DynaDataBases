package com.dao;

import com.domin.Person;
import com.common.MyMapper;
import org.springframework.stereotype.Component;

/**
 * @InterfaceName IPersonDao
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/8
 * @Version V1.0
 **/
@Component
public interface PersonMapper extends MyMapper<Person> {
}
