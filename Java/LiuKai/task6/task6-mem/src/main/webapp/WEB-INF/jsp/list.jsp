<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="date"%>

<meta http-equiv="content-type" content="text/html; charset=utf-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<table border=1 align="center" width="80%" style="border-collapse: collapse">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>课程</td>
        <td>创建时间</td>
        <td>修改时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="student">
    <tr>
    <td>${student.id}</td>
    <td>${student.stuName}</td>
    <td>${student.course}</td>
    <td><date:date value="${student.createTime}"/></td>
    <td>${student.updateTime}</td>
    <th>
    <form action="/students/${student.id}" method="post">
    <input type="hidden" value="DELETE" name="_method">
    <input type="submit" value="点击删除">
    </form>
    </th>
    <%--<td><a href="/list/?id=${student.id}">删除</a></td>--%>
    <%--<td><a href="editStudent?id=${student.id }">更新</a>--%>
    <th>
    <form action="/students/${student.id}" method="post">
    <input type="submit" value="修改">
    <input type="hidden" value="put" name="_method">
    </form>
        <%--<a href="/editStudent/${student.id}">非rest修改</a>--%>
    </th>
    </tr>
    </c:forEach>

    <%--<c:forEach var="student" items="${requestScope.get('list')} " varStatus="status">--%>
    <%--<tr>--%>
    <%--<td>${student.id}</td>--%>
    <%--<td>${student.stuName}</td>--%>
    <%--<td>${student.course}</td>--%>
    <%--<td><a href="delete?id=${student.id}">删除</a>--%>
    <%--<br/>--%>
    <%--<a href="update?id=${student.id }">更新</a></td>--%>
    <%--&lt;%&ndash;<td><a href="update?id=${student.id }">更新</a>&ndash;%&gt;--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--<c:forEach items="${list}" var="student">--%>
    <%--<td>${student.id}</td>--%>
    <%--<td>${student.stuName}</td>--%>
    <%--<td>${student.course}</td>--%>
    <%--</c:forEach>--%>


</table>
<div align="center" >
    <tr>
        <a href="?start=0">首  页</a>
        <c:if test="${page.start-page.count<0}">
            <a href="javascript:void (0)"></a>
        </c:if>
        <c:if test="${page.start-page.count>=0}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>
        <c:if test="${page.start+page.count<=page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <c:if test="${page.start+page.count>page.last}">
            <a href="javascript:void (0)"></a>
        </c:if>
        <a href="?start=${page.last}">末  页</a>
    </tr>
</div>
<div style="text-align:left;margin-top:40px">
    <%--<form method="post" action="/insertStudent">--%>
    <%--姓名： <input name="stuName" type="text"> <br><br>--%>
    <%--课程： <input name="course" type="text"> <br><br>--%>
    <%--<input type="submit" value="增加">--%>
    <%--</form>--%>
    <form method="post" action="/students">
        姓名： <input name="stuName" type="text">
        课程： <input name="course" type="text">
        <input type="submit" value="增加">
    </form>
</div>

    <form method="get" action="/students/stuName">
        姓名： <input name="stuName" type="text">

        <input type="submit" value="查找">
    </form>


    <form method="get" action="/students/id">
        ID： <input name="id" type="text">
        <input type="submit" value="查找">
    </form>

<form action="/students" method="post">
    <input type="hidden" value="DELETE" name="_method">
    <input type="submit" value="删除全部">
</form>
</body>
</html>