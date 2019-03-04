<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/18
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账户列表</title>
</head>
<body>
<table border="1" cellpadding="10"cellspacing="0">
    <tr>
        <td>ID</td>
        <td>账户名</td>
        <td>角色</td>
        <td>创建时间</td>
        <td>创建人</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userList}" var="user" >
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userRole}</td>
            <td>${user.createTime}</td>
            <td>${user.createId}</td>
            <td><a href="/user/${user.userId}">更新</a></td>
            <td>
                <form action="${pageContext.request.contextPath}/user/${user.userId}" method="post">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input type="submit" value="删除"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/user">新增用户</a>

</body>
</html>

<%--<json:object>--%>
    <%--<json:property name="code" value="${code}"/>--%>
    <%--<json:property name="message" value="${message}"/>--%>
    <%--<json:array name="userList" var="users" items="${userList}">--%>
        <%--<json:object>--%>
            <%--<json:property name="userId" value="${users.userId}"/>--%>
            <%--<json:property name="userName" value="${users.userName}"/>--%>
            <%--<json:property name="userPassword" value="${users.password}"/>--%>
            <%--<json:property name="userRole" value="${users.userRole}"/>--%>
            <%--<json:property name="create_time" value="${users.createTime}"/>--%>
            <%--<json:property name="create_id" value="${users.createId}"/>--%>
            <%--<json:property name="privileges" value="${users.privileges}"/>--%>
        <%--</json:object>--%>
    <%--</json:array>--%>

    <%--<json:array name="user" var="user">--%>
        <%--<json:object>--%>
            <%--<json:property name="userId" value="${user.userId}"/>--%>
            <%--<json:property name="userName" value="${user.userName}"/>--%>
            <%--<json:property name="userPassword" value="${user.password}"/>--%>
            <%--<json:property name="userRole" value="${user.userRole}"/>--%>
            <%--<json:property name="create_time" value="${user.createTime}"/>--%>
            <%--<json:property name="create_id" value="${user.createId}"/>--%>
            <%--<json:property name="privileges" value="${user.privileges}"/>--%>
        <%--</json:object>--%>
    <%--</json:array>--%>
<%--</json:object>--%>