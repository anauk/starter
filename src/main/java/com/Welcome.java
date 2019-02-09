package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpHandler;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("I am here!");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<h2>It is work</h2>");
        pw.close();
        /*req.setAttribute("name", "Devcolibri");
        getServletContext().getRequestDispatcher("src/main/webapp/mypage.jsp").forward(req, resp);*/
    }
}
