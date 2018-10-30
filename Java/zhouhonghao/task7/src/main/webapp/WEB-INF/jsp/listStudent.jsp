<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<%@ taglib uri="/tags" prefix="zhh"%>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".delete").click(function(){
            var href=$(this).attr("href");
            $("#formDelete").attr("action",href).submit();
            return false;
        });
    });
</script>

<form id="formDelete" action="" method="POST" >
	<input type="hidden" name="_method" value="DELETE">
</form>
<html>
<head>
	<title></title>
</head>
<body>
<main>
	<div>
	<table align='center'  border='1'  cellspacing='0'>
		<tr>
	        <td>学号</td>
	        <td>姓名</td>
	        <td>学校</td>
	        <td>电话</td>
	        <td>时间</td>
	        <td>编辑</td>
	        <td>删除</td>
	    </tr>
		<%--ss是page对象，而不是student对象,ss.list才是student对象--%>
	    <c:forEach items="${ss.list}" var="s" varStatus="st">
	        <tr>
	            <td>${s.id}</td>
	            <td>${s.name}</td>
	             <td>${s.address}</td>
	            <td>${s.phone}</td>
	            <%--<td>${s.create_up}</td>--%>
				<%--<td>--%>
					<%--<jsp:setProperty name="date" property="time" value="${s.create_up}"/>--%>
					<%--<fmt:formatDate value="${date}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />--%>
				<%--</td>--%>
				<td><zhh:date value="${s.create_up}"/></td>
	            <td><a href="/u/students/${ss.currPage}/${s.id}">编辑</a></td>
	            <td><a class="delete" href="/u/students/${ss.currPage}/${s.id}">删除</a></td>
	        </tr>
	    </c:forEach>
	</table>
	<div style="text-align:center">
			<span>第${ss.currPage}页</span>&nbsp;&nbsp;
			<span>总记录数:${ss.totalCount}</span>&nbsp;&nbsp;
			<span>
				<c:if test="${ss.currPage!=1}">
					<a href="/u/students?currPage=1">首页</a>&nbsp;&nbsp;
					<a href="/u/students?currPage=${ss.currPage-1}">上一页</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${ss.currPage!=ss.totalPage}">
					<a href="/u/students?currPage=${ss.currPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="/u/students?currPage=${ss.totalPage}">尾页</a>&nbsp;&nbsp;
				</c:if>
			</span>
	</div>
	</div>
</main>
</body>
</html>