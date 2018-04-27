<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/13/013
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/fuck/${student.id}" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="text" name="name"/>
    <input type="submit" value="修改"/>
 </form>
</body>
</html>
