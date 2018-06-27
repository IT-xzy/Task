<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/7
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册账户</title>
</head>
<body>
<h2 align="center">请输入注册信息</h2>
<form action="${pageContext.request.contextPath}/doregister" method="post" align="center">
    <table align="center"  width="800">
        <tr>
            <td align="right" width="300"><font color="red">*</font><strong>用户名:</strong></td>
            <td align="left"  ><input type="text" name="username" width="400" placeholder="请输入4-16位用户名" style="background-color:LavenderBlush"> </td>
            <td align="left"><font color="red" size="-1"><strong>以字母开头，可使用字母、数字、下划线</strong></font></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font><strong>密码:</strong></td>
            <td align="left"><input type="password"  name="password" placeholder="请输入4-16位密码" style="background-color:LavenderBlush"></td>
            <td align="left"><font color="red" size="-1"><strong>可使用字母和数字</strong></font></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font><strong>确认密码:</strong></td>
            <td align="left"><input type="password" name="repassword"  placeholder="请输入4-16位密码" style="background-color:LavenderBlush"></td>
            <td align="left"><font color="red" size="-1"><strong>务必与密码相同</strong></font></td>
        </tr>
    </table>
    <%--<input type="hidden" value="PUT" name="_method">--%>
    <div align="center"><input type="submit" value="注册并登陆" ></div>
</form>
</body>
</html>
