<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/27
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绑定邮箱</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/u/a/sendemail" method="post" align="center">
    <table align="center"  width="600">
        <tr>
            <td align="right"><font color="red">*</font><strong>email:</strong></td>
            <td align="left"><input type="text" name="email" style="background-color:LavenderBlush"></td>
        </tr>
    </table>
    <div align="center"><input type="submit" value="发送链接" ></div>
</form>
</body>
</html>
