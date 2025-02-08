<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 08/02/2025
  Time: 00:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Email already exists</p>
    <% } %>
    <form action="register" method="post">
       <input type="text" name="fullName" placeholder="Full Name" required><br>
       <input type="email" name="email" placeholder="Email Address" required><br>
       <input type="password" name="password" placeholder="Password" required><br>
       <button type="submit">Register</button>
    </form>
</body>
</html>
