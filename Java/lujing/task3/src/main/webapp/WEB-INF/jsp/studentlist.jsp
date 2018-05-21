<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示学生清单</title>
</head>
<body>

	<div align="center">
		<form action="${pageContext.request.contextPath }/student/newpage">
			<input type="submit" value="添加">
		</form>
	</div>


	<table align='center' border='2' cellspacing='0'>

		<tr>
			<td>id</td>
			<td>name</td>
			<td>qqNum</td>
			<td>type</td>
			<td>gradSchool</td>
			<td>perTime</td>
			<td>操作</td>

		</tr>

		<c:forEach items="${studentlist}" var="studentlist">
			<tr>
				<td>${studentlist.id}</td>
				<td>${studentlist.name}</td>
				<td>${studentlist.qqNum}</td>
				<td>${studentlist.type}</td>
				<td>${studentlist.gradSchool}</td>
				<td> <fmt:formatDate value="${studentlist.perTime}" pattern="yyyy-MM-dd"/></td>
				<td>
					<form
						action="${pageContext.request.contextPath }/student/${studentlist.id}"
						method="post">
						<input type="submit" value="删除"> <input type="hidden"
							name="_method" value="DELETE">
					</form>
				</td>
				<td>
				<form action="${pageContext.request.contextPath }/student/${studentlist.id}"
						method="get">
						
						<input type="submit" value="修改"> 
						
							</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>