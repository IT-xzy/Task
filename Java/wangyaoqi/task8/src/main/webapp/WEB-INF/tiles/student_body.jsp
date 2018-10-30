<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/8/4
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>
<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>类型</th>
            <th>学校</th>
            <th>誓言</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>师兄ID</th>
            <th>师兄</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>头像</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${students}" var="stu" varStatus="st">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.type}</td>
                <td>${stu.school}</td>
                <td>${stu.pledge}</td>
                <td>${stu.createTime}</td>
                <td>${stu.updateTime}</td>
                <td>${stu.siblingId}</td>
                <td>${stu.siblingName}</td>
                <td>${stu.telephone}</td>
                <td>${stu.email}</td>
                <td><a class="delete" href="/u/student/${stu.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align: center">
        <a href="?start=0">首页</a>
        ${page.start}
        <c:if test="${page.start>page.count-1}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>
        <c:if test="${page.start<page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <a href="?start=${page.last}">末页</a>
    </div>
    <div style="text-align:center;margin-top:40px">
        <form method="post" action="/u/student" enctype="multipart/form-data">
            <%--id="allow" onsubmit="return check(this)"--%>
            <label style="width: 20px;text-align: right">姓名：</label><input type="text" name="name" value="" id="name" required="required"><br/>
            <label style="width: 20px;text-align: right">类型：</label><input type="text" name="type" value="" id="type" required="required"><br/>
            <label style="width: 20px;text-align: right">学校：</label><input type="text" name="school" value="" id="school" required="required"><br/>
            <label style="width: 20px;text-align: right">誓言：</label><input type="text" name="pledge" value="" id="pledge" required="required"><br/>
            <label style="width: 20px;text-align: right">创建时间：</label><input type="text" name="createTime" value="" id="createTime" required="required"><br/>
            <label style="width: 20px;text-align: right">更新时间：</label><input type="text" name="updateTime" value="" id="updateTime" required="required"><br/>
            <label style="width: 20px;text-align: right">师兄ID：</label><input type="text" name="siblingId" value="" id="siblingId" required="required"><br/>
            <label style="width: 20px;text-align: right">师兄：</label><input type="text" name="siblingName" value="" id="siblingName" required="required"><br/>
            <label style="width: 20px;text-align: right">手机：</label><input type="text" name="telephone" value="" id="telephone" required="required"><br/>
            <label style="width: 20px;text-align: right">邮箱：</label><input type="text" name="email" value="" id="email" required="required"><br/>
            <input type="submit" value="增加" id="send">
        </form>
    </div>
</div>
<form id="formdelete" action="" method="post">
    <input type="hidden" name="_method" value="delete">
</form>
