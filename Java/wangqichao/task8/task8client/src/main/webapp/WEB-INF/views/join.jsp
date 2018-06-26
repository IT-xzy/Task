<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/25
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报名内门</title>
</head>
<body>
<h2 align="center">请输入相关信息</h2>
<form action="${pageContext.request.contextPath}/u/dojoin" method="post" align="center">
<table align="center"  width="600">
    <tr>
        <td align="right"><font color="red">*</font><strong>真实姓名:</strong></td>
        <td align="left"><input type="text" name="name" style="background-color:LavenderBlush"></td>
        <td>请务必输入真实姓名</td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>修行职业:</strong></td>
        <td align="left" size="10">
            <select style="background-color:LavenderBlush" name="profession">
            <option value="java">java</option>
            <option value="web">web</option>
            <option value="ios">ios</option>
            <option value="android">android</option>
            <option value="pm">pm</option>
            <option value="qa">qa</option>
            <option value="ui">ui</option>
            <option value="python">python</option>
            <option value="css">css</option>
            <option value="js">js</option>
            </select>
        </td>
        <td><button type="button"><a href="${pageContext.request.contextPath}/u/profession">了解职业详情</a></button></td>
    </tr>
</table>
    <div align="center"><input type="submit" value="确认加入" ></div>
</form>

</body>
</html>
