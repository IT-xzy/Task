<%@ page import="java.util.List" %>
<%@ page import="pojo.Student" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<div style="text-align:left;margin-top:40px">
    <%--<form method="post" action="/insertStudent">--%>
    <%--姓名： <input name="stuName" type="text"> <br><br>--%>
    <%--课程： <input name="course" type="text"> <br><br>--%>
    <%--<input type="submit" value="增加">--%>
    <%--</form>--%>
    <form method="post" action="/students">
        姓名： <input name="stuName" type="text">
        课程： <input name="course" type="text">
        <input type="submit" value="增加">
    </form>

</div>
<div style="text-align:left;margin-top:40px">
    <form method="get" action="/students/stuName">
        姓名： <input name="stuName" type="text">

        <input type="submit" value="查找">
    </form>
</div>
<div style="text-align:left;margin-top:40px">
    <form method="get" action="/students/id">
        ID： <input name="id" type="text">
        <input type="submit" value="查找">
    </form>
</div>
<br>
<form action="/students" method="post">
    <input type="hidden" value="DELETE" name="_method">
    <input type="submit" value="删除全部">
</form>
<br>
<td><a href="/students" >返回</a></td>
<table border=1>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>课程</td>
        <td>创建时间</td>
        <td>修改时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.stuName}</td>
            <td>${student.course}</td>
            <td>${student.createTime}</td>
            <td>${student.updateTime}</td>
            <th>
                <form action="/students/${student.id}" method="post">
                    <input type="hidden" value="DELETE" name="_method">
                    <input type="submit" value="点击删除">
                </form>
            </th>
                <%--<td><a href="/list/?id=${student.id}">删除</a></td>--%>
                <%--<td><a href="editStudent?id=${student.id }">更新</a>--%>
            <th>
                <form action="/students/${student.id}" method="post">
                    <input type="submit" value="修改">
                    <input type="hidden" value="put" name="_method">
                </form>
            </th>
        </tr>
    </c:forEach>

    <%--<c:forEach var="student" items="${requestScope.get('list')} " varStatus="status"> --%>
    <%--<tr>--%>
    <%--<td>${student.id}</td>--%>
    <%--<td>${student.stuName}</td>--%>
    <%--<td>${student.course}</td>--%>
    <%--<td><a href="delete?id=${student.id}">删除</a>--%>
    <%--<br/>--%>
    <%--<a href="update?id=${student.id }">更新</a></td>--%>
    <%--&lt;%&ndash;<td><a href="update?id=${student.id }">更新</a>&ndash;%&gt;--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--<c:forEach items="${list}" var="student">--%>
    <%--<td>${student.id}</td>--%>
    <%--<td>${student.stuName}</td>--%>
    <%--<td>${student.course}</td>--%>
    <%--</c:forEach>--%>

    <%--<c:forEach items="${requestScope.pagemsg.lists}" var="item">--%>
    <%--<tr>--%>
    <%--<td>${item.id}</td>--%>
    <%--<td>${item.stuName}</td>--%>
    <%--<td>${item.course}</td>--%>
    <%--&lt;%&ndash;<td><a href="delete?id=${item.id}">删除</a></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td><a href="update?id=${item.id }">更新</a>&ndash;%&gt;--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
</table>
<table border="0" cellspacing="0" cellpadding="0" width="900px">
    <tr>
        <td>
            <%--<span>第${requestScope.pagemsg.currPage }/${requestScope.pagemsg.totalPage}页</span>--%>
            <%--<span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;--%>
            <%--<span>--%>
            <%--<c:if test="${requestScope.pagemsg.currPage != 1}">--%>
            <%--<a href="${pageContext.request.contextPath }/list?currentPage=1">[首页]</a>&nbsp;&nbsp;--%>
            <%--<a href="${pageContext.request.contextPath }/list?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;--%>
            <%--</c:if>--%>

            <%--<c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">--%>
            <%--<a href="${pageContext.request.contextPath }/list?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;--%>
            <%--<a href="${pageContext.request.contextPath }/list?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;--%>
            <%--</c:if>--%>
            <%--</span>--%>
        </td>
    </tr>
</table>

</body>
</html>