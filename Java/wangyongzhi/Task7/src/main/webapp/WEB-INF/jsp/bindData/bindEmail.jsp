<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<html>
<head>
    <title>绑定邮箱</title>
</head>
<body>
<h2 align="center">绑定邮箱</h2>
<form action="${pageContext.request.contextPath}/u/bindEmail" method="post" align="center">
    <table align="center" width="600">
        <tr>
            <td align="right"><font color="red">*</font><strong>输入邮箱：</strong></td>
            <td align="left"><input type="text" name="email" style="background-color: deepskyblue">
                ${map.warning}</td>
        </tr>
    </table>
    <div align="center"><input  type="submit"  value="确认发送邮件"></div>
</form>
<div align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/showInfo">
    放弃更改</a></button></div>
</body>
</html>
