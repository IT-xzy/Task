<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/com/restful/tld/datetag.tld" prefix="ltd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询结果</title>
</head>
<body>
<c:if test="${empty requestScope.students}">
    没有查询到信息！
    <br/>
    <a href="${pageContext.request.contextPath}/stu/students">返回查询页</a>
</c:if>
<c:if test="${!empty requestScope.students}">
<form>
    查询结果：
    <table width="100%" border=1>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>入学时间</td>
            <td>毕业院校</td>
            <td>学号</td>
            <td>日报连接</td>
            <td>许愿</td>
            <td>师兄</td>
            <td>从何处了解到修真院</td>
            <td>创建时间</td>
            <td>更新时间</td>
        </tr>
        <c:forEach items="${students }" var="list">

            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.sex}</td>
                <td>${list.qq}</td>
                <td>${list.whatType}</td>
                <td>${list.joinTime}</td>
                <td>${list.school}</td>
                <td>${list.student_id}</td>
                <td>${list.link}</td>
                <td>${list.wishes}</td>
                <td>${list.tutorBro}</td>
                <td>${list.knowFrom}</td>
                <td><ltd:dateTag value="${list.create_at}"/></td>
                <td><ltd:dateTag value="${list.update_at}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
</c:if>
</body>

</html>