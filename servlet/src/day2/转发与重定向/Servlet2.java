package day2.转发与重定向;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是servlet2方法..");
        //getAttribute()用于服务器端传递数据
        System.out.println("servlet2收到的参数为:" + req.getAttribute("hello"));
        //getParameter()获取客户端参数
        System.out.println(req.getParameter("name"));
         //服务器端出现错误
           int num=1/0;
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("servlet2已经处理完客户端请求!!!");
    }
}
