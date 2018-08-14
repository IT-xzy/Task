<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/8/1
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>

    <%--< align='center' border='1' cellspacing='0'>--%>
    <%--<tr>--%>
    <%--<td>序号</td>--%>
    <%--<td>名字</td>--%>
    <%--<td>年龄</td>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${userList}" var="user" varStatus="st">--%>
    <json:array name="用户信息" var="user" items="${userList}">
        <json:object>
            <json:property name="id" value="${user.id}"/>
            <json:property name="name" value="${user.userName}"/>
            <json:property name="age" value="${user.age}"/>
            <json:property name="weight" value="${user.weight}"/>
            <json:property name="createAt" value="${user.createAt}"/>
            <json:property name="updateAt" value="${user.updateAt}"/>
        </json:object>
    </json:array>
    <>
    <%--</c:forEach>--%>
    <%--</table>--%>
</json:object>
