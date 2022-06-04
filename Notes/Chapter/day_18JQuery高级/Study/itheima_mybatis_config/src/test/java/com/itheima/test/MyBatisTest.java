package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.utils.MapperUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test1() throws IOException {

        //模拟创建User对象
        User user = new User();
        user.setUsername("guo");
        user.setPassword("123");
        user.setBirthday(new Date());

        //执行保存操作
        MapperUtil mapper = new MapperUtil();
        mapper.userMapper().save(user);
    }

    @Test
    public void test2() throws IOException {
        MapperUtil mapper = new MapperUtil();
        User byId = mapper.userMapper().findById(8);
        System.out.println(byId);
    }

    @Test
    public void test3() throws IOException {

        //设置分页的相关参数 当前页，每页显示的条数
        PageHelper.startPage(2,3);

        MapperUtil mapper = new MapperUtil();
        List<User> userList = mapper.userMapper().findAll();
        for (User user : userList){
            System.out.println(user);
        }

        //获取与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页" + pageInfo.getPageNum());
        System.out.println("每页显示条数" + pageInfo.getPageSize());
        System.out.println("总条数" + pageInfo.getTotal());
        System.out.println("总页数" + pageInfo.getPages());
        System.out.println("上一页" + pageInfo.getPrePage());
        System.out.println("下一页" + pageInfo.getNextPage());
        System.out.println("是否是第一页" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页" + pageInfo.isIsLastPage());
        System.out.println("是否拥有下一页" + pageInfo.isHasNextPage());
    }
}
