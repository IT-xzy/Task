<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--c标签需要它--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>--%>

<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message">
    <spring:message code="${code}"/>
</json:property>
    <%--    <json:array name="user" var="user" items="${list}">--%>
<json:array name="user" var="user" items="${user}">
 <json:object>
    <json:property name="id" value="${user.id}"/>
    <json:property name="type" value="${user.type}"/>
    <json:property name="name" value="${user.name}"/>
    <json:property name="admission_time" value="${user.admissionTime}"/>
    <json:property name="graduated_school" value="${user.graduatedSchool}"/>
    <json:property name="daliy_link" value="${user.daliyLink}"/>
    <json:property name="volunte" value="${user.volunte}"/>
    <json:property name="brother" value="${user.brother}"/>
    <json:property name="source" value="${user.source}"/>
    <json:property name="create_at" value="${user.createAt}"/>
    <json:property name="update_at" value="${user.updateAt}"/>
</json:object>
</json:array>
</json:object>


<%--<html>--%>
<%--<head>--%>
<%--    <title>show</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--&lt;%&ndash;居中对齐，  边框宽度    ，表格中单元格之间的距离&ndash;%&gt;--%>
<%--<table align="center" border="1" cellspacing="0">--%>
<%--    <tr>--%>
<%--        <td>id</td>--%>
<%--        <td>name</td>--%>
<%--        <td>type</td>--%>
<%--        <td>admission_time</td>--%>
<%--        <td>graduated_school</td>--%>
<%--        <td>daliy_link</td>--%>
<%--        <td>volunte</td>--%>
<%--        <td>brother</td>--%>
<%--        <td>source</td>--%>
<%--        <td>create_at</td>--%>
<%--        <td>update_at</td>--%>
<%--        <td>修改</td>--%>
<%--        <td>删除</td>--%>
<%--    </tr>--%>
<%--    &lt;%&ndash;//接收controller给出的model数据&ndash;%&gt;--%>
<%--    &lt;%&ndash;c标签里封装了java循环语法&ndash;%&gt;--%>
<%--    <c:forEach items="${user}" var="user">--%>
<%--        <c:forEach items="${user}" var="user">--%>
<%--        <tr>--%>
<%--            <td>${user.id}</td>--%>
<%--            <td>${user.name}</td>--%>
<%--            <td>${user.type}</td>--%>
<%--            <td>${user.admissionTime}</td>--%>
<%--            <td>${user.graduatedSchool}</td>--%>
<%--            <td>${user.daliyLink}</td>--%>
<%--            <td>${user.volunte}</td>--%>
<%--            <td>${user.brother}</td>--%>
<%--            <td>${user.source}</td>--%>
<%--            <td>${user.createAt}</td>--%>
<%--            <td>${user.updateAt}</td>--%>
<%--            <td><a href="/user/findById?id=${user.id}">修改</a></td>--%>
<%--            <td><a href="/user/delete?id=${user.id}">删除</a></td>--%>
<%--        </tr>--%>

<%--    </c:forEach>--%>
<%--&lt;%&ndash;    这是一个表，没有界限&ndash;%&gt;--%>
<%--</table>--%>
<%--<td><a href="/user/task?number=1">首页</a></td>--%>
<%--<td><a href="/user/task?number=${prePage}">上一页</a></td>--%>
<%--<td><a href="/user/task?number=${nextPage}">下一页</a></td>--%>
<%--<td><a href="/user/task?number=${totalPages}">尾页</a></td>--%>
<%--<td>当前第${number}页</td>--%>
<%--<td>总共${totalPages}页</td>--%>
<%--<br>--%>
<%--<form action="/user/task">--%>
<%--    跳转<input type="text" name="number">页--%>
<%--    <input type="submit" value="GO">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
