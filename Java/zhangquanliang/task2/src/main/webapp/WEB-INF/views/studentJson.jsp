<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <meta content="application/json; charset=UTF-8">
    <title>根据姓名查询返回json</title>
</head>
<body>

<json:array name="student" var="s" items="${students}">
    <json:object>
        <json:property name="学生Id" value="${s.id}"/>
        <json:property name="姓名" value="${s.name}"/>
        <json:property name="QQ" value="${s.qq}"/>
        <json:property name="修真类型" value="${s.profession}"/>
        <json:property name="入学时间" value="${s.startTime}"/>
        <json:property name="毕业院校" value="${s.graduatedFrom}"/>
        <json:property name="学号" value="${s.onlineId}"/>
        <json:property name="日报链接" value="${s.dailyLink}"/>
        <json:property name="立愿" value="${s.wish}"/>
        <json:property name="辅导师兄" value="${s.counselor}"/>
        <json:property name="从哪里知道修真院" value="${s.way}"/>
        <json:property name="注册时间" value="${s.createAt}"/>
        <json:property name="更新时间" value="${s.updateAt}"/>
    </json:object>
</json:array>
</body>
</html>
