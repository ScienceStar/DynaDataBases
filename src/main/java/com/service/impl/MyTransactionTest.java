package com.service.impl;

import com.aop.annotation.DataSourceSelector;
import com.aop.annotation.MyTransaction;
import com.aop.holder.DataSourceConnectHolder;
import com.config.DynamicDataSourceEnum;
import com.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName MyTransactionTest
 * @Description: TODO
 * @Author lxc
 * @Date 2020/7/20 13:05
 * @Version V1.0
 **/
@Service
public class MyTransactionTest implements ITestService {

    @Autowired
    DataSourceConnectHolder holder;

    @MyTransaction(rollbackFor = ArithmeticException.class)
    @Override
    public void saveTest(int id) {
        saveWitharamters(id, "luozhou@gmail.com");
        saveWitharamters(id + 10, "luozhou@gmail.com");
        int aa = id / 0;
    }

    @DataSourceSelector(value = DynamicDataSourceEnum.MASTER)
    @Override
    public void saveWitharamters(int id, String email) {
        String sql = "insert into tb_test values(?,?)";
        Connection connection = holder.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
