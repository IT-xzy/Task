<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/18
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
<a href="${ctx}/sms/user">短信注册</a><br/>
<a href="${ctx}/email/user">邮件注册</a><br/>
<a href="${ctx}/users">展示所有用户</a><br/>
<a href="${ctx}/user/ali">展示阿里云文件存储文件名</a><br/>
<a href="${ctx}/user/qiniu">展示七牛云文件存储文件名</a><br/>
<a href="${ctx}/alitoqiniu">阿里云文件迁移到七牛云</a><br/>
<a href="${ctx}/qiniutoali">七牛云文件迁移到阿里云</a><br/>
<a href="${ctx}/qiniufile">删除七牛所有文件</a><br/>
<a href="${ctx}/alifile">删除阿里所有文件</a><br/>
<%--<a href="${ctx}/email/user">邮件注册</a><br/>--%>
</body>
</html>
