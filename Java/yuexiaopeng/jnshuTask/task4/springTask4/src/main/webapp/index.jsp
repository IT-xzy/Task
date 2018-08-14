<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
    <title> Login Home </title>
</head>
<body>
<form action="loginVerify" method="post">
    <table align='center'>
        <tr>
            <td>id:</td>
            <td><input type="text" name="loginId" value=""><br/></td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input type="text" name="loginPassword" value=""><br/></td>
        </tr>

        <tr>
            <td><input type="submit" value="点击登录"></td>
        </tr>
    </table>
</form>
<br/><br/>
<div style="text-align:center">
    <a href="/springTask4/loginRegister">没有账号，请点击注册</a>
</div>
<br/>
<div style="text-align:center">
    <img src="img/shamgod.gif"/>
</div>
<div style="text-align: center">
    <a href="home">点击进入首页</a>
</div>
</body>
</html>
