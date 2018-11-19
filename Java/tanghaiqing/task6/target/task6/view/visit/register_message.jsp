<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<p>${saveMessage}</p>
<p><c:if
        test="${savaMessage=='注册成功'}">${savaMessage},请<a href="logging">登录</a></c:if>
    <c:if test="${savaMessage=='注册失败'}">${savaMessage},请重新<a href="registration">注册</a>></c:if>
</p>

