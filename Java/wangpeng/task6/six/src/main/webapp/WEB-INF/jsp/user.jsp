<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/6/3
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>查询</title>
</head>

<body>
<table align="center" border="1" cellspacing="0">

    <%--td是一列,tr是一行,href 属性规定链接的目标,<a href="/listtable">指向/listtable超链接的--%>
    <tr>
        <td>name</td>
        <td>password</td>
        <td>添加</td>
    </tr>
    <%--//接收controller给出的model数据--%>
    <%--c标签里封装了java循环语法--%>
    <c:forEach items="${users}" var="User">
        <tr>
            <td>${User.name}</td>
            <td>${User.password}</td>
            <td><a href="/a/u/add">添加</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>




<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" isErrorPage="true" %>--%>
<%--<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<%--<json:object>--%>
    <%--<json:property name="code" value="${code}"/>--%>
    <%--<json:property name="message">--%>
        <%--<spring:message code="${code}"/>--%>
    <%--</json:property>--%>

    <%--<json:array name="users" var="User" items="${users}">--%>
        <%--<json:object>--%>
            <%--<json:property name="name" value="${User.name}"/>--%>
            <%--<json:property name="password" value="${User.password}"/>--%>
        <%--</json:object>--%>
    <%--</json:array>--%>
<%--</json:object>--%>


