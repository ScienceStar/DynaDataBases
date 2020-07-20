package application.dao;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ICronMapper {
        String getCron();
    }
