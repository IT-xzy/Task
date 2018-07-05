<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/4/29
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width:500px;margin:0px auto;text-align:center">


    <div style="text-align:center;margin-top:40px">

        <form method="post" action="../${c.stuId}">
            学员资料： <br><br>
            姓名：<input name="stuName" value="${c.stuName}" type="text"> <br><br>
            QQ：<input name="stuQQ" value="${c.stuQQ}" type="text"> <br><br>
            修真类型：<input name="stuType" value="${c.stuType}" type="text"> <br><br>
            学号：<input name="stuNum" value="${c.stuNum}" type="text"> <br><br>
            <input name="update_at" value="${c.update_at}" type="hidden"> <br><br>
            <input type="hidden" value="${c.stuId}" name="stuId">
            <input type="submit" value="更新学员信息">
        </form>

    </div>
</div>

</body>
</html>
