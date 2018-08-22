<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/8/2
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有用户</title>
    <style type="text/css">
        td{text-align: center;}
        .td2{text-align: right;}
        .table1{
            border:1px solid #ddd;
            width:900px;
        }
        thead{
            background-color:lightblue;
        }
    </style>
</head>
<body>
<h1>全部用户信息</h1>
<hr>
<table border="1" cellpadding="10" cellspacing="0" class="table1">
    <%--border:规定表格边框的宽度;cellpadding:规定单元边沿与其内容之间的空白。
    cellspacing:规定单元格之间的空白;--%>
        <thead>
        <tr>
            <td>编号</td>
            <td>团队成员</td>
            <td>年龄</td>
            <td>体重</td>
            <td>create_at</td>
            <td>update_at</td>
        </tr>
        </thead>
        <c:forEach items="${userList}" var="user" varStatus="st">

            <tr>
                <th>${user.id}</th>
                <th>${user.userName}</th>
                <th>${user.age}</th>
                <th>${user.weight}</th>
                <th>${user.createAt}</th>
                <th>${user.updateAt}</th>
            </tr>
        </c:forEach>
</table>




</body>
</html>
