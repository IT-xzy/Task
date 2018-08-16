<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/8/7
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码提交</title>
</head>
<body>
${message}
<form action="${pageContext.request.contextPath}/phoneCode">
    <%--<br>用户名：<input type="text" name="username">--%>
    <%--<br>手机号：<input type="text" name="phone">--%>
    <br>手机验证码:<input type="text"name="phoneCode">
    <br><input type="submit" value="绑定提交">
</form>

<form action="${pageContext.request.contextPath}/emailCode">
    <%--<br>用户名：<input type="text" name="username">--%>
    <%--<br>邮箱号：<input type="text" name="email">--%>
    <br>邮箱验证码：<input type="text" name="emailCode">
    <br><input type="submit" value="提交">
</form>


<form action="${pageContext.request.contextPath}/phoneModifyResult">
    <%--<br>用户名：<input type="text" name="username">--%>
    <br>手机号：<input type="text" name="newPhone">
    <br>手机验证码:<input type="text"name="phoneCode">
    <br><input type="submit" value="修改提交">
</form>

<br><a href="${pageContext.request.contextPath}/u/personal">返回个人信息页面</a>
</body>
</html>
