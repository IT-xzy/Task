<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/1/17
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body style="text-align: center">
<h2 style="text-align: center">编辑学员</h2>
<%--<form action="${pageContext.request.contextPath }/student/${student.id}" method="post" >--%>
    <%--<input type="hidden" name="_method" value="PUT">--%>
    <%--<br>创建时间<input type="text" name="createAt" value="${student.createAt}" style="text-align: center">--%>
    <%--<br>更新时间<input type="text" name="updateAt" value="${student.updateAt}" style="text-align: center">--%>
    <%--<br>姓名<input type="text" name="name" value="${student.name}" style="text-align: center">--%>
    <%--<br>性别<input type="text" name="sex" value="${student.sex}" style="text-align: center">--%>
    <%--<br>QQ<input type="text" name="qq" value="${student.qq}" style="text-align: center">--%>
    <%--<br>主修<input type="text" name="major" value="${student.major}" style="text-align: center">--%>
    <%--<br>入学时间<input type="text" name="entryTime" value="${student.entryTime}" style="text-align: center">--%>
    <%--<br>来自<input type="text" name="comeFrom" value="${student.comeFrom}" style="text-align: center">--%>
    <%--<input type="submit" value="修改">--%>
<%--</form>--%>
<form action="${pageContext.request.contextPath }/student/${student.id}" method="post" >
    <input type="hidden" name="_method" value="PUT">
    <br>创建时间<input readonly name="createAt" value="${student.createAt}" style="text-align: center">
    <br>更新时间<input readonly name="updateAt" value="${student.updateAt}" style="text-align: center">
    <br>姓名<input type="text" name="name" value="${student.name}" style="text-align: center">
    <br>性别<input type="text" name="sex" value="${student.sex}" style="text-align: center">
    <br>QQ<input type="text" name="qq" value="${student.qq}" style="text-align: center">
    <br>主修<input type="text" name="major" value="${student.major}" style="text-align: center">
    <br>入学时间<input type="text" name="entryTime" value="${student.entryTime}" style="text-align: center">
    <br>来自<input type="text" name="comeFrom" value="${student.comeFrom}" style="text-align: center">
    <br>手机号<input type="text" name="cellphone" value="${student.cellphone}" style="text-align: center">
    <br>邮箱<input type="text" name="email" value="${student.email}" style="text-align: center">
    <br>头像<input type="text" name="headPortrait" value="${student.headPortrait}" style="text-align: center">
    <input type="submit" value="修改">
</form>
</body>
</html>
