<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/26
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证验证码</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/u/a/verifycode" method="post" align="center">
<table align="center" border="1" cellspacing="0">
    <tr>
        <td align="right"><font color="red">*</font><strong>手机号码:</strong></td>
        <td align="left" name="telephone">${telephone}</td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>验证码</strong></td>
        <td align="left"><input type="text" name="code" style="background-color:LavenderBlush"></td>
    </tr>
</table>
    <div align="center"><input type="submit" value="确认绑定" ></div>
</form>
</body>
</html>
