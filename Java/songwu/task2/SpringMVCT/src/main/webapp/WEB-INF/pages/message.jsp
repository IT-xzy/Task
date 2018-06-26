<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/6/11
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员表</title>
</head>
<body>

<tr>${message}</tr>
<form action="/mvc/page">
    <input type="hidden" name="pageId" value="${pageId}">
    <input type="submit" value="返回">
</form>

<%--<input type="text" name="page" value="1">
<a href="${pageContext.request.contextPath}/mvc/page">提交</a>--%>

</body>
</html>
