package com.aop.holder;

import com.dynamicdatasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName DataSourceConnectHolder
 * @Description: TODO 该类帮助我们管理连接，该类的核心功能是把取出的连接对象绑定到线程上，方便在AOP处理中取出，进行提交或者回滚操作。
 * @Author lxc
 * @Date 2020/7/20 12:48
 * @Version V1.0
 **/
@Component
public class DataSourceConnectHolder {
    @Autowired DynamicDataSource dynamicDataSource;
    /**
     * 线程绑定对象
     */
    ThreadLocal<Connection> resources = new NamedThreadLocal<>("Transactional resources");

    public Connection getConnection() {
        Connection con = resources.get();
        if (con != null) {
            return con;
        }
        try {
            con = dynamicDataSource.getConnection();
            //为了体现事务，全部设置为手动提交事务
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resources.set(con);
        return con;
    }

    public void cleanHolder() {
        Connection con = resources.get();
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resources.remove();
    }
}
