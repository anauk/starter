import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/hello")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameterMap());
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        try {
            writer.println("Hello");
            writer.println("<h2>Does it work</h2>");
            writer.println("<p>Adfshjkddh vnheuirhg ckmsnvhruhgruh vfbs.</p>");
            writer.println("<p>Мипрвтволр сиоыпдурарп.</p>");
        }finally {
            writer.close();
        }
    }
}
