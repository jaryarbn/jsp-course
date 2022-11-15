<%--
  Created by IntelliJ IDEA.
  User: jyb
  Date: 2022/11/15
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录</title>
</head>
<body>
<label for="username"></label><input type="text" id="username" name="username" placeholder="请输入用户名"/>
<label for="password"></label><input type="password" id="password" name="password" placeholder="请输入用户名"/>
<button type="button" name="loginButton" onclick="loginVerify();">登 录</button>

</body>
</html>

<script>
    function loginVerify() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        if (username == '') {
            alert('用户名不能为空，请您输入！');
            return;
        }
        if (password == ""){
            alert("密码不能为空，请您输入！")
            return;
        }
            }
</script>
