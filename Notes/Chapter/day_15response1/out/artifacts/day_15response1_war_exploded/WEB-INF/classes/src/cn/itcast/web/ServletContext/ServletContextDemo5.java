package src.cn.itcast.web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //2.获取服务器真实路径
        //String realPath = context.getRealPath("/WEB-INF/classes/a.txt");

        //String realPath = context.getRealPath("/WEB-INF/a.txt");

        String realPath = context.getRealPath("/a.txt");

        System.out.println(realPath);
    }
}
