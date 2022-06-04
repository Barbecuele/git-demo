package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSelectAll(){
        List<User> userList = mapper.findAll();
        for (User user:userList
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectById(){
        User byId = mapper.findById(3);
        System.out.println(byId);
    }

    @Test
    public void testDelete(){
        mapper.delete(8);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(5);
        user.setUsername("wangQi");
        user.setPassword("123");

        mapper.update(user);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("zhangMing");
        user.setPassword("123");

        mapper.save(user);
    }
}
