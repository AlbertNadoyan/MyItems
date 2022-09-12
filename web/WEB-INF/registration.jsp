<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12.09.2022
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
%>
<% if(msg != null){ %>
<p style="color: red"><%=msg%></p>
<% } %>
<form action="/registration" method="post">
    <input type="text" name="name" placeholder="input name"><br>
    <input type="text" name="surname" placeholder="input surname"><br>
    <input type="email" name="email" placeholder="input email"><br>
    <input type="password" name="password" placeholder="input password"><br>
    <input type="submit" value="Registration"><br>
</form>

</body>
</html>
