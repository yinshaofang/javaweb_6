package day2.servletcontext全局对象;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

//一个应用只有一个servletcontext全局对象，来管理多个servlet对象（相互独立），实现多个servlet对象共享数据
//一次请求对象request（servlet转发，可以共享数据），作用域是一次请求
//生命周期:tomcat启动就产生，Tomcat关闭就销毁
public class ServletContextDemo extends HttpServlet {
    //String name;//服务器端的servlet对象来同时服务多个客户端时，尽量不要设置属性，多线程前提下，共享属性
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取全局对象
        ServletContext ctx=this.getServletContext();

        //作用1:获取应用路径
        System.out.println("获取应用路径："+req.getContextPath());//request对象通过获取全局对象来获取getContextPath()
        System.out.println("获取应用路径："+ctx.getContextPath());

        //作用2:获取全局参数
        //注意:在web.xml中配置全局参数，Tomcat启动扫描web.xml，把这些参数放到全局对象中
        Enumeration<String> e=ctx.getInitParameterNames();
        while (e.hasMoreElements()){
            String key=e.nextElement();
            System.out.println("名字:" + key + ",值:" + ctx.getInitParameter(key));
        }

        //作用3:作为域对象  全局
        //1.重定向中的数据设置
        resp.sendRedirect(ctx.getContextPath()+"/day2/context/scdemo?name=admin&age=22");

        //2、设置
        String[] arr={"username","password"};
        ctx.setAttribute("user",arr);

        System.out.println("servletcontext中获取全局对象的值:");
        String[] users= (String[]) ctx.getAttribute("user");
        for(String u:users){
            System.out.println(u);
        }

        //删除指定的值
       // ctx.removeAttribute("user");


       //作用4:读取资源文件   src目录下的文件内容，全在tomcat对应项目的WEB-INF目录下的classes目录中
       String path=ctx.getRealPath("/WEB-INF/classes/1.txt");
       System.out.println("文件最终路径:" + path);

        //读取文件
        InputStream is=ctx.getResourceAsStream("/WEB-INF/classes/1.txt");
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        System.out.println(br.readLine());//按行
    }

}
