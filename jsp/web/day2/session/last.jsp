<%--
  Created by IntelliJ IDEA.
  User: ysf
  Date: 2020/4/22
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--jsp中四大作用域：request<session<application--%>
    <%="last中的session对象中的值:"+session.getAttribute("name")%><br>
    <%="last中的request对象中的值:"+request.getAttribute("username")%><br>
    <%="last中的application对象中的值:"+application.getAttribute("uname")%>
</body>
</html>
