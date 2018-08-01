<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>type</td>
            <td> 编辑</td>
        </tr>
        <c:forEach items="${list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.type}</td>
                <td><a class="update" href="user/{name}">编辑</a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="?start=0">首 页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末 页</a>
    </div>
    <div>
        <form method="post" action="user">

            <input type="hidden" name="_method" value="PUT">
            分类名称： <input name="name" value="" type="text"> <br><br>
            <input type="submit" value="增加分类">
        </form>
    </div>

</div>

<form action=" ${pageContext.request.contextPath }/user" method="post">
    <input type="hidden" name="_method" value="put">
    <input name="name" value="" type="text"> <br><br>
    <input name="type" value="" type="text"> <br><br>
    <input type="submit" value="编辑">
</form>