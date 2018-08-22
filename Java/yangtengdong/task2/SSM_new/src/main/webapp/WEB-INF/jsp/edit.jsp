<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑页面</title>
</head>
<body>
欢迎您：${currentUser}
<hr>
<form:form action="save" method="post" modelAttribute="returnUser">
    <form:hidden path="id"/>
    用户名:<form:input path="userName" /><br>
    密码:<form:input path="password" /><br>
    邮件:<form:input path="email" /><br>
    联系电话:<form:input path="phone" /><br>
    职位:<form:select path="roleName">
    <form:option value="">请选择职位</form:option>
    <form:option value="客户经理">客户经理</form:option>
    <form:option value="高管">高管</form:option>
    <form:option value="销售主管">销售主管</form:option>
    <form:option value="系统管理员">系统管理员</form:option>
</form:select><br>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>