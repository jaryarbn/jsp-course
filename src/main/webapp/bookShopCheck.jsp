<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>已购书信息</title>
</head>
<body>
<jsp:useBean id="cart" scope="session" class="com.github.jaryarbn.BookShopBean"/>
<jsp:setProperty property="*" name="cart"/>
<%
    cart.processRequest(request);
%>
<br>您已选购的书有：
<ol>
    <%
        String[] items = cart.getItems().toArray(new String[0]);
        for (String item : items) {
    %>
    <li><%=item%>
    </li>
    <%} %>
</ol>
<br>
<hr>
<%@include file="bookShop.jsp" %>
</body>
</html>