<%@ page pageEncoding="UTF-8" %>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>用户注册页面</title>


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
        <tr>
            <td>验证码：</td>
            <td>
                <label for="checkCode"></label><input name="checkCode" type="text" id="checkCode">
                <img id="checkCodeImg" src="<%=request.getContextPath()%>/checkCodeServlet">
                <a href="#" id="changeImg">看不清？</a>
            </td>
        </tr>
    </table>
    <input type="submit" value="注册">
</form>
<script>
    document.getElementById("changeImg").onclick = function () {
        document.getElementById("checkCodeImg").src = "checkCodeServlet?" + new Date().getMilliseconds();
    }
</script>
</body>
<br>
<h1 style="color: red;"><%=msg != null ? msg : "" %>
</h1>
<a href="<%=request.getContextPath()%>/show.goods">返回</a>
<a href="<%=request.getContextPath()%>/login.jsp">已有账号？点击登录</a>
</html>
