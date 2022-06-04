package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/account",produces = "text/html;charset=utf-8")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //保存
    @RequestMapping("/save")
    @ResponseBody//防止页面调回，直接返回字符串
    public String save(Account account){
        accountService.save(account);
        return "恭喜你,保存成功!";
    }

    //查询
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Account> accounts = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accountList");
        modelAndView.addObject("accountList",accounts);
        return modelAndView;
    }
}
