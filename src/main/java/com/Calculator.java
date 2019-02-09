package com;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.sun.javafx.animation.TickCalculation.add;
import static com.sun.javafx.animation.TickCalculation.sub;

@WebServlet(urlPatterns = "/com.Calculator")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("com.Calculator Hello!");
        int a = Integer.parseInt(req.getParameter("a"));
        System.out.println(a);
        int b = Integer.parseInt(req.getParameter("b"));
        System.out.println(b);
        String[] op = req.getParameterValues("op");
        //op = Character.toString((char)Integer.parseInt(op));
        //43 is +
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        //System.out.println(op);
        PrintWriter writer = resp.getWriter();
        int result1=0, result2=0, result3=0, result4 = 0;
        for (int i = 0; i < op.length; i++) {
            if(op[i].equals("sum")){
                result1 = sum(a,b);
            }
            if(op[i].equals("min")){
                result2 = min(a,b);
            }
            if(op[i].equals("mul")){
                result3 = mul(a,b);
            }
            if(op[i].equals("div")){
                result4 = div(a,b);
            }
        }

        try {
            /*float result=0.00f;
            if ("+".equals(op)) {
                result = (a + b);
            }
            if ("-".equals(op)) {
                result = (a - b);
            }
            if ("*".equals(op)) {
                result = (a * b);
            }
            if ("/".equals(op)) {
                result = (a / b);
            }*/
            //System.out.println("result of "+op+" = "+result);
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title> com.Calculator</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<p>a = " + a + " " + op[0] + " " + "b = " + b + " result " + result1+"</p><br>");
            writer.println("<p>a = " + a + " " + op[1] + " " + "b = " + b + " result " + result2+"</p><br>");
            writer.println("<p>a = " + a + " " + op[2] + " " + "b = " + b + " result " + result3+"</p><br>");
            writer.println("<p>a = " + a + " " + op[3] + " " + "b = " + b + " result " + result4+"</p><br>");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }
    private int min(int a, int b) {
        return a-b;
    }

    private int div(int a, int b) {
        return a/b;
    }

    private int mul(int a, int b) {
        return a*b;
    }

    private int sum(int a, int b) {
        return a+b;
    }
}
