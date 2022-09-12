<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12.09.2022
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    User user = (User) session.getAttribute("user");

%>
<% if(msg != null){ %>
<p style="color: red"><%=msg%></p>
<% } %>
<form action="/login" method="post">
    <input type="email" name="email" placeholder="input email"><br>
    <input type="password" name="password" placeholder="input password"><br>
    <input type="submit" value="Sign In">
</form>
</body>
</html>
