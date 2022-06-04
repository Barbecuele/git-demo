package cn.itcast.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3.获取Cookie
        Cookie[] cs = request.getCookies();

        //获取数据，遍历Cookies
        if (cs != null) {
            for (Cookie cookie : cs) {
                String name = cookie.getName();
                String value = cookie.getValue();

                //打印输出name，value
                System.out.println(name + ":" + value);//msg:你好
            }
        }
    }
}
