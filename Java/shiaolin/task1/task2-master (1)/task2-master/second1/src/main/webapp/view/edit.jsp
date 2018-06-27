<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/28
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/stu" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <p>
        <label for="name">用户名：</label>
        <input id="name" name="name"/>
    </p>
    <p>
        <label for="qq">QQ:</label>
        <input id="qq" name="qq"/>
    </p>
    <p>
        <label for="enrolment_time">入学时间</label>
        <input id="enrolment_time" type="text" name="enrolment_time"/>
    </p>
    <p>
        <label for="learning_type">学习类型</label>
        <input id="learning_type" name="learning_type"/>
    </p>
    <p>
        <label for="desire">立愿</label>
        <input id="desire" name="desire"/>
    </p>
    <p>
        <label for="number">学号</label>
        <input id="number" name="number"/>
    </p>
    <input id="submit" type="submit" value="确定">
</form:form>

</body>
</html>
