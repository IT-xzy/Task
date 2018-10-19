<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<json:object>
    <json:array name="students" var="student" items="${students}">
        <json:object>
            <json:property name="studentName" value="${student.studentName}"/>
            <json:property name="qq" value="${student.qq}"/>
            <json:property name="learnType" value="${student.learnType}"/>
            <json:property name="joinTime" value="${student.joinTime}"/>
            <json:property name="school" value="${student.school}"/>
            <json:property name="studentID" value="${student.studentID}"/>
            <json:property name="link" value="${student.link}"/>
            <json:property name="motto" value="${student.motto}"/>
            <json:property name="brother" value="${student.brother}"/>
            <json:property name="knowFrom" value="${student.knowFrom}"/>
        </json:object>
    </json:array>
</json:object>


<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>后台管理</title>--%>
    <%--<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">--%>
    <%--<script src="http://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<input class="btn" type="button" value="btn">--%>
<%--<script>--%>
    <%--$(document).ready(function () {--%>
        <%--function ajax() {--%>
            <%--$.ajax({--%>
                <%--url:"/students",--%>
                <%--success:function (${students}) {--%>
                    <%--alert(name)--%>
                <%--}--%>
            <%--})--%>
        <%--}--%>

        <%--$(".btn").click(function () {--%>
            <%--ajax();--%>
        <%--})--%>
    <%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
