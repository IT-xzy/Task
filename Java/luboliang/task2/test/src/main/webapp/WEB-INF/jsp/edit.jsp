<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

    <title>编辑用户</title>

</head>

<body>

<h1>编辑用户</h1>
<form action="/student/${student.id}" name="student" method="get">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" name="id" value="${student.id}"/>
    姓名：<input type="text" name="name" value="${student.name}"/> <br>
    更新时间：<input type="text" name="update_at" value="${student.update_at}"/> <br>
    QQ:<input type="text" name="qq" value="${student.qq }"/> <br>
    课程类型:<input type="text" name="course_type" value="${student.course_type}"/> <br>
    入学时间:<input type="text" name="entrance_time" value="${student.entrance_time}"/> <br>
    毕业学校:<input type="text" name="graduate_school" value="${student.graduate_school}"/> <br>
    线上学号:<input type="text" name="wish" value="${student.wish}"/> <br>
    日报:<input type="text" name="daily_link" value="${student.daily_link}"/> <br>
    愿望:<input type="text" name="set_to" value="${student.set_to}"/> <br>
    师兄:<input type="text" name="brother" value="${student.brother}"/> <br>
    何处了解:<input type="text" name="learn" value="${student.learn}"/> <br>
        <input type="submit" value="修改">
        <td><a href="/students">返回页面</a></td>
    <%--<input type="button" value="编辑", onclick="edit()">--%>
            <%--="edit()"/>--%>
</form>


<%--<script type="text/javascript">--%>
    <%--function edit(){--%>
        <%--var form = document.forms[0];--%>
        <%--form.action = "<%=basePath%>/hello";--%>
        <%--form.method="post";--%>
        <%--form.submit();--%>
    <%--}--%>
<%--</script>--%>

</body>
</html>