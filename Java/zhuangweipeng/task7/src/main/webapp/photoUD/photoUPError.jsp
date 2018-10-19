<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="refresh" content="3;url=/h1">
<!DOCTYPE html>
<html>
<head>
    <title>上传照片失败</title>
</head>
<body>
<p>上传照片失败</p>
<p>页面3秒后自动跳转上传页面，请重新上传</p>
<form  method="get" action="${pageContext.request.contextPath}/photeUpload">
</form>

</body>