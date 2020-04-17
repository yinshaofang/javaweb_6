package day1.生命周期;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//生命周期
// tomcat容器可以装servlet对象  当客户端发来第一次请求，Tomcat创建servlet对象
public class Test extends HttpServlet {
    @Override //只执行一次初始化
    public void init() throws ServletException {
        System.out.println("执行一次init方法..");
    }

    @Override//多次响应客户请求
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("多次执行service方法...");
        //获取web.xml中的黑名单
        //获取ServletConfig对象
        ServletConfig config=this.getServletConfig();
        System.out.println(config.getInitParameter("blackIP1"));
        Enumeration<String> e=config.getInitParameterNames();
        while (e.hasMoreElements()){
            String name=e.nextElement();
            String value=config.getInitParameter(name);
            System.out.println(name + "=" + value);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override//销毁阶段
    public void destroy() {
        System.out.println("-----------servlet对象销毁---------------");
    }
}
