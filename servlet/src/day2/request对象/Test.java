package day2.request对象;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

public class Test extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //乱码
      req.setCharacterEncoding("utf8");
      //获取用户名
      System.out.println("姓名:"+req.getParameter("uname"));
      //获取多个value值
      System.out.println(Arrays.toString(req.getParameterValues("hobbies")));

      System.out.println("获取应用名路径:"+req.getContextPath());

      System.out.println("获取url-pattern路径:"+req.getServletPath());

      System.out.println("获取地址栏url:"+req.getRequestURL());

      System.out.println(req.getRequestURI());//jsp中表单提交常用这样方法   /servlet/day2/request

      System.out.println(req.getRemoteAddr()+",端口号:"+req.getRemotePort());

      //服务器内部传递数据（作用范围在一次请求中）
      req.setAttribute("hello","你好！");
      req.setAttribute("china","中国");
      System.out.println(req.getAttribute("hello"));

      //遍历枚举(key)
        Enumeration<String> e=req.getAttributeNames();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

      //获取请求行信息
        System.out.println(req.getMethod());//post
        System.out.println(req.getProtocol());//HTTP/1.1

      //请求头
      Enumeration<String> e1=req.getHeaderNames();
      while (e1.hasMoreElements()){
          System.out.println(e1.nextElement());
      }

      //响应字符流
        PrintWriter out=resp.getWriter();
        out.write("<h1>this is my info</h1>");


    }
}
