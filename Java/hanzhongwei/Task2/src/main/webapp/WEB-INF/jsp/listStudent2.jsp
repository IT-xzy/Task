<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/4/29
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="width:500px;margin:0px auto;text-align:center">
    <%--通过forEach标签，遍历StudentController传递过来的集合数据--%>
    <table align='center' border='1' width="120%" cellspacing='0'>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>QQ</td>
            <td>派别</td>
            <td>学号</td>
            <td>create_at</td>
            <td>update_at</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.stuId}</td>
                <td>${c.stuName}</td>
                <td>${c.stuQQ}</td>
                <td>${c.stuType}</td>
                <td>${c.stuNum}</td>
                <td>${c.create_at}</td>
                <td>${c.update_at}</td>
                <td><a href="student1/ins/${c.stuId}">编辑</a></td>
                    <%--<td><a href="deleteStudent?stuId=${s.stuId}">删除</a></td>--%>
                <td>
                    <form action="student1/${c.stuId}" method="post">
                        <input type="hidden" name="_method" value="DELETE">
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
        <c:if test="${page.start-page.count<0}">
            <a href="javascript:void(0)">上一页</a>
        </c:if>

        <c:if test="${page.start+page.count<=page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <c:if test="${page.start+page.count>page.last}">
            <a href="javascript:void(0)">下一页</a>
        </c:if>
        <a href="?start=${page.last}">末页</a>
    </div>

    <div style="text-align:center;margin-top:40px">
        <form method="post" action="student1">
            <input type="hidden" name="_method" value="PUT">
            学员资料：<br><br>
            姓名：<input name="stuName" value="" type="text"> <br><br>
            QQ：<input name="stuQQ" value="" type="text"> <br><br>
            修真类型：<input name="stuType" value="" type="text"> <br><br>
            学号：<input name="stuNum" value="" type="text"> <br><br>
            <input type="submit" value="增加学员">
        </form>
    </div>
</div>

</body>
</html>
