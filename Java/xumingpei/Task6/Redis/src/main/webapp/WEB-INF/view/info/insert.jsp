<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<div style="text-align:center;margin-top:40px">
    <form method="post" action="/u/student">
        学生名字：<input name="name"  type="text"> <br><br>
        学生介绍: <input name="introduction"  type="text"> <br><br>
        学生岗位：<input name="position"  type="text"> <br><br>
        学生头像：<input name="img"  type="text"> <br><br>
        学生薪水：<input name="salary"  type="text"> <br><br>
        就业状态：<input name="status"  value="0" type="hidden"> <br><br>
        <input name="createAt" value="<%=System.currentTimeMillis()%>" type="hidden"> <br><br>
        <input name="updateAt" value="<%=System.currentTimeMillis()%>" type="hidden"> <br><br>
        <input name="createBy"  value="xmp" type="hidden"> <br><br>
        <br>
        <input type="submit" value="添加">
    </form>
</div>
</body>
</html>
