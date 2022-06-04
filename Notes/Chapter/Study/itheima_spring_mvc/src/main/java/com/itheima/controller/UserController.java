package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick24")
    @ResponseBody
    public void save24(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("D:\\Chapter\\" + originalFilename));
    }

    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(@CookieValue(value = "JSESSIONID",required = false) String cookie) {
        System.out.println(cookie);
    }

    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(@CookieValue(value = "JSESSIONID",required = false) String cookie) {
        System.out.println(cookie);
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@RequestHeader(value = "User-Agent",required = false) String user_agent) {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(HttpServletResponse response, HttpServletRequest request,
                       HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(Date date) {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick18/{name}")
    @ResponseBody
    public void save18(@PathVariable(value = "name") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick17")
    @ResponseBody
    public void save17(@RequestParam(value = "name",required = false,defaultValue = "乌兹") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    //期望SpringMVC自动将user对象转化为json格式的字符串
    public User save13(User user) {

        return user;
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    //期望SpringMVC自动将user对象转化为json格式的字符串
    public User save11() {
        User user = new User();
        user.setUsername("zhangSan");
        user.setAge(23);

        return user;
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    //期望SpringMVC自动将List集合转化为json格式的字符串
    public void save12(String username,int age) {
        System.out.printf("username:" + username + "\nage:" + age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    //期望SpringMVC自动将user对象转化为json格式的字符串
    public User save10() {
        User user = new User();
        user.setUsername("zhangSan");
        user.setAge(23);

        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("zhangSan");
        user.setAge(23);

        //使用JSON转换工具，将对象转换为JSON格式的字符串，再进行返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writer().writeValueAsString(user);

        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\": \"zhangSan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7() {
        return "Hello World";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("hello 酷丁鱼");
    }

    @RequestMapping(value = "/quick5")//quick为映射地址
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "北大青鸟");
        return "success";
    }

    @RequestMapping(value = "/quick4")//quick为映射地址
    public String save4(Model model) {
        model.addAttribute("username", "powerNode");
        return "success";
    }

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"name"})//quick为映射地址
    public String save() {
        System.out.printf("controller save running...");
        return "success";
    }

    @RequestMapping(value = "/quick2")//quick为映射地址
    public ModelAndView save2() {
        /*
            Model:模型 作用封装数据
            View: 视图 作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username", "itcast");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick3")//quick为映射地址
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "atguigu");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
