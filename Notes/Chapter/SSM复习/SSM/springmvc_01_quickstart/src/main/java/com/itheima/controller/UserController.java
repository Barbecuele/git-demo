package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/save")
    @ResponseBody//设置返回结果为响应体，不是页面
    public String save(){
        System.out.println("user save ....");
        return "{'info':'Hello World!'}";
    }
}
