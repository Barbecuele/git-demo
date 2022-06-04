package cn.itcast.web.servlet;

import cn.itcast.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //页面提示语

        //获取request域中共享的内容
        User user = (User)request.getAttribute("user");

        //设置编码
        response.setContentType("text/html;charset=utf-8");

        if (user!=null) {
            //输出
            response.getWriter().write("登陆成功！" + user.getUsername() + "，欢迎您");
        }
    }
}
