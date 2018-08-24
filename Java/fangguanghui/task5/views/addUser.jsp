<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/6/4
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
    <title>添加用户界面</title>
</head>
<body>
<h2>添加用户</h2>
    <form action="${pageContext.request.contextPath}/users/newuser" name="userForm" method="post" >
        <fieldset>
            <legend>用户详细</legend>
        <p><label for="username">用户姓名</label>
            <input type="text" name="username" id="username"　/></p>

        <p><label for="QQ">用户QQ</label>
            <input type="text" name="QQ" id="QQ"　/></p>

        <p><label for="type">修真类型</label>
            <input type="text" name="type" id="type"　/></p>

        <p><label for="joinTime">入学时间</label>
            <input type="text" name="joinTime" id="joinTime" /></p>

        <p><label for="school">毕业院校</label>
            <input type="text" name="school" id="school" autocomplete="off"/></p>

        <p><label for="onlineId">网上学号</label>
            <input type="text" name="onlineId" id="onlineId" autocomplete="off"/></p>

        <p><label for="daily">日报链接</label>
            <input type="text" name="daily" id="daily" autocomplete="off"/></p>

        <p><label for="description">入学宣言</label>
            <input type="text" name="description" id="description" autocomplete="off"/></p>

        <p><label for="counsellor">辅导师兄</label>
            <input type="text" name="counsellor" id="counsellor" autocomplete="off"/></p>

        <p><label for="way">了解途径</label>
            <input type="text" name="way" id="way" autocomplete="off"/></p>

        <p><label for="create_at">创建时间</label>
            <input  name="create_at" id="create_at" autocomplete="off"/></p>

        <p><label for="update_at">更新时间</label>
            <input  name="update_at" id="update_at" autocomplete="off"/></p>

        <p><label for="create_by">创建人员</label>
            <input  name="create_by" id="create_by" autocomplete="off"/></p>

        <p><label for="update_by">创建人员</label>
            <input  name="update_by" id="update_by" autocomplete="off"/></p>

        <p><input type="submit" value="添加">&emsp;&emsp;&emsp;
            <a href="${pageContext.request.contextPath}/users">返回列表</a>
        </fieldset>
</form>
</body>
</html>
