<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加</title>
</head>
<body style="text-align: center">
<h2 style="text-align: center">添加学员</h2>
<form action="${pageContext.request.contextPath}/student" method="post">
<br>姓名<input type="text" name="name" >
   <br>QQ <input type="text" name="qq">
   <br>主修 <input type="text" name="major">
    <input type="submit" value="增加啦">

</form>















</body>
</html>












