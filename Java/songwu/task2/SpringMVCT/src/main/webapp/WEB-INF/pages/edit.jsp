<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/6/12
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
修改：<br>
<form action="${pageContext.request.contextPath}/mvc/putUser" method="post">
    编号： <input type="text" name="id" value="${user.id}" size="4">
    姓名<input type="text" name="name" value="${user.name}" size="4">
    QQ：<input type="text" name="qq" value="${user.qq}" size="4">
    修真类型：<input type="text" name="type" value="${user.type}" size="4">
    <input type="hidden" name="pageId" value="${pageId}">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="提交">

</form>

</body>
</html>
