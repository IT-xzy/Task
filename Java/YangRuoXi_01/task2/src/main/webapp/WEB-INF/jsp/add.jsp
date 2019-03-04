<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.jnshu.task2.beans.Student" scope="request" ></jsp:useBean>
<html>
<head>
    <title>add</title>
</head>
<body>
    <form:form action="student" method="post" >
        id<form:input path="id" /><</br>
        name<form:input path="name" /><</br>
        qq<form:input path="qq" /><</br>
        type<form:input path="type" /><</br>
        time<form:input path="time" /><</br>
        school<form:input path="school" /><</br>
        onlineNumber<form:input path="onlineNumber" /><</br>
        link<form:input path="link" /><</br>
        wish<form:input path="wish" /><</br>
        teacher<form:input path="teacher" /><</br>
        whereKonw<form:input path="whereKonw" /><</br>
        createAt<form:input path="createAt" /><</br>
        updateAt<form:input path="updateAt" /><</br>
        <input type="submit" value="add">
    </form:form>
</body>
</html>
