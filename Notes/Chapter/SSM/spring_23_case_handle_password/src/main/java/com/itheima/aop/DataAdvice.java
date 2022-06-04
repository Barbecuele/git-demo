package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class DataAdvice {


    @Pointcut("execution(boolean com.itheima.service.*Service.*(..))")
    private void ptService(){};

    @Around("ptService()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();

        for (int i = 0; i < args.length; i++) {
            if (args[i].getClass().equals(String.class)){
                args[i] = args[i].toString().trim();
            }
        }

        Object proceed = pjp.proceed(args);

        return proceed;
    }
}
