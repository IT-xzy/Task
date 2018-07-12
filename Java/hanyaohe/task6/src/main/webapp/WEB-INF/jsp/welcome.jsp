<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/students">学员列表</a><br/>
<a href="${pageContext.request.contextPath}/student/add">添加学员</a><br/>
<a href="${pageContext.request.contextPath}/student/modify">更新学员</a><br/>
<a href="${pageContext.request.contextPath}/studentsJson">Json接口</a>
<a href="${pageContext.request.contextPath}/Cache">清空缓存</a>
<a href="${pageContext.request.contextPath}/JsonTag">JsonTag</a>
<form action="${pageContext.request.contextPath }/student" method="post">
    <br>账号<input type="text" name="name">
    <input type="submit" name="注册">
</form>
</body>
</html>
