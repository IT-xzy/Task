<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>新增成功页面</title>
</head>
<body>
<hr>
<br>
<br>
<br>
<br>
<form action="/test/students" method="get">
    <input type="submit" value="返回主页">
</form>
姓名为：${requestScope.student.name}，的学生信息新增成功。
id为：${requestScope.student.id}。
请求头信息为：${request.getHeader()}
<%
    Enumeration e = request.getHeaderNames();
    while(e.hasMoreElements()) {
        String key = (String)e.nextElement();
        System.out.print(key);
        System.out.print(": ");
        System.out.print(request.getHeader(key));
        System.out.print("<br> ");
    }
%>
</body>
</html>