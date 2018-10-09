<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/15
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" isErrorPage="true" %>
<html>
<head>
    <title>studenttable</title>
</head>
<body>
<tr><h1>学生表</h1></tr>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>QQ</td>
        <td>wish</td>
        <td>createAt</td>
        <td>updateAt</td>
        <td>edit</td>
        <td>delete</td>
    </tr>

    <%--item代表输入的数据，User代表防止的地方--%>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.QQ}</td>
            <td>${student.wish}</td>
            <td>${student.createAt}</td>
            <td>${student.updateAt}</td>
            <td><a href="/student/up/${student.id}/${page}">修改</a></td>
            <td><a href="/student/down/${student.id}/${page}">删除</a></td>
        </tr>
    </c:forEach>
    <td><a type="button" href="/student/add">插入</a></td>
</table>

<table align="center">

    <td><a href="/page">首页</a></td>
    <td><a href="/lastPage/${page}">上一页</a></td>

    <td>
        <form action="/pageStudent">
            <input type="text" size=4 name="page" value="${page}"/>
            <input type="submit" size=5 value="跳转"/>
        </form>
    </td>

    <td><a href="/nextPage/${page}">下一页</a></td>
    <td><a href="/pageStudent/${allPage}">尾页</a></td>
    <td>共有"${allPage}"页</td>

</table>


</body>


</html>
