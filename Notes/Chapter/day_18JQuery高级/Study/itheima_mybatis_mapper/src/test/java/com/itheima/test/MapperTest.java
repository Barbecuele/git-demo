package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.utils.MapperUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    @Test
    public void test1() throws IOException {

        MapperUtils mapperUtils = new MapperUtils();
        //模拟条件
        User condition = new User();
        condition.setId(1);
        condition.setUsername("zhangsan");
        //condition.setPassword("123");

        List<User> userList = mapperUtils.userMapper().findByCondition(condition);
        System.out.println(userList);
    }

    @Test
    public void test2() throws IOException {
        MapperUtils mapperUtils = new MapperUtils();
        User condition = new User();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(4);

        List<User> userList = mapperUtils.userMapper().findByIds(ids);
        System.out.println(userList);
    }
}
