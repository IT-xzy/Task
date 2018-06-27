
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #hezi{margin: 36px 90px;border: black 1px solid;background-color: aquamarine}
        #hezi h3{text-align: center; }
        #hezi input{ border: red 1px solid;margin: 10px 5px;}
    </style>

</head>
<body>

<form action="api" method="post">
    姓名
    <input type="text" name="name" value="">
    qq
    <input type="text" name="qq" value="">
    修真类型
    <input type="text" name="type" value="">
    <%--入学时间
    <input type="date" name="entranceTime" value="">
    毕业学校
    <input type="text" name="school" value="">
    学号
    <input type="text" name="onlineNum" value="">
    日报连接
    <input type="text" name="dailyLink" value="">
    志愿
    <input type="text" name="wish" value="">
    师兄
    <input type="text" name="brother" value="">
    哪里获知
    <input type="text" name="whereKnown" value="">
    创建时间
    <input type="date" name="create_at" value="">
    修改时间
    <input type="date" name="update_at" value="">--%>

    <input type="submit" value="增加">
</form>
<table align="center" border="1px" cellspacing="0">
<tr>
    <td>id</td>
    <td>姓名</td>
    <td>qq</td>
    <td>修真类型</td>
    <td>入学时间</td>
    <td>毕业学校</td>
    <td>学号</td>
    <td>日报连接</td>
    <td>志愿</td>
    <td>师兄</td>
    <td>哪里获知</td>
    <td>创建时间</td>
    <td>修改时间</td>
    <td>删除</td>
    <td>编辑</td>
</tr>

<c:forEach items="${userList}" var ="c" varStatus="st">

    <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td>${c.qq}</td>
        <td>${c.type}</td>
        <td>${c.entranceTime}</td>
        <td>${c.school}</td>
        <td>${c.onlineNum}</td>
        <td>${c.dailyLink}</td>
        <td>${c.wish}</td>
        <td>${c.brother}</td>
        <td>${c.whereKnown}</td>
        <td>${c.create_at}</td>
        <td>${c.update_at}</td>
        <td><a href="/updateUser?id=${c.id}">编辑</a></td>

        <td><a href="/delete?id=${c.id}">删除</a></td>

    </tr>

</c:forEach>
</table>
</body>