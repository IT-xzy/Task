<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="false" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <form action="${path}/land" method="get">
        <input type="submit" value="登陆"/>
    </form>
    <form action="${path}/register" method="get">
        <input type="submit" value="注册"/>
    </form>
</div>
</body>
</html>
