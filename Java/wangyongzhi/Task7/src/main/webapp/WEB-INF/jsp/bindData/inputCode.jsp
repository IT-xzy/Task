<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<html>
<head>
    <title>输入验证码</title>
</head>
<body>
<h2 align="center">请输入验证码</h2>
<form action="${pageContext.request.contextPath}/u/verifycode" method="post" align="center">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td align="right"><font color="red">*</font><strong>验证码</strong></td>
            <td align="left"><input type="text" name="secureCode" style="background-color:deepskyblue">
                ${map.warning}</td>
        </tr>
    </table>
    <div align="center"><input type="submit" value="确认绑定" ></div>
</form>
</body>
</html>
