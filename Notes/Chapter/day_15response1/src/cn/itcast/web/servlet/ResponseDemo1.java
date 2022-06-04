package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Demo1被访问了....");

        //访问该资源，会自动跳转到ResponseDemo2资源
        //1.设置状态码为302
        //response.setStatus(302);

        //2.设置响应头location
        //response.setHeader("location","/day15/responseDemo2");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        //第二种方式：简单的重定向方法
        response.sendRedirect(contextPath+ "/responseDemo2");
    }
}
