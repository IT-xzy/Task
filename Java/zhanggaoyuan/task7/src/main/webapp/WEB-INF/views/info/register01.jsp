<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>操作结果</title>
</head>
<body>
<c:if test="${rs==1}"><c:out value="注册成功，请返回首页登录"/></c:if>
<c:if test="${rs==0}"><c:out value="注册失败"/></c:if>

<%--手机注册结果--%>
<c:if test="${rp==4}"><c:out value="注册信息不完整"/></c:if>
<c:if test="${rp==0}"><c:out value="手机注册失败，验证码不通过"/></c:if>
<c:if test="${rp==1}"><c:out value="注册成功，请返回首页登录"/></c:if>
<c:if test="${rp==2}"><c:out value="手机注册失败，注册名字已经被使用"/></c:if>

<c:if test="${rp==3}"><c:out value="验证码输入错误过多,请重新获取验证码"/></c:if>

<%--邮箱注册结果--%>

<%--手机注册结果--%>
<c:if test="${re==4}"><c:out value="注册信息不完整"/></c:if>
<c:if test="${re==0}"><c:out value="邮箱注册失败，验证码不通过"/></c:if>
<c:if test="${re==1}"><c:out value="注册成功，请返回首页登录"/></c:if>
<c:if test="${re==2}"><c:out value="邮箱注册失败，注册名字已经被使用"/></c:if>

<c:if test="${re==3}"><c:out value="验证码输入错误过多,请重新获取验证码"/></c:if>



<a href="/home">返回首页</a>
</body>
</html>