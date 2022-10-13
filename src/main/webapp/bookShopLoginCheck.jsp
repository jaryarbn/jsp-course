<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在线购书系统-处理登陆页面</title>
</head>
<body bgcolor="ccc fff">
<jsp:useBean id="user" scope="page" class="com.example.demo.UserInfoBean"/>
<jsp:setProperty property="*" name="user"/>
<%
    if (user.getUserName() == null || user.getPassword() == null) {
%>
<jsp:forward page="bookShopLogin.jsp"/>
<%
    }
    if (user.getUserName().equals("123")) {
        if (user.getPassword().equals("123456")) {
%>
<jsp:forward page="bookShop.jsp">
    <jsp:param name="userName" value="<%=user.getUserName()%>"/>
</jsp:forward>
<%
} else {
%>
<jsp:forward page="bookShopLogin.jsp"/>
<%
    }
} else {
%>
<jsp:forward page="bookShopLogin.jsp"/>
<%
    }
%>
</body>
</html>