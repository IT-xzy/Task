<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/7
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>

<%--设定网页的信息，语言为java语言，引用jar包，页面编码是utf-8--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改结果</title>
</head>

<body>
<form>
    <h1>修改结果</h1>
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