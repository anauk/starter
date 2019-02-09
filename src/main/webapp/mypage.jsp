<%-- My first app --%>
<%@page import="com.Calculator" %>
<%-- подключили java class --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String header = "Users:";
    String[] list = new String[]{"Masha", "Kola", "Lera"};
%>
<html>
<head>
    <title>Devcolibri.com</title>
</head>
<body>
<h1>Hello ${name}</h1>
<p>Todat <%= new java.util.Date() %></p>
<h2><%= header %></h2>
<ul>
    <%
        for(String user:list){
            System.out.println("<li>"+ user+"</li>");
        }
    %>
</ul>
<jsp:include page = "index.html"/>
</body>
</html>