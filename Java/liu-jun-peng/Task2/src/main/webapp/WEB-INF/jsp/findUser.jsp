<%--
  Created by IntelliJ IDEA.
  User: liujunpeng
  Date: 2018/5/24
  Time: 下午2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>查找用户</title>
</head>
<body>
<h1>查找用户</h1>
<form action="" name="userForm">
    序号：<input type="text" name="id"><br>
    <input type="button" value="查找"
           onclick="getUser()">
</form>
<script type="text/javascript">
    function getUser() {
        var form = document.forms[0];
        form.action = "<%=basePath%>demo/getUser";
        form.method = "GET";
        form.submit();
    }
</script>

</body>
</html>
