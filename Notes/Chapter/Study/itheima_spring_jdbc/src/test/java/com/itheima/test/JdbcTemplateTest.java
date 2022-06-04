package com.itheima.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    @Test
    public void test1() throws PropertyVetoException {//测试Jdbc开发步骤
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mytest?user=root&password=242377mxj" +
                "&useUnicode=true&characterEncoding=utf8 & useSSL=false & serverTimezone=GMT%2B8 & " +
                "rewriteBatchedStatements=true");
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("242377mxj");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象。知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);

        //执行操作
        int row = jdbcTemplate.update("insert into account values(?,?) ", "tom", 500);
        System.out.println(row);
    }

    @Test
    public void test2(){//测试Spring产生Jdbc模板对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?,?) ", "Jerry", 850);
        System.out.println(row);
    }
}
