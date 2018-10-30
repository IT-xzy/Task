<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Spring MVC Hello World</title>
</head>

<body>
<h3>执行结果</h3>
<c:choose>
    <c:when test="${rt==true}">
        删除成功<br>
    </c:when>
    <c:when test="${rt==false}">
        删除失败，该条信息不存在<br>
    </c:when>
</c:choose>
<a href="/info/paging">返回操作页面</a><br>
</body>
</html>