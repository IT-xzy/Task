<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/23
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/tags" prefix="date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>vote</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/task8-3.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    　
    <base href="${pageContext.request.contextPath}/">

</head>
<body>

<div style="width:500px;margin:0px auto;text-align:center">

    <div class="row row1">

        <div class="col-lg-4 carrer1">

            <div class="headpic">
                <div class="item1">
                    <c:choose>
                        <c:when test="${empty people.picture}">
                            <img class="img-responsive" src="img/head22.png">
                            <a href="skipPicture">上传头像</a>
                        </c:when>
                        <c:otherwise>
                            <img class="img-responsive" src="${people.picture}">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="item2">
                    <h4>${people.name}</h4>
                </div>
            </div>
            <table class="table table-bordered table1">
                <tbody>

                <tr>
                    <td class="grey">电话</td>
                    <c:choose>
                        <c:when test="${people.tel==null}">
                            <td><a href="tel">绑定手机号</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a>${people.tel}</a></td>
                        </c:otherwise>
                    </c:choose>
                </tr>
                <tr>
                    <td class="grey">邮箱</td>
                    <c:choose>
                        <c:when test="${empty people.email}">
                            <td><a href="skipEmail">绑定邮箱</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a>${people.email}</a></td>
                        </c:otherwise>
                    </c:choose>
                </tr>

                <tr>
                    <td class="grey">信息</td>
                    <td><span class="red">${people.info}</span></td>
                </tr>
                <tr>
                    <td class="grey">修真类型</td>
                    <td><span class="red">${people.type}</span></td>
                </tr>
                <tr>
                    <td class="grey">注册时间</td>
                    <td><span class="red"><date:date value="${people.creatTime}"/></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>

</script>
</body>
</html>
