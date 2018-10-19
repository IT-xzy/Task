<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<main>
<json:array name="student">
	<json:property name="id" value="${c.id}"/>
	<json:property name="name" value="${c.name}"/>
	<json:property name="address" value="${c.address}"/>
	<json:property name="phone" value="${c.phone}"/>
</json:array>
 <div style="width:500px;margin:0px auto;text-align:center">
	<div style="text-align:center;margin-top:40px">
		<form method="post" action="/u/students/${nowPage}/${c.id}">
		学生姓名： <input name="name" value="${c.name}" type="text"> <br><br>
		  学校： <input name="address" value="${c.address}" type="text"> <br><br>
		  电话： <input name="phone" value="${c.phone}" type="text"> <br><br>
			<input type="hidden" value="${c.id}" name="id">
			<input type="hidden" value="${c.create_up}" name="create_up">
			<input type="submit" value="保存">
		</form>
	</div>	
 </div>
</main>
</body>
</html>