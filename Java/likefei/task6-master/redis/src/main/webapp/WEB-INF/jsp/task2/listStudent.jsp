<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@include file="copyright.jsp" %>
<p style="color:#FF00FF ;font-size:32px;text-align: center;top: auto">修真院学生资料
</p>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>

<script type="text/javascript" src="js/jquery.min.js"></script>


<div style="width:500px;margin:0px auto;text-align:center">
    <table border="1" width="120%">
    <tr>
        <td style="width:10%">id</td  >
        <td style="width:15%">name</td>
        <td style="width:20%">qq</td>
        <td style="width:15%">job</td>
        <td style="width:20%">school</td>
        <td style="width:20%">url</td>
        <td style="width:10%">更新</td>
        <td style="width:10%">删除</td>
    </tr>

    <c:forEach items="${studentList}" var="student" varStatus="st">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.job}</td>
            <td>${student.school}</td>
            <td>${student.url}</td>
            <td><a href="student/${student.id}/profile">更新</a> </td>
            <td><a href="student/${student.id}" onclick = 'return confirm("确认要删除吗？");'>删除</a></td>
        </tr>
    </c:forEach>
</table>
    <%--.<p>一共${page.pages}页</p>--%>
    <%--<a href="student/${page.firstPage}">首页</a>--%>
    <%--<a href="student?page=${page.nextPage}">下一页</a>--%>
    <%--<a href="student?page=${page.prePage}">上一页</a>--%>
    <%--<a href="student/${page.lastPage}">末页</a>--%>

    <div style="text-align:center;margin-top:40px">
        <form method="post" action="student" accept-charset="UTF-8">
            学生名称： <input name="name" type="text"> <br><br>
            学生qq: <input name="qq"  type="text"> <br><br>
            学习类型：<input name="job"  type="text"> <br><br>
            毕业学校：<input name="school" type="text"> <br><br>
            日报链接：<input name="url"  type="text"> <br><br>
            <input type="submit" value="增加学生">
        </form>
    </div>

    <div style="text-align:center;margin-top:40px">
        <form method="post" action="student/select" accept-charset="UTF-8">
            学生ID： <input name="id" value="${student.id}" type="text"> <br><br>
            <input type="submit" value="查询学生" >
        </form>
    </div>
</div>



