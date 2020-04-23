<%--
  Created by IntelliJ IDEA.
  User: ysf
  Date: 2020/4/22
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--jsp本质就是servlet，转发时request和response对象相同--%>
    <%="session对象中的值:"+session.getAttribute("name")%>
    <hr>
    <%="request对象中的值:"+request.getAttribute("username")%>
    <hr>
    <%="application全局对象中的值:"+application.getAttribute("uname")%>
    <hr>
    <%--jsp中没有重定向概念，但是可以模拟重定向--%>
    <a href="<%=request.getContextPath()%>/day2/session/last.jsp">打开新页面</a>
</body>
</html>
