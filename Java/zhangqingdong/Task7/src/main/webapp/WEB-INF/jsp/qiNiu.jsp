<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/27
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>七牛云全部文件</title>
</head>
<body>
<table border="1">
    <c:forEach items="${qiNiuAllFile}" var="fileName">
        <tr><td>${fileName}</td></tr>
    </c:forEach>
</table>
</body>
</html>
