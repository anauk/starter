package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] users = new String[]{"Tom", "Bob", "Adam"};
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/src/main/webapp/user.jsp").forward(req, resp);
        /*List<String> users = new ArrayList<String>();
        Collections.addAll(users, "Tom", "Bob", "Rita");
        req.setAttribute("users", users);*/
    }
}
