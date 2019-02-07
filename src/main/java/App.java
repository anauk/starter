import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static void main0(String[] args) throws Exception {
        System.out.println("Hello");
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new Servlet1()),"/admin/*");
        Server server = new Server(80);
        server.setHandler(handler);
        server.start();
        server.join();
    }

    public static void main1(String[] args) throws Exception {
        System.out.println("Calculator");
        ServletContextHandler sh = new ServletContextHandler();
        sh.addServlet(new ServletHolder(new Calculator()), "/admin/*");
        Server server = new Server(80);
        server.setHandler(sh);
        server.start();
        server.join();
    }

    public static void main2(String[] args) throws Exception {
        System.out.println("Welcome!");
        ServletContextHandler sc = new ServletContextHandler();
        sc.addServlet(new ServletHolder(new Welcome()), "/admin/*");
        Server server1 = new Server(80);
        server1.setHandler(sc);
        server1.start();
        server1.join();
    }

    public static void main3(String[] args) throws Exception {
        System.out.println("Forma");
        ServletContextHandler sch = new ServletContextHandler();
        sch.addServlet(new ServletHolder(new Forma()), "/admin/*");
        Server ser = new Server(80);
        ser.setHandler(sch);
        ser.start();
        ser.join();
    }
    public static void main4(String[] args) throws Exception {
        System.out.println("ToForma");
        ServletContextHandler sch = new ServletContextHandler();
        sch.addServlet(new ServletHolder(new ToForma()), "/admin/*");
        Server ser = new Server(80);
        ser.setHandler(sch);
        ser.start();
        ser.join();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Easy method");
        int parametr = 0;
        String name = null;
        try{
            HttpServletRequest req = null;
            parametr = Integer.parseInt(req.getParameter("a"));
            name = req.getParameter("name");

        } catch (Exception e){}
        final int finalParametr = parametr;
        final String finalName = name;
        new Server(80){{
                setHandler(new ServletContextHandler() {{
                               addServlet(new ServletHolder(new HttpServlet() {
                                   @Override
                                   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                                       resp.getWriter().write("what do you want");
                                       resp.setContentType("text/html");
                                       resp.setCharacterEncoding("UTF-8");
                                       PrintWriter writer = resp.getWriter();
                                       writer.println("<h1>I do it "+ finalParametr +" from " + finalName + "</h2>");
                                       System.out.println("Do it in console...!"+finalName);
                                   }
                               }), "/*");
                           }}
                );
                start();
                join();
            }};
    }
}
