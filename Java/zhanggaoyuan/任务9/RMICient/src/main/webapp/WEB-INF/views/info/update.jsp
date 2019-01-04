<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/u/students" method="POST">
    <%--浏览器不支持put的方法，加个隐藏域--%>
    <input type="hidden" name="_method" value="PUT" /><br>
    请输入新增学员的信息:<br>
    要更新的id:<input type="readonly" name="id" value="${id}" readonly>
    <br>
    姓名 :<input type="text" name="name" value="苏正荣">
    <br>
    头像链接 :<input type="text" name="img" value="t10/imges/242424.png">
    <br>
    职位 :<input type="text" name="position" value="Android工程师">
    <br>
    简介 :<input type="text" name="description" value="这是一个。。。">
    <br>
    薪水 :<input type="text" name="salary" value="100">
    <br>
    是否优秀学生 :<input type="checkbox" name="ifExcellent" value="true"><br>
    <br>
    <br>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
