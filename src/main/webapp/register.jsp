<%@ page language="java" pageEncoding="UTF-8" %>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>用户注册</title>


    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<h1>用户注册</h1>
<hr/>
<form action="<%=request.getContextPath()%>/register.user" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td>
                <label>
                    <input type="text" name="username">
                </label>
            </td>
        </tr>
        <tr>
            <td>密 码:</td>
            <td>
                <label>
                    <input type="password" name="password">
                </label>
            </td>
        </tr>
        <tr>
            <td>电 话:</td>
            <td>
                <label>
                    <input type="text" name="phone">
                </label>
            </td>
        </tr>
        <tr>
            <td>地 址:</td>
            <td>
                <label>
                    <input type="text" name="address">
                </label>
            </td>
        </tr>
    </table>
    <input type="submit" value="注册">
</form>
</body>
<br>
<h1 style="color: red;"><%=msg != null ? msg : "" %>
</h1>
<a href="<%=request.getContextPath()%>/show.goods">返回</a>
</html>
