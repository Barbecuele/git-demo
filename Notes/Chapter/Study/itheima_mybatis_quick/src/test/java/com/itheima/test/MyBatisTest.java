package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作 参数：namespace +id
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        //打印数据
        System.out.println(userList);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //模拟User对象
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123");
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        int insert = sqlSession.insert("userMapper.save",user);

        //如果MyBatis需要执行更新操作，需要提交事务
        sqlSession.commit();

        System.out.println(insert);
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(6);
        user.setPassword("123");
        user.setUsername("tom");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userMapper.update", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userMapper.drop",6);
        sqlSession.commit();
        sqlSession.close();
    }
}
