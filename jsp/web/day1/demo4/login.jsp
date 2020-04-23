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
    <script src="<%=request.getContextPath()%>/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/jquery.cookie.js"></script>
    <script>
        $(function() {
            var name=$.cookie("name");
            var pass=$.cookie("pass");
            if(name&&pass){//如果用户名或密码不为null
               $("#name").val(name);
               $("#pass").val(pass);
               $("form").submit();
            }
        });

    </script>
</head>
<body>
  <form action="<%=request.getContextPath()%>/day1/ex/login">
       <fieldset>
           <legend>用户登录</legend>
           用户名:<input type="text" name="name" id="name" placeholder="输入用户名"><br>
           密&nbsp;&nbsp;&nbsp;码:<input type="password" name="pass" id="pass" placeholder="输入密码"><br>
           <input type="checkbox" name="rm">七天免登陆<br>
           <input type="submit" value="登录">
           <div style="color: red">
               <%
                 //通过request对象获取服务器的错误信息
                String msg= (String) request.getAttribute("errMsg");
               %>
               <%=msg==null?"":msg%>
           </div>
       </fieldset>

  </form>
</body>
</html>
