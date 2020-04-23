package day2.转发与重定向;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是servlet1方法...");
        //request对象是一个作用域：作用范围：是一次请求
        req.setAttribute("hello","这是servlet1设置的值");
        //重定向 客户端自动提交
       // resp.sendRedirect("/servlet/day2/s2");
        //转发(服务内部转发)
        req.getRequestDispatcher("/day2/s2").forward(req,resp);
    }
}
