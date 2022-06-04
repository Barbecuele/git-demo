<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 24237
  Date: 2022/4/1
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
<%
    User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());
        request.setAttribute("u",user);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);

    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("sname","张三");
    map.put("gender","male");
    map.put("user",user);

    request.setAttribute("map",map);
%>
${u}<br>
<%--
    通写过对象的属性来获取
        *setter或者getter方法。去掉set或者get，将剩余部分，首字母变小
        *setName-->Name--->name
--%>
${requestScope.u.name}<br>
${requestScope.u.age}<br>
${requestScope.u.birStr}<br>
${requestScope.u.birthday.month}<br>

<h3>获取List集合中的值</h3>
${list}<br>
${list[0]}<br>
${list[2].name}<br>

<h3>获取Map集合中的值</h3>
${map.gender}<br>
${map["gender"]}<br>
${map["user"].name}<br>
</body>
</html>
