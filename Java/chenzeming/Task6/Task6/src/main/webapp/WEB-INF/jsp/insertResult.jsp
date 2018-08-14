<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/8/1
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加结果</title>
</head>

<body>
<form>
    <h1>添加结果</h1>
    学号 ：${user.id}<br>
    姓名 ：${user.userName}<br>
    年龄 ：${user.age}<br>
    体重 ：${user.weight}<br>
    create_at:${user.createAt}<br>
    update_at:${user.updateAt}
    <%--shfslaf:${userr.id}--%>
</form>
</body>
</html>