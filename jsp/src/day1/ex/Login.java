package day1.ex;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //获取参数
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        String rm=req.getParameter("rm");
        System.out.println("name="+name+",pass="+pass+",rm="+rm);
         //判断用户名或密码是否正确
       if(!("zhangsan".equals(name)&&"123".equals(pass))){
          req.setAttribute("errMsg","用户名或密码错误！");
          //转发 request对象是一个
          req.getRequestDispatcher("/day1/demo4/login.jsp").forward(req,resp);
          return;
       }
       //判断rm是否为空
        if(rm!=null){
            Cookie n=new Cookie("name",name);
            Cookie p=new Cookie("pass",pass);
            //设置七天免登陆时间
            n.setMaxAge(7*24*60*60);
            p.setMaxAge(7*24*60*60);
            //响应到客户端
            resp.addCookie(n);
            resp.addCookie(p);
        }
        //重定向到成功页面
         resp.sendRedirect(req.getContextPath()+"/day1/demo4/success.jsp");
    }
}
