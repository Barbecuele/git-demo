package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        System.out.println("user save...");
        return "{'model':'user save'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        System.out.println("user delete...");
        return "{'model':'user delete'}";
    }

    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(@RequestParam String name,@RequestParam int age) {
        System.out.println("普参数传递 name===>" + name);
        System.out.println("普参数传递 age===>" + age);
        return "{'model':'commonParam...'}";
    }

    //普通参数，请求参数与形参名不同
    @RequestMapping("/commonParamDifferent")
    @ResponseBody
    public String commonParamDifferent(@RequestParam("name") String username, int age) {
        System.out.println("普参数传递 name===>" + username);
        System.out.println("普参数传递 age===>" + age);
        return "{'model':'common Param Different'}";
    }

    //POJO参数
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("pojo 参数传递 user ==>" + user);
        return "'model' : 'pojo prarm'";
    }

    //POJO嵌套参数
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(@RequestParam User user) {
        System.out.println("pojo嵌套pojo特发对方给他参数传递 user ==>" + user);
        return "{'model' : 'pojo contain pojo param'}";
    }

    //数组参数
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(@RequestParam String[] likes) {
        System.out.println("数组参数传递 likes==>" + Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    //集合参数
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("集合参数传递 likes==>" + likes);
        return "{'module':'list param'}";
    }

    //集合参数:json格式
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("list common(json)参数传递 listr==>" + likes);
        return "{'module':'list common for json param'}";
    }

    //POJO参数:json格式
    @RequestMapping("/pojoParamJson")
    @ResponseBody
    public String pojoParamJson(@RequestBody User user){
        System.out.println("pojo(json)参数传递 user==>" + user);
        return "{'module':'pojo for json param'}";
    }

    //集合参数:json格式
    @RequestMapping("/listPojoParamJson")
    @ResponseBody
    public String listPojoParamJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递 listr==>" + list);
        return "{'module':'list pojo for json param'}";
    }

    //日期参数
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") @RequestParam Date date1,
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam Date date2,
                            @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss") @RequestParam Date date3){
        System.out.println("参数传递 date==>" + date1);
        System.out.println("参数传递 date==>" + date2);
        System.out.println("参数传递 date==>" + date3);

        return "{'module':'date param'}";
    }
}
