<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/27
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Date" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
<div style="text-align:center;margin-top:40px">
    <form method="post" action="/u/student">
        <input type="hidden" name="_method"  value="PUT">
        姓名： <input name="name"  type="text"> <br><br>
        学校： <input name="address"  type="text"> <br><br>
        电话： <input name="phone"  type="text"> <br><br>
        <input name="create_up"  type="hidden" value=<%=new Date().getTime()%>> <br><br>
        <input type="submit" value="登记">
    </form>
</div>
</main>
</body>
</html>
