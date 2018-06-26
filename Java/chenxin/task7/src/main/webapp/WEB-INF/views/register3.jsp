<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/23
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${result == 'true'}">
    <p style="color: red">验证成功！</p><br>
<form:form action="/registration/registerProcess" method="post">
    确认注册<input type="submit"></input>
    <%--<a href="/registerProcess">确认注册</a>--%>
</form:form>

</c:if>
<c:if test="${result == 'false'}">
    请重新验证。
</c:if>
</body>
</html>
