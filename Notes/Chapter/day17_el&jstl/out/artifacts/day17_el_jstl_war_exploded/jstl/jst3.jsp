<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%--
        foreach相当于java中的for语句
            1.完成重复的操作
                *属性：
                    begin：开始值
                    end：结束值
                    var:临时变量
                    step:步长
                    varstatus:循环状态对象
                        index:容器中元素索引，从0开始
                        count:循环次数，从1开始
            2.遍历容器
                属性：
                    items：容器对象
                    var:容器中元素的临时变量
--%>

<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    ${i} ${s.index} ${s.count}<br>
</c:forEach>

<hr>

<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

    request.setAttribute("list",list);
%>

<c:forEach items="${requestScope.list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str}<br>
</c:forEach>
</body>
</html>
