<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/12
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>测试</title>
</head>

<body>
<form action="/category" method="post">
    <input type="hidden" name="_method" value="PUT">
    <fieldset>
    <h1>查询结果</h1>
        姓名 ：<input type="text"  name="userName" value="${user.userName}"><br/>
        年龄 ：<input type="text"  name="age" value="${user.age}"><br/>
        体重 ：<input type="text"  name="weight" value="${user.weight}"><br/>
        update_at ：<input type="text"  name="updateAt" value="${user.updateAt}"><br/>
    <input  id="submit" type="submit" value="提交">
        <input type="hidden"  name="id" value="${user.id}"><br/>
        <input type="hidden"  name="createAt" value="${user.createAt}"><br/>
    </fieldset>
</form>
</body>
</html>
