<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/4/11
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索</title>
</head>
<body>
ID查询：<br>
<form action="${pageContext.request.contextPath}/user/list" method="get">
    输入需要查询学员的ID:<input type="text" name="ID" ><br>
    <input type="submit" value="查询">
</form>
<br>
名字查询：<br>
<form action="${pageContext.request.contextPath}/user/nameList" method="get">
    输入需要查询学员的名字:<input type="text" name="name" ><br>
    <input type="submit" value="查询">
</form>
<br>
</body>
</html>
