<%--
  Created by IntelliJ IDEA.
  User: 24237
  Date: 2022/4/15
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--${pageContext.request.contextPath}获取绝对路径--%>
    <form action="${pageContext.request.contextPath}/user/quick15" method="post">
        <%--表明是第一个对象的username  age--%>
        <input type="text" name="userList[0].username"><br/>
        <input type="text" name="userList[0].age"><br/>
        <input type="text" name="userList[1].username"><br/>
        <input type="text" name="userList[1].age"><br/>
        <input type="submit" name="提交">
    </form>
</body>
</html>
