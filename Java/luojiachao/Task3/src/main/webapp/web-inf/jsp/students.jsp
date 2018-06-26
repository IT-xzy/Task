<%--
  Created by IntelliJ IDEA.
  User: luojiac
  Date: 2018/4/5
  Time: 下午6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--import="java.util.*"--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>大概是个数据库</title>
</head>

<body style="background-image:url(/images/Alujpg.jpg);background-size: 1440px">
<form action="/students/{id}" method="get" style="text-align:center">
    <p>ID: <input type="text" name="id" value=""/></p>
    <input type="submit" value="查找" />
</form>
<form action="/students/stu_name" method="get" style="text-align:center">
    <p>Name: <input type="text" name="stu_name" value=""/></p>
    <input type="submit" value="查找" />
</form>
<div style="text-align:center">
    <a href="${pageContext.request.contextPath}/student">添加用户</a>
</div>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>创建时间</td>
        <td>更新时间</td>
        <td>名字</td>
        <td>类型</td>
        <td>加入日期</td>
        <td>学号</td>
        <td>师兄</td>
        <td>毕业学校</td>
        <td>日报</td>
        <td>签名</td>
        <td>qq</td>
        <td>立志</td>
        <td>选项</td>
    </tr>
    <c:forEach items="${students}" var="student" varStatus="st">
        <tr>
            <td>${student.id}</td>
            <td>${student.create_at}</td>
            <td>${student.update_at}</td>
            <td>${student.stu_name}</td>
            <td>${student.profession}</td>
            <td>${student.join_date}</td>
            <td>${student.online_id}</td>
            <td>${student.brother}</td>
            <td>${student.school}</td>
            <td>${student.daily}</td>
            <td>${student.wishing}</td>
            <td>${student.qq}</td>
            <td>${student.heard}</td>
            <td>
                <form action="/students/${student.id}"  method="post">
                    <input type="hidden" value="delete" name="_method">
                    <%--<input type="submit" value="删除">--%>

                    <button onClick="return fun()" >删除</button>
                            <script>
                            function fun(){
                                alert("删除成功")
                        }
                    </script>

                </form>
                <form action="/students/${student.id}"  method="post">
                        <input type="submit" value="更改">
                    <%--<button onClick="fun()" >更改</button>--%>
                </form>
            </td>
        </tr>
    </c:forEach>

<c:if test="${student==null}">
<div style="text-align:center">
    <a href="?start=0">首  页</a>
    <a href="?start=${page.start-page.count}">上一页</a>
    <a href="?start=${page.start+page.count}">下一页</a>
    <a href="?start=${page.last}">末  页</a>

</div>
</c:if>
</table>

<%--<div style="text-align:center">--%>
<%--<a href="http://localhost:8080/addUser">添加用户</a>--%>
<%--</div>--%>
<%--<form action="${pageContext.request.contextPath}/listUser/id" method="get" style="text-align:center">--%>
    <%--<p>ID: <input type="text" name="id" value=""/></p>--%>
    <%--<input type="submit" value="查找" />--%>
<%--</form>--%>
</body>

</html>