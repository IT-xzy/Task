<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/8
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>序号</td>
        <td>名字</td>
        <td>年龄</td>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="st">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>