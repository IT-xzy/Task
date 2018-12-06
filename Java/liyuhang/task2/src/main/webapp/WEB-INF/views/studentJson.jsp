<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/22
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page isELIgnored="false"%>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function(){
        $(".delete").click(function(){
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>
<form id="formdelete" action="" method="POST" >
    <input type="hidden" name="_method" value="DELETE">
</form>
<a href="/student">返回首页</a>
<html>
<head>
    <title>学生管理界面</title>
</head>

<body>
<json:object>
</json:object>
<json:array name="students" var="student" items="${students}">
    <json:object>
        <json:property name="ID" value="${student.id}"/>
        <json:property name="学生学号" value="${student.studentNumber}"/>
        <json:property name="学生名字" value="${student.name}"/>
        <json:property name="企鹅号" value="${student.qq}"/>
        <json:property name="入学誓言" value="${student.wish}"/>
        <json:property name="毕业院校" value="${student.school}"/>
        <json:property name="入学时间" value="${student.enrolmentTime}"/>
        <json:property name="修真类型" value="${student.type}"/>
        <json:property name="了解渠道" value="${student.knowFrom}"/>
        <json:property name="创建时间" value="${student.createAt}"/>
        <json:property name="更新时间" value="${student.updateAt}"/>
    </json:object>
</json:array>
<table border="1">
    <tbody>
    <tr>
        <td>ID</td>
        <td>学生学号</td>
        <td>名字</td>
        <td>企鹅号</td>
        <td>入门宣言</td>
        <td>毕业院校</td>
        <td>入学时间</td>
        <td>修真类型</td>
        <td>了解途径</td>
        <td>创建时间</td>
        <td>更新时间</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.studentNumber}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.wish}</td>
            <td>${student.school}</td>
            <td>${student.enrolmentTime}</td>
            <td>${student.type}</td>
            <td>${student.knowFrom}</td>
            <td>${student.createAt}</td>
            <td>${student.updateAt}</td>
            <td><a href="/student/${student.id}">编辑</a></td>
            <td><a class="delete" href="/student/${student.id}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
