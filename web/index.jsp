<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="model.Item" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10.09.2022
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    List<Item> itemList = (List<Item>) request.getAttribute("item");
    List<Category> categoryList = (List<Category>) request.getAttribute("category");
%>
<div class="header">
    <div class="siteName">
        <h1>MyItems</h1>
    </div>
    <div class="loginAndRegistration">
        <%
            if (user == null) {
        %>
        <a href="/login">Login</a>
        <a href="/registration">Registration</a>
        <div class="categoriesMenu">
            <a href="/">Main</a>
            <% for (Category category : categoryList) { %>
            <a href="/category?id=<%=category.getId()%>"><%=category.getName()%>
            </a>
            <% } %>
        </div>
        <% } %>
    </div>
</div>

<div class="item">
    <% for (Item item : itemList) { %>
<div class="items">
    <div><%=item.getTitle()%>
    </div>
    <div><%=item.getPrice()%>
    </div>
    <div><%=item.getCatId().getName()%>
    </div>
    <div>
        <img src="/getImage?itemPic=<%=item.getPicUrl()%>" alt="" width="100">
    </div>
    <div><%=item.getUserId().getName()%> <%=item.getUserId().getSurname()%>
    </div>
</div>
    <% } %>
</div>

</body>
</html>
