<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

查询/修改：<br><form action="${pageContext.request.contextPath}/user/student">
    输入需要查询/修改的学员的ID:<input type="text" name="ID" ><br>
    <input type="submit" value="查询">
</form><br>
<a href="/index.jsp">返回主页</a>
</body>
</html>