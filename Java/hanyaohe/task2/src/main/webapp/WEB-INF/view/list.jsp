<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%--suppress HtmlUnknownTarget --%>
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">

</script>
<div>
	<table align='center' border='1' cellspacing='0'>
	    <tr>
	        <td>id</td>
	        <td>name</td>
			<td>qq</td>
			<td>major</td>
	        <td>编辑</td>
	        <td>删除</td>
	    </tr>
			<%--增加按钮--%>
		<form action="${pageContext.request.contextPath}/student/students" method="get">
			<input type="submit" value="增加">
		</form>
		<s:forEach var="student" items="${studentList}">
			<tr>
				<th>${student.id}</th>
				<th>${student.name}</th>
				<th>${student.qq}</th>
				<th>${student.major}</th>
					<%--修改按钮--%>
				<th>
					<form action="${pageContext.request.contextPath}/student/u/${student.id}" method="get">
						<input type="submit" value="修修">
					</form>
				</th>
					<%--删除按钮--%>
				<th>
					<form action="${pageContext.request.contextPath}/student/${student.id}" method="post">
						<input type="hidden" name="_method" value="DELETE">
						<input type="submit" value="删除">
					</form>
				</th>
			</tr>
		</s:forEach>
	</table>
</div>

