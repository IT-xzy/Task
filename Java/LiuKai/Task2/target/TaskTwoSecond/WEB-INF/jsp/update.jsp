<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/students" method="post">
    <input type="hidden" value="${stu.id}" name="id">
姓名:<input type="text"  name="stuName" value="${stu.stuName }" >
课程:<input type="text" name="course" value="${stu.course }">
<input type="submit" value="提交">
    <input type="hidden" value="put" name="_method">
</form>
</body>
</html>
