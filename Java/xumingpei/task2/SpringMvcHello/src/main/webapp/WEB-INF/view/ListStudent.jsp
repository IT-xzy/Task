<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/1/8
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  isErrorPage="true" pageEncoding="UTF-8" language="java" import="java.util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page isELIgnored="false"%>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function(){
        $(".delete").on("click", function(){
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>
<form id="formdelete" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

<html>
<head>
    <title>学生列表</title>
</head>
<form method="get" action="/students/name">
    <input type="text" name="name" placeholder="请输入姓名">
    <input type="submit" value="根据姓名查询">
</form>
<body>
<a href="/new/student">添加用户</a>
<div style="width:500px;margin:0px auto;text-align:center">
<table align='left' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>qq</td>
        <td>type</td>
        <td>enrolmentTime</td>
        <td>school</td>
        <td>onlineId</td>
        <td>dailyUrl</td>
        <td>wish</td>
        <td>brother</td>
        <td>whereToKnowJnshu</td>
        <td>create_at</td>
        <td>update_at</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.type}</td>
            <td>${student.enrolmentTime}</td>
            <td>${student.school}</td>
            <td>${student.onlineId}</td>
            <td>${student.dailyUrl}</td>
            <td>${student.wish}</td>
            <td>${student.brother}</td>
            <td>${student.whereToKnowJnshu}</td>
            <td>${student.getcreateAt()}</td>
            <td>${student.getupdateAt()}</td>
            <td><a href="students/${student.id}">编辑</a></td>
            <td><a class="delete" href="/student/${student.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<div style="text-align:center">
    <a href="http://localhost:8080/students?start=0">返 回</a>
    <a href="?start=0">首 页</a>
    <c:if test="${page.start-page.count>=0}">
    <a href="?start=${page.start-page.count}">上一页</a>
    </c:if>
    <c:if test="${page.start-page.count<0}">
        <a href="javascript:void(0)"></a>
    </c:if>

    <c:if test="${page.start+page.count<=page.last}">
    <a href="?start=${page.start+page.count}">下一页</a>
    </c:if>
    <c:if test="${page.start+page.count>page.last}">
        <a href="javascript:void(0)"></a>
    </c:if>

    <a href="?start=${page.last}">末 页</a>
</div>
<%--<div style="text-align:center;margin-top:40px">--%>

    <%--<form method="post" action="students">--%>
        <%--名字：    <input name="name"  type="text"> <br><br>--%>
        <%--qq:      <input name="qq"  type="text"> <br><br>--%>
        <%--修真类型：<input name="type"  type="text"> <br><br>--%>
        <%--入学时间：<input name="enrolmentTime"  type="text"> <br><br>--%>
        <%--毕业院校：<input name="school"  type="text"> <br><br>--%>
        <%--线上学号：<input name="onlineId"  type="text"> <br><br>--%>
        <%--日报连接：<input name="dailyUrl"  type="text"> <br><br>--%>
        <%--入门誓言：<input name="wish"  type="text"> <br><br>--%>
        <%--入门师兄：<input name="brother"  type="text"> <br><br>--%>
        <%--了解渠道：<input name="whereToKnowJnshu"  type="text"> <br><br>--%>
        <%--创建时间：<input name="createAt"  type="text"> <br><br>--%>
        <%--更新时间：<input name="updateAt"  type="text"> <br><br>--%>
        <%--<input type="submit" value="增加分类">--%>
    <%--</form>--%>
<%--</div>--%>
</div>
</body>
</html>
