<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/10
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Json</title>
</head>
<span>${head}</span>
<body>
<json:object>
    <json:array name="user" var="student" items="${students}">
        学员名<json:property name="学员名" value="${student.name} "/>
        QQ <json:property name="QQ" value="${student.QQ}"/>
        类型<json:property name="类型" value=" ${student.type}"/>
        入学时间<json:property name="入学时间" value="${student.appointment}"/>
        毕业学校<json:property name="毕业学校" value="${student.school}"/>
        立愿 <json:property name="立愿" value="${student.oath}"/>
        学号<json:property name="学号" value=" ${student.number}"/>
        日报链接<json:property name="日报链接" value=" ${student.link}"/>
        辅助师兄<json:property name="辅助师兄" value=" ${student.supportSenior}"/>
        推荐师兄<json:property name="推荐师兄" value=" ${student.referrer}"/>
        来源<json:property name="来源" value=" ${student.source}"/>
        <br/>
    </json:array>
</json:object>
</body>
</html>
