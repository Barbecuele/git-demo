<%--
  Created by IntelliJ IDEA.
  User: 24237
  Date: 2022/4/1
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //在域中存储数据
    session.setAttribute("name","lisi");
    pageContext.setAttribute("name", "张三");
    request.setAttribute("age", "12");
    session.setAttribute("gender", "male");
    application.setAttribute("hobby", "sing");
%>
<h1>获取值</h1>
${pageScope.name}
${sessionScope.gender}
${requestScope.age}
${applicationScope.hobby}
<h2>新语法</h2>
${name}
</body>
</html>
