<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/26
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机绑定</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/u/a/sendcode" method="post" align="center">
    <table align="center"  width="600">
        <tr>
            <td align="right"><strong>验证码</strong></td>
            <td alian="left">${precode}</td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font><strong>输入上方验证码:</strong></td>
            <td align="left"><input type="text" name="precode" style="background-color:LavenderBlush"></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font><strong>手机号码:</strong></td>
            <td align="left"><input type="text" name="telephone" style="background-color:LavenderBlush"></td>
        </tr>
    </table><br/>
    <div align="center"><input type="submit" value="发送验证码" ></div><br/>
    <div align="center"><input type="reset" value="重置" ></div>
</form>
</body>
</html>
