<%--
  Created by IntelliJ IDEA.
  User: ysf
  Date: 2020/4/21
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%--jsp指令
  isErrorPage="true" 表示服务器出现5XX异常问题，指定跳转到此标志的页面上
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
  import="java.util.*,java.lang.*"
  pageEncoding="UTF-8"
  buffer="8kb" autoFlush="true"
  isErrorPage="true"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--jsp注释:客户端看不到
    --%>
    <!--静态的HTML-->
    <h1>jsp页面元素</h1>

    <%--jsp脚本：java代码--%>
    <%
        //属性
        int num=10;
        System.out.println("this is java code!");
    %>
    <%--jsp表达式--%>
    <%=num %>
    <%="hello,jsp!"%>
    <%--等价于--%>
    <%out.print(num);%>

    <%--jsp声明--%>
    <%!
     int a=30;
     public static void myMethods(){
         System.out.println("这是我的方法！");
     }
    %>

    <hr>
   <%--打印hello4次--%>
   <%
    int[] arr={1,3,4,3};
    System.out.println(Arrays.toString(arr));

    for(int i=0;i<4;i++){
   %>
    <h1>hello<%=i%></h1>
   <%}%>
</body>
</html>
