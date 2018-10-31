<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>操作成功</title>
</head>

<body>
<a href="/info/paging">返回操作界面</a>
<%--<body> 标签表示 HTML 网页的主体部分，该标签内的内容使用户可以看到的。--%>
	<h3>学生信息表</h3>
<%--<a href="http://134.175.119.11:8080">点此返回主页面</a><br>--%>
	<table border="5">
		<%--<table> 标签用来定义 HTML 表格--%>
		<tr>
			<th>id</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>姓名</th>
			<th>QQ</th>
			<th>修真类型</th>
			<th>预计入学时间</th>
			<th>毕业院校</th>
			<th>线上学号</th>
			<th>日报链接</th>
			<th>立愿</th>
			<th>辅导师兄</th>
			<th>从何处了解到修真院</th>
		</tr>

		<c:forEach var="student" items="${students}">
			<tr>
				<%--<td> 元素中的文本通常是普通的左对齐文本。--%>
				<td>${student.id}</td>
				<td>${student.createAt}</td>
				<td>${student.updateAt}</td>
				<td>${student.studentName}</td>
				<td>${student.qq}</td>
				<td>${student.profession}</td>
				<td>${student.admissionDate}</td>
				<td>${student.graduatedFrom}</td>
				<td>${student.studentId}</td>
				<td>${student.dailyLink}</td>
				<td>${student.makeWishes}</td>
				<td>${student.coachingSenior}</td>
				<td>${student.approach}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>