<%--
  Created by IntelliJ IDEA.
  User: baich
  Date: 2018/5/8
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!--对c 标签的支持-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑用户</title>
    <style type="text/css">
        #hezi {margin: 36px 400px 0px 400px;border: red 1px solid;height:600px}
        #hezi input {margin: 40px auto;}

    </style>
</head>


<body>

<!-- 更改数据的 编辑器-->
<div id="hezi">
<form action="/chen/up" name="user" method="post">
    id:<input type="hidden" name="id" value="${c.id }" />
    姓名:<input type="text" name="name" value="${c.name }" />
    qq:<input type="text" name="qq" value="${c.qq }" />
    科目:<input type="text" name="kemu" value="${c.kemu}">
    入学时间:<input type="text" name="startTime" value="${c.startTime}"/>
    学校:  <input type="text" name="school" value="${c.school}">
    学号:  <input type="text" name="xuehao" value="${c.xuehao}">
    日报:   <input type="text" name="ribao" value="${c.ribao}">
    心愿:   <input type="text" name="xinyuan" value="${c.xinyuan}">
    师兄:   <input type="text" name="shixiong" value="${c.shixiong}">
    <input type="submit" value="更改"  />

</form>
</div>


</body>
</html>
