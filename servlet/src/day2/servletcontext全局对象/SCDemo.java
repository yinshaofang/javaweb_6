package day2.servletcontext全局对象;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SCDemo extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("scdemo中获取重定向设置参数的值:");
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("age"));
        ServletContext ctx=this.getServletContext();
        String[] users= (String[]) ctx.getAttribute("user");
        System.out.println("scdemo中获取全局对象的值:");
        for(String u:users){
            System.out.println(u);
        }
    }
}
