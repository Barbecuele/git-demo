package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {//加载SpringMVC的容器对象

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMVCConfig.class);
        return ctx;
    }

    @Override
    protected String[] getServletMappings() {//哪些请求归SpringMVC处理
        return new String[]{"/"};//代表所有的请求都归SpringMVC处理
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
