<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/com/restful/tld/datetag.tld" prefix="ltd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息</title>
</head>
<body>
<c:if test="${empty requestScope.students}">
    没有查询到信息！
    <br/>
    <a href="${pageContext.request.contextPath}/stu/students">返回查询页</a>
</c:if>
<c:if test="${!empty requestScope.students}">
    <form action="${pageContext.request.contextPath }/stu/students" method="get">
        数据列表：
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
                <td>修改</td>
                <td>删除</td>
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
                    <td><a href="${pageContext.request.contextPath }/stu/student/${list.id}">修改</a></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/stu/student/${list.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="删除">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</c:if>

<div class="pagging">
    <div class="left">共${studentNum}条记录</div>
    <div class="right">
        <c:if test="${currentPage == 1}">
            <span class="disabled"><< 前一页</span>
        </c:if>
        <c:if test="${currentPage != 1}">
            <a href="${pageContext.request.contextPath}/stu/students?page=${currentPage-1}"><< 前一页</a>
        </c:if>
        <c:if test="${currentPage == 1}">
            <span class="current">1</span>
        </c:if>
        <c:if test="${currentPage != 1}">
            <a href="${pageContext.request.contextPath}/stu/students?page=1">1</a>
        </c:if>
        <%
            int pageTimes = (Integer) session.getAttribute("pageTimes");
            for (int i = 1; i < pageTimes; i++) {
                request.setAttribute("page", i + 1);
        %>
        <c:if test="${currentPage == page}">
            <span class="current"><%=i + 1%></span>
        </c:if>
        <c:if test="${currentPage != page}">
            <a href="${pageContext.request.contextPath}/stu/students?page=<%=i+1%>"><%=i + 1%>
            </a>
        </c:if>
        <%} %>

        <c:if test="${currentPage == pageTimes}">
            <span class="disabled">后一页 >></span>
        </c:if>
        <c:if test="${currentPage != pageTimes}">
            <a href="${pageContext.request.contextPath}/stu/students?page=${currentPage+1}">后一页 >></a>
        </c:if>
    </div>
</div>

<br/>

<form id="itemForm" action="${pageContext.request.contextPath }/stu/student/object" method="get">
    查询学生：
    <table width="60%" border=1>
        <tr>
            <td>综合查询</td>
            <td><input type="text" name="object"/><input type="submit" value="综合查询"/></td>
        </tr>
    </table>
</form>

<br/>

<form id="itemForm" action="${pageContext.request.contextPath }/stu/student/student" method="post">
    增加学生：
    <table width="60%" border=1>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"/></td>
            <td rowspan="11" align="center"><input type="submit" value="提交"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex"/></td>
        </tr>
        <tr>
            <td>QQ</td>
            <td><input type="text" name="qq"/></td>
        </tr>
        <tr>
            <td>修真类型</td>
            <td><input type="text" name="whatType"/></td>
        </tr>
        <tr>
            <td>入学时间</td>
            <td><input type="text" name="joinTime"/></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><input type="text" name="school"/></td>
        </tr>
        <tr>
            <td>学号</td>
            <td><input type="text" name="student_id"/></td>
        </tr>
        <tr>
            <td>日报连接</td>
            <td><input type="text" name="link"/></td>
        </tr>
        <tr>
            <td>许愿</td>
            <td><input type="text" name="wishes"/></td>
        </tr>
        <tr>
            <td>师兄</td>
            <td><input type="text" name="tutorBro"/></td>
        </tr>
        <tr>
            <td>从何处了解到修真院</td>
            <td><input type="text" name="knowFrom"/></td>
        </tr>
    </table>
</form>
</body>
</html>