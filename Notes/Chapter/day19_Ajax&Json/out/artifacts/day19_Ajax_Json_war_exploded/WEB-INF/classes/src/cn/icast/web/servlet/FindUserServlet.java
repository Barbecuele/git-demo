package cn.icast.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取用户名
        String username = request.getParameter("username");

        //2.调用service层判断用户名是否存在
        response.setContentType("text/html;charset=utf-8");
        Map<String,Object> map = new HashMap<>();

        if ("tom".equals(username)){
            //存在
            map.put("userExist",true);
            map.put("msg","次用户名太受欢迎，请更换一个");
        }else {
            //不存在
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }
}
