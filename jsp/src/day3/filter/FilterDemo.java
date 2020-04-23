package day3.filter;

import javax.servlet.*;
import java.io.IOException;

 //请求购物车页面--》过滤器拦截（检查是否登录、字符编码）--》返回登录页面（用户登录成功）--》过滤器不拦截--》访问购物车模块
public class FilterDemo implements Filter{
    FilterConfig cfg;
    @Override //服务器启动，自动产生Filter实例对象，并调用init初始化方法
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器的init方法被执行...");
        this.cfg=filterConfig;
        System.out.println("获取过滤器的名字:"+cfg.getFilterName());
        System.out.println("获取全局对象:"+cfg.getServletContext());


    }

    @Override//处理过滤
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter方法被执行");

    }

    @Override
    public void destroy() {
        System.out.println("===========过滤器被销毁==========");

    }
}
