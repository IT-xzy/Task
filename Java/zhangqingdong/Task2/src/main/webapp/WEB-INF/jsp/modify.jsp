<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/18
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>修改学员信息</title>
</head>
<body>
<form action="${ctx}/student/${student.id}" method="post">
    <input type="hidden" name="_method" value="PUT">
    <%--用户名<input type="text" name="username" value="${user.username}" readonly="readonly"></br>--%>
    <%--密码<input type="text" name="password" value="${user.password}"></br>--%>
        用户名<input type="text" name="name" value="${student.name}" readonly="readonly" />
        <br/>
        QQ<input type="text" name="QQ" value="${student.QQ}"/>
        <br/>
        职位：<input type="radio"  name="type" value="CSS"/>CSS
        <input type="radio" name="type"  value="JAVA" />JAVA
        <input type="radio" name="type"  value="PM" />PM
        <br>
        毕业学校<input type="text" name="school"  value="${student.school}"/>
        <br/>
        入学时间<input type="text" name="number" value="${student.appointment}"/>
        <br/>
        学号<input type="text" name="number" value="${student.number}"/>
        <br/>
        日报链接<input type="text" name="link" value="${student.link}"/>
        <br/>
        立愿<input type="text" name="oath" value="${student.oath}"/>
        <br/>
        辅助师兄<input type="text" name="supportSenior" value="${student.supportSenior}"/>
        <br/>
        推荐师兄<input type="text" name="referrer" value="${student.referrer}"/>
        <br/>
        来源<input type="text" name="source" value="${student.source}"/>
        <br/>
    <input type="submit" value="确认修改">
</form>
</body>
</html>
