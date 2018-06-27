<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/3/31
  Time: 下午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>根据姓名查询</title>
</head>
<body>
查询：<br><form action="${pageContext.request.contextPath}/user/allname" method="get">
    输入需要查询的学员的姓名:<input type="text" name="name" ><br>
    <input type="submit" value="查询">
</form><br>
</body>
</html>
