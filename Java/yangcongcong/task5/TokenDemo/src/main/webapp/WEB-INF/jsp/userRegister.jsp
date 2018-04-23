<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/20
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <h3>注册界面</h3>
        <form action="${path}/register" method="post">
            用户名：<input type="text" name="username"/>
            密码：<input type="password" name="password"/>
            <input type="submit" value="注册"/>
        </form>
    </div>
</body>
</html>
