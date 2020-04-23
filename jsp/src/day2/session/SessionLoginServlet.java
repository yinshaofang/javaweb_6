package day2.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 面试题:服务器什么时候会创建session?
 * 1、发起第一次请求，并使用到该session时，服务器则会创建session
 *    注意：jsp中内置对象是session，服务器自动创建对象
 *
 * 2、浏览器30分钟没有刷新，sessionId过期，服务会自动创建session对象
 *
 *
 */
public class SessionLoginServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       String pass=req.getParameter("pass");
       //获取jsp中的session对象  默认参数是true没有session对象创建对象，有就获取，如果参数是false,有就获取对象，没有返回null
        HttpSession session =req.getSession();
        System.out.println(session.getLastAccessedTime());
        //作用域:一次会话
        session.setAttribute("name",name);
        //作用域:一次请求
        req.setAttribute("username",name);
        //全局作用域:全局
        this.getServletContext().setAttribute("uname",name);
        //转发
        req.getRequestDispatcher("/day2/session/success.jsp").forward(req,resp);
    }
}
