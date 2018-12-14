<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="/tags" prefix="date"%>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>

<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("#formdelete").attr("action", href).submit();
            return false;
        })
    });
</script>
<div width="95%" align="center">
    <form action="/u/student/" >
        <input type="text" name="name" placeholder="请输入姓名" >
        <input type="submit" value="根据姓名查询" >
    </form>
</div>

<form id="formdelete" action="${pageContext.request.contextPath}/u/student/" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>

<div>
<table border="1" cellpadding="0" width="95%" align="center">
    <tr>
        <th>用户Id</th>
        <th>用户名</th>
        <th>职位</th>
        <th>职业</th>
        <th>简介</th>
        <th>薪水</th>
        <th>注册时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${students}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.position}</td>
            <td>${s.profession}</td>
            <td>${s.intro}</td>
            <td>${s.salary}</td>
            <td><date:date value ="${s.createAt} "/></td>
            <td><date:date value ="${s.updateAt} "/></td>
            <td>
                <a href="/u/student/${s.id}">编辑</a>
                <a class="delete" href="/u/student/${s.id}">删除</a>
            </td>
        </tr>

    </c:forEach>
</table>
</div>

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

