package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//@RestControllerAdvice是一个组合注解，由@ControllerAdvice、@ResponseBody组成，
//而@ControllerAdvice继承了@Component，因此@RestControllerAdvice本质上是个Component，用于定义@ExceptionHandler，
// @InitBinder和@ModelAttribute方法，适用于所有使用@RequestMapping方法。
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员

        return new Result(Code.SYSTEM_UNKNOWN_ERR,null,"系统繁忙！");
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员

        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){

        return new Result(ex.getCode(),null,ex.getMessage());
    }
}
