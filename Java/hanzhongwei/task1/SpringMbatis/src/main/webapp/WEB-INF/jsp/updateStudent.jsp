<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/4/23
  Time: 14:15
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

        <form method="post" action="updateStudent">
            学员资料： <br><br>
            姓名：<input name="s_name" value="${c.s_name}" type="text"> <br><br>
            QQ：<input name="s_qq" value="${c.s_qq}" type="text"> <br><br>
            修真类型：<input name="s_type" value="${c.s_type}" type="text"> <br><br>
            学号：<input name="s_num" value="${c.s_num}" type="text"> <br><br>
            <input name="update_at" value="${c.update_at}" type="hidden"> <br><br>
            <input type="hidden" value="${c.s_id}" name="id">
            <input type="submit" value="更新学员信息">
        </form>

    </div>
</div>
</body>
</html>
