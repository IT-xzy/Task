<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%--<div style="width:100%;margin:0px auto;text-align:center">--%>
	<center>
	<form action="/user/session" method="post">
		<table  border="1" cellspacing="0">
			<tr>
				<td>用户名:</td>
				<td><input id="username" name="username" type="text"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input id="password" name="password" type="password"></td>
			</tr>
			<tr  align="center">
				<td colspan="2"><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
	</center>
<%--</div>--%>
</body>
</html>