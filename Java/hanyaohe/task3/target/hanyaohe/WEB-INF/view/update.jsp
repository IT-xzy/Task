<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="text-align: center">
<h2 style="text-align: center">编辑学员</h2>


<form action="${pageContext.request.contextPath}/student/${student.id}" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <br>姓名<input type="text" name="name" value="${student.name}"/>
   <br>QQ<input type="text" name="qq" value="${student.qq}"/>
    <br>主修<input type="text" name="major" value="${student.major}"/>
    <input type="submit" value="改好啦">

</form>






</body>
</html>
