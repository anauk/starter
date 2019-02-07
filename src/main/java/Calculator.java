import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/Calculator")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Calculator Hello!");
        int a = Integer.parseInt(req.getParameter("a"));
        System.out.println(a);
        int b = Integer.parseInt(req.getParameter("b"));
        System.out.println(b);
        String op = req.getParameter("op");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        try {
            float result=0.00f;
            if ("plus".equals(op)) {
                result = (a + b);
            }
            if ("min".equals(op)) {
                result = (a - b);
            }
            if ("mult".equals(op)) {
                result = (a * b);
            }
            if ("div".equals(op)) {
                result = (a / b);
            }
            System.out.println("result of "+op+" = "+result);
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title> Calculator</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>a = " + a + " " + op + " " + "b = " + b + " result " + result+"</h1");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }
}
