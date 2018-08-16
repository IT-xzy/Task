<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/2
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
</head>

<body>
${message}
<br><a href="${pageContext.request.contextPath}/u/personal">返回个人信息页面</a>
<br>--------------------------------------------
<br><a href="${pageContext.request.contextPath}/">重输验证码</a>

<br>--------------------------------------------

<br>${loginMessage}
<br><a href="${pageContext.request.contextPath}/logout">返回登录页面</a>
</body>
</html>
