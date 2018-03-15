<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>getDate</title>
</head>
<body>
request:${requestScope.message}<br/>
session:${sessionScope.message }<br/>
application:${applicationScope.message}<br/>
<hr/>
<h1>ModelMap中的数据</h1>
${requestScope.message}<br/>
${requestScope.date}<br/>
<p>列表</p>
<c:forEach items="${requestScope.users}" var="u">
    ${u.username }-${u.password }-${u.sex }<br/>
</c:forEach>
</body>
</html>