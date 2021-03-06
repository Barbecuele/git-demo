package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet的方法
 */
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法
     * 在Servlet被创建的时候执行，只会被执行一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("int .....");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务
     * 每一次Servlet被访问时都会执行
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.....");
        int number = 3;
    }

    /**
     * 获取Servlet的一些信息，版本，作者等等。。。
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器被正常关闭时执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
