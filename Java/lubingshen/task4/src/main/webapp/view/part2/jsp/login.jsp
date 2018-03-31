<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<div style="width:1800px;margin:0px auto;text-align:center">
    <font color="blue" size="5" >请先完成登录操作</font><br/>
    <form method="POST" action="/login"><!--指向的是路径名称-->
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="userName" value=""/></td>
            </tr>

            <tr>
                <td>密码</td>
                <td><input type="password" name="userKey" value=""/></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="登录"/>
                </td>
            </tr>
        </table>
    </form>
    <a href="/registration">没有账号？点击注册</a>
    <a href="/task4/home">返回技能树</a>
</div>
</body>
</html>
