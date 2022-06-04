<%--
  Created by IntelliJ IDEA.
  User: 24237
  Date: 2022/3/30
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    response.getWriter().write("response");
  %>

    <%
      int i =5;//局部变量
      System.out.println("Hello World");

      String contextPath = request.getContextPath();
      out.print(contextPath);
    %>

    <%!
      int i = 3;//成员变量
    %>

    <%=i//优先局部变量

    %>
    <br>

  <h1>
    hi~~~JSP
  </h1>
  </body>
</html>
