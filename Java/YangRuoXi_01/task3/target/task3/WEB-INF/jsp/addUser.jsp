<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/19
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<jsp:useBean id="user" class="com.jnshu.clroom.beans.User" scope="request"></jsp:useBean>
<form:form action="${pageContext.request.contextPath}/user/${user.userId}" method="post" modelAttribute="user">
<c:if test="${!empty user.userId}" var="flag">
    <%--update--%>
    <form:hidden path="userId"/>
    <input type="hidden" name="_method" value="PUT">
</c:if>


    <%--判断当前页面是添加还是修改--%>
<table>
    <tr>
        <td>账户名 :<form:input path="userName"/></td>
        <td><form:errors path="userName" cssStyle="color: red"/> </td>
        <td>密码: <form:input path="password"/></td>
        <td>角色 : <form:input path="userRole"/></td>
    </tr>
</table>

<c:if test="${flag}">
    <a href="/users" name="update" type=""/>
    <input type="submit" value="更新用户信息">
</c:if>

<c:if test="${!flag}">
    <a href="/users" name="add"/>
    <input type="submit" value="新增用户">
</c:if>

</form:form>
</body>
</html>