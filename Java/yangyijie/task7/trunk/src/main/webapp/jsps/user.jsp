<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2018/1/21
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <span>${email}<span/>
    <span>
        <c:if test="${emailConf==0}">
            <c:if test="${mailCount==1}">邮件已发送,请到邮箱验证</c:if>
            <c:if test="${mailCount==null}"><a href="${pageContext.request.contextPath}/u/email">点击验证邮箱</a> </c:if>
    </c:if>
             <c:if test="${emailConf==1}">
        邮箱已验证 </c:if>
        <span/>
</div>
<div>
    <span>${phone}</span>
    <c:if test="${phoneConf==0}">
        <c:if test="${phoneCount==1}">
            <br>
            请输入验证码
            <br>
            <span>
                <form action="${pageContext.request.contextPath}/u/phoneCode" method="post">
                    <input type="text" name="code">
                    <input type="submit" value="提交"/>
                </form>
            </span>
        </c:if>
        <c:if test="${phoneCount==null}"><a href="${pageContext.request.contextPath}/u/phone">点击发送短信</a> </c:if>
    </c:if>
    <c:if test="${phoneConf==1}">
        手机号已验证 </c:if>
</div>
<form action="${pageContext.request.contextPath}/u/file" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="提交">
</form>
<img src="${head}">
</body>
</html>
