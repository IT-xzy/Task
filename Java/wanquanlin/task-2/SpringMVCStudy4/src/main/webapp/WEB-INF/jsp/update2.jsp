<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示修改成功或者失败</title>
</head>
<body>

<h2>${message}</h2>
<form action="${pageContext.request.contextPath}/user/student/list" method="get">
    <input type="submit" value="返回查询页">
</form>
<a href="/index.jsp">返回主页</a>
</body>
</html>