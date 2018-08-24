<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\8\4 0004
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的信息</title>
    <link href="static/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="header-end"></div>


        <table align="center" border="1" width="40%">
            <tr>
                <th align="center" colspan="2">个人信息</th>
            </tr>
            <tr>
                <td>用户名</td>
                <td>${username}</td>
            </tr>
            <tr>
                <td>头像</td>
                <td><img src="${uri}"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td> <p>绑定邮箱：<c:if test="${emailStatus == 1}">${email}</c:if>
                    <c:if test="${emailStatus == 0}">暂未绑定&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/emailVerify">绑定邮箱</a></c:if></p></td>
            </tr>
            <tr>
                <td>手机号</td>
                <td><p><c:if test="${phone != null}">${phone}</c:if>
                    <c:if test="${phone == null}">暂未绑定</c:if></p></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <a href="${pageContext.request.contextPath}/home">返回首页< </a>
                </td>
            </tr>
        </table>





</body>
</html>