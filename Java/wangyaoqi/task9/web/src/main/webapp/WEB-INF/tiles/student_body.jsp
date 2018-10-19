<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/8/4
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            </tr>
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
</div>
