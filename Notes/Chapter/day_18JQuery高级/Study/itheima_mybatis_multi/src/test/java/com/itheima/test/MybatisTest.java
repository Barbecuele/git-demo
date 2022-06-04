package com.itheima.test;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.utils.MapperOrderUtil;
import com.itheima.utils.MapperUserUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    @Test
    public void test3() throws IOException {
        MapperUserUtil mapper = new MapperUserUtil();
        List<User> userAndRoleAll = mapper.userMapper().findUserAndRoleAll();
        for (User user : userAndRoleAll) {
            System.out.println(user);
        }

    }

    @Test
    public void test2() throws IOException {
        MapperUserUtil mapper = new MapperUserUtil();
        List<User> userList = mapper.userMapper().findAll();
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void test1() throws IOException {
        MapperOrderUtil mapper = new MapperOrderUtil();
        List<Order> orderList = mapper.orderMapper().findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }

    }

}
