package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQueryCount() {
        Long account = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(account);
    }

    @Test
    public void testQueryOne() {
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?",
                            new BeanPropertyRowMapper<Account>(Account.class), "Lucy");
        System.out.println(account);
    }

    @Test
    public void testQueryAll() {int row = jdbcTemplate.update("update account set money=? where name = ?",600,"tom");
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testUpdate() {
        int row = jdbcTemplate.update("update account set money=? where name = ?",600,"tom");
        System.out.println(row);
    }

    @Test
    public void testDelete() {
        int row = jdbcTemplate.update("delete from account where name = ?","tom");
        System.out.println(row);
    }
}
