package day2.url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UrlServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String name=req.getParameter("name");
          String pass=req.getParameter("pass");
          System.out.println("用户名:" +name+",密码:"+pass);

          //获取session
          HttpSession session= req.getSession();//禁用cookie没有sessionid  就创建了session
          session.setAttribute("name",name);
          //获取sessionId
          String id=session.getId();
          System.out.println("sessionId="+id);

          //重定向 禁用cookie重定向不起作用
          //resp.sendRedirect(req.getContextPath()+"/day2/url/2.jsp");

          //方法一:把sessionid拼接到请求地址
          //resp.sendRedirect(req.getContextPath()+"/day2/url/2.jsp"+";jsessionid="+id);

          //方法二:encodeURL()：返回一个新的字符串
          resp.sendRedirect(resp.encodeURL(req.getContextPath()+"/day2/url/2.jsp"));
    }
}
