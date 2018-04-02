<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增学生信息</title>

</head>
<body> 
<form id="itemForm" action="${pageContext.request.contextPath }/student/studentOne" method="post" >


<table border=1 align='center' width="50%" >
<tr >
	<td align="center" colspan="2"><font size="5" >新增学生信息</font></td>
</tr>
<tr>
	<td>学生ID</td>
	<td><input type="text" name="id" /></td>
</tr>
<tr>
	<td>学生姓名</td>
	<td><input type="text" name="name" value="${studentCustom.name }"/></td>
</tr>
<tr>
	<td>QQ号码</td>
	<td><input type="text" name="qqNum" value="${studentCustom.qqNum }"/></td>
</tr>
<tr>
	<td>TYPE</td>
	<td>
	<input type="text" name="type" value="${studentCustom.type }"/>
	</td>
</tr>
<tr>
	<td>毕业学校</td>
	
	<td><input type="text" name="gradSchool" value="${studentCustom.gradSchool }"/></td>
	
</tr>
	<tr >
		<td>入学时间</td>

		<td><input type="date" name="perTime" value="<fmt:formatDate value="${studentCustom.perTime }" pattern="yyyy-MM-dd"/>" /></td>


	</tr>
<!-- <tr> -->
<!-- 	<td>商品生产日期</td> -->
<%-- 	<td><input type="text" name="createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/>"/></td> --%>
<!-- </tr> -->
<!-- <tr> -->
<!-- 	<td>商品图片</td> -->
<!-- 	<td> -->
<%-- 		<c:if test="${item.pic !=null}"> --%>
<%-- 			<img src="/pic/${item.pic}" width=100 height=100/> --%>
<!-- 			<br/> -->
<%-- 		</c:if> --%>
<!-- 		<input type="file"  name="pictureFile"/>  -->
<!-- 	</td> -->
<!-- </tr> -->

<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>