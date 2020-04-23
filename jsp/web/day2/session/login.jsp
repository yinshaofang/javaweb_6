<%--
  Created by IntelliJ IDEA.
  User: ysf
  Date: 2020/4/21
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/day2/session/login">
       <fieldset>
           <legend>用户登录</legend>
           用户名:<input type="text" name="name" id="name" placeholder="输入用户名"><br>
           密&nbsp;&nbsp;&nbsp;码:<input type="password" name="pass" id="pass" placeholder="输入密码"><br>
           <input type="submit" value="登录">
       </fieldset>
  </form>
</body>
</html>
