<%--
  Created by IntelliJ IDEA.
  User: G510
  Date: 2018/3/30
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>更新信息</title>
</head>
<br>
<h1>学生信息</h1>
<form action="${pageContext.request.contextPath}/ssm/student/${up.id}" name="sd" method="post">
    姓名:<input name="name" type="text" value="${up.name}" required="required"></br>
    年龄:<input name="age" type="text" value="${up.age}" required="required"></br>

    <input type="submit" value="更新">


</form>
</body>
</html>