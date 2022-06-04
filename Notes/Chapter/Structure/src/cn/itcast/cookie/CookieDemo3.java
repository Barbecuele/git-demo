package cn.itcast.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c = new Cookie("msg","hello");

        //2.设置Cookie的存活时间
        //c.setMaxAge(30);//将cookie持久化的硬盘，30s之后自动删除
        //c.setMaxAge(-1);//默认值为负数
        c.setMaxAge(0);

        //3.发送Cookie
        response.addCookie(c);
    }
}
