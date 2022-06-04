<%--
  Created by IntelliJ IDEA.
  User: 24237
  Date: 2022/3/31
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${3>4} <%--false--%>

\${3>4}<%--${3>4}--%>

<hr>

<h1>算数运算符</h1>
${3+4}<br>
${3/4}<br>
${3 div 4}<br>
${3 % 4}<br>
${3 mod 4}<br>
<hr>
<h2>比较运算符</h2>
${3==4}<br>
<hr>
<h2>逻辑运算符</h2>
${3>4 && 5>2}<br>
${3<4 && 5>3}<br>
${3>4 || 5>3}<br>
${3>4 || 5>7}
</body>
</html>
