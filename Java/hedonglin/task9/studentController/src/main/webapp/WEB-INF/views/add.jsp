<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/1/17
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>添加</title>
</head>
<body style="text-align: center">
    <h2 style="text-align: center">添加学员</h2>
    <form action="${pageContext.request.contextPath }/student" method="post">
        <br>创建时间<input readonly name="createAt"style="text-align: center">
        <br>更新时间<input readonly name="updateAt" style="text-align: center">
        <br>姓名<input type="text" name="name" style="text-align: center">
        <br>性别<input type="text" name="sex" style="text-align: center">
        <br>QQ<input type="text" name="qq" style="text-align: center">
        <br>主修<input type="text" name="major" style="text-align: center">
        <br>入学时间<input type="text" name="entryTime" style="text-align: center">
        <br>来自<input type="text" name="comeFrom" style="text-align: center">
        <br>手机号<input type="text" name="cellphone" style="text-align: center">
        <br>邮箱<input type="text" name="email" style="text-align: center">
        <br>头像<input type="text" name="headPortrait" style="text-align: center">
    <input type="submit" name="添加"></form>


</body>
</html>
