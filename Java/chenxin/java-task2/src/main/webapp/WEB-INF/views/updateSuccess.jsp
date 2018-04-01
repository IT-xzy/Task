<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>更新成功页面</title>
</head>
<body>
<hr>
<br>
<br>
<br>
<br>
<form action="/test/students" method="get">
    <input type="submit" value="返回主页">
</form>
姓名为：${requestScope.student.name}，的学生信息更新成功。
</body>
</html>