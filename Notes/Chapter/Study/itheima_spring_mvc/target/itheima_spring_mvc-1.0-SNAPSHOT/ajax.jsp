<%--
  Created by IntelliJ IDEA.
  User: 24237
  Date: 2022/4/15
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<html>
<head>
    <title>Title</title>
    <script>
        var userList = new Array();
        userList.push({username:"zhangSan",age:18});
        userList.push({username:"liSi",age:20});
        userList.push({username:"zhaoLiu",age:22});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/quick16",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
