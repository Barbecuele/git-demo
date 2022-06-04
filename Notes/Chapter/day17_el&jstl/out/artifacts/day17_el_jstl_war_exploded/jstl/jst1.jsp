<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
c:if标签
    1.属性：
        *test必须属性，接收boolean表达式
            *如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
            *一般情况下。test属性值会结合el表达式一起使用
--%>
<c:if test="true">
    <h1>我是真的</h1>
</c:if>

<%
    //判断request域中的一个list集合是否为空，如果不为空则显示遍历集合

    List list = new ArrayList();
    request.setAttribute("list", list);

    list.add("gjr");
    list.add("yff");

    request.setAttribute("number1", 3);
    request.setAttribute("number2", 4);
%>
<c:if test="${not empty list}">
    遍历集合。。。
</c:if>
<br>
<c:if test="${requestScope.number1 mod 2 !=0}">
    ${number1}为奇数
</c:if>

<c:if test="${number2 % 2 ==0}">
    ${number2}为偶数
</c:if>
</body>
</html>
