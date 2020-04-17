package day1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//servlet
public class Hello extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //解决乱码
          resp.setContentType("text/html;charset=UTF-8");
          PrintWriter out =resp.getWriter();
//        out.println("<h1>Hello,World!</h1>");
          out.write(req.getRemoteAddr()+",端口号:"+req.getRemotePort()+"访问");
    }
}
