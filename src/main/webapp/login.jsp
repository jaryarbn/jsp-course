<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String msg=(String)request.getAttribute("msg"); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>用户登录界面</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1>用户登录</h1>
   <hr/>
   <form action="<%=request.getContextPath()%>/login.user" method="post">
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
   </table>
   <input type="submit" value="登录">
   </form>
   <h1 style="color: red;"><%=msg!=null?msg:"" %></h1>
   <a href="<%=request.getContextPath()%>/show.goods">返回</a>
  </body>
</html>
