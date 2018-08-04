<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="data" uri="WEB-INF/tld/datetag.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/7/13
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" width="50%" height="80%">

    <tr>
        <td><img src="${student.image} " height="100" width="100"/></td>
        <td><h5><a href="../../inputimage.jsp" style="color: navy">上传头像</a></h5></td>
    </tr>
    <tr>
        <td>学号：</td>
        <td>${student.id}</td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td>${student.name}</td>
    </tr>
    <tr>
        <td>入学时间：</td>
        <td><data:date value="${student.creatdate}"/></td>
    </tr>
    <tr>
        <td>修行职业：</td>
        <td>${student.occupation}</td>
    </tr>
    <tr>
        <td>学习状态：</td>
        <td>${student.state}</td>
    </tr>
    <tr>
        <td>邮箱地址：</td>
        <td>${student.email}</td>
    </tr>
    <tr>
        <td>电话号码：</td>
        <td>${student.telephone}</td>
    </tr>
</table>
</body>
</html>
