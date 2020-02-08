package com.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @InterfaceName MyMapper
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/8
 * @Version V1.0
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
