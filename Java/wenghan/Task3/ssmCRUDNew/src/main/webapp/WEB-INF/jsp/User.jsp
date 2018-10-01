<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>测试页面</title>
</head>
<body>
    <h1>测试负载均衡：Tomcat1</h1>
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>qq</td>
            <td>查询</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.qq}</td>
                <td>
                    <form method="get" action="/User/${c.id}">
                        <input type="hidden" name="id" value="${c.id}">
                        <input type="hidden" name="name" value="${c.name}">
                        <input type="submit" value="查询">
                    </form>
                </td>
                <td>
                    <form method="get" action="/User/${c.id}">
                        <input type="hidden" name="id" value="${c.id}">
                        <input type="submit" value="编辑">
                    </form>
                </td>
                <td>
                    <form method="post" action="/User/${c.id}">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="hidden" name="id" value="${c.id}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="?start=0">首 页</a>
        <c:if test="${page.start-page.count>=0}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>
        <c:if test="${page.start+page.count<=page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <a href="?start=${page.last}">末页</a>
    </div>
    <div style="text-align:center">
        <p>添加用户</p>
        <form action="User" method="post">
            <input type="text" name="name" >
            <input type="text" name="qq" >
            <input type="submit" value="增加">
        </form>
    </div>
</body>
</html>
