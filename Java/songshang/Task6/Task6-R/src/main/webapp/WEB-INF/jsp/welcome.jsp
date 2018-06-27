<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<a href="${ctx}/students">学员列表</a><br/>
<a href="${ctx}/student">单个学员</a><br/>
<a href="${ctx}/student/register">添加学员</a><br/>
<a href="${ctx}/student/modify">更新学员</a><br/>
<a href="${ctx}/studentsJson">Json接口</a>
<a href="${ctx}/Cache">清空缓存</a>
<a href="${ctx}/JsonTag">JsonTag</a>
<form action="${pageContext.request.contextPath }/student" method="post">
    <br>账号<input type="text" name="name">
    <input type="submit" name="注册">
</form>
</body>
</html>