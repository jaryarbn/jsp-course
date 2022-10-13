<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>在线购书系统</title>
</head>
<body bgcolor="8E8E8E">
<jsp:useBean id="user" scope="page" class="com.example.demo.UserInfoBean" />
<jsp:setProperty property="*" name="user" />
<form action="bookShopCheck.jsp" method="get">
    <hr />
    欢迎访问本网站，尊敬的：<%=user.getUserName()%>
    <hr />
    请选择要购买的图书:
    <hr />
    <label>
        <select name="item">
            <option>《java程序设计与项目实训教程》</option>
            <option>《jsp程序设计技术教程》</option>
            <option>《java程序设计与项目实训教程》</option>
            <option>《java程序设计与项目案例教程》</option>
            <option>《struts+Hibernate+spring3》</option>
            <option>《web框架技术（struts+Hibernate+spring3）教程》</option>
            <option>《java程序设计与项目实训教程Ⅱ》</option>
        </select>
    </label> <br />
    <hr />
    <input type="submit" name="submit" value="购买" />
</form>
</body>
</html>
