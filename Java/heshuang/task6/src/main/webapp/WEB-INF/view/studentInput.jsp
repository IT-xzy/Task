<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.task5.pojo.Student" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../../static/css/task9-3.css">
    <title>新增学生</title>
</head>
<body>
<form:form name="input" action="/student" method="post">
    </br>
    <%--id:<form:input path="id"/></br>--%>
    创建时间：<form:input path="create_at"/>
    姓名：<form:input path="name"/></br>
    QQ：<form:input path="qq"/></br>
    职业：<form:input path="professional"/></br>
    报道时间：<form:input path="start_time"/></br>
    毕业院校：<form:input path="university"/></br>
    学号：<form:input path="online_id"/></br>
    日报：<form:input path="daily_url"/></br>
    立愿：<form:input path="oath"/></br>
    师兄：<form:input path="counselor"/></br>
    城市：<form:input path="city"/></br>
    <input type="hidden" value="put" name="_method"></br>
    <input type="submit" value="新增">
</form:form>
</body>
</html>