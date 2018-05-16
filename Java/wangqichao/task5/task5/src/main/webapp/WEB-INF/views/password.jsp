<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/12
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<h2 align="center">请输入修改信息</h2>
<form action="${pageContext.request.contextPath}/changePassword" method="post" align="center">
    <table align="center"  width="800">
        <tr>
            <td align="right" width="300"><font color="red">*</font><strong>原密码:</strong></td>
            <td align="left"  ><input type="password" name="oldpassword" width="400" placeholder="请输入4-16位原密码" style="background-color:LavenderBlush"> </td>
            <td align="left"><font color="red" size="-1"><strong>可使用字母和数字</strong></font></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font><strong>新密码:</strong></td>
            <td align="left"><input type="password"  name="password" placeholder="请输入4-16位密码" style="background-color:LavenderBlush"></td>
            <td align="left"><font color="red" size="-1"><strong>可使用字母和数字</strong></font></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font><strong>确认密码:</strong></td>
            <td align="left"><input type="password" name="repassword"  placeholder="请输入4-16位密码" style="background-color:LavenderBlush"></td>
            <td align="left"><font color="red" size="-1"><strong>务必与新密码相同</strong></font></td>
        </tr>
    </table>
    <%--<input type="hidden" value="PUT" name="_method">--%>
    <div align="center"><input type="submit" value="修改并返回主页" ></div>
    <p style="text-align:center"><a href="${pageContext.request.contextPath}/homepage">放弃修改</a><p/>
</form>
</body>
</html>
