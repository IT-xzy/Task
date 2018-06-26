<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/6/11
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
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
            <th>编辑</th>
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
            <td><a href="student/${stu.id}">编辑</a></td>
            <td><a class="delete" href="student/${stu.id}">删除</a></td>
            </tr>
            <%--<json:object prettyPrint="ture">--%>
                <%--<json:property name="id" value="${stu.id}"/>--%>
                <%--<json:property name="name" value="${stu.name}"/>--%>
                <%--<json:property name="type" value="${stu.type}"/>--%>
                <%--<json:property name="school" value="${stu.school}"/>--%>
                <%--<json:property name="pledge" value="${stu.pledge}"/>--%>
                <%--<json:property name="createTime" value="${stu.createTime}"/>--%>
                <%--<json:property name="updateTime" value="${stu.updateTime}"/>--%>
                <%--<json:property name="siblingId" value="${stu.siblingId}"/>--%>
                <%--<json:property name="siblingName" value="${stu.siblingName}"/>--%>
            <%--</json:object>--%>
        </c:forEach>
    </table>
    <div style="text-align: center">
        <a href="?start=0">首页</a>
        <c:if test="${page.start>page.count-1}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>
        <c:if test="${page.start<page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <a href="?start=${page.last}">末页</a>
    </div>
    <div style="text-align:center;margin-top:40px">
        <form method="post" action="/mvc/student">
        <input type="hidden" name="_method" value="PUT">
        <label style="width: 20px;text-align: right">姓名：</label><input type="text" name="name" value=""><br/>
        <label style="width: 20px;text-align: right">类型：</label><input type="text" name="type" value=""><br/>
        <label style="width: 20px;text-align: right">学校：</label><input type="text" name="school" value=""><br/>
        <label style="width: 20px;text-align: right">誓言：</label><input type="text" name="pledge" value=""><br/>
        <label style="width: 20px;text-align: right">创建时间：</label><input type="text" name="createTime" value=""><br/>
        <label style="width: 20px;text-align: right">更新时间：</label><input type="text" name="updateTime" value=""><br/>
        <label style="width: 20px;text-align: right">师兄ID：</label><input type="text" name="siblingId" value=""><br/>
        <label style="width: 20px;text-align: right">师兄：</label><input type="text" name="siblingName" value=""><br/>
        <input type="submit" value="增加">
        </form>
    </div>
</div>
<form id="formdelete" action="" method="post">
    <input type="hidden" name="_method" value="delete">
</form>
