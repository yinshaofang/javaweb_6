<%--
  Created by IntelliJ IDEA.
  User: ysf
  Date: 2020/4/21
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%--isErrorPage=true 处理异常的跳转到此页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--jsp九大内置对象之一 exception--%>
    <%=exception.getMessage()%>
</body>
</html>
