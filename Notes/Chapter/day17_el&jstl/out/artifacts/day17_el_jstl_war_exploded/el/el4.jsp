<%--
  Created by IntelliJ IDEA.
  User: 24237
  Date: 2022/4/1
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隐式对象</title>
</head>
<body>
${pageContext.request}<br>
<h1>JSP页面动态获取虚拟目录</h1>
${pageContext.request.contextPath}<br><%--获取虚拟目录--%>}

</body>
</html>
