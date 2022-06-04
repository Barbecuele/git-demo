package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/index.jsp")//1.具体资源路径：/index.jsp
//@WebFilter("/user/*")//2.目录拦截：/user/*
//@WebFilter("*.jsp")//3.后缀名拦截：*.jsp
public class FilterDemo4 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4...");
        chain.doFilter(request, response);
    }
}
