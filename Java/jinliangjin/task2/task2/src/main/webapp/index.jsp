<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div style="text-align: center;">
    <h2>Welcome to PPTeng</h2>
</div>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Do sth.</title>
</head>
<div style="width:100%;height:100%;border:1px;text-align:center">
    <a href="${pageContext.request.contextPath}/stu/students">查询所有学生信息</a>
    <br/>
    <a href="${pageContext.request.contextPath}/stu/add">添加学生信息</a>
    <br/>
    <a href="${pageContext.request.contextPath}/stu/select">综合查询</a>
    <br/>
    <a href="${pageContext.request.contextPath}/stu/selectBy">按字段查询</a>
    <br/>
    <a href="${pageContext.request.contextPath}/file/uploadFile">上传文件</a>
    <br/>
    <a href="${pageContext.request.contextPath}/file/registerFile">使用对象接收上传的文件</a>
</div>

</body>
</html>
