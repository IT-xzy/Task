<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/25
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>邮箱绑定</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>


<c:choose>
    <c:when test="${empty email}">
        <form action="email" method="post">
            <input type="hidden" name="name" value="${sessionScope.get("name")}">
            <p>邮箱<input name="email" type="text"><br/>
                <input type="submit" value="邮箱验证"><br/>
            </p>
        </form>
    </c:when>
    <c:otherwise>
        ${email} ${result.msg}
        <a href="people">返回首页</a>
    </c:otherwise>
</c:choose>
</body>
</html>

