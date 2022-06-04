package com.itheima.service;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import com.itheima.utils.SqlSessionUtil;

import java.io.IOException;
import java.util.List;

public class ServiceDemo {

    public static void main(String[] args) throws IOException {

        UserMapper userMapper = new SqlSessionUtil().userMapper();
        List<User> userList = userMapper.findAll();
        System.out.println(userList);

        UserMapper mapper = new SqlSessionUtil().userMapper();
        List<User> users = mapper.findById(3);
        System.out.println(users);
    }
}
