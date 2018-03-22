<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello <a href="/student">增加</a></h1>
    <div style="text-align:center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>名字</th>
            <th>QQ</th>
            <th>班级ID</th>
            <th>毕业学校</th>
            <th>学号</th>
            <th>日报链接</th>
            <th>誓言</th>
            <th>师兄</th>
            <th>更新</th>
            <th>删除</th>
        </tr>

        <c:forEach var="list" items="${massege}">
        <tr>
            <th>${list.id}</th>
            <th>${list.name}</th>
            <th>${list.qq}</th>
            <th>${list.class_id}</th>
            <th>${list.graduate_school}</th>
            <th>${list.oline_number}</th>
            <th><a href=${list.link}>${list.link}</a></th>
            <th>${list.wish}</th>
            <th>${list.brother_id}</th>
            <th><a href="/updatestudent/${list.id}">更</a></th>
            <th><a href="/delstudent/${list.id}">删</a></th>
        </tr>
        </c:forEach>
            </table>
        </div>

        <div style="text-align:center">
            <a href="?start=0">首  页</a>
            <a href="?start=${page.start-page.count}">上一页</a>
            <a href="?start=${page.start+page.count}">下一页</a>
            <a href="?start=${page.last}">末  页</a>
        </div>
</body>
</html>
