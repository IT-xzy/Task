<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="date" class="java.util.Date"/>
<%@ taglib uri="/tags" prefix="zhh"%>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#sign").click(function(){
            document.getElementById("save").style.visibility="visible";
        });
    });
</script>
<html>
<head>
    <title></title>
</head>
<body>
<main>
<form action="/personal" method="post">
    注册手机号:<input type="text" name="phone" value="${c.phone}" readonly="true"><br><br>
    用户名:<input type="text" name="name" value="${c.name}"><br><br>
    注册时间:<zhh:date value="${c.create_at}"/><br><br>
    签名:<input id="sign" type="text" name="sign" value="${c.sign}"><br><br>
    <input type="hidden" name="id" value="${c.id}">
    <input type="hidden" name="password" value="${c.password}">
    <input id="save" type="submit" value="保存" style="visibility: hidden">
</form>
</main>
</body>
</html>
