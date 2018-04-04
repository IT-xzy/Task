<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div style="width:1800px;margin:0px auto;text-align:center">
    <font color="blue" size="5" >请输入你的信息</font><br/>
    <form method="POST" action="/registration"><!--指向的是路径名称-->
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
                <td colspan="2" align="center"><input type="submit" value="注册"/>
                </td>
            </tr>
        </table>
    </form>
    <a href="/login">已有账号？点击登录</a>
    <a href="/task4/home">返回技能树</a>
</div>
</body>
</html>
