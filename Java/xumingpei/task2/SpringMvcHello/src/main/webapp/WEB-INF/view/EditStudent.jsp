<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/1/8
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<div style="width:500px;margin:0px auto;text-align:center">

    <div style="text-align:center;margin-top:40px">

        <form method="post" action="/students/${student.id}">
            <input type="hidden" name="_method" value="PUT">
            名字：    <input name="name" value="${student.name}" type="text"> <br><br>
            qq:      <input name="qq" value="${student.qq}" type="text"> <br><br>
            修真类型：<input name="type" value="${student.type}" type="text"> <br><br>
            入学时间：<input name="enrolmentTime" value="${student.enrolmentTime}" type="text"> <br><br>
            毕业院校：<input name="school" value="${student.school}" type="text"> <br><br>
            线上学号：<input name="onlineId" value="${student.onlineId}" type="text"> <br><br>
            日报连接：<input name="dailyUrl" value="${student.dailyUrl}" type="text"> <br><br>
            入门誓言：<input name="wish" value="${student.wish}" type="text"> <br><br>
            入门师兄：<input name="brother" value="${student.brother}" type="text"> <br><br>
            了解渠道：<input name="whereToKnowJnshu" value="${student.whereToKnowJnshu}" type="text"> <br><br>
            <input name="createAt" value="${student.getcreateAt()}" type="hidden"> <br><br>
            <input name="updateAt" value="${student.getupdateAt()}" type="hidden"> <br><br>
            <input type="submit" value="增加分类">
        </form>
    </div>
</div>
</body>
</html>
