<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Insert stu</title>
</head>
<body>
<jsp:useBean id="student" class="com.jnshu.task2.beans.Student" scope="request"></jsp:useBean>
<form:form action="${pageContext.request.contextPath}/stu/${student.id}" method="post" modelAttribute="student">
    <%--id<form:input path="id" /><br/>--%>
    <c:if test="${!empty student.id}" var="flag">
        <%--update--%>
        <form:hidden path="id" />
        <input type="hidden" name="_method" value="PUT" >

    </c:if>
    <table>
        <tr>
            <td>name</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssStyle="color: red"/> </td>
        </tr>
    </table>
    <%--判断当前页面是添加还是修改--%>

    qq<form:input path="qq" /><br/>
    type<form:input path="type" /><br/>
    time<form:input path="time" /><br/>
    school<form:input path="school" /><br/>
    onlineNubmer<form:input path="onlineNumber" /><br/>
    link<form:input path="link" /><br/>
    wish<form:input path="wish" /><br/>
    teacher<form:input path="teacher" /><br/>
    whereKonw<form:input path="whereKonw" /><br/>
    <%--creatAt<form:input path="createAt" /><br/>--%>
    <%--updateAt<form:input path="updateAt" /><br/>--%>
    <c:if test="${flag}">
        <a href="/stus" name="update" type=""/>
        <input type="submit" value="update">
    </c:if>

    <c:if test="${!flag}">
        <a href="/stus" name="add"/>
        <input type="submit" value="add">
    </c:if>


</form:form>
</body>
</html>
