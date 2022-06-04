<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Choose标签</title>
</head>
<body>
<!--
完成数字编号对应星期几的案例
  1.域中存储一数字
  2.使用Chooser标签取出数字
  3.使用when标签对数字进行判断
  4.otherwise标签做其他情况的声明
-->

<%
    request.setAttribute("number",0);
%>
<c:choose>
    <c:when test="${requestScope.number==1}">星期一</c:when>
    <c:when test="${requestScope.number==2}">星期二</c:when>
    <c:when test="${requestScope.number==3}">星期三</c:when>
    <c:when test="${requestScope.number==4}">星期四</c:when>
    <c:when test="${requestScope.number==5}">星期五</c:when>
    <c:when test="${requestScope.number==6}">星期六</c:when>
    <c:when test="${requestScope.number==7}">星期日</c:when>

    <c:otherwise>您的输入有误</c:otherwise>
</c:choose>
</body>
</html>
