<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/6/12
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>综合查询</title>
</head>
<body>
<table frame="box" rules="all">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>QQ</td>
        <td>修真类型</td>
        <td>创建时间</td>
        <td>修改时间</td>
    </tr>
    <c:forEach items="${Users}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.qq}</td>
            <td>${s.type}</td>
            <td>${s.createAt}</td>
            <td>${s.updateAt}</td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/mvc/page">
    <input type="hidden" name="pageId" value="1">
    <input type="submit" value="返回主页面">
</form>
</body>
</html>
