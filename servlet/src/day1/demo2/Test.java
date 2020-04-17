package day1.demo2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Test extends HttpServlet{
    protected void 字节流响应乱码(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream out =resp.getOutputStream();
        System.out.println("服务器已回复".getBytes().length);//12  服务器和浏览器默认是gbk解析
        //如果服务器端设置了utf8,告诉浏览器以utf8格式解析字节数组，不然出现乱码
        resp.setHeader("content-type","text/html;charset=utf8");
        out.write("服务器已回复".getBytes("utf-8"));
    }

    protected void 字符响应乱码(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //为什么乱码?--服务器端默认采用iso-8859-1编码格式，把字符流转为多个字节，存储在响应缓冲区中
        //方法一
//        resp.setCharacterEncoding("utf8");//替换iso-8859-1
//        resp.setHeader("content-type","text/html;charset=utf8");//告诉浏览器

        //方法二 推荐
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out =resp.getWriter();
        out.write("服务器端响应数据:");
        out.write("123123123");
    }

    protected void post请求服务器端出现乱码(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post请求出现乱码:服务器默认以iso-8859-1格式解析客户端utf-8格式提交的数据,出现乱码
        req.setCharacterEncoding("utf8");//告诉服务器
        System.out.println("用户名:" + req.getParameter("username"));
    }








    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req:请求对象  Tomcat把客户端的请求参数放在请求对象
        System.out.println("用户名:" + req.getParameter("username")+",密码:"+req.getParameter("pass"));
    }
}
