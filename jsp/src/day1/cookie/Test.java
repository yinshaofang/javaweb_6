package day1.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath=req.getContextPath();
        String servletPath=req.getServletPath();
        String urlPath=req.getRequestURI();
        System.out.println("应用路径:" + contextPath + ",url-pattern路径:" + servletPath + ",url路径:" + urlPath);

        //对cookie进行增删改查
        if(urlPath.contains("add")){
           add(req,resp);
        }else if(urlPath.contains("select")){
           select(req,resp);
        }else if(urlPath.contains("modify")){
           modify(req,resp);
        }else if (urlPath.contains("delete")){
           delete(req,resp);
        }
    }
    //删除
    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        Cookie c=new Cookie("tel","aaa");
        c.setPath("/jsp/day1");//路径相同 否则改不了
        c.setMaxAge(0); //设置0 不能存活===删除
        resp.addCookie(c);
    }

    //修改
    private void modify(HttpServletRequest req, HttpServletResponse resp) {
        Cookie c=new Cookie("name","zhangsan");
        resp.addCookie(c);
    }

    //查询
    private void select(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] arr=req.getCookies();
        for(Cookie c:arr){
            System.out.println(c.getName() + "=" + c.getValue());
        }
    }
    //增加
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        //创建对象
        Cookie c=new Cookie("name","Tom");
        resp.addCookie(c);//响应给客户端

        c=new Cookie("pass","123");
        //设置路径
        c.setPath("/jsp/day1/exception");
        resp.addCookie(c);//兄弟路径下的cookie响应给客户端，客户端是存储不了

        c=new Cookie("tel","1356");
        c.setPath("/jsp/day1");//设置当前包路径或父包路径下，客户端是可以存储的
        resp.addCookie(c);

    }
}
