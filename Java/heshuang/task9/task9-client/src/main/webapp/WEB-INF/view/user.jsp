<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tags" prefix="date"%>
<%--<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../../static/css/task9-3.css">
    <title>个人用户信息</title>
</head>

<body style="text-align: center">
<style>
    .to{width: 100px;height: 100px;border-radius: 100px}
</style>
</br>

<div>
    <c:if test="${empty user1}">
        <form action="/login" method="get">
            <input type="submit" value="返回登录">
        </form>
    <br>
    <span style="color: red; font-size: small;">${message}</span>
    <br>
    </c:if>
    <c:if test="${!empty user1}">
        <table border="1" cellspacing="0" cellpadding="0" class="table">
            <thead>
            <td>id</td>
            <td>头像</td>
            <td>姓名</td>
            <td>手机号码</td>
            <td>邮箱</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>编辑</td>
            </thead>

            <tr>
                <td>${user1.id}</td><br>
                <%--<td>${user1.headURL}</td><br>--%>
              <td><img class="to" src="${user1.headURL}"></td><br>
                <td>${user1.userName}</td><br>
                <td>${user1.phoneNumber}</td><br>
                <td>${user1.email}</td><br>
                <td><date:date value="${user1.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></td><br>
                <%--<td>${user1.createAt}</td><br>--%>
                <%--<td>${user1.updateAt}</td><br>--%>
                <td><date:date value="${user1.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></td><br>
                <td>
                    <form action="/u/user/${user1.id}" method="get">
                        <input type="submit" value="编辑">
                    </form>
                </td>
            </tr>
        </table>
    </c:if>
</div>
</body>
</html>
