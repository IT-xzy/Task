<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/18
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学员</title>
</head>
<body>
页面一 ${check}
<form action="/student" method="post">
    学生姓名：<input type="text" name="uname"/><br/>
    学生性别：<input type="text" name="usex"/><br/>
    <input type="submit" name="注册" value="添加学员">
</form>
</body>
</html>