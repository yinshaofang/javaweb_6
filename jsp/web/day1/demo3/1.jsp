<%--
  Created by IntelliJ IDEA.
  User: ysf
  Date: 2020/4/21
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>this is 1.jsp</h1>
   <%
     int i=20;
   %>
   <%--
        1、include指令：只编译和执行一次
       把2.jsp拷贝到1.jsp中 =>提高了效率，但注意不能有相同的属性和方法
   --%>
   <%--<%@include file="2.jsp"%>--%>

   <%--
        2、include动作:把多个页面执行的结果合并在一起
         =>特点:两个页面共享req和resp,不存在变量重名问题  =》推荐
   --%>
      <jsp:include page="2.jsp"></jsp:include>
      <%=request.getAttribute("name")%>
      <%=i%>
      <jsp:include page="3.jsp"></jsp:include>
      <%=request.getAttribute("hello")%>
      <%=i%>
</body>
</html>
