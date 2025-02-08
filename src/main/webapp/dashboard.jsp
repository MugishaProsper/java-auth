<%@ page import="com.webapp.java_auth.models.User" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 08/02/2025
  Time: 02:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");
   if(user == null){
       response.sendRedirect("login.jsp");
       return;
   }
%>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>Welcome back 👋👋👋 <%= user.getFullName() %>!</h1>
<h2>This account is under the email : <%= user.getEmail() %> 💯💯</h2>
<form method="post" action="logout">
    <button type="submit">Logout</button>
</form>
</body>
</html>
