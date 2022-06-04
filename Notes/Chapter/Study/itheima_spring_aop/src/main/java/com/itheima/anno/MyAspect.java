package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect//标注当前myAspect是一个切面类
public class MyAspect {

    //配置前置增强
    //@Before("execution(* com.itheima.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强....");
    }

    public void afterReturning() {
        System.out.println("fuck you!");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        //切点方法
        Object proceed = pjp.proceed();

        System.out.println("环绕后增强");

        return proceed;
    }

    @AfterThrowing("pointcut()")
    private void afterThrowing(){
        System.out.println("异常抛出");
    }

    public void after(){
        System.out.println("最终增强");
    }

    //定义一个切点表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){

    }
}
