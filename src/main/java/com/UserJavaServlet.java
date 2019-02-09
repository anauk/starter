package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/hello")
public class UserJavaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserJava tom = new UserJava("Tom", 25);
        req.setAttribute("user",tom);
        try {
            getServletContext().getRequestDispatcher("./src/main/webapp/userJava.jsp")
                    .forward(req, resp);
        } catch (NullPointerException e){
            System.out.println("Empty");
        }
    }
}
