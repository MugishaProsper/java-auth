<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 08/02/2025
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if (request.getParameter("error") != null){ %>
<p>Invalid email or password</p>
<% } %>
<form action="login" method="post">
    <input type="text" name="email" placeholder="email">
    <input type="password" name="password" placeholder="password">
    <button type="submit">Login</button>
</form>

</body>
</html>